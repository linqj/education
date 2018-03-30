import React from 'react';
import {
  Form,
  Input,
  Icon,
  Tooltip
} from 'antd';
const FormItem = Form.Item;
import {observer} from 'mobx-react';
import OperateSemester from '../../common/modal/OperateSemester';

@Form.create()
@observer
class BuildingModal extends React.Component {

  constructor(props) {
    super(props);
    this.state = {};
  }
  handleSubmit = () => {
    this.props.form.validateFields((err, values) => {
      if (!err) {
        this.props.onHandleSubmit(values);
      }
    });
  };

  render() {
    const {getFieldDecorator} = this.props.form;
    const formItemLayout = {
      labelCol: {span: 6},
      wrapperCol: {span: 16},
    };
    let gradeName = <span>教学楼名称<Tooltip title="prompt text"><Icon type="exclamation-circle-o"/></Tooltip></span>;
    return (
      <OperateSemester visible={this.props.modalVisible} title={this.props.modalTitle}
        handleOk={this.handleSubmit} handleCancel={this.props.onHandleCancel}>
        <Form onSubmit={this.handleSubmit}>
          <FormItem
            {...formItemLayout}
            label={gradeName}
          >
            {getFieldDecorator('buildingName')(
              <Input placeholder="请输入"/>
            )}
          </FormItem>
          <FormItem
            {...formItemLayout}
            label="教学楼编号"
          >
            {getFieldDecorator('buildingNumber')(
              <Input placeholder="请输入"/>
            )}
          </FormItem>
        </Form>
      </OperateSemester>
    );
  }
}

const fieldsName = ['buildingName','buildingNumber'];
const WrappedBuildingModal = Form.create({
  mapPropsToFields (props) {
    let p = {};
    let {initValues} = props;
    if (initValues) {
      fieldsName.forEach(key => p[key] = {value: initValues[key]});
    }
    return p;
  },
})(BuildingModal);

export default WrappedBuildingModal;
