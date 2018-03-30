import React from 'react';
import {
  Form,
  Input,
  Select,
} from 'antd';
const FormItem = Form.Item;
const {Option, OptGroup} = Select;
import * as mobx from 'mobx';
import {observer} from 'mobx-react';
import OperateSemester from '../../common/modal/OperateSemester';

@observer
class StudentModal extends React.Component {
  _mounted = false;
  handleSubmit = () => {
    this.props.form.validateFields((err, values) => {
      if (!err) {
        this.props.onHandleSubmit(values);
      }
    });
  };

  constructor(props) {
    super(props);
    this.state = {
      gradeList: [],
    };
  }

  componentDidMount() {
    //获取年级列表
    const store = this.props.store;
    // store.getAllGradeTypeList();
    //获取性别
    store.getGenderList();
    //获取级别列表
    store.getStuLevelList();
    //获取班干列表
    store.getStuClassList();
    //获取所在班级列表
    this._mounted = true;
    //获取年级列表
    store.getGradeList().then(json => {
      if (this._mounted) {
        this.setState({
          gradeList: json,
        });
      }
    });

  }

  componentWillUnmount() {
    this._mounted = false;
  }

  render() {
    const {getFieldDecorator} = this.props.form;
    const formItemLayout = {
      labelCol: {span: 6},
      wrapperCol: {span: 16},
    };
    const store = this.props.store;
    let genderList = store.genderList ? mobx.toJS(store.genderList) : [];
    let gradeList = this.state.gradeList;
    let stuLevelList = store.stuLevelList ? mobx.toJS(store.stuLevelList) : [];
    let stuClassList = store.stuClassList ? mobx.toJS(store.stuClassList) : [];

    return (
      <OperateSemester visible={this.props.modalVisible} title={this.props.modalTitle}
                       handleOk={this.handleSubmit} handleCancel={this.props.onHandleCancel}>
        <Form onSubmit={this.handleSubmit}>
          <FormItem
            {...formItemLayout}
            label='学生姓名'
          >
            {getFieldDecorator('stuName')(
              <Input placeholder="请输入"/>
            )}
          </FormItem>
          <FormItem
            {...formItemLayout}
            label='学号'
          >
            {getFieldDecorator('stuNumber')(
              <Input placeholder="请输入"/>
            )}
          </FormItem>
          <FormItem
            {...formItemLayout}
            label="性别"
          >
            {getFieldDecorator('stuGender')(
              <Select placeholder="请选择">
                {genderList.map(item => {
                  return <Option value={item.code} key={item.code}>{item.name}</Option>;
                })}
              </Select>
            )}
          </FormItem>
          <FormItem
            {...formItemLayout}
            label="级别"
          >
            {getFieldDecorator('stuLevel')(
              <Select placeholder="请选择">
                {stuLevelList.map(item => {
                  return <Option value={item.code} key={item.code}>{item.name}</Option>;
                })}
              </Select>
            )}
          </FormItem>
          {this.props.identify === 'all' ? <FormItem
            {...formItemLayout}
            label="所在班级"
          >
            {getFieldDecorator('classId')(
              <Select
                placeholder="请选择"
              >
                {gradeList.map(items => {
                  let grade = items.grade;
                  let classList = items.classList;
                  return <OptGroup label={grade.gradeName} key={grade.gradeName}>
                    {classList.map(item => {
                      return <Option value={(item.id).toString()} key={item.id}>{item.claName}</Option>;
                    })}
                  </OptGroup>;
                })}
              </Select>
            )}
          </FormItem> : <FormItem
            {...formItemLayout}
            label="班干部"
          >
            {getFieldDecorator('stuClassPost')(
              <Select placeholder="请选择">
                {stuClassList.map(item => {
                  return <Option value={item.code} key={item.code}>{item.name}</Option>;
                })}
              </Select>
            )}
          </FormItem>
          }
        </Form>
      </OperateSemester>
    );
  }
}
const fieldsName = ['stuName', 'stuNumber', 'stuGender', 'stuLevel', 'classId','stuClassPost'];
const WrappedStudentModal = Form.create({
  mapPropsToFields (props) {
    let p = {};
    let {initValues} = props;
    if (initValues) {
      fieldsName.forEach(key => p[key] = {value: initValues[key]});
      if (initValues['classId'] || initValues['classId'] === 0) {
        p['classId'] = {value: initValues['classId'].toString()};
      }
      if(initValues['stuClassPost']==='null'){
        p['stuClassPost']={value:''};
      }
    }
    return p;
  },
})(StudentModal);

export default WrappedStudentModal;
