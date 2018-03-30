import React from 'react';
import { Form, Input, DatePicker,Select} from 'antd';
import moment from 'moment';
import OperateSemester from '../common/modal/OperateSemester';
import {observer} from 'mobx-react';
import * as mobx from 'mobx';

const FormItem = Form.Item;
const {Option,OptGroup}=Select;
@observer

class SelectCourseModal extends React.Component{
  store=this.props.store;
  constructor(props){
    super(props);
    this.state={};

  }
  onHandleSubmit = () => {
    this.props.form.validateFields((err, values) => {
      if (!err) {
        if(values.theStartTime){
          values.theStartTime=moment(values.theStartTime).format('YYYY-MM-DD');
        }
        if(values.theLastTime){
          values.theLastTime=moment(values.theLastTime).format('YYYY-MM-DD');
        }
        console.log(values);
        this.props.handleSubmit(values);
      }
    });
  };
  componentDidMount(){
    this.store.getAllSemesterList();
    this.store.getAllGradeList();
  }
  render(){
    const {getFieldDecorator} = this.props.form;
    const formItemLayout = {
      labelCol: {span: 6},
      wrapperCol: {span: 16},
    };
    let allSemesterData=this.store.allSemesterData?mobx.toJS(this.store.allSemesterData):[];
    let allGradeData=this.store.allGradeData?mobx.toJS(this.store.allGradeData):[];
    return(
      <OperateSemester visible={this.props.modalVisible} title={this.props.modalTitle} handleOk={this.onHandleSubmit} handleCancel={this.props.handleCancel}>
        <Form >
          <div className="project-content-item">
            <p className="project-content-title">选课范围</p>
            <FormItem
              {...formItemLayout}
              label="选择学年学期"
            >
              {getFieldDecorator('schoolYearName')(
                <Select
                  size='default'
                  placeholder="请选择"
                  style={{ width: '100%' }}
                >
                  {allSemesterData.map((items,index)=>{
                    return <OptGroup label={items.schoolYearName} key={index}>
                      {
                        items.children.map((item)=>{
                          return <Option value={(item.id).toString()} key={item.id}>{items.schoolYearName+item.semesterName}</Option>;
                        })
                      }
                    </OptGroup>;
                  })
                  }
                </Select>
              )}
            </FormItem>
            <FormItem
              {...formItemLayout}
              label="选择年级"
            >
              {getFieldDecorator('grade')(
                <Select style={{ width: 304 }} placeholder="请选择">
                  {
                    allGradeData.map((item,index)=>{
                      return <Option value={(item.id).toString()} key={index}>{item.gradeName}</Option>;
                    })
                  }
                </Select>
              )}
            </FormItem>
          </div>

          <p className="project-content-title">选课设置</p>
          <FormItem
            {...formItemLayout}
            label="活动名称"
          >
            {getFieldDecorator('name')(
              <Input placeholder="请输入"/>
            )}
          </FormItem>
          <FormItem
            {...formItemLayout}
            label="选课开始时间"
          >
            {getFieldDecorator('theStartTime')(
              <DatePicker />
            )}
          </FormItem>
          <FormItem
            {...formItemLayout}
            label="选课结束时间"
          >
            {getFieldDecorator('theLastTime')(
              <DatePicker />
            )}
          </FormItem>
        </Form>
      </OperateSemester>
    );
  }
}

const fieldsName = ['schoolYearName','schoolYearCode','firstSemesterName','theFirstTime','lastSemesterName','theLastTime'];
const WrappedSelectCourseModal = Form.create({
  mapPropsToFields (props) {
    let p = {};
    let {initValues} = props;
    if (initValues) {
      fieldsName.forEach(key => p[key] = {value: initValues[key]});
    }
    return p;
  },
})(SelectCourseModal);
export default WrappedSelectCourseModal;
