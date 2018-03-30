import React from 'react';
import {Button, Table, Popconfirm, message, Form,Pagination} from 'antd';
import {observer} from 'mobx-react';
import SemesterModal from './SemesterModal';
import moment from 'moment';
import './Index.less';

@Form.create()
@observer
export default class Semester extends React.Component {
  _mounted = false;

  parentColumns = [{
    title: '名称',
    dataIndex: 'schoolYearName',
    key: 'schoolYearName',
    width:'20%'
  }, {
    title: '开始年月',
    dataIndex: 'startTime',
    key: 'startTime',
    render:(text)=>{
      let value=text?moment(text).format('YYYY-MM-DD'):null;
      return <span>{value}</span>;
    }
  }, {
    title: '结束年月',
    dataIndex: 'endTime',
    key: 'endTime',
    render:(text)=>{
      let value=text?moment(text).format('YYYY-MM-DD'):null;
      return <span>{value}</span>;
    }
  }, {
    title: '创建时间',
    dataIndex: 'createTime',
    key: 'createTime',
    render:(text)=>{
      let value=text?moment(text).format('YYYY-MM-DD HH:mm:ss'):null;
      return <span>{value}</span>;
    }
  }, {
    title: '操作',
    dataIndex: 'operate',
    key: 'operate',
    render: (text,record,index) =>
      <div>
        <span className="operate-edit" onClick={()=>this.onEdit(text,record,index)}>编辑</span>
        <Popconfirm title="你确定要删除这行内容吗？" onConfirm={()=>this.onDelete(text,record)} okText="确认" cancelText="取消">
          <a href="javascript:void(0);">删除</a>
        </Popconfirm>
      </div>
  }];
  childColumns = [{
    title: '名称',
    dataIndex: 'semesterName',
    key: 'semesterName',
    width:'21%',
  }, {
    title: '开始年月',
    dataIndex: 'startTime',
    key: 'startTime',
    width:'18%',
    render:(text)=>{
      let value=text?moment(text).format('YYYY-MM-DD'):null;
      return <span>{value}</span>;
    }

  }, {
    title: '结束年月',
    dataIndex: 'endTime',
    key: 'endTime',
    width:'18%',
    render:(text)=>{
      let value=text?moment(text).format('YYYY-MM-DD'):null;
      return <span>{value}</span>;
    }

  }, {
    title: '创建时间',
    dataIndex: 'createTime',
    key: 'createTime',
    width:'15%',
    render:(text)=>{
      let value=text?moment(text).format('YYYY-MM-DD HH:mm:ss'):null;
      return <span>{value}</span>;
    }

  }, {
    title: '操作',
    dataIndex: 'operate',
    key: 'operate',
    render: () =>
      <div style={{width: '38px'}}>
      </div>
  }];

  onDelete = (text,record) => {
    this.setState({
      xnId:record.id
    });
    const store= this.props.store;
    const success=()=>{
      message.success('删除成功');
      this.renderView(1);
    };
    const error = (error) => {
      if(error.message){
        message.error(error.message);
      }else{
        message.error('删除失败');
      }
    };
    store.delSemesterList(record.id).then(success,error);
  };

  onEdit = (text,record,index) => {
    let child=this.state.childList[index];
    record.child=child;
    this.setState({
      modalVisible: true,
      modalTitle: '修改学期',
      initialValues:record,
      operate:'edit',
      xnId:record.id
    });
  };
  constructor(props) {
    super(props);
    this.state = {
      modalVisible: null,
      modalTitle: '',
      semesterData: null,
      childList: [],
      current: null,
      total: null,
      pageSize:null,
      xnId:null,
      initialValues: [],
      operate:null
    };
  }

  createSemester = () => {
    this.setState({
      modalVisible: true,
      modalTitle: '添加学年',
      initialValues:[],
      operate:'add'
    });
  };
  onHandleCancel = () => {
    this.setState({
      modalVisible: false,
    });
  };
  expandedRowRender = (recode, index) => {
    return <Table className='table-child-thead' rowKey="id" columns={this.childColumns}
      dataSource={this.state.childList[index]} pagination={false}/>;
    // return ''
  };
  onHandleSubmit = (values) => {
    // e.preventDefault();
    const store = this.props.store;
    let operate = this.state.operate;
    if(operate=='add'){
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
      store.saveSemesterList(values).then(success,error);
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
      store.saveSemesterList(values).then(success, error);
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
    store.getAllSemesterList(current).then(res => {
      let AllParentList = [];
      let childList = [];
      res.data.list.forEach(item => {
        let parentItem = {};
        Object.keys(item).forEach(items => {
          if (items != 'children') {
            parentItem[items] = item[items];
          } else {
            childList.push(item[items]);
            parentItem.startTime=item[items][0].startTime;
            parentItem.endTime=item[items][1].endTime;
          }
        });
        AllParentList.push(parentItem);
      });

      if (this._mounted) {
        this.setState({
          semesterData: AllParentList,
          childList: childList,
          total: Number(res.data.total),
          current: Number(res.data.pageNum),
          pageSize: Number(res.data.pageSize)
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
      <div>
        <div className="project-content-first">
          <p className="project-content-title">学年列表</p>
          <Button className="project-content-button" type="primary" onClick={this.createSemester}>添加新学年</Button>
          <Table columns={this.parentColumns}
            rowKey="id"
            pagination={false}
            className='project-table-mix project-margin-top'
            expandedRowRender={(recode, index) => this.expandedRowRender(recode, index)}
            dataSource={this.state.semesterData}
          />
          <Pagination className="project-margin-top" pageSize={this.state.pageSize}
            current={this.state.current} onChange={this.onPageChange}
            total={this.state.total}/>
        </div>
        <SemesterModal  modalVisible={this.state.modalVisible} modalTitle={this.state.modalTitle} handleCancel={this.onHandleCancel} handleSubmit={this.onHandleSubmit} initValues={this.state.initialValues}/>
      </div>
    );
  }
}
