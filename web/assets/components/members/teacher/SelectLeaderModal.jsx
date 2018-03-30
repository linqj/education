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
class SelectLeaderModal extends React.Component {
  handleSubmit = () => {
    this.props.form.validateFields((err, values) => {
      if (!err) {
        this.props.onLeaderSubmit(values.teacherId);
      }
    });
  };

  componentDidMount() {
    this.props.store.getLeaderList(this.props.menuKey);
    this.props.store.getLeaderTwoList(this.props.menuKey);
  }

  render() {
    const {getFieldDecorator} = this.props.form;
    const formItemLayout = {
      labelCol: {span: 6},
      wrapperCol: {span: 16},
    };
    let operate = this.props.operate;
    let leaderList = this.props.store.LeaderList ? mobx.toJS(this.props.store.LeaderList) : [];
    let leaderTwoList = this.props.store.LeaderTwoList ? mobx.toJS(this.props.store.LeaderTwoList) : [];
    let list = [];
    if (operate === 'leaderOne') {
      list = leaderList;
    } else {
      list = leaderTwoList;
    }
    return (
      <Modal
        title={this.props.leaderTitle}
        visible={true}
        onOk={this.handleSubmit}
        onCancel={this.props.leaderHandleCancel}
      >
        <Form onSubmit={this.handleSubmit}>
          <FormItem
            {...formItemLayout}
            label='选择教师'>
            {getFieldDecorator('teacherId', {
              rules: [{required: true, message: '请选择'}],
            })(
              <Select >
                {list.map(item => {
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
export default SelectLeaderModal;
