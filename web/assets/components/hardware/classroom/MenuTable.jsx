import React from 'react';
import {Breadcrumb, Table, Input, Popconfirm, message} from 'antd';
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
export default class MenuTable extends React.Component {
  store = this.props.store;

  constructor(props) {
    super(props);
    this.columns = [{
      title: '教室名称',
      dataIndex: 'roomName',
      render: (text, record) => this.renderColumns(text, record, 'roomName'),
    }, {
      title: '教室编号',
      dataIndex: 'roomNumber',
      render: (text, record) => this.renderColumns(text, record, 'roomNumber'),
    }, {
      title: '操作',
      dataIndex: 'operation',
      render: (text, record,index) => {
        const {editable} = record;
        return (
          <div>
            {
              editable ?
                <span>
                  <Popconfirm title="确定要保存此项内容吗?" onConfirm={() => this.save(record.id)} okText="确定" cancelText="取消">
                    <a href="javascript:void(0);" className="operate-edit">保存</a>
                  </Popconfirm>
                  <a href="javascript:void(0);" onClick={() => this.cancel(record.id)}>取消</a>
                </span>
                : <span>
                  <a href="javascript:void(0);" onClick={() => this.edit(record.id)} className="operate-edit">修改</a>
                  <Popconfirm title="确定要删除此项内容吗?" onConfirm={() => this.delete(record.id)} okText="确定" cancelText="取消">
                    <a href="javascript:void(0);">删除</a>
                  </Popconfirm>
                </span>
            }
          </div>
        );
      },
    }];
    this.state = {
      classList: [],
      oneNewClass: [],
      roomBuildingId: null
    };
    this.cacheData = this.state.classList.map(item => ({...item}));
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.roomBuildingId) {
      //获取对应的教室列表
      this.getAllClassList(nextProps.roomBuildingId);
      this.setState({
        roomBuildingId: nextProps.roomBuildingId
      });
    }
  }

  getAllClassList(buildingId){
    this.store.getClassroomListByBuilding(buildingId).then(json => {
      this.setState({
        classList: json.data.list
      });
    });
  }

  renderColumns(text, record, column) {
    return (
      <EditableCell
        editable={record.editable}
        value={text}
        onChange={value => this.handleChange(value, record.id, column)}
      />
    );
  }

  handleChange(value, key, column) {
    const newData = [...this.state.classList];
    const target = newData.filter(item => key === item.id)[0];
    if (target) {
      target[column] = value;
      this.setState({oneNewClass: target});
    }
  }

  edit(key) {
    const newData = [...this.state.classList];
    const target = newData.filter(item => key === item.id)[0];
    if (target) {
      target.editable = true;
      this.setState({classList: newData});
    }
  }

  save = (id) => {
    let oneNewClass=this.state.oneNewClass;
    oneNewClass.cbId=this.state.roomBuildingId;
    //保存
    const success = () => {
      message.success('保存成功');
      this.getAllClassList(this.state.roomBuildingId);
    };
    const error = (error) => {
      if(error.message){
        message.error(error.message);
      }else{
        message.error('保存失败');
      }
    };
    if(oneNewClass&&oneNewClass.operate=='add'){
      this.store.addOneNewClassroom(oneNewClass).then(success, error);
    }else{
      oneNewClass.crId=id;
      this.store.saveOneNewClassroom(oneNewClass).then(success, error);
    }
  };
  delete = (classId) => {
    const success = () => {
      message.success('删除成功');
      this.getAllClassList(this.state.roomBuildingId);
    };
    const error = (error) => {
      if(error.message){
        message.error(error.message);
      }else{
        message.error('删除失败');
      }
    };
    this.store.deleteClassroom(classId).then(success, error);
  };

  cancel(key) {
    const newData = [...this.state.classList];
    const target = newData.filter(item => key === item.id)[0];
    if (target) {
      Object.assign(target, this.cacheData.filter(item => key === item.id)[0]);
      delete target.editable;
      this.setState({classList: newData});
    }
  }

  //点击添加按钮
  handleAdd = () => {
    let classList=this.state.classList;
    const newData = {
      key: classList.length,
      roomName:null,
      roomNumber: null,
      editable:true,
      operate:'add',

    };
    classList.push(newData);
    this.setState({
      classList:classList,
    });
  };

  render() {
    return (
      <div className="project-menu-table">
        <div>
          <Breadcrumb>
            <Breadcrumb.Item>硬件</Breadcrumb.Item>
            <Breadcrumb.Item>教室管理</Breadcrumb.Item>
          </Breadcrumb>
          <p className="project-title-first">{this.props.buildingName}&nbsp;&nbsp;教室列表</p>
        </div>
        <Table dataSource={this.state.classList} rowKey={'id'} columns={this.columns} pagination={false}/>
        <div className="project-table-add" onClick={this.handleAdd}>+添加</div>
      </div>
    );
  }
}
