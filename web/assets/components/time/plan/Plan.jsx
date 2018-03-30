import React from 'react';
import {Tabs, Select, Breadcrumb} from 'antd';
const Option = Select.Option;
const TabPane = Tabs.TabPane;
import {observer} from 'mobx-react';
import PlanTable from './PlanTable';

@observer
export default class Plan extends React.Component {
  store = this.props.store;
  _mounted = false;

  constructor(props) {
    super(props);
    this.state = {
      yearList: [],
      currentYearId: '',
      currentYearName: '',
      currentSemesterList: [],
      semesterId: null,
      semesterName:''
    };
  }

  handleSubmit = (e) => {
    e.preventDefault();
    this.props.form.validateFields((err, values) => {
      if (!err) {
        //
      }
    });
  };
  callback = (key) => {
    let currentSemesterList=this.state.currentSemesterList;
    this.setState({
      semesterId: key,
      semesterName:currentSemesterList[key-1].semesterName
    });
  };

  componentDidMount() {
    this._mounted = true;
    //获取学年列表
    this.store.getYearList().then(json => {
      if (this._mounted) {
        this.setState({
          yearList: json,
          currentYearId: json[0].id.toString(),
          currentYearName: json[0].schoolYearName,
          currentSemesterList: json[0].children,
          semesterId: json[0].children[0].id,
          semesterName:json[0].children[0].semesterName
        });
      }
    });
  }

  componentWillUnmount() {
    this._mounted = false;
  }

  onYearChange = (v) => {
    let yearList = this.state.yearList;
    Object.keys(yearList).forEach(item => {
      if (yearList[item].id == v) {
        this.setState({
          currentYearName: yearList[item].schoolYearName,
        });
      }
    });
    this.setState({
      currentYearId: v,
    });
  };

  render() {
    let yearList = this.state.yearList;
    let currentYearId = this.state.currentYearId;
    let currentSemesterList = this.state.currentSemesterList;
    let semesterId = this.state.semesterId;
    return (
      <div className="plan">
        <div className="project-breadcrumb">
          <Breadcrumb>
            <Breadcrumb.Item>课时</Breadcrumb.Item>
            <Breadcrumb.Item>课程开设计划</Breadcrumb.Item>
          </Breadcrumb>
          <p className="project-title-first">课程开设计划</p>
          <p>在这里查看各个学期课程的开设计划，管理各个学期的课程课时安排</p>
        </div>
        <div className="plan-search">
          <span>学年名称：</span>
          <Select value={currentYearId} onChange={this.onYearChange}>
            {yearList.map(item => {
              return <Option value={(item.id).toString()} key={item.id}>{item.schoolYearName}</Option>;
            })
            }
          </Select>
        </div>
        <div className="plan-table">
          <Tabs onChange={this.callback} type="card">
            {currentSemesterList.map(item => {
              return <TabPane tab={item.semesterName} key={item.id}>
                <PlanTable schoolYearId={currentYearId} currentYearName={this.state.currentYearName} semesterName={this.state.semesterName} semesterId={semesterId}
                           store={this.store}/>
              </TabPane>;
            })}
          </Tabs>
        </div>
      </div>
    );
  }
}
