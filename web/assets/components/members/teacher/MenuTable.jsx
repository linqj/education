import React from 'react';
import {
  Breadcrumb,
  Button,
  Table,
  Popconfirm,
  Pagination,
  Input,
  message,
} from 'antd';
const Search = Input.Search;
import {Link} from 'react-router-dom';
import {observer} from 'mobx-react';
import * as mobx from 'mobx';
import TeaModal from './TeaModal';
import SelectLeaderModal from './SelectLeaderModal';
import MoveTeacherModal from './MoveTeacherModal';
@observer

export default class MenuTable extends React.Component {
  store = this.props.store;
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
    render:(text)=>{
      let genderList=this.store.genderList?mobx.toJS(this.store.genderList):[];
      let gender=genderList.filter(item=>item.code===text);
      if(gender.length>0){
        return <span>{gender[0].name}</span>;
      }else {
        return <span> </span>;
      }
    }
  }, {
    title: '级别',
    dataIndex: 'teacherLevel',
    key: 'teacherLevel',
    render:(text)=>{
      let teaLevelList=this.store.teaLevelList?mobx.toJS(this.store.teaLevelList):[];
      let teaLevel=teaLevelList.filter(item=>item.code===text);
      if(teaLevel.length>0){
        return <span>{teaLevel[0].name}</span>;
      }else{
        return <span> </span>;
      }

    }
  }, {
    title: '职责',
    dataIndex: 'teacherProperty',
    key: 'teacherProperty',
  }, {
    title: '操作',
    dataIndex: 'operate',
    key: 'operate',
    render: (text, record, index) => {
      return <div>
        <span className="operate-edit" onClick={() => this.onEdit(text, record, index)}>编辑</span>
        <Popconfirm title="你确定要删除这行内容吗？" onConfirm={() => this.onDelete(text, record, index)} okText="确定" cancelText="取消">
          <a href="javascript:void(0);">删除</a>
        </Popconfirm>
      </div>;
    }
  }];
  onDelete = (text, record, index) => {
    const success = () => {
      message.success('删除成功');
      this.setList(this.state.groupId, 1);
    };
    const error = (error) => {
      if (error.message) {
        message.error(error.message);
      } else {
        message.error('删除失败');
      }
    };
    this.store.delTeacher(record.id).then(success, error);
  };
  onEdit = (text, record, index) => {
    this.setState({
      modalVisible: true,
      modalTitle: '修改教师成员',
      initialValues: record,
      operate: 'edit',
      getId: record.id,
    });
  };

  constructor(props) {
    super(props);
    this.state = {
      groupId: null,
      rowkeys: [],
      modalVisible: null,
      modalTitle: '',
      operate: null,
      getId: null,
      initialValues: [],
      leaderTitle:'',
      moveTeacherVisible:false,
      moveTitle:'',
      leaderModal:<span></span>,
      moveModal:<span></span>,
    };
  }

  onHandleCancel = () => {
    this.setState({
      modalVisible: false,
    });
  };
  onHandleSubmit = (values) => {
    let TeacherList = mobx.toJS(this.store.TeacherList);
    values.id = this.state.getId;
    const success = () => {
      message.success('修改成功');
      this.setList(this.state.groupId, TeacherList.pageNum);
      this.
      this.onHandleCancel();
    };
    const error = (error) => {
      if (error.message) {
        message.error(error.message);
      } else {
        message.error('修改失败');
      }
    };
    this.store.editTea(values).then(success, error);
  };

  componentDidMount() {
    this.setList(this.props.menuKey, 1);
    this.setState({
      groupId: this.props.menuKey,
    });
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.menuKey) {
      //获取对应的教研组列表
      this.setList(nextProps.menuKey, 1);
      //更新获取对应的教师列表,教研组列表
      this.store.getLeaderList(nextProps.menuKey);
      this.store.getLeaderTwoList(nextProps.menuKey);
      this.store.getMoveGroupList(nextProps.menuKey);
      this.setState({
        groupId: nextProps.menuKey,
      });
    }
  }
  setList(groupId, current) {
    this.store.getGroupTeacherList(groupId, current);
  }

  onPageChange = (v) => {
    this.setList(this.state.groupId, v);
  };
  teaSearch = (v) => {
    this.store.getTeaSearchName(this.props.menuKey, v);
  };
  onRowDelete = (rowkeys) => {
    this.setState({
      rowkeys: rowkeys
    });
  };
  onRowsDelete = () => {
    if (this.state.rowkeys.length > 0) {
      const success = () => {
        message.success('删除成功');
        this.setList(this.state.groupId, 1);
      };
      const error = (error) => {
        if (error.message) {
          message.error(error.message);
        } else {
          message.error('删除失败');
        }
      };
      this.store.onRowTeacherDel(this.state.rowkeys).then(success, error);
    } else {
      message.error('请选择要删除的项');
    }
  };
  onMoveTeacher=()=>{
    this.setState({
      moveModal:<MoveTeacherModal  onMoveModalCancel={this.onMoveModalCancel} moveTeacherSubmit={this.moveTeacherSubmit} store={this.store}  menuKey={this.props.menuKey} movetitle='调整教研组'/>
    });
  };
  onMoveModalCancel=()=>{
    this.setState({
      moveModal:<span></span>
    });
  };
  moveTeacherSubmit=(groupId)=>{
    if(this.state.rowkeys.length>0){
      const success = () => {
        message.success('调整成功');
        this.onMoveModalCancel();
        this.setList(this.state.groupId, 1);
      };
      const error = (error) => {
        if (error.message) {
          message.error(error.message);
        } else {
          message.error('调整失败');
        }
      };
      this.store.moveTeacher(groupId,this.state.rowkeys).then(success, error);
    }else {
      message.error('请选择要调整的项');
    }
  };
  onEditLeader=()=>{
    let TeacherList=this.store.TeacherList?mobx.toJS(this.store.TeacherList):[];
    let initialLeaderName=TeacherList.leaderName;

    this.setState({
      operate:'leaderOne',
      initialLeaderName:initialLeaderName,
      leaderModal: <SelectLeaderModal  leaderHandleCancel={this.onLeaderModalCancel} onLeaderSubmit={this.onLeaderSubmit} store={this.store} leaderTitle='教研组长选择' menuKey={this.props.menuKey} operate='leaderOne'  />
    });
  };
  onEditLeaderTwo=()=>{
    this.setState({
      operate:'leaderTwo',
      leaderModal: <SelectLeaderModal  leaderHandleCancel={this.onLeaderModalCancel} onLeaderSubmit={this.onLeaderSubmit} store={this.store} leaderTitle='教研副组长选择' menuKey={this.props.menuKey} operate='leaderOne'  />
    });
  };
  onLeaderModalCancel = () => {
    this.setState({
      leaderModal:<span></span>
    });
  };
  onLeaderSubmit = (teacherId) => {
    let tId=Number(teacherId);
    if(this.state.operate==='leaderOne'){
      const success = () => {
        message.success('修改成功');
        this.setList(this.state.groupId, 1);
        this.store.getLeaderList(this.state.groupId);
        this.onLeaderModalCancel();
      };
      const error = (error) => {
        if (error.message) {
          message.error(error.message);
        } else {
          message.error('修改失败');
        }
      };
      this.store.saveLeader(this.state.groupId,tId).then(success,error);
    }else if(this.state.operate==='leaderTwo'){
      const success = () => {
        message.success('修改成功');
        this.setList(this.state.groupId, 1);
        this.store.getLeaderTwoList(this.state.groupId);
        this.onLeaderModalCancel();
      };
      const error = (error) => {
        if (error.message) {
          message.error(error.message);
        } else {
          message.error('修改失败');
        }
      };
      this.store.saveLeaderTwo(this.state.groupId,tId).then(success,error);
    }

  };
  render() {
    let groupName = this.props.groupsName;
    let teacherList = this.store.TeacherList.list ? mobx.toJS(this.store.TeacherList.list) : [];
    const rowSelection = {
      onChange: (selectedRowKeys, selectedRows) => {
        this.onRowDelete(selectedRowKeys);
      },
      getCheckboxProps: record => ({}),
    };
    let TeacherList = mobx.toJS(this.store.TeacherList);
    let initialValues = this.state.initialValues;
    let current = TeacherList.pageNum ? Number(TeacherList.pageNum) : 1;
    let pageSize = TeacherList.pageSize ? Number(TeacherList.pageSize) : 10;
    let total = TeacherList.total ? TeacherList.total : 0;
    return (
      <div className="project-menu-table">
        <Breadcrumb>
          <Breadcrumb.Item>成员</Breadcrumb.Item>
          <Breadcrumb.Item>教师成员管理</Breadcrumb.Item>
          <Breadcrumb.Item>教研组</Breadcrumb.Item>
        </Breadcrumb>
        <div className="student">
          <p className="project-content-title">{groupName}列表</p>
          <div className="project-operate">
            <Button className="project-content-button" type="primary"><Link
              to={`/members/teacher/add/${this.props.menuKey}`}>添加成员</Link></Button>
            <Button className="project-content-button project-operate-item"
                    onClick={this.onMoveTeacher}
            >调整教研组</Button>
            <Button className="project-content-button project-operate-item" onClick={this.onRowsDelete}>批量删除</Button>
            <Search
              placeholder="搜索教师姓名"
              onSearch={this.teaSearch}
              className="project-operate-search"
            />
          </div>
          <p className="project-margin-top">教研组长:{TeacherList.leaderName}<a href="javascript:void(0);" className="teacher-edit"
                                                      onClick={this.onEditLeader}>修改</a>教研副组长:{TeacherList.leaderTwoName}<a
            href="javascript:void(0);" className="teacher-edit" onClick={this.onEditLeaderTwo}>修改</a></p>
          <Table columns={this.parentColumns}
                 rowSelection={rowSelection}
                 pagination={false}
                 className='project-table-mix project-margin-top'
                 rowKey="id"
                 dataSource={teacherList}/>
          <Pagination className="project-margin-top" pageSize={pageSize}
                      current={current} onChange={this.onPageChange}
                      total={total}/>
        </div>
        <TeaModal modalVisible={this.state.modalVisible} store={this.store}
                  modalTitle={this.state.modalTitle}
                  onHandleCancel={this.onHandleCancel} onHandleSubmit={this.onHandleSubmit}
                  identify="each"
                  initValues={initialValues}
        />
        {this.state.leaderModal}
        {this.state.moveModal}
      </div>
    )
  }
}
