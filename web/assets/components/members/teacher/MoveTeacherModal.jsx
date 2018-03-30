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
class MoveTeacherModal extends React.Component {
  store=this.props.store;
  handleSubmit = () => {
    this.props.form.validateFields((err, values) => {
      if (!err) {
        this.props.moveTeacherSubmit(values.groupId);
      }
    });
  };

  componentDidMount() {
    this.store.getMoveGroupList(this.props.menuKey);
  }
  render() {
    const { getFieldDecorator } = this.props.form;
    const formItemLayout = {
      labelCol: {span: 6},
      wrapperCol: {span: 16},
    };
    let moveGroupList=this.store.MoveGroupList?mobx.toJS(this.props.store.MoveGroupList):[];

    return (
      <Modal
        title={this.props.movetitle}
        visible={true}
        onOk={this.handleSubmit}
        onCancel={this.props.onMoveModalCancel}
      >
        <Form  onSubmit={this.handleSubmit}>
          <FormItem
            {...formItemLayout}
            label='选择教研组'>

            {getFieldDecorator('groupId', {
              rules: [{ required: true, message: '请选择' }],
            })(
              <Select >
                {moveGroupList.map(item=>{
                  return <Option value={(item.id).toString()} key={item.id}>{item.tgName}</Option>;
                })}
              </Select>
            )}
          </FormItem>
        </Form>
      </Modal>
    );
  }
}
export default MoveTeacherModal;
