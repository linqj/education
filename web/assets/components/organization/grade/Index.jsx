import React from 'react';
import {
  Breadcrumb,
  Button,
  Table,
  Popconfirm,
  Pagination,
  message,
} from 'antd';
import {observer} from 'mobx-react';
import moment from 'moment';
import * as mobx from 'mobx';
import GradeModal from './GradeModal';

@observer
export default class GradeIndex extends React.Component {
  store = this.props.store;
  parentColumns = [{
    title: '名称',
    dataIndex: 'gradeName',
    key: 'gradeName',
    width: '20%'
  }, {
    title: '代码',
    dataIndex: 'gradeCode',
    key: 'gradeCode',
    width: '10%'
  }, {
    title: '班级数(个)',
    dataIndex: 'gradeTotalClassNum',
    key: 'gradeTotalClassNum',
    width: '15%'
  }, {
    title: '学生数(人)',
    dataIndex: 'gradeTotalStuNum',
    key: 'gradeTotalStuNum',
    width: '15%'
  }, {
    title: '毕业日期',
    dataIndex: 'endDate',
    key: 'endDate',
    width: '20%',
    render: (text) => {
      let value = text ? moment(text).format('YYYY-MM-DD') : null;
      return <span>{value}</span>;
    }
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

  childColumns = [{
    title: '名称',
    dataIndex: 'claName',
    key: 'claName',
    width: '4%'
  }, {
    title: '代码',
    dataIndex: 'classCode',
    key: 'classCode',
    width: '5%'
  }, {
    title: '学生数(人)',
    dataIndex: 'classStuNum',
    key: 'classStuNum',
    width: '10%'
  }];
  onDelete = (text, record, index) => {
    this.setState({
      gradeId: record.id
    });
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
    this.store.deleteGrade(record.id).then(success, error);

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
      gradeId: null
    };
  }

  createSemester = () => {
    this.setState({
      modalVisible: true,
      modalTitle: '添加新学年',
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
    let gradeListObject = mobx.toJS(this.store.gradeListObject);
    if (values.endDate) {
      values.endDate = moment(values.endDate).valueOf();
    }
    if (operate == 'add') {
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
      this.store.addGrade(values).then(success, error);
    } else {
      values.id = this.state.gradeId;
      const success = () => {
        message.success('修改成功');
        this.setList(gradeListObject.pageNum);
        this.onHandleCancel();
      };
      const error = (error) => {
        if (error.message) {
          message.error(error.message);
        } else {
          message.error('修改失败');
        }
      };
      this.store.editGrade(values).then(success, error);
    }
  };

  componentDidMount() {
    this.setList(1);
  }

  setList(current) {
    this.store.getAllGradeList(current);
  }

  onPageChange = (v) => {
    this.setList(v);
  };
  expandedRowRender = (record, index) => {
    let gradeListObject = mobx.toJS(this.store.gradeListObject);
    let childAllList = gradeListObject.childAllList;
    return <Table className='table-child-thead' columns={this.childColumns}
      dataSource={childAllList[index]} rowKey="id" pagination={false}/>;
  };


  render() {
    let gradeListObject = mobx.toJS(this.store.gradeListObject);
    let gradeAllList = gradeListObject.gradeAllList;
    let initialValues = this.state.initialValues;
    let current=gradeListObject.pageNum?Number(gradeListObject.pageNum):0;
    let pageSize=gradeListObject.pageSize?Number(gradeListObject.pageSize):10;
    let total=gradeListObject.total?gradeListObject.total:0;
    return (
      <div className="grade">
        <div className="project-breadcrumb">
          <Breadcrumb>
            <Breadcrumb.Item>组织</Breadcrumb.Item>
            <Breadcrumb.Item>年级管理</Breadcrumb.Item>
          </Breadcrumb>
          <p className="project-title-first">年级管理</p>
          <p>通过年级管理来管理年级</p>
        </div>
        <div className="project-content-first">
          <p className="project-content-title">年级列表</p>
          <Button className="project-content-button" type="primary" onClick={this.createSemester}>添加年级</Button>
          <Table columns={this.parentColumns}
            pagination={false}
            className='project-table-mix project-margin-top'
            expandedRowRender={(record, index) => this.expandedRowRender(record, index)}
            rowKey="id"
            dataSource={gradeAllList}/>
          <Pagination className="project-margin-top" pageSize={pageSize}
            current={current} onChange={this.onPageChange}
            total={total}/>
        </div>
        <GradeModal modalVisible={this.state.modalVisible} modalTitle={this.state.modalTitle}
          onHandleCancel={this.onHandleCancel}
          initValues={initialValues} onHandleSubmit={this.onHandleSubmit}
          store={this.store}
        />
      </div>
    );
  }
}
