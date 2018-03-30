import React from 'react';
import {
  Breadcrumb,
  Button,
  Table,
  Popconfirm,
  Pagination,
  message,
} from 'antd';
import * as mobx from 'mobx';
import {observer} from 'mobx-react';
import BuildingModal from './BuildingModal';

@observer
export default class buildingIndex extends React.Component {
  parentColumns = [{
    title: '名称',
    dataIndex: 'buildingName',
    key: 'buildingName',
  }, {
    title: '编号',
    dataIndex: 'buildingNumber',
    key: 'buildingNumber',
  }, {
    title: '教室数量(个)',
    dataIndex: 'buildingRoomNum',
    key: 'buildingRoomNum',
  }, {
    title: '操作',
    dataIndex: 'operate',
    key: 'operate',
    render: (text, record) =>
      <div>
        <span className="operate-edit" onClick={() => this.onEdit(text, record)}>编辑</span>
        <Popconfirm title="你确定要删除这行内容吗？" onConfirm={() => this.onDelete(text, record)} okText="确定" cancelText="取消">
          <a href="javascript:void(0);">删除</a>
        </Popconfirm>
      </div>
  }];
store=this.props.store;
  onDelete = (text, record) => {
    this.setState({
      cbId: record.id
    });
    const success = () => {
      message.success('删除成功');
      this.setList(1);
    };
    const error = (error) => {
      if(error.message){
        message.error(error.message);
      }else{
        message.error('删除失败');
      }
    };
    this.store.deleteBuilding(record.id).then(success, error);

  };
  onEdit = (text, record) => {
    this.setState({
      modalVisible: true,
      modalTitle: '修改教学楼',
      initialValues: record,
      operate: 'edit',
      cbId: record.id
    });
  };

  constructor(props) {
    super(props);
    this.state = {
      modalVisible: null,
      modalTitle: '',
      initialValues: [],
      operate: null,
      cbId: null
    };
  }

  createSemester = () => {
    this.setState({
      modalVisible: true,
      modalTitle: '添加新教学楼',
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
    let buildingListObject = mobx.toJS(this.store.buildingListObject);
    if (operate == 'add') {
      const success = () => {
        message.success('添加成功');
        this.setList(1);
        this.onHandleCancel();
      };
      const error = (error) => {
        if(error.message){
          message.error(error.message);
        }else{
          message.error('添加失败');
        }
      };
      this.store.addBuilding(values).then(success, error);
    } else {
      values.cbId = this.state.cbId;
      const success = () => {
        message.success('修改成功');
        this.setList(buildingListObject.pageNum);
        this.onHandleCancel();
      };
      const error = (error) => {
        if(error.message){
          message.error(error.message);
        }else{
          message.error('修改失败');
        }
      };
      this.store.editBuilding(values).then(success, error);
    }
  };

  componentDidMount() {
    this.setList(1);
  }
  setList(current){
    this.store.getAllBuildingList(current);
  }

  onPageChange = (v) => {
    this.setList(v);
  };

  render() {
    let buildingListObject = mobx.toJS(this.store.buildingListObject);
    let initialValues = this.state.initialValues;
    let current=buildingListObject.pageNum?Number(buildingListObject.pageNum):0;
    let pageSize=buildingListObject.pageSize?Number(buildingListObject.pageSize):10;
    let total=buildingListObject.total?buildingListObject.total:0;
    return (
      <div className="building">
        <div className="project-breadcrumb">
          <Breadcrumb>
            <Breadcrumb.Item>硬件</Breadcrumb.Item>
            <Breadcrumb.Item>教学楼管理</Breadcrumb.Item>
          </Breadcrumb>
          <p className="project-title-first">教学楼管理</p>
          <p>学年管理包括学年管理、学期管理以及学期开学和放假日期的管理</p>
        </div>
        <div className="project-content-first">
          <p className="project-content-title">教学楼列表</p>
          <Button className="project-content-button" type="primary" onClick={this.createSemester}>添加教学楼</Button>
          <Table columns={this.parentColumns}
            pagination={false}
            className='project-table-mix project-margin-top'
            rowKey="id"
            dataSource={buildingListObject.list}/>
          <Pagination className="project-margin-top" pageSize={pageSize}
            current={current} onChange={this.onPageChange}
            total={total}
          />
        </div>
        <BuildingModal modalVisible={this.state.modalVisible} modalTitle={this.state.modalTitle}
          onHandleCancel={this.onHandleCancel}
          initValues={initialValues} onHandleSubmit={this.onHandleSubmit}
        />
      </div>
    );
  }
}
