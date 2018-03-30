import React from 'react';
import {Breadcrumb, Button, Table, Popconfirm, message, Form, Pagination} from 'antd';
import {observer} from 'mobx-react';
import ResearchModal from './ResearchModal';
import {Link} from 'react-router-dom';

@Form.create()
@observer
export default class ResearchIndex extends React.Component {
  _mounted = false;
  store = this.props.store;
  columns = [{
    title: '名称',
    dataIndex: 'tgName',
    key: 'tgName',
    width: '15%',
    render:(text,record)=>{
      return <Link to={`/members/teacher/${record.id}`}>{text}</Link>;
    }

  }, {
    title: '代码',
    dataIndex: 'tgCode',
    key: 'tgCode',
    width: '10%'

  }, {
    title: '教师数(人)',
    dataIndex: 'tgTeacherNumber',
    key: 'tgTeacherNumber',
    width: '15%'

  }, {
    title: '教研组长',
    dataIndex: 'tgLeader',
    key: 'tgLeader',
    width: '15%'
  }, {
    title: '负责科目',
    dataIndex: 'ctList',
    key: 'ctList',
    width: '30%',
    render: (text, record) => {
      let values = [];
      text.forEach(item => {
        values.push(item.courseName);
      });
      values=values.join(' | ');
      return <span>{values}</span>;
    }
  }, {
    title: '操作',
    key: 'action',
    render: (text, record, index) => (
      <div>
        <span className="operate-edit" onClick={() => this.onEdit(text, record, index)}>编辑</span>
        <Popconfirm title="你确定要删除这行内容吗？" onConfirm={() => this.onDelete(text, record, index)} okText="是" cancelText="否">
          <a href="javascript:void(0);">删除</a>
        </Popconfirm>
      </div>
    ),
  }];

  constructor(props) {
    super(props);
    this.state = {
      modalVisible: null,
      modalTitle: '',
      inputValue: null,
      allData: [],
      researchId: null,
      allTeacherData: null,
      current: null,
      total: null,
      pageSize: null,
      operate: null,
    };
  }

  createSemester = () => {
    this.setState({
      modalVisible: true,
      modalTitle: '添加教研组',
      initialValues: [],
      operate: 'add',
    });
  };
  onDelete = (text, record, index) => {
    const success = () => {
      message.success('删除成功');
      this.renderView(1);
    };
    const error = () => {
      message.error('删除失败');
    };
    this.store.delResearchList(record.id).then(success, error);
  };
  onEdit = (text, record, index) => {
    this.setState({
      modalVisible: true,
      modalTitle: '修改教研组',
      initialValues: record,
      operate: 'edit',
      researchId: record.id
    });
  };
  onHandleCancel = () => {
    this.setState({
      modalVisible: false,
    });
  };
  onHandleSubmit = (values) => {
    if (this.state.operate === 'edit') {
      values.tgid = this.state.researchId;
      const success = () => {
        message.success('修改成功');
        this.renderView(1);
        this.onHandleCancel();
      };
      const error = () => {
        message.error('修改失败');
      };
      this.store.saveResearchList(values).then(success, error);
    } else if (this.state.operate === 'add') {
      const success = () => {
        message.success('添加成功');
        this.renderView(1);
        this.onHandleCancel();
      };
      const error = () => {
        message.error('添加失败');
      };
      this.store.saveResearchList(values).then(success, error);
    }

  };

  componentDidMount() {
    this._mounted = true;
    this.renderView(this.state.current);
  }

  componentWillUnmount() {
    this._mounted = false;
  }

  renderView(current) {
    const store = this.props.store;
    store.getAllResearchList(current).then(res => {
      if (this._mounted) {
        this.setState({
          allData: res.data.list,
          current: Number(res.data.pageNum),
          total: Number(res.data.total),
          pageSize: Number(res.data.pageSize),
        });
      }
    });

  }

  onPageChange = (v) => {
    this.setState({
      current: v
    });
    this.renderView(v);
  };

  render() {

    return (
      <div className="research">
        <div className="project-breadcrumb">
          <Breadcrumb>
            <Breadcrumb.Item>组织</Breadcrumb.Item>
            <Breadcrumb.Item>教研组管理</Breadcrumb.Item>
          </Breadcrumb>
          <p className="project-title-first">教研组管理</p>
          <p>教研组管理包括添加教研组，制定教研组长</p>
        </div>
        <div className="project-content-first">
          <p className="project-content-title">教研组列表</p>
          <Button className="project-content-button" type="primary" onClick={this.createSemester}>添加教研组</Button>
          <Table className='project-margin-top' columns={this.columns} dataSource={this.state.allData} rowKey="id"
            pagination={false}/>
          <Pagination className="project-margin-top" pageSize={this.state.pageSize}
            current={this.state.current} onChange={this.onPageChange}
            total={this.state.total}/>
        </div>
        <ResearchModal modalVisible={this.state.modalVisible} modalTitle={this.state.modalTitle}
          handleCancel={this.onHandleCancel} onHandleSubmit={this.onHandleSubmit}
          initValues={this.state.initialValues} store={this.props.store}/>
      </div>
    );
  }
}

