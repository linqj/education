import React from 'react';
import {Form, Input, Select,TimePicker} from 'antd';
import moment from 'moment';
import * as mobx from 'mobx';
const FormItem = Form.Item;
const { Option } = Select;
import {observer} from 'mobx-react';

@observer
class SectionInitModal extends React.Component {
  store=this.props.store;
  constructor(props) {
    super(props);
  }

  render() {
    const {getFieldDecorator} = this.props.form;
    const formItemLayout = {
      labelCol: {span: 8},
      wrapperCol: {span: 16},
    };
    const format='HH:mm';
    let allCode=this.store.allCodeData?mobx.toJS(this.store.allCodeData):[];
    return (
      <Form >
        <div className="project-content-item">
          <p className="project-content-title">节次初始化</p>
          <FormItem
            {...formItemLayout}
            label="每天上课节数"
          >
            {getFieldDecorator('courseNum')(
              <Select style={{ width: 304 }} placeholder="请选择">
                {
                  allCode.map((item,index)=>{
                    return <Option value={item.code} key={index}>{item.name}</Option>;
                  })
                }
              </Select>
            )}
          </FormItem>
          <FormItem
            {...formItemLayout}
            label="每节课时长"
          >
            {getFieldDecorator('courseLength')(
              <Input placeholder="请输入"/>
            )}
          </FormItem>
          <FormItem
            {...formItemLayout}
            label="第一节课开始时间"
          >
            {getFieldDecorator('firstCourseTime')(
              <TimePicker initialValue={moment('12:08', format)} format={format} />
            )}
          </FormItem>
          <FormItem
            {...formItemLayout}
            label="课间操在第几节课后"
          >
            {getFieldDecorator('gymnasticsSort')(
              <Select style={{ width: 304 }} placeholder="请选择">
                {
                  allCode.map((item,index)=>{
                    return <Option value={item.code} key={index}>{item.name}</Option>;
                  })
                }
              </Select>
            )}
          </FormItem>
          <FormItem
            {...formItemLayout}
            label="课间操时长"
          >
            {getFieldDecorator('gymnasticsLength')(
              <Input placeholder="请输入"/>
            )}
          </FormItem>
          <FormItem
            {...formItemLayout}
            label="下午第一节课开始时间"
          >
            {getFieldDecorator('pmFirstCourseTime')(
              <TimePicker initialValue={moment('12:08', format)} format={format} />
            )}
          </FormItem>
          <FormItem
            {...formItemLayout}
            label="下午第一节课开始节次"
          >
            {getFieldDecorator('pmFirstCourseSort')(
              <Select style={{ width: 304 }} placeholder="请选择">
                {
                  allCode.map((item,index)=>{
                    return <Option value={item.code} key={index}>{item.name}</Option>;
                  })
                }
              </Select>
            )}
          </FormItem>
          <FormItem
            {...formItemLayout}
            label="课间休息时间"
          >
            {getFieldDecorator('recess')(
              <Input placeholder="请输入"/>
            )}
          </FormItem>
        </div>
      </Form>

    );
  }
}

const fieldsName = ['tgName','tgCode','courseIds'];
const WrappedSectionInitModal = Form.create({
  mapPropsToFields (props) {
    let p = {};
    let {initValues} = props;
    if (initValues) {
      fieldsName.forEach(key => p[key] = {value: initValues[key]});
    }
    return p;
  },
})(SectionInitModal);
export default WrappedSectionInitModal;
