import React from 'react';
import {Link} from 'react-router-dom';
import {Breadcrumb,Button,Table,message} from 'antd';
import './Index.less';
export  default class DivideClassTable extends React.Component{
  columns = [{
    title: '科目名称',
    dataIndex: 'name',
    key: 'name',
    width: '20%'

  }, {
    title: '已选人数',
    dataIndex: 'num',
    key: 'num',
    width: '20%'

  }, {
    title: '分层情况',
    dataIndex: 'status',
    key: 'status',
    width: '20%'
  }, {
    title: '分层详细',
    dataIndex: 'detail',
    key: 'detail',
    width: '20%'
  }, {
    title: '操作',
    key: 'action',
    render: (text, record, index) => (
      <div>
        <span>
          <Link to='#'>分班</Link>&nbsp;&nbsp;&nbsp;
          <Link to='#'>查看选课名单</Link>
        </span>
      </div>
    ),
  }];
  allData=[{'name':'aa','num':30,'status':'未分班','detail':'-'},{'name':'bb','num':20,'status':'已分3个班','detail':'-'},{'name':'cc','num':50,'status':'已分4个班','detail':'-'}];
  render(){
    return(
      <div className="select-course">
        <div className="project-breadcrumb">
          <Breadcrumb>
            <Breadcrumb.Item>选课</Breadcrumb.Item>
            <Breadcrumb.Item>学生选课管理</Breadcrumb.Item>
            <Breadcrumb.Item>选课结果</Breadcrumb.Item>
            <Breadcrumb.Item>分班设置</Breadcrumb.Item>
          </Breadcrumb>
          <p className="project-title-first">分班设置</p>
        </div>
        <div className="project-content-first">
          <Button className="project-content-button" type="primary" ><Link to='/s_course/result'>返回</Link></Button>

          <div className="select-result-div">高一物理选课分班</div>
          <div className="select-result-p">
            <p>已选:300人</p>
            <p>状态:选课中</p>
          </div>
          <div className="select-result-p" >
            <p>学期:上学期</p>
            <p>时间:2016-06-07至2016-06-09</p>
          </div>


        </div>
      </div>
    );
  }
}
