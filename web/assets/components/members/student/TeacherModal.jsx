import React from 'react';
import {
  Modal,
  Form,
  Select,
} from 'antd';
const FormItem = Form.Item;
const Option = Select.Option;
import * as mobx from 'mobx';
import {observer} from 'mobx-react';

@observer
class TeacherModal extends React.Component {
  handleSubmit = () => {
    this.props.form.validateFields((err, values) => {
      if (!err) {
        this.props.onTeacherSubmit(values.teacherId);
      }
    });
  };

  componentDidMount() {
    this.props.store.getAllTeacher();
  }
  render() {
    const { getFieldDecorator } = this.props.form;
    const formItemLayout = {
      labelCol: {span: 6},
      wrapperCol: {span: 16},
    };
    let teacherList=this.props.store.teacherList?mobx.toJS(this.props.store.teacherList):[];
    return (
      <Modal
        title="班主任选择"
        visible={this.props.visible}
        onOk={this.handleSubmit}
        onCancel={this.props.handleCancel}
      >
        <Form  onSubmit={this.handleSubmit}>
          <FormItem
            {...formItemLayout}
            label='选择教师'>
            {getFieldDecorator('teacherId', {
              rules: [{ required: true, message: '请选择班主任' }],
            })(
              <Select >
                {teacherList.map(item=>{
                 return <Option value={(item.id).toString()} key={item.id}>{item.teacherName}</Option>;
                })}
              </Select>
            )}
          </FormItem>
        </Form>
      </Modal>
    );
  }
}

const fieldsName = ['teacherId'];
const WrappedTeacherModal = Form.create({
  mapPropsToFields (props) {
    let p = {};
    let {initValues} = props;
    if (initValues) {
      fieldsName.forEach(key => p[key] = {value: initValues[key]});
      if(initValues['teacherId']){
        p['teacherId'] = {value: initValues['teacherId'].toString()};
      }
    }
    return p;
  },
})(TeacherModal);

export default WrappedTeacherModal;
