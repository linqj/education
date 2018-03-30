import React from 'react';
import {Breadcrumb, Button, Table, Popconfirm, message, Form, Pagination} from 'antd';
import {observer} from 'mobx-react';
import SectionModal from './SectionModal';
import moment from 'moment';

@Form.create()
@observer
export default class SectionIndex extends React.Component {
  _mounted = false;
  store = this.props.store;
  columns = [{
    title: '节次',
    dataIndex: 'sort',
    key: 'sort',
    width: '20%'

  }, {
    title: '名称',
    dataIndex: 'name',
    key: 'name',
    width: '20%'

  }, {
    title: '开始时间',
    dataIndex: 'startTime',
    key: 'startTime',
    width: '20%'

  }, {
    title: '结束时间',
    dataIndex: 'endTime',
    key: 'endTime',
    width: '20%'
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
      allData: [],
      researchId: null,
      current: null,
      total: null,
      pageSize: null,
      operate: null,
      initialValues:[],
      sign:'add',
    };
  }

  createSection = () => {
    this.setState({
      modalVisible: true,
      modalTitle: '添加节次',
      initialValues: [],
      operate: 'add',
      sign:'add'
    });
  };
  initSection = () => {
    this.setState({
      modalVisible: true,
      modalTitle: '初始化节次',
      operate:'init',
      sign:'init'
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
    this.store.delSectionList(record.id).then(success, error);
  };
  onEdit = (text, record, index) => {
    this.setState({
      modalVisible: true,
      modalTitle: '修改节次',
      initialValues: record,
      operate: 'edit',
      sign:'add',
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
      values.id = this.state.researchId;
      values.startTime=moment(values.startTime).format('HH:mm');
      values.endTime=moment(values.endTime).format('HH:mm');
      const success = () => {
        message.success('修改成功');
        this.renderView(1);
        this.onHandleCancel();
      };
      const error = () => {
        message.error('修改失败');
      };
      this.store.editSectionList(values).then(success, error);
    } else if (this.state.operate === 'add') {
      values.sort=Number(values.sort);
      values.startTime=moment(values.startTime).format('HH:mm');
      values.endTime=moment(values.endTime).format('HH:mm');
      const success = () => {
        message.success('添加成功');
        this.renderView(1);
        this.onHandleCancel();
      };
      const error = () => {
        message.error('添加失败');
      };
      this.store.saveSectionList(values).then(success, error);
    }else if(this.state.operate==='init'){
      values.firstCourseTime=moment(values.firstCourseTime).format('HH:mm');
      values.pmFirstCourseTime=moment(values.pmFirstCourseTime).format('HH:mm');
      values.courseLength=Number(values.courseLength);
      values.courseNum=Number(values.courseNum);
      values.gymnasticsLength=Number(values.gymnasticsLength);
      values.gymnasticsSort=Number(values.gymnasticsSort);
      values.recess=Number(values.recess);
      values.pmFirstCourseSort=Number(values.pmFirstCourseSort);
      const success = () => {
        message.success('初始化成功');
        this.renderView(1);
        this.onHandleCancel();
      };
      const error = () => {
        message.error('初始化失败');
      };
      this.store.initSectionList(values).then(success, error);
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
    this.store.getAllSectionList(current).then(res => {
      if (this._mounted) {
        this.setState({
          allData: res.data.pageInfo.list,
          current: Number(res.data.pageInfo.pageNum),
          total: Number(res.data.pageInfo.total),
          pageSize: Number(res.data.pageInfo.pageSize),
        });
      }
    });
  }

  onPageChange = (v) => {
    this.renderView(v);
  };

  render() {

    return (
      <div className="section">
        <div className="project-breadcrumb">
          <Breadcrumb>
            <Breadcrumb.Item>课时</Breadcrumb.Item>
            <Breadcrumb.Item>节次管理</Breadcrumb.Item>
          </Breadcrumb>
          <p className="project-title-first">节次管理</p>
          <p>管理规划学校的课程节次、上课下课时间、休息时间、课间操时间安排等</p>
        </div>
        <div className="project-content-first">
          <p className="project-content-title">节次列表</p>
          <Button type="primary" onClick={this.createSection}>添加节次</Button>
          <Button className='section-right-button' type="default" onClick={this.initSection}>初始化节次</Button>
          <Table className='project-margin-top' columns={this.columns} dataSource={this.state.allData} rowKey="id"
            pagination={false}/>
          <Pagination className="project-margin-top" pageSize={this.state.pageSize}
            current={this.state.current} onChange={this.onPageChange}
            total={this.state.total}/>
        </div>
        <SectionModal modalVisible={this.state.modalVisible} modalTitle={this.state.modalTitle} handleCancel={this.onHandleCancel} onHandleSubmit={this.onHandleSubmit} initValues={this.state.initialValues} store={this.props.store} formSign={this.state.sign} />
      </div>
    );
  }
}

