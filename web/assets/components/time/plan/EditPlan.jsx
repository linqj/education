import React from 'react';
import {Breadcrumb, Select, Table, Checkbox, Button, Input, message} from 'antd';
const Option = Select.Option;
const CheckboxGroup = Checkbox.Group;
import {Link} from 'react-router-dom';
import PropTypes from 'prop-types';
import EditPlanStore from '../../../stores/time/EditPlanStore';
import {observer} from 'mobx-react';
class EditableCell extends React.Component {
  render() {
    return <div>
      <Input defaultValue={this.props.value} onChange={e => this.props.onChange(e.target.value)}/>
    </div>;
  }
}
@observer
export default class EditPlan extends React.Component {
  parentColumns = [{
    title: '课程名称',
    dataIndex: 'courseName',
    key: 'courseName',
  }, {
    title: '学科',
    dataIndex: 'disciplineName',
    key: 'disciplineName',
  }, {
    title: '学期学时(h)',
    dataIndex: 'semesterLearnTime',
    key: 'semesterLearnTime',
    render: (text, record) => this.renderColumns(text, record, 'semesterLearnTime'),
  }, {
    title: '周学时(h)',
    dataIndex: 'weekLearnTime',
    key: 'weekLearnTime',
    render: (text, record) => this.renderColumns(text, record, 'weekLearnTime'),
  }];

  renderColumns(text, record, column) {
    return (
      <EditableCell
        value={text}
        onChange={value => this.handleChange(value, record.id, column)}
      />
    );
  }
  handleChange = (value, key, column) => {
    const newData = [...this.state.courseTableList];
    const target = newData.filter(item => key === item.id)[0];
    let arr=[];
    if (target) {
      target[column] = value;
      newData.forEach(item=>{
        if(key==item.id){
          arr.push(target);
        }else{
          arr.push(item);
        }

      });
      this.setState({courseTableList: arr});
    }
  };
  constructor(props) {
    super(props);
    this.state = {
      gradeId: null,
      checkedList: [],
      indeterminate: true,
      checkAll: false,
      courseList: [],
      gradeList: [],
      courseTableList: [],
      checkedCourseList: [],
      defaultSelected:[],
      courseDefaultTableList:[],
      getCourseCourse: [],
    };
  }

  componentDidMount() {
    //获取年级列表
    EditPlanStore.getGradeList().then(json => {
      this.setState({
        gradeList: json
      });
    });
  }

  onGradeChange = (v) => {
    let parentState = this.props.location.state;
    this.setState({
      gradeId: v
    });
    //获取课程列表
    EditPlanStore.getCourseList(v).then(json => {
      this.setState({
        courseList: json.data
      });
    });
    EditPlanStore.getCourseTableList(parentState.schoolYearId, parentState.semesterId, v).then(json => {
      let defaultSelected=[];
      json.data.forEach(item=>{
        defaultSelected.push(item.courseDiscipline);
      });
      this.setState({
        courseDefaultTableList: json.data,
        courseTableList: json.data,
        checkedList:defaultSelected
      });
    });
  };
  onChange = (checkedList) => {
    let plainOptions=this.transformWord(this.state.courseList);
    let arr=[];
    plainOptions.forEach(item=>{
      arr.push(item.value);
    });
    this.setState({
      checkedList,
      indeterminate: !!checkedList.length && (checkedList.length < arr.length),
      checkAll: checkedList.length === arr.length,
    });
  };
  onCheckAllChange = (e) => {
    let plainOptions=this.transformWord(this.state.courseList);
    let arr=[];
    plainOptions.forEach(item=>{
      arr.push(item.value);
    });
    this.setState({
      checkedList: e.target.checked ? arr : [],
      indeterminate: false,
      checkAll: e.target.checked,
    });
  };

  static contextTypes = {
    router: PropTypes.object.isRequired
  };
  onSubmitCourses = () => {
    let parentState = this.props.location.state;
    let courseTableList=this.state.courseTableList;
    const success = () => {
      message.success('提交成功');
      this.context.router.history.push('/time/plan');
    };
    const error = (error) => {
      if (error.message) {
        message.error(error.message);
      } else {
        message.error('提交失败');
      }
    };
    let arr=[];
    let gradeName='';
    let gradeList = this.state.gradeList;
    gradeList.forEach(item=>{
      if(item.id==this.state.gradeId){
        gradeName=item.gradeName;
      }
    });
    courseTableList.forEach(item=>{
      item.schoolYearId=Number(parentState.schoolYearId);
      item.semesterId=parentState.semesterId;
      item.gradeId=Number(this.state.gradeId);
      item.courseId=Number(item.id);
      item.schoolYearName=parentState.schoolYearName;
      item.semesterName=parentState.semester_Name;
      item.gradeName=gradeName;
      arr.push(item);
    });
    EditPlanStore.postCourseList(arr).then(success,error);
  };
  //转换字段
  transformWord(arr) {
    let arrList = [];
    arr.forEach(item => {
      arrList.push({label: item.courseName, value: item.courseDiscipline});
    });
    return arrList;
  }
  submitCourse=()=>{
    let courseList = this.state.courseList;
    let courseDefaultTableList = this.state.courseDefaultTableList;
    let allList=[];
    if(courseDefaultTableList.length>0){
      this.state.checkedList.forEach(checkItem=>{
        let isHave=false;
        courseDefaultTableList.forEach(courseItem=>{
          if(courseItem.courseDiscipline === checkItem){
            allList.push(courseItem);
            isHave=true;
          }
        });
        if(!isHave){
          courseList.forEach(courseItem=>{
            if(courseItem.courseDiscipline === checkItem){
              allList.push(courseItem);
            }
          });
        }
      });
    }else{
      this.state.checkedList.forEach(checkItem=>{
        courseList.forEach(courseItem=>{
          if(courseItem.courseDiscipline==checkItem){
            allList.push(courseItem);
          }
        });
      });
    }
    this.setState({
      courseTableList:allList
    });
  };
  render() {
    let parentState = this.props.location ? this.props.location.state : [];
    let gradeList = this.state.gradeList;
    let courseList = this.state.courseList;
    let courseOptions=this.transformWord(courseList);
    let courseTableList = this.state.courseTableList;
    let checkedList=this.state.checkedList;

    return (
      <div className="plan">
        <div className="project-breadcrumb">
          <Breadcrumb>
            <Breadcrumb.Item>课时</Breadcrumb.Item>
            <Breadcrumb.Item>课程开设计划</Breadcrumb.Item>
          </Breadcrumb>
          <p className="project-title-first">课程开设计划</p>
          <p>在这里查看各个学期课程的开设计划，管理各个学期的课程课时安排</p>
        </div>
        <div className="plan-search">
          <p className="project-content-title">管理学期课程开设计划</p>
          <span className="plan-search-text">学年：{parentState.schoolYearName}</span>
          <span className="plan-search-text">学期：{parentState.semester_Name}</span>
          <div className="plan-search-text">
            <span>年级：</span>
            <Select onChange={this.onGradeChange} className="project-content-item-select">
              {gradeList.map(item => {
                return <Option value={(item.id).toString()} key={item.id}>{item.gradeName}</Option>;
              })
              }
            </Select>
          </div>
          {
            courseList.length > 0 && <div>
              <Checkbox
                indeterminate={this.state.indeterminate}
                onChange={this.onCheckAllChange}
                checked={this.state.checkAll}
                className='project-margin-top'
              >
                全选
              </Checkbox>
              <br />
              <div className="project-margin-top clear">
                <span>标题：</span>
                <CheckboxGroup className="plan-checkbox-group" options={courseOptions} value={checkedList}
                               onChange={this.onChange}/>
                <Button type="primary" className='plan-check-button' onClick={this.submitCourse}>确定</Button>
              </div>
            </div>
          }
        </div>
        <div className="plan-search">
          <div  className="clear"><span className="project-title-first">已选课程</span>
            <div className="plan-button">
              <Button className="plan-button-submit" type="primary" onClick={this.onSubmitCourses}>提交</Button>
              <Button className="plan-button-callback"><Link to="/time/plan">返回</Link></Button>
            </div>
          </div>
          <Table columns={this.parentColumns}
                 rowKey="id"
                 pagination={false}
                 dataSource={courseTableList}
                 className='project-margin-top'
          />
        </div>
      </div>
    );
  }
}
