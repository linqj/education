import React from 'react';
import {
  Tooltip,
  Form,
  Input,
  DatePicker,
  Select,
  Row,
  Col,
  InputNumber,
  Icon
} from 'antd';
const FormItem = Form.Item;
const Option = Select.Option;
import * as mobx from 'mobx';
import moment from 'moment';
import {observer} from 'mobx-react';
import OperateSemester from '../../common/modal/OperateSemester';

@observer
class GradeModal extends React.Component {
  handleSubmit = () => {
    this.props.form.validateFields((err, values) => {
      if (!err) {
        this.props.onHandleSubmit(values);
      }
    });
  };

  componentDidMount() {
    //获取年级列表
    const store = this.props.store;
    store.getAllGradeTypeList();

  }

  render() {
    const {getFieldDecorator} = this.props.form;
    const formItemLayout = {
      labelCol: {span: 6},
      wrapperCol: {span: 16},
    };
    let gradeName = <span>
      年级名称
      <Tooltip title="prompt text">
        <Icon type="exclamation-circle-o"/>
      </Tooltip>
    </span>;
    const store = this.props.store;
    let gradeTypeList = store.gradeTypeList ? mobx.toJS(store.gradeTypeList) : [];
    return (
      <OperateSemester visible={this.props.modalVisible} title={this.props.modalTitle}
        handleOk={this.handleSubmit} handleCancel={this.props.onHandleCancel}>
        <Form onSubmit={this.handleSubmit}>
          <div className="project-content-item">
            <p className="project-content-title">添加年级</p>
            <FormItem
              {...formItemLayout}
              label={gradeName}
            >
              {getFieldDecorator('gradeName')(
                <Input placeholder="请输入"/>
              )}
            </FormItem>
            <FormItem
              {...formItemLayout}
              label="年级选择"
            >
              {getFieldDecorator('gradeType')(
                <Select placeholder="请选择">
                  {gradeTypeList.map(item => {
                    return <Option value={item.code} key={item.code}>{item.name}</Option>;
                  })}
                </Select>
              )}
            </FormItem>
            <FormItem
              {...formItemLayout}
              label="年级代码"
            >
              {getFieldDecorator('gradeCode')(
                <Input placeholder="请输入"/>
              )}
            </FormItem>
            <FormItem
              {...formItemLayout}
              label="毕业日期"
            >
              {getFieldDecorator('endDate')(
                <DatePicker />
              )}
            </FormItem>
          </div>
          <p className="project-content-title">班级规划</p>
          <Row className='form-item'>
            <Col span={6} className='form-item-label'>班级数量:</Col>
            <Col span={5} className='form-item-text'>
              <FormItem>
                {getFieldDecorator('gradeTotalClassNum')(
                  <InputNumber
                    className="ant-input-number-bottom"
                  />
                )}
              </FormItem>
            </Col>
            <Col span={1}>个</Col>
          </Row>
        </Form>
      </OperateSemester>
    );
  }
}
const fieldsName = ['gradeName', 'gradeCode', 'endDate', 'gradeTotalClassNum'];
const WrappedGradeModal = Form.create({
  mapPropsToFields (props) {
    let p = {};
    let {initValues} = props;
    if (initValues) {
      fieldsName.forEach(key => p[key] = {value: initValues[key]});
      if (initValues['endDate']) {
        p['endDate'] = {value: moment(initValues['endDate'])};
      }
    }
    return p;
  },
})(GradeModal);

export default WrappedGradeModal;
