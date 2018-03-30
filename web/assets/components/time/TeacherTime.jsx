import React from 'react';
import {Select, Button, Breadcrumb, Menu,Pagination,Table,Popconfirm,message,Input} from 'antd';
import * as mobx from 'mobx';
const Option = Select.Option;
import {observer} from 'mobx-react';
class EditableCell extends React.Component {
  render() {
    return <div>
      {this.props.editable
        ? <Input defaultValue={this.props.value} onChange={e => this.props.onChange(e.target.value)}/>
        : this.props.value
      }
    </div>;
  }
}
@observer
export default class TeacherTime extends React.Component {
  store = this.props.store;
  constructor(props) {
    super(props);
    this.state = {
      allYearList: [],
      parentList: [],
      childrenList: [],
      yearValueId: null,
      semesterValueId: null,
      tgId:'all',
      tableValues: [],
      oneNewClass: [],
    };
    this.cacheData = this.state.tableValues.map(item => ({...item}));
  }
  _mounted = false;
  parentColumns = [{
    title: '姓名',
    dataIndex: 'teacherName',
    key: 'teacherName',
  }, {
    title: '教研组',
    dataIndex: 'teacherGroupName',
    key: 'teacherGroupName',
  }, {
    title: '学时',
    dataIndex: 'allLearnTime',
    key: 'allLearnTime',
    render: (text, record) => this.renderColumns(text, record, 'allLearnTime'),
  }, {
    title: '周学时',
    dataIndex: 'weekLearnTime',
    key: 'weekLearnTime',
    render: (text, record) => this.renderColumns(text, record, 'weekLearnTime'),
  }, {
    title: '实际安排课时',
    dataIndex: 'actualCourseTime',
    key: 'actualCourseTime',
    render: (text, record) => this.renderColumns(text, record, 'actualCourseTime'),
  }, {
    title: '操作',
    dataIndex: 'operation',
    render: (text, record, index) => {
      const {editable} = record;
      return (
        <div>
          {
            editable ?
              <span>
                  <Popconfirm title="确定要保存此项内容吗?" onConfirm={() => this.save(record.teacherId)} okText="确定" cancelText="取消">
                    <a href="javascript:void(0);" className="operate-edit">保存</a>
                  </Popconfirm>
                  <a href="javascript:void(0);" onClick={() => this.cancel(record.teacherId)}>取消</a>
                </span>
              : <span>
                  <a href="javascript:void(0);" onClick={() => this.edit(record.teacherId)} className="operate-edit">修改</a>
                </span>
          }
        </div>
      );
    }
  }];
  save = () => {
    let oneNewClass = this.state.oneNewClass;
    //保存
    const success = () => {
      message.success('保存成功');
      this.getTableValues(this.state.yearValueId,this.state.semesterValueId,this.state.tgId);
    };
    const error = (error) => {
      if (error.message) {
        message.error(error.message);
      } else {
        message.error('保存失败');
      }
    };
    oneNewClass.schoolYearId=this.state.yearValueId;
    oneNewClass.semesterId=this.state.semesterValueId;
    oneNewClass.tgId=this.state.tgId;
    this.store.editTimeManger(oneNewClass).then(success, error);
  };
  edit(key) {
    const newData = [...this.state.tableValues];
    const target = newData.filter(item => key === item.teacherId)[0];
    if (target) {
      target.editable = true;
      this.setState({tableValues: newData,
        oneNewClass:target});
    }
  }
  cancel(key) {
    const newData = [...this.state.tableValues];
    const target = newData.filter(item => key === item.teacherId)[0];
    if (target) {
      Object.assign(target, this.cacheData.filter(item => key === item.teacherId)[0]);
      delete target.editable;
      this.setState({tableValues: newData});
    }
  }
  renderColumns(text, record, column) {
    return (
      <EditableCell
        editable={record.editable}
        value={text}
        onChange={value => this.handleChange(value, record.teacherId, column)}
      />
    );
  }
  handleChange=(value, key, column)=> {
    const newData = [...this.state.tableValues];
    const target = newData.filter(item => key === item.teacherId)[0];
    if (target) {
      target[column] = value;
      this.setState({oneNewClass: target});
    }
  };


  handleClick = (e) => {
    this.setState({
      tgId:e.key
    });
    this.getTableValues(this.state.yearValueId,this.state.semesterValueId,e.key);
  };

  componentWillUnmount() {
    this._mounted = false;
  }

  componentDidMount() {
    this._mounted = true;
    //获取学年列表
    this.store.getAllYearList().then(json => {
      if (this._mounted) {
        this.setState({
          allYearList: json,
          childrenList: json.length > 0 ? json[0].children : [],
          yearValueId: json.length > 0 ? json[0].id.toString() : null,
          semesterValueId: json.length > 0 ? json[0].children[0].id.toString() : null,
        });
      }
      this.store.getTableObjects(json[0].id,json[0].id,null).then(json=>{
        let tableListObject = this.store.tableListObject ? mobx.toJS(this.store.tableListObject) : [];
        let tableValues=tableListObject.tctList?tableListObject.tctList:[];
        if (this._mounted) {
          this.setState({
            tableValues:tableValues
          });
        }
      });
    });
    //获取教研组列表
    this.store.getGroupList();
  }
  //获取列表内容
  getTableValues=(syId,xqId,tgId)=>{
    this.store.getTableObjects(syId,xqId,tgId).then(json=>{
      let tableListObject = this.store.tableListObject ? mobx.toJS(this.store.tableListObject) : [];
      let tableValues=tableListObject.tctList?tableListObject.tctList:[];
        this.setState({
          tableValues:tableValues
        });
    });
  };
  onYearSelect = (v) => {
    let allYearList = this.state.allYearList;
    let item = allYearList.filter(item => item.id == v);
    this.setState({
      yearValueId: v,
      childrenList: item[0].children,
      semesterValueId: item[0] ? item[0].children[0].id.toString() : null,
    });
  };
  onSemesterSelect = (v) => {
    this.setState({
      semesterValueId: v
    });
  };
  onPageChange = (v) => {
    this.getTableValues(this.state.yearValueId,this.state.semesterValueId,this.state.tgId,v);
  };
  onSearch=()=>{
    this.getTableValues(this.state.yearValueId,this.state.semesterValueId,this.state.tgId);
  };
  render() {
    let allYearList = this.state.allYearList;
    let childrenList = this.state.childrenList;
    let yearValueId = this.state.yearValueId;
    let semesterValueId = this.state.semesterValueId;
    let groupList = this.store.groupList ? mobx.toJS(this.store.groupList) : [];
    let tableListObject = this.store.tableListObject ? mobx.toJS(this.store.tableListObject) : [];
    let current = tableListObject.pageNum ? Number(tableListObject.pageNum) : 0;
    let pageSize = tableListObject.pageSize ? Number(tableListObject.pageSize) : 10;
    let total = tableListObject.total ? tableListObject.total : 0;
    let tableValues=this.state.tableValues;
    return (
      <div className="time-manger">
        <div className="project-breadcrumb">
          <Breadcrumb>
            <Breadcrumb.Item>课时</Breadcrumb.Item>
            <Breadcrumb.Item>教师课时管理</Breadcrumb.Item>
          </Breadcrumb>
          <p className="project-title-first">教师课时管理</p>
          <p>在这里管理教师的学期课时计划</p>
        </div>
        <div className="project-content-first">
          <div className="time-manger-select">
            <span>学年选择：</span>
            <Select placeholder="请选择" value={yearValueId} onChange={this.onYearSelect}
                    className="project-content-min-width">
              {allYearList.map(item => {
                return <Option value={item.id.toString()} key={item.id}>{item.schoolYearName}</Option>;
              })}
            </Select>
          </div>
          <div className="time-manger-select">
            <span>学期选择：</span>
            <Select placeholder="请选择" value={semesterValueId} onChange={this.onSemesterSelect}
                    className="project-content-min-width">
              {childrenList.map((item, index) => {
                return <Option value={item.id.toString()} key={item.id}>{item.semesterName}</Option>;
              })}
            </Select>
          </div>
          <Button
            type="primary"
            onClick={this.onSearch}
          >
            搜索
          </Button>
          <div className="project-margin-top clear">
            <span className="time-manger-text">所属教研组：</span>
            <Menu
              onClick={this.handleClick}
              defaultSelectedKeys={['all']}
              mode="inline"
            >
              <Menu.Item key={'all'}>全部</Menu.Item>
              {groupList.map(item=>{
                return <Menu.Item key={item.id}>{item.tgName}</Menu.Item>;
              })}
            </Menu>
          </div>
          <Table columns={this.parentColumns}
                 pagination={false}
                 className='project-table-mix project-margin-top'
                 rowKey="teacherId"
                 dataSource={tableValues}/>
          <Pagination className="project-margin-top" pageSize={pageSize}
                      current={current} onChange={this.onPageChange}
                      total={total}/>
        </div>
      </div>
    );
  }
}
