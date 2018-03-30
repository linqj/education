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
@Form.create()
@observer
class MoveStudentModal extends React.Component {
  store=this.props.store;
  handleSubmit = () => {
    this.props.form.validateFields((err, values) => {
      if (!err) {
        this.props.moveStudentSubmit(values.classId);
      }
    });
  };

  componentDidMount() {
    this.store.getMoveClassList(this.props.menuKey);
  }

  render() {
    const { getFieldDecorator } = this.props.form;
    const formItemLayout = {
      labelCol: {span: 6},
      wrapperCol: {span: 16},
    };
    let allClass=this.store.allClass?mobx.toJS(this.props.store.allClass):[];

    return (
      <Modal
        title={this.props.moveTitle}
        visible={true}
        onOk={this.handleSubmit}
        onCancel={this.props.onMoveModalCancel}
      >
        <Form  onSubmit={this.handleSubmit}>
          <FormItem
            {...formItemLayout}
            label='选择班级'>

            {getFieldDecorator('classId', {
              rules: [{ required: true, message: '请选择' }],
            })(
              <Select >
                {allClass.map(item=>{
                  return <Option value={(item.id).toString()} key={item.id}>{item.claName}</Option>;
                })}
              </Select>
            )}
          </FormItem>
        </Form>
      </Modal>
    );
  }
}
export default MoveStudentModal;
