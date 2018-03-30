import React from 'react';
import {Form, Input, Select} from 'antd';
import OperateSemester from '../../common/modal/OperateSemester';
import * as mobx from 'mobx';
const FormItem = Form.Item;
const { Option, OptGroup } = Select;
import {observer} from 'mobx-react';
@observer
class ResearchModal extends React.Component {
  store=this.props.store;
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
  componentDidMount(){
    this.store.getAllCourseList();
  }

  render() {
    const {getFieldDecorator} = this.props.form;
    const formItemLayout = {
      labelCol: {span: 6},
      wrapperCol: {span: 16},
    };
    let allCourseData=this.store.allCourseData?mobx.toJS(this.store.allCourseData):[];
    return (
      <OperateSemester visible={this.props.modalVisible} title={this.props.modalTitle} handleOk={this.handleSubmit}
        handleCancel={this.props.handleCancel}>
        <Form onSubmit={this.handleSubmit}>
          <div className="project-content-item">
            <p className="project-content-title">添加教研组</p>
            <FormItem
              {...formItemLayout}
              label="教研组名称"
            >
              {getFieldDecorator('tgName')(
                <Input placeholder="请输入"/>
              )}
            </FormItem>
            <FormItem
              {...formItemLayout}
              label="教研组编号"
            >
              {getFieldDecorator('tgCode')(
                <Input placeholder="请输入"/>
              )}
            </FormItem>
          </div>
          <p className="project-content-title">科目设置</p>
          <FormItem
            {...formItemLayout}
            label="教研组负责科目"
          >
            {getFieldDecorator('courseIds')(
              <Select
                mode="multiple"
                size='default'
                placeholder="请选择科目"
                style={{ width: '100%' }}
              >
                {allCourseData.map((items,index)=>{
                  return <OptGroup label={items.disciplineName} key={index}>
                    {
                      items.childlist.map((item)=>{
                        return <Option value={(item.id).toString()} key={item.id}>{item.courseName}</Option>;
                      })
                    }
                  </OptGroup>;
                })
                }
              </Select>
            )}
          </FormItem>
        </Form>
      </OperateSemester>
    );
  }
}

const fieldsName = ['tgName','tgCode','courseIds'];
const WrappedResearchModal = Form.create({
  mapPropsToFields (props) {
    let p = {};
    let {initValues} = props;
    if (initValues) {
      fieldsName.forEach(key => p[key] = {value: initValues[key]});
      let values = [];
      if(initValues.ctList&&initValues.ctList.length>0){
        initValues.ctList.forEach(item => {
          values.push(item.courseId.toString());
        });
        p['courseIds']={value:values};
      }
    }
    return p;
  },
})(ResearchModal);
export default WrappedResearchModal;
