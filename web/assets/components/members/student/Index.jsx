import React from 'react';
import {Menu} from 'antd';
const SubMenu = Menu.SubMenu;
import {observer} from 'mobx-react';
import MenuTable from './MenuTable';
import AllStudentTable from './AllStudentTable';

@observer
export default class StudentIndex extends React.Component {
  store = this.props.store;
  _mounted = false;

  constructor(props) {
    super(props);
    this.state = {
      gradeList: [],
      menuKey: null,
      gradeName: '全体学生',
      classNam: null,
    };
  }

  componentDidMount() {
    this._mounted = true;
    //获取年级列表
    this.store.getGradeList().then(json => {
      if (this._mounted) {
        this.setState({
          gradeList: json,
        });
      }
    });
  }

  componentWillUnmount() {
    this._mounted = false;
  }

  handleClick = (item) => {
    let gradeList = this.state.gradeList;
    if (item.key == 'all') {
      this.setState({
        menuKey: null,
        gradeName: '全体学生',
        classNam: null
      });
    } else {
      let gradeIndex = Number(item.keyPath[1]);
      let classIndex = Number(item.key.slice(item.key.indexOf('child')+5));
      let menuKey=gradeList[gradeIndex].classList[classIndex].id;
      let gradeName= gradeList[gradeIndex].grade.gradeName;
      let  classNam= gradeList[gradeIndex].classList[classIndex].claName;
      this.setState({
        menuKey: menuKey,
        gradeName: gradeName,
        classNam: classNam,
      });
    }
  };

  render() {
    let gradeList = this.state.gradeList ? this.state.gradeList : [];
    let menuKey = this.state.menuKey;
    let gradeName = this.state.gradeName;
    let classNam = this.state.classNam;
    return (
      <div className="project-content-second">
        <div className="project-menu clear">
          <Menu
            onClick={this.handleClick}
            className="project-menu-item"
            defaultSelectedKeys={['all']}
            mode="inline"
          >
            <Menu.Item key={'all'}>全体学生</Menu.Item>
            {gradeList && gradeList.map((items, gradeIndex) => {
              if (items.classList.length > 0) {
                return <SubMenu key={gradeIndex} title={items.grade.gradeName}>
                  {items.classList.map((item, classIndex) =>
                    <Menu.Item key={gradeIndex+'child' + classIndex}>{item.claName}</Menu.Item>)}
                </SubMenu>;
              } else {
                return <Menu.Item key={gradeIndex} disabled>{items.grade.gradeName}</Menu.Item>;
              }
            })}
          </Menu>
          {menuKey? <MenuTable classId={menuKey} gradeName={gradeName} classNam={classNam} store={this.store}/>:
            <AllStudentTable gradeName={gradeName} classNam={classNam} store={this.store}/>}
        </div>
      </div>
    );
  }
}
