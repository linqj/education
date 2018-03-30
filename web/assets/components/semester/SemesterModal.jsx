import React from 'react';
import { Form, Input, DatePicker} from 'antd';
import moment from 'moment';
import OperateSemester from '../common/modal/OperateSemester';

const { RangePicker} = DatePicker;
const FormItem = Form.Item;

class SemesterModal extends React.Component{
  constructor(props){
    super(props);
    this.state={};

  }
  onHandleSubmit = () => {
    this.props.form.validateFields((err, values) => {
      if (!err) {
        if(values.theFirstTime.length>0){
          values.firstStartTime=moment(values.theFirstTime[0]).format('YYYY-MM-DD');
          values.firstEndTime=moment(values.theFirstTime[1]).format('YYYY-MM-DD');
        }
        if(values.theLastTime.length>0){
          values.lastStartTime=moment(values.theLastTime[0]).format('YYYY-MM-DD');
          values.lastEndTime=moment(values.theLastTime[1]).format('YYYY-MM-DD');
        }
        this.props.handleSubmit(values);
      }
    });
  };
  render(){
    const {getFieldDecorator} = this.props.form;
    const formItemLayout = {
      labelCol: {span: 6},
      wrapperCol: {span: 16},
    };
    return(
      <OperateSemester visible={this.props.modalVisible} title={this.props.modalTitle} handleOk={this.onHandleSubmit} handleCancel={this.props.handleCancel}>
        <Form >
          <div className="project-content-item">
            <p className="project-content-title">添加新学年</p>
            <FormItem
              {...formItemLayout}
              label="学年名称"
            >
              {getFieldDecorator('schoolYearName')(
                <Input placeholder="请输入"/>
              )}
            </FormItem>
            <FormItem
              {...formItemLayout}
              label="学年编号"
            >
              {getFieldDecorator('schoolYearCode')(
                <Input placeholder="请输入"/>
              )}
            </FormItem>
          </div>
          <div className="project-content-item">
            <p className="project-content-title">第一学期</p>
            <FormItem
              {...formItemLayout}
              label="学期名称"
            >
              {getFieldDecorator('firstSemesterName')(
                <Input placeholder="请输入"/>
              )}
            </FormItem>
            <FormItem
              {...formItemLayout}
              label="选择日期"
            >
              {getFieldDecorator('theFirstTime')(
                <RangePicker/>
              )}
            </FormItem>
          </div>
          <p className="project-content-title">第二学期</p>
          <FormItem
            {...formItemLayout}
            label="学期名称"
          >
            {getFieldDecorator('lastSemesterName')(
              <Input placeholder="请输入"/>
            )}
          </FormItem>
          <FormItem
            {...formItemLayout}
            label="选择日期"
          >
            {getFieldDecorator('theLastTime')(
              <RangePicker />
            )}
          </FormItem>
        </Form>
      </OperateSemester>
    );
  }
}

const fieldsName = ['schoolYearName','schoolYearCode','firstSemesterName','theFirstTime','lastSemesterName','theLastTime'];
const WrappedSemesterModal = Form.create({
  mapPropsToFields (props) {
    let p = {};
    let {initValues} = props;
    if (initValues) {
      fieldsName.forEach(key => p[key] = {value: initValues[key]});
      if(initValues.child&&initValues.child.length>0){
        p['firstSemesterName']={value: initValues.child[0]['semesterName']};
        p['theFirstTime']={value: [initValues.child[0].startTime?moment(initValues.child[0].startTime):null,initValues.child[0].endTime?moment(initValues.child[0].endTime):null]};
      }
      if(initValues.child&&initValues.child.length>1){
        p['lastSemesterName']={value: initValues.child[1]['semesterName']};
        p['theLastTime']={value: [initValues.child[1].startTime?moment(initValues.child[1].startTime):null,initValues.child[1].endTime?moment(initValues.child[1].endTime):null]};
      }
    }
    return p;
  },
})(SemesterModal);
export default WrappedSemesterModal;
