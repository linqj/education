import React from 'react';
import {Pagination, Table, Input, Popconfirm, message, Button, Select} from 'antd';
const {Option} = Select;
import * as mobx from 'mobx';
import CourseModal from './CourseModal';
import {observer} from 'mobx-react';

@observer
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

class EditableSelectCell extends React.Component {
  render() {
    let valueList = this.props.valueList;
    return <div>
      {this.props.editable
        ? <Select defaultValue={this.props.value} onChange={e => this.props.onSelectChange(e)}>
          {valueList.map(item => {
            return <Option value={item.code} key={item.code}>{item.name}</Option>;
          })}
        </Select>
        : this.props.value
      }
    </div>;
  }
}
@observer
export default class CourseTable extends React.Component {
  store = this.props.store;

  constructor(props) {
    super(props);
    this.columns = [{
      title: '课程名称',
      dataIndex: 'courseName',
      render: (text, record) => this.renderColumns(text, record, 'courseName'),
    }, {
      title: '学科',
      dataIndex: 'disciplineName',
      className: 'project-content-min-width',
      render: (text, record) => this.renderSelectColumns(text, record, 'courseDiscipline'),
    }, {
      title: '序号',
      dataIndex: 'courseNumber',
      render: (text, record) => this.renderColumns(text, record, 'courseNumber'),
    },
      //   {
      //   title: '总学时',
      //   dataIndex: 'coursePlanLength',
      //   className: 'project-content-min-width',
      //   render: (text, record) => {
      //     return this.EditableCell(text, record, 'coursePlanLength');
      //   }
      // },
      //   {
      //   title: '周学时',
      //   dataIndex: 'keyClassroomName',
      //   className: 'project-content-min-width',
      //   render: (text, record) => {
      //     return this.EditableCell(text, record, 'keyClassroomId');
      //   }
      // },
      {
        title: '是否走班',
        dataIndex: 'courseTypeFixed',
        className: 'project-content-min-width',
        render: (text, record) => {
          let isTrue = '否';
          if (text) {
            isTrue = '是';
          }
          return this.renderSelectColumns(isTrue, record, 'courseTypeFixed');
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
      courseList: [],
      getCourseCourse: [],
      gradeId: null,
      pageNum: null,
      pageSize: null,
      total: null,
      modalVisible: null,
      modalTitle: '课程管理',
    };
    this.cacheData = this.state.courseList.map(item => ({...item}));
  }

  componentDidMount() {
    this.getCourseList(this.props.gradeId);
    this.store.getCourseTypeList();
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.gradeId) {
      //获取对应的班级列表
      this.getCourseList(nextProps.gradeId);
      this.setState({
        gradeId: nextProps.gradeId,
        modalVisible: null
      });
    }
  }

  getCourseList = (gradeId) => {
    this.store.getAllCourseList(gradeId).then(json => {
      let data = json.data.pageInfo;
      this.setState({
        courseList: data.list,
        pageNum: data.pageNum,
        pageSize: data.pageSize,
        total: data.total
      });
    });
  };
  onPageChange = (v) => {
    this.getCourseList(this.props.gradeId, v);
  };

  renderColumns(text, record, column) {
    return (
      <EditableCell
        editable={record.editable}
        value={text}
        onChange={value => this.handleChange(value, record.id, column)}
      />
    );
  }

  renderSelectColumns(text, record, column) {
    let valueList = [];
    if (column == 'courseDiscipline') {
      valueList = this.store.courseTypeList ? mobx.toJS(this.store.courseTypeList) : [];
    } else {
      valueList = [{code: 'false', name: '否'}, {code: 'true', name: '是'}];
    }
    return (
      <EditableSelectCell
        editable={record.editable}
        valueList={valueList}
        value={text}
        onSelectChange={value => this.handleChange(value, record.id, column)}
      />
    );
  }

  handleChange = (value, key, column) => {
    const newData = [...this.state.courseList];
    const target = newData.filter(item => key === item.id)[0];
    if (target) {
      target[column] = value;
      this.setState({getCourseCourse: target});
    }
  };
  createCourse = () => {
    this.setState({
      modalVisible: true
    });

  };

  edit(key) {
    const newData = [...this.state.courseList];
    const target = newData.filter(item => key === item.id)[0];
    if (target) {
      target.editable = true;
      this.setState({
        courseList: newData,
        getCourseCourse: target
      });
    }
  }

  save = () => {
    let getCourseCourse = this.state.getCourseCourse;
    //保存
    const success = () => {
      message.success('保存成功');
      this.getCourseList(this.props.gradeId);
    };
    const error = (error) => {
      if (error.message) {
        message.error(error.message);
      } else {
        message.error('保存失败');
      }
    };
    this.store.editCourse(getCourseCourse).then(success, error);
  };
  delete = (courseId) => {
    const success = () => {
      message.success('删除成功');
      this.getCourseList(this.props.gradeId);
    };
    const error = (error) => {
      if (error.message) {
        message.error(error.message);
      } else {
        message.error('删除失败');
      }
    };
    this.store.deleteCourse(courseId).then(success, error);
  };

  cancel(key) {
    const newData = [...this.state.courseList];
    const target = newData.filter(item => key === item.id)[0];
    if (target) {
      Object.assign(target, this.cacheData.filter(item => key === item.id)[0]);
      delete target.editable;
      this.setState({courseList: newData});
    }
  }

  //关闭课程管理对话框
  onHandleCancel = () => {
    this.setState({
      modalVisible: false
    });
  };
  onHandleSubmit = (values) => {
    const success = () => {
      message.success('添加成功');
      this.getCourseList(this.props.gradeId);
      this.onHandleCancel();
    };
    const error = (error) => {
      if (error.message) {
        message.error(error.message);
      } else {
        message.error('添加失败');
      }
    };
    this.store.addCourse({gradeId: this.props.gradeId, codes: values}).then(success, error);
  };


  render() {
    let current = this.state.pageNum;
    let pageSize = this.state.pageSize ? Number(this.state.pageSize) : 10;
    let total = this.state.total ? this.state.total : 0;
    return (
      <div className="course-tabs-table">
        <p className="course-tabs-table-title">{this.props.gradeName}班级列表</p>
        <Button type="primary" onClick={this.createCourse}>课程管理</Button>
        <Table dataSource={this.state.courseList} rowKey="id" className='project-margin-top' columns={this.columns}
               pagination={false}/>
        <Pagination className="project-margin-top" pageSize={pageSize}
                    current={current} onChange={this.onPageChange}
                    total={total}/>
        <CourseModal modalVisible={this.state.modalVisible} modalTitle={this.state.modalTitle}
                     gradeName={this.props.gradeName} gradeIdIndex={this.props.gradeId}
                     courseStore={this.props.store}
                     handleCancel={this.onHandleCancel} handleSubmit={this.onHandleSubmit}
                     tabsIndex={this.props.tabIndex}/>
      </div>
    );
  }
}

