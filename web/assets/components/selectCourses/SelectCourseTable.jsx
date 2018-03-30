import React from 'react';
import {Breadcrumb,Button,Steps,Table,Icon,message} from 'antd';
import {Link} from 'react-router-dom';
import SelectCourseModal from './SelectCourseModal';

import './Index.less';
const Step = Steps.Step;


export default class SelectCourseTable extends React.Component {

  columns = [{
    title: 'Name',
    dataIndex: 'name',
    key: 'name',
    width: '30%',
  }, {
    title: 'Address',
    dataIndex: 'address',
    key: 'address',
    width:'50%',
    render:()=>{
      return (
        <Steps current={this.state.currentStep}>
          <Step title="创建选课成功"  />
          <Step title="选课中"  />
          <Step title="选课完成"  />
        </Steps>
      );
    }
  }, {
    title: 'Action',
    key: 'action',
    width: '20%',
    render: () => (
      <span style={{display:'inline-block',width:'100%',textAlign:'center'}}>
        <Link to="/s_course/result" >{this.state.currentStep===2?'查看选课结果':'查看选课情况'}</Link>&nbsp;&nbsp;&nbsp;
        <Link to="/s_course/#">更多<Icon type="down" /></Link>
    </span>
    ),
  }];
  constructor(props){
    super(props);
    this.state={
      modalVisible: null,
      modalTitle: '',
      semesterData: null,
      childList: [],
      current: null,
      total: null,
      pageSize:null,
      xnId:null,
      initialValues: [],
      operate:null,
      currentStep:0
    };
  }
  createCourse=()=>{
    this.setState({
      modalVisible: true,
      modalTitle: '新建选课',
      initialValues:[],
      operate:'add'
    });
  };
  onHandleCancel = () => {
    this.setState({
      modalVisible: false,
    });
  };
  onHandleSubmit = (values) => {
    const store = this.props.store;
    let operate = this.state.operate;
    if(operate==='add'){
      // 提交
      const success=()=>{
        message.success('添加成功');
        this.renderView(1);
        this.onHandleCancel();
      };
      const error = (error) => {
        if(error.message){
          message.error(error.message);
        }else{
          message.error('修改失败');
        }
      };
      // store.saveSemesterList(values).then(success,error);
    }else{
      values.xnId=this.state.xnId;
      const success = () => {
        message.success('修改成功');
        this.renderView(this.state.current);
        this.onHandleCancel();
      };
      const error = (error) => {
        if(error.message){
          message.error(error.message);
        }else{
          message.error('修改失败');
        }
      };
      // store.saveSemesterList(values).then(success, error);
    }
  };
  componentDidMount(){

  }
  render() {
    const data = [];
    for (let i = 1; i <= 3; i++) {
      data.push({
        key: i,
        name: 'John Brown',
        address: `New York No. ${i} Lake Park`,
      });
    }
    return (
      <div className="select-course">
        <div className="project-breadcrumb">
          <Breadcrumb>
            <Breadcrumb.Item>选课</Breadcrumb.Item>
            <Breadcrumb.Item>学生选课管理</Breadcrumb.Item>
          </Breadcrumb>
          <p className="project-title-first">学生选课管理</p>
          <p>学生选课管理、创建学生学科活动</p>
        </div>
        <div className="project-content-first">
          <p className="project-content-title">选课活动</p>
          <Button className="project-content-button" type="primary" onClick={this.createCourse}>创建选课</Button>
          <Table columns={this.columns}
                 rowKey="id"
                 pagination={false}
                 className='project-table-mix project-margin-top'
                 dataSource={data}
                 showHeader={false}
          />
          <SelectCourseModal  modalVisible={this.state.modalVisible} modalTitle={this.state.modalTitle} handleCancel={this.onHandleCancel} handleSubmit={this.onHandleSubmit} store={this.props.store} />
        </div>
      </div>
    );
  }
}
