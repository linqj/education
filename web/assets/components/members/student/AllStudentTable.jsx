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
import StudentModal from './StudentModal';

@observer
export default class AllStudentTable extends React.Component {
  store = this.props.store;
  parentColumns = [{
    title: '姓名',
    dataIndex: 'stuName',
    key: 'stuName',
  }, {
    title: '学号',
    dataIndex: 'stuNumber',
    key: 'stuNumber',
  }, {
    title: '性别',
    dataIndex: 'stuGenderShow',
    key: 'stuGenderShow',
  }, {
    title: '级别',
    dataIndex: 'stuLevelShow',
    key: 'stuLevelShow',
  }, {
    title: '所在班级',
    dataIndex: 'className',
    key: 'className',
  },{
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
      this.setList(this.state.classId, 1);
    };
    const error = (error) => {
      if (error.message) {
        message.error(error.message);
      } else {
        message.error('删除失败');
      }
    };
    this.store.deleteStudent(record.id).then(success, error);
  };
  onEdit = (text, record, index) => {
    this.setState({
      modalVisible: true,
      modalTitle: '修改学年',
      initialValues: record,
      operate: 'edit',
      gradeId: record.id
    });
  };

  constructor(props) {
    super(props);
    this.state = {
      modalVisible: null,
      modalTitle: '',
      initialValues: [],
      operate: null,
      classId: null,
      rowkeys: []
    };
  }

  createSemester = () => {
    this.setState({
      modalVisible: true,
      modalTitle: '添加学生成员',
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
    let StudentListObject = mobx.toJS(this.store.StudentListObject);
    if (operate === 'add') {
      const success = () => {
        message.success('添加成功');
        this.setList(this.state.classId, 1);
        this.onHandleCancel();
      };
      const error = (error) => {
        if (error.message) {
          message.error(error.message);
        } else {
          message.error('添加失败');
        }
      };
      this.store.addStudent(values).then(success, error);
    } else {
      values.id = this.state.gradeId;
      const success = () => {
        message.success('修改成功');
        this.setList(this.state.classId, StudentListObject.pageNum);
        this.onHandleCancel();
      };
      const error = (error) => {
        if (error.message) {
          message.error(error.message);
        } else {
          message.error('修改失败');
        }
      };
      this.store.editStudent(values).then(success, error);
    }
  };

  componentDidMount() {
    this.setList(null, 1);
  }

  setList(classId, current) {
    this.store.getAllStudentList(classId, current);
  }

  onPageChange = (v) => {
    this.setList(this.state.classId, v);
  };
  stuSearch = (v) => {
    this.store.getSearchName(v);
  };
  onRowsDelete = () => {
    if (this.state.rowkeys.length > 0) {
      const success = () => {
        message.success('删除成功');
        this.setList(this.state.classId, 1);
      };
      const error = (error) => {
        if (error.message) {
          message.error(error.message);
        } else {
          message.error('删除失败');
        }
      };
      this.store.onRowStudentDelete(this.state.rowkeys).then(success,error);
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
    let StudentListObject = this.store.StudentListObject?mobx.toJS(this.store.StudentListObject):[];
    let initialValues = this.state.initialValues;
    let current = StudentListObject.pageNum ? Number(StudentListObject.pageNum) : 0;
    let pageSize = StudentListObject.pageSize ? Number(StudentListObject.pageSize) : 10;
    let total = StudentListObject.total ? StudentListObject.total : 0;
    let gradeName = this.props.gradeName;
    let classNam = this.props.classNam;
    const rowSelection = {
      onChange: (selectedRowKeys, selectedRows) => {
        this.onRowDelete(selectedRowKeys);
      },
      getCheckboxProps: record => ({}),
    };
    return (
      <div className="project-menu-table">
        <Breadcrumb>
          <Breadcrumb.Item>成员</Breadcrumb.Item>
          <Breadcrumb.Item>学生成员管理</Breadcrumb.Item>
          {classNam && <Breadcrumb.Item>{classNam}</Breadcrumb.Item>}

        </Breadcrumb>
        <div className="student">
          <p className="project-content-title">{gradeName}列表</p>
          <div className="project-operate">
            <Button className="project-content-button" type="primary" onClick={this.createSemester}>添加成员</Button>
            <Button className="project-content-button project-operate-item">批量导入</Button>
            <Button className="project-content-button project-operate-item" onClick={this.onRowsDelete}>批量删除</Button>
            <Search
              placeholder="请输入"
              onSearch={this.stuSearch}
              className="project-operate-search"
            />
          </div>
          <Table columns={this.parentColumns}
            rowSelection={rowSelection}
            pagination={false}
            className='project-table-mix project-margin-top'
            rowKey="id"
            dataSource={StudentListObject.list}/>
          <Pagination className="project-margin-top" pageSize={pageSize}
            current={current} onChange={this.onPageChange}
            total={total}/>
        </div>
        <StudentModal modalVisible={this.state.modalVisible} modalTitle={this.state.modalTitle}
          onHandleCancel={this.onHandleCancel}
          initValues={initialValues} onHandleSubmit={this.onHandleSubmit}
          store={this.store} identify="all"
        />
      </div>
    );
  }
}
