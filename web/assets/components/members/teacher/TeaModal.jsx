import React from 'react';
import {
  Form,
  Input,
  Select,
} from 'antd';
const FormItem = Form.Item;
const {Option,} = Select;
import * as mobx from 'mobx';
import {observer} from 'mobx-react';
import OperateSemester from '../../common/modal/OperateSemester';

@observer
class TeaModal extends React.Component {
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
      teacherGroup: [],
    };
  }

  componentDidMount() {
    this._mounted = true;

    //获取教研组列表
    const store = this.props.store;
    store.getGroupList().then(res=>{
      if(this._mounted){
        this.setState({
          teacherGroup:res,
        });
      }
    });
    //获取性别
    store.getGenderList();
    //获取级别列表
    store.getTeaLevelList();


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
    let teacherGroup = this.state.teacherGroup;
    let teaLevelList = store.teaLevelList ? mobx.toJS(store.teaLevelList) : [];

    return (
      <OperateSemester visible={this.props.modalVisible} title={this.props.modalTitle}
                       handleOk={this.handleSubmit} handleCancel={this.props.onHandleCancel}>
        <Form onSubmit={this.handleSubmit}>
          <FormItem
            {...formItemLayout}
            label='教师姓名'
          >
            {getFieldDecorator('teacherName')(
              <Input placeholder="请输入"/>
            )}
          </FormItem>
          <FormItem
            {...formItemLayout}
            label='工号'
          >
            {getFieldDecorator('teacherNumber')(
              <Input placeholder="请输入"/>
            )}
          </FormItem>
          <FormItem
            {...formItemLayout}
            label="性别"
          >
            {getFieldDecorator('teacherGender')(
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
            {getFieldDecorator('teacherLevel')(
              <Select placeholder="请选择">
                {teaLevelList.map(item => {
                  return <Option value={item.code} key={item.code}>{item.name}</Option>;
                })}
              </Select>
            )}
          </FormItem>
          {this.props.identify === 'all' ? <FormItem
            {...formItemLayout}
            label="所属教研组"
          >
            {getFieldDecorator('teacherGroupId')(
              <Select
                placeholder="请选择"
              >
                {
                  teacherGroup.map((item,index)=>{
                    return <Option value={(item.id).toString()} key={index}>{item.tgName}</Option>;
                  })
                }
              </Select>
            )}
          </FormItem> :<div/>
          }
        </Form>
      </OperateSemester>
    );
  }
}
const fieldsName = ['teacherName', 'teacherNumber', 'teacherGender', 'teacherLevel', 'teacherGroupId'];
const WrappedTeaModal = Form.create({
  mapPropsToFields (props) {
    let p = {};
    let {initValues} = props;
    if (initValues) {
      fieldsName.forEach(key => p[key] = {value: initValues[key]});
      if (initValues['teacherGroupId'] || initValues['teacherGroupId'] === 0) {
        p['teacherGroupId'] = {value: initValues['teacherGroupId'].toString()};
      }
    }
    return p;
  },
})(TeaModal);

export default WrappedTeaModal;
