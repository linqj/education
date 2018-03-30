import React from 'react';
import {Button, Table, Popconfirm, message, Form, Collapse,Input} from 'antd';
const Panel = Collapse.Panel;
import {Link} from 'react-router-dom';
import {observer} from 'mobx-react';
class EditableCell extends React.Component {
  render() {
    return <div>
      {this.props.editable
        ? <Input defaultValue={this.props.value} onChange={e => this.props.onChange(e.target.value)}/>
        : this.props.value
      }
    </div>;
  }
}
@Form.create()
@observer
export default class PlanTable extends React.Component {
  store=this.props.store;
  constructor(props) {
    super(props);
    this.state = {
      courseList: [],
      oneNewClass: [],
      gradeId: null,
      semesterData: null,
      childList: [],
      current: null,
      total: null,
      pageSize: null,
      xnId: null,
      initialValues: [],
      operate: null,
      schoolYearId: null,
      semesterId: null,
      coursePlanList:[],
      collapseTableIndex:null
    };
    this.cacheData = this.state.courseList.map(item => ({...item}));
  }
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
  }, {
    title: '操作',
    dataIndex: 'operation',
    render: (text, record, index) => {
      const {editable} = record;
      return (
        <div>
          {
            editable ?
              <span>
                  <Popconfirm title="确定要保存此项内容吗?" onConfirm={() => this.save(record.id)} okText="确定" cancelText="取消">
                    <a href="javascript:void(0);" className="operate-edit">保存</a>
                  </Popconfirm>
                  <a href="javascript:void(0);" onClick={() => this.cancel(record.id)}>取消</a>
                </span>
              : <span>
                  <a href="javascript:void(0);" onClick={() => this.edit(record.id)} className="operate-edit">修改</a>
                  <Popconfirm title="确定要删除此项内容吗?" onConfirm={() => this.delete(record.id)} okText="确定" cancelText="取消">
                    <a href="javascript:void(0);">删除</a>
                  </Popconfirm>
                </span>
          }
        </div>
      );
    }
  }];
  renderColumns(text, record, column) {
    return (
      <EditableCell
        editable={record.editable}
        value={text}
        onChange={value => this.handleChange(value, record.id, column)}
      />
    );
  }
  handleChange=(value, key, column)=> {
    const newData = [...this.state.courseList];
    const target = newData.filter(item => key === item.id)[0];
    if (target) {
      target[column] = value;
      this.setState({oneNewClass: target});
    }
  };
  save = () => {
    let oneNewClass = this.state.oneNewClass;
    //保存
    const success = () => {
      message.success('保存成功');
      this.getCourseList(this.props.schoolYearId, this.props.semesterId);
    };
    const error = (error) => {
      if (error.message) {
        message.error(error.message);
      } else {
        message.error('保存失败');
      }
    };
    oneNewClass.courseNumber=oneNewClass.id;
    this.store.editCoursePlan(oneNewClass).then(success, error);
  };

  cancel(key) {
    const newData = [...this.state.courseList];
    const target = newData.filter(item => key === item.id)[0];
    if (target) {
      Object.assign(target, this.cacheData.filter(item => key === item.id)[0]);
      delete target.editable;
      this.setState({courseList: newData});
    }
  }
  edit(key) {
    const newData = [...this.state.courseList];
    const target = newData.filter(item => key === item.id)[0];
    if (target) {
      target.editable = true;
      this.setState({courseList: newData,
        oneNewClass:target});
    }
  }
  delete = (courseId) => {
    const success = () => {
      message.success('删除成功');
      this.getCourseList(this.props.schoolYearId, this.props.semesterId);
    };
    const error = (error) => {
      if (error.message) {
        message.error(error.message);
      } else {
        message.error('删除失败');
      }
    };
    this.store.deleteCoursePlan(courseId).then(success, error);
  };

  componentDidMount() {
    if (this.props.schoolYearId && this.props.semesterId) {
      //得到Table数据
      this.getCourseList(this.props.schoolYearId, this.props.semesterId);
    }
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.schoolYearId && nextProps.semesterId) {
      this.getCourseList(nextProps.schoolYearId, nextProps.semesterId);
      this.setState({
        schoolYearId: nextProps.schoolYearId,
        semesterId: nextProps.semesterId
      });
    }
  }

  //获取列表
  getCourseList = (schoolYearId, semesterId) => {
    const store = this.props.store;
    store.getAllCoursePlanList(schoolYearId, semesterId).then(json=>{
      this.setState({
        coursePlanList:json.data,
        courseList:this.state.collapseTableIndex?json.data[this.state.collapseTableIndex].childlist:[]
      });
    });
  };

  callback=(key)=>{
    let coursePlanList = this.state.coursePlanList;
    this.setState({
      collapseTableIndex:key,
      courseList:coursePlanList[key]?coursePlanList[key].childlist:[]
    });
  };
  render() {
    let coursePlanList = this.state.coursePlanList;
    let courseList=this.state.courseList;
    let collapseTableIndex=this.state.collapseTableIndex;
    let collapseTableArray=[];
    collapseTableArray.push(collapseTableIndex);
    return (
      <div className="plan-table-content">
        <Button className="project-content-button" type="primary">
          <Link to={{
            pathname: '/time/plan/edit',
            state: {schoolYearId: this.props.schoolYearId, semesterId: this.props.semesterId,
              schoolYearName:this.props.currentYearName,semester_Name:this.props.semesterName}
          }}>管理学期课程计划</Link>
        </Button>
        <Collapse accordion activeKey={collapseTableArray} onChange={this.callback} className='project-margin-top'>
          {coursePlanList.map((items,index) => {
            return <Panel header={items.gradeName + '课程计划'} key={index}>
              <Table columns={this.parentColumns}
                     rowKey="id"
                     pagination={false}
                     dataSource={courseList}
              />
            </Panel>;
          })}
        </Collapse>
      </div>
    );
  }
}
