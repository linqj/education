import React from 'react';
import {Button, Table,message} from 'antd';
import {Link} from 'react-router-dom';
import * as mobx from 'mobx';
import {observer} from 'mobx-react';
@observer
export default class TeacherAddModal extends React.Component {
  store=this.props.store;
  constructor(props){
    super(props);
    this.state={
      tgId:null,
    };
  }
  parentColumns = [{
    title: '姓名',
    dataIndex: 'teacherName',
    key: 'teacherName',
  }, {
    title: '工号',
    dataIndex: 'teacherNumber',
    key: 'teacherNumber',
  }, {
    title: '性别',
    dataIndex: 'teacherGender',
    key: 'teacherGender',
  }, {
    title: '级别',
    dataIndex: 'teacherLevel',
    key: 'teacherLevel',
  }];

  componentDidMount(){
    this.store.getTeacherAddList();
  }
  addClick(){
    let tgId=window.location.pathname.split('/')[4];
    const success = () => {
      message.success('添加成功');
      this.store.getTeacherAddList();
    };
    const error = (error) => {
      if (error.message) {
        message.error(error.message);
      } else {
        message.error('添加失败');
      }
    };
    this.store.saveTeacherToTg(this.state.srId,tgId).then(success,error);
  }
  onRowDelete = (rowkeys,selectedRows) => {
    let ids=[];
    selectedRows.map(item=>{
      ids.push(item.id);
    });
    this.setState({
      rowkeys: rowkeys,
      srId:ids,
    });

  };
  render() {
    const rowSelection = {
      onChange: (selectedRowKeys, selectedRows) => {
        this.onRowDelete(selectedRowKeys,selectedRows);
      },
      getCheckboxProps: record => ({}),
    };
    let teacherList=this.store.TeacherAddList ? mobx.toJS(this.store.TeacherAddList) : [];
    return (
      <div className="project-content-first">
        <Link to='/members/teacher'><Button>返回</Button></Link>
        <p className="project-title-first">添加教师</p>
        <Table columns={this.parentColumns}
               rowSelection={rowSelection}
               pagination={false}
               className='project-table-mix project-margin-top'
               rowKey="id"
               dataSource={teacherList}/>
        <Button type='primary' onClick={()=>this.addClick()}>添加</Button>
      </div>
    );
  }
}
