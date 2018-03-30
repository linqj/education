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
import {observer} from 'mobx-react';
import * as mobx from 'mobx';
import TeaModal from './TeaModal';

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
    title: '所属教研组',
    dataIndex: 'teacherGroupName',
    key: 'teacherGroupName',
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
        <Popconfirm title="你确定要删除这行内容吗？" onConfirm={() => this.onDelete(text, record, index)} okText="确定"
                    cancelText="取消">
          <a href="javascript:void(0);">删除</a>
        </Popconfirm>
      </div>;
    }
  }];
  onDelete = (text, record, index) => {
    const success = () => {
      message.success('删除成功');
      this.setList( 1);
    };
    const error = (error) => {
      if (error.message) {
        message.error(error.message);
      } else {
        message.error('删除失败');
      }
    };
    this.store.deleteTeacher(record.id).then(success, error);
  };
  onEdit = (text, record, index) => {
    this.setState({
      modalVisible: true,
      modalTitle: '修改教师成员',
      initialValues: record,
      operate: 'edit',
      recordId: record.id
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
      recordId:null,
      initialValues:[],
    };

  }
  createSemester = () => {
    this.setState({
      modalVisible: true,
      modalTitle: '添加教师成员',
      buildingNumber: [],
      operate: 'add',
      initialValues: []
    });
  };
  onHandleCancel = () => {
    this.setState({
      modalVisible: false,
    });
  };
  onHandleSubmit = (values) => {
    let operate = this.state.operate;
    let allTeacherList = mobx.toJS(this.store.allTeacherList);
    if (operate === 'add') {
      const success = () => {
        message.success('添加成功');
        this.setList(1);
        this.onHandleCancel();
      };
      const error = (error) => {
        if (error.message) {
          message.error(error.message);
        } else {
          message.error('添加失败');
        }
      };
      values.teacherGroupId=Number(values.teacherGroupId);
      this.store.addTeacher(values).then(success, error);
    } else {
      values.tId = this.state.recordId;
      values.teacherGroupId=Number(values.teacherGroupId);
      const success = () => {
        message.success('修改成功');
        this.setList( allTeacherList.pageNum);
        this.onHandleCancel();
      };
      const error = (error) => {
        if (error.message) {
          message.error(error.message);
        } else {
          message.error('修改失败');
        }
      };
      this.store.editTeacher(values).then(success, error);
    }
  };
  componentDidMount() {
    this.setList(1);
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.menuKey) {
      //获取对应教研组
      this.setList(1);
      this.setState({
        groupId: nextProps.menuKey,
      });
    }
  }

  setList(current) {
    this.store.getAllTeacherList(current);
  }
  onPageChange = (v) => {
    this.setList( v);
  };
  teaSearch = (v) => {
    this.store.getSearchName(v);
  };
  onRowsDelete = () => {
    if (this.state.rowkeys.length > 0) {
      const success = () => {
        message.success('删除成功');
        this.setList(1);
      };
      const error = (error) => {
        if (error.message) {
          message.error(error.message);
        } else {
          message.error('删除失败');
        }
      };
      this.store.onRowTeacherDelete(this.state.rowkeys).then(success,error);
    } else {
      message.error('请选择要删除的项');
    }
  };
  onRowDelete = (rowkeys) => {
    this.setState({
      rowkeys: rowkeys
    });
  };


  render() {
    let groupName = this.props.groupsName;
    let allTeacherList = this.store.allTeacherList ? mobx.toJS(this.store.allTeacherList) : [];
    const rowSelection = {
      onChange: (selectedRowKeys, selectedRows) => {
        this.onRowDelete(selectedRowKeys);
      },
      getCheckboxProps: record => ({}),
    };
    let initialValues = this.state.initialValues;
    let current = allTeacherList.pageNum ? Number(allTeacherList.pageNum) : 1;
    let pageSize = allTeacherList.pageSize ? Number(allTeacherList.pageSize) : 10;
    let total = allTeacherList.total ? allTeacherList.total : 0;
    return (
      <div className="project-menu-table">
        <Breadcrumb>
          <Breadcrumb.Item>成员</Breadcrumb.Item>
          <Breadcrumb.Item>教师成员管理</Breadcrumb.Item>
          <Breadcrumb.Item>全体教师</Breadcrumb.Item>
        </Breadcrumb>
        <div className="student">
          <p className="project-content-title">{groupName}列表</p>
          <div className="project-operate">
            <Button className="project-content-button" type="primary" onClick={this.createSemester}>添加成员</Button>
            <Button className="project-content-button project-operate-item">批量导入</Button>
            <Button className="project-content-button project-operate-item" onClick={this.onRowsDelete}>批量删除</Button>
            <Search
              placeholder="搜索教师姓名"
              onSearch={this.teaSearch}
              className="project-operate-search"
            />
          </div>
          <Table columns={this.parentColumns}
                 rowSelection={rowSelection}
                 pagination={false}
                 className='project-table-mix project-margin-top'
                 rowKey="id"
                 dataSource={allTeacherList.list}/>
          <Pagination className="project-margin-top" pageSize={pageSize}
                      current={current} onChange={this.onPageChange}
                      total={total}/>
        </div>
        <TeaModal modalVisible={this.state.modalVisible} store={this.store}
                  modalTitle={this.state.modalTitle}
                  onHandleCancel={this.onHandleCancel} onHandleSubmit={this.onHandleSubmit}
                  identify="all"
                  initValues={initialValues}
        />

      </div>
    )
  }
}
