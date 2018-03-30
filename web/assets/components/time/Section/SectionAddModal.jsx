import React from 'react';
import {Form, Input, Select,TimePicker} from 'antd';
import moment from 'moment';
import * as mobx from 'mobx';
const FormItem = Form.Item;
const { Option } = Select;
import {observer} from 'mobx-react';

@observer
class SectionAddModal extends React.Component {
  store=this.props.store;
  constructor(props) {
    super(props);
  }
  render() {
    const {getFieldDecorator} = this.props.form;
    const formItemLayout = {
      labelCol: {span: 6},
      wrapperCol: {span: 16},
    };
    const format = 'HH:mm';
    let allCode=this.store.allCodeData?mobx.toJS(this.store.allCodeData):[];
    return (
      <Form>
        <div className="project-content-item">
          <p className="project-content-title">添加节次</p>
          <FormItem
            {...formItemLayout}
            label="节次"
          >
            {getFieldDecorator('sort')(
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
            label="节次名称"
          >
            {getFieldDecorator('name')(
              <Input placeholder="请输入"/>
            )}
          </FormItem>
          <FormItem
            {...formItemLayout}
            label="上课开始时间"
          >
            {getFieldDecorator('startTime')(
              <TimePicker format={format} />
            )}
          </FormItem>
          <FormItem
            {...formItemLayout}
            label="上课结束时间"
          >
            {getFieldDecorator('endTime')(
              <TimePicker format={format} />
            )}
          </FormItem>
        </div>
      </Form>

    );
  }
}

const WrappedSectionAddModal = Form.create({
  mapPropsToFields (props) {
    let p = {};
    let {initValues} = props;
    if (initValues&&initValues.name) {
      p['name']={value:initValues.name};
      p['sort']={value:initValues.sort.toString()};
      p['startTime']={value:moment(initValues.startTime,'HH:mm')};
      p['endTime']={value:moment(initValues.endTime,'HH:mm')};
    }
    return p;
  },
})(SectionAddModal);
export default WrappedSectionAddModal;
