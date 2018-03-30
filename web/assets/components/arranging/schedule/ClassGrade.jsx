import React from 'react';
import {Menu} from 'antd';
const SubMenu = Menu.SubMenu;
import {observer} from 'mobx-react';
import ClassGradeTable from './ClassGradeTable';

@observer
export default class ClassGrade extends React.Component {
  store = this.props.store;
  _mounted = false;

  constructor(props) {
    super(props);
    this.state = {
      gradeList: [],
      selectedKeys: [],
      openKeys: [],
      gradeId: null,
      semesterId: null
    }
  }

  componentDidMount() {
    this._mounted = true;
    //获取年级班级列表
    this.store.getGradeList(this.props.yearId, this.props.semesterId).then(json => {
      let defaultArr = [];
      let defaultOpenArr = [];
      if (json[0]) {
        defaultArr.push(json[0].grade.id + 'child' + json[0].classList[0].id.toString());
        defaultOpenArr.push(json[0].grade.id.toString());
      }
      if (this._mounted) {
        this.setState({
          gradeList: json,
          selectedKeys: defaultArr,
          openKeys: defaultOpenArr,
          gradeId: json[0].grade.id,
          semesterId: json[0].classList[0].id
        })
      }
    })
  }

  componentWillUnmount() {
    this._mounted = false;
  }

  handleClick = (v) => {
    let defaultArr = [];
    defaultArr.push(v.key);
    this.setState({
      selectedKeys: defaultArr,
      gradeId: v.keyPath[1],
      semesterId: v.key[v.key.indexOf('child') + 5]
    })
  };
  onOpenChange = (v) => {
    this.setState({
      openKeys: v,
    })
  };

  render() {
    let gradeList = this.state.gradeList;
    let selectedKeys = this.state.selectedKeys;
    let openKeys = this.state.openKeys;
    return (
      <div >
        <div className="project-menu clear">
          <Menu
            onClick={this.handleClick}
            className="project-menu-item"
            selectedKeys={selectedKeys}
            openKeys={openKeys}
            onOpenChange={this.onOpenChange}
            mode="inline"
          >
            {gradeList && gradeList.map((items) => {
              if (items.classList.length > 0) {
                return <SubMenu key={items.grade.id.toString()} title={items.grade.gradeName}>
                  {items.classList.map((item) =>
                    <Menu.Item key={items.grade.id + 'child' + item.id}>{item.claName}</Menu.Item>)}
                </SubMenu>;
              } else {
                return <Menu.Item key={items.grade.id.toString()} disabled>{items.grade.gradeName}</Menu.Item>;
              }
            })}
          </Menu>
          <div className="project-menu-table">
            <ClassGradeTable store={this.store}/>
          </div>
        </div>
      </div>
    );
  }
}
