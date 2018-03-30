import React from 'react';
import {Breadcrumb, Table, Input, Popconfirm, message, Select} from 'antd';
const { Option, OptGroup } = Select;
import * as mobx from 'mobx';

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
class EditableMutilSelectCell extends React.Component {
  render() {
    let classTypeList=this.props.classTypeList?this.props.classTypeList:[];
    let defaultValue=[];
    if(this.props.value && this.props.value!='null'){
      defaultValue=this.props.value;
    }
    return <div>
      {this.props.editable
        ? <Select mode="multiple" defaultValue={defaultValue} onChange={e => this.props.onMutilSelectChange(e)}>
          {classTypeList.map(item => {
            return <Option value={(item.code).toString()} key={item.id}>{item.name}</Option>;
          })}
        </Select>
        : defaultValue
      }
    </div>;
  }
}
class EditableSelectCell extends React.Component {
  render() {
    let classNameList=this.props.classNameList?this.props.classNameList:[];
    return <div>
      {this.props.editable
        ? <Select  defaultValue={this.props.value} onChange={e => this.props.onSelectChange(e)}>
          {classNameList.map(items => {
            return <OptGroup label={items.buildingName} key={items.buildingName}>
              {items.children.map(item=>{
                return <Option value={(item.id).toString()} key={item.id}>{item.roomName}</Option>;
              })}
            </OptGroup>;
          })}
        </Select>
        : (<span>{this.props.buildingName}{this.props.value}</span>)
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
      title: '班级名称',
      dataIndex: 'claName',
      render: (text, record) => this.renderColumns(text, record, 'claName'),
    }, {
      title: '代码',
      dataIndex: 'classCode',
      render: (text, record) => this.renderColumns(text, record, 'classCode'),
    }, {
      title: '班级类型',
      dataIndex: 'classType',
      className:'project-content-min-width',
      render: (text, record) =>{
        return  this.renderMutilSelectColumns(text, record, 'classType');
      }

    }, {
      title: '所在教室',
      dataIndex: 'keyClassroomName',
      className:'project-content-min-width',
      render: (text, record) => {
        return this.renderSelectColumns(text, record, 'keyClassroomId');
      }
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
      gradeId: null
    };
    this.cacheData = this.state.classList.map(item => ({...item}));
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.gradeId) {
      //获取对应的班级列表
      this.getAllClassList(nextProps.gradeId);
      this.setState({
        gradeId: nextProps.gradeId
      });
    }
  }

  getAllClassList = (gradeId) => {
    this.store.getClassListByGrad(gradeId).then(json => {
      this.setState({
        classList: json
      });
    });
  };

  componentDidMount() {
    this.store.getClassTypeList();
    this.store.getClassNameList();
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

  renderMutilSelectColumns(text, record, column) {
    let classTypeList = this.store.classTypeList ? mobx.toJS(this.store.classTypeList) : [];
    return (
      <EditableMutilSelectCell
        classTypeList={classTypeList}
        editable={record.editable}
        value={text}
        onMutilSelectChange={value => this.handleChange(value, record.id, column)}
      />
    );
  }
  renderSelectColumns(text, record, column) {
    let classNameList = this.store.classNameList ? mobx.toJS(this.store.classNameList) : [];
    return (
      <EditableSelectCell
        classNameList={classNameList}
        editable={record.editable}
        value={text}
        buildingName={record.keyClassroomBuldingName}
        onSelectChange={value => this.handleChange(value, record.id, column)}
      />
    );
  }
  handleChange=(value, key, column)=> {
    const newData = [...this.state.classList];
    const target = newData.filter(item => key === item.id)[0];
    if (target) {
      target[column] = value;
      this.setState({oneNewClass: target});
    }
  };

  edit(key) {
    const newData = [...this.state.classList];
    const target = newData.filter(item => key === item.id)[0];
    if (target) {
      target.editable = true;
      this.setState({classList: newData,
        oneNewClass:target});
    }
  }

  save = () => {
    let oneNewClass = this.state.oneNewClass;
    //保存
    const success = () => {
      message.success('保存成功');
      this.getAllClassList(this.state.gradeId);
    };
    const error = (error) => {
      if (error.message) {
        message.error(error.message);
      } else {
        message.error('保存失败');
      }
    };
    if (oneNewClass && oneNewClass.operate == 'add') {
      this.store.addOneNewClass(oneNewClass).then(success, error);
    } else {
      this.store.saveOneNewClass(oneNewClass).then(success, error);
    }
  };
  delete = (classId) => {
    const success = () => {
      message.success('删除成功');
      this.getAllClassList(this.state.gradeId);
    };
    const error = (error) => {
      if (error.message) {
        message.error(error.message);
      } else {
        message.error('删除失败');
      }
    };
    this.store.deleteClass(classId).then(success, error);
  };

  cancel(key) {
    const newData = [...this.state.classList];
    const target = newData.filter(item => key === item.id)[0];
    newData.forEach((item,index)=>{
      if(!item.id){
        newData.splice(index,1);
      }
    });
    if (target) {
      Object.assign(target, this.cacheData.filter(item => key === item.id)[0]);
      delete target.editable;
      this.setState({classList: newData});
    }
  }

  //点击添加按钮
  handleAdd = () => {
    let classList = this.state.classList;
    const newData = {
      key: classList.length,
      claName: null,
      classCode: null,
      classType: null,
      editable: true,
      operate: 'add',
      classGradeId: this.state.gradeId
    };
    classList.push(newData);
    this.setState({
      classList: classList,
    });
  };

  render() {
    return (
      <div className="project-menu-table">
        <div>
          <Breadcrumb>
            <Breadcrumb.Item>组织</Breadcrumb.Item>
            <Breadcrumb.Item>班级管理</Breadcrumb.Item>
          </Breadcrumb>
          <p className="project-title-first">{this.props.gradeName}班级列表</p>
        </div>
        <Table dataSource={this.state.classList} rowKey="id" columns={this.columns} pagination={false}/>
        <div className="project-table-add" onClick={this.handleAdd}>+添加</div>
      </div>
    );
  }
}
