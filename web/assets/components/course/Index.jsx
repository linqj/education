import React from 'react';
import {Breadcrumb,Tabs} from 'antd';
const TabPane = Tabs.TabPane;
import './Index.less';
import CourseTable from './CourseTable';
import CourseStore from '../../stores/course/CourseStore';
import {observer} from 'mobx-react';

@observer
export default class CourseIndex extends React.Component {
  constructor(props){
    super(props);
    this.state={
      gradeList:[],
      gradeId:null
    };
  }
  callback = (key) => {
    this.setState({
      gradeId:key
    });
  };

  componentDidMount() {
    //获取tab menu
    CourseStore.getTabsMenu().then(json=>{
      this.setState({
        gradeList:json,
        gradeId:json.length>0?json[0].id:null
      });
    });
  }
  render() {
    let gradeList = this.state.gradeList;
    return (
      <div className="course">
        <div className="project-breadcrumb">
          <Breadcrumb>
            <Breadcrumb.Item>排课管理</Breadcrumb.Item>
            <Breadcrumb.Item>课程管理</Breadcrumb.Item>
          </Breadcrumb>
          <p className="project-title-first">课程管理</p>
          <p>学年管理包括学年管理、学期管理以及学期开学和放假日期的管理</p>
        </div>
          <Tabs onChange={this.callback} type="card" className='course-tabs' >
            {gradeList.map((item,index) => {
              return <TabPane tab={item.gradeName} key={item.id}>
                <CourseTable store={CourseStore} gradeId={this.state.gradeId} gradeName={item.gradeName} tabIndex={index}/>
              </TabPane>;
            })}
          </Tabs>
        </div>
    );
  }
}
