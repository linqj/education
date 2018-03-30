import React from 'react';
import {
  Button,
  Select,
  Tabs
} from 'antd';
const TabPane = Tabs.TabPane;
const Option = Select.Option;
import {observer} from 'mobx-react';
import ClassGrade from './ClassGrade';
import Teacher from './Teacher';
import Student from './Student';
import ClassRoom from './ClassRoom';

@observer
export default class ScheduleIndex extends React.Component {
  store = this.props.store;
  constructor(props) {
    super(props);
    this.state = {
      allYearList: [],
      parentList: [],
      childrenList: [],
      yearValueId: null,
      semesterValueId: null,
      tableValues: [],
    };
  }
  componentWillUnmount() {
    this._mounted = false;
  }

  componentDidMount() {
    this._mounted = true;
    //获取学年列表
    this.store.getAllYearList().then(json => {
      if (this._mounted) {
        this.setState({
          allYearList: json,
          childrenList: json.length > 0 ? json[0].children : [],
          yearValueId: json.length > 0 ? json[0].id.toString() : null,
          semesterValueId: json.length > 0 ? json[0].children[0].id.toString() : null,
        });
      }
    });

  }

  onYearSelect = (v) => {
    let allYearList = this.state.allYearList;
    let item = allYearList.filter(item => item.id == v);
    this.setState({
      yearValueId: v,
      childrenList: item[0].children,
      semesterValueId: item[0] ? item[0].children[0].id.toString() : null,
    });
  };
  onSemesterSelect = (v) => {
    this.setState({
      semesterValueId: v
    });
  };
  onSearch=()=>{
    this.getTableValues(this.state.yearValueId,this.state.semesterValueId,this.state.tgId);
  };
  callback=()=>{

  };

  render() {
    let allYearList = this.state.allYearList;
    let childrenList = this.state.childrenList;
    let yearValueId = this.state.yearValueId;
    let semesterValueId = this.state.semesterValueId;
    return (
      <div className="schedule">
        <div className="project-breadcrumb">
          <p className="project-title-first">课程查看</p>
        </div>
        <div className="schedule-search">
          <div className="schedule-search-item">
            <span>学年：</span>
            <Select placeholder="请选择" value={yearValueId} onChange={this.onYearSelect}
                    className="project-content-min-width">
              {allYearList.map(item => {
                return <Option value={item.id.toString()} key={item.id}>{item.schoolYearName}</Option>;
              })}
            </Select>
          </div>
          <div className="schedule-search-item">
            <span>学期：</span>
            <Select placeholder="请选择" value={semesterValueId} onChange={this.onSemesterSelect}
                    className="project-content-min-width">
              {childrenList.map((item, index) => {
                return <Option value={item.id.toString()} key={item.id}>{item.semesterName}</Option>;
              })}</Select>
          </div>
          <Button
            type="primary"
            onClick={this.onSearch}
          >
            搜索
          </Button>
        </div>
        <Tabs onChange={this.callback} type="card" className="schedule-search-table">
          <TabPane tab="班级课表" key="class_grade" className="schedule-search-table-content"><ClassGrade yearId={yearValueId} semesterId={semesterValueId} store={this.props.store}/></TabPane>
          <TabPane tab="教师课表" key="teacher" className="schedule-search-table-content"><Teacher yearId={yearValueId} semesterId={semesterValueId} store={this.props.store}/></TabPane>
          <TabPane tab="学生课表" key="student" className="schedule-search-table-content"><Student yearId={yearValueId} semesterId={semesterValueId} store={this.props.store}/></TabPane>
          <TabPane tab="教室课表" key="classroom" className="schedule-search-table-content"><ClassRoom yearId={yearValueId} semesterId={semesterValueId} store={this.props.store}/></TabPane>
        </Tabs>
      </div>
    );
  }
}
