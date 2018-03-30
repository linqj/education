import React from 'react';
import {observer} from 'mobx-react';
import {Menu} from 'antd';
const SubMenu = Menu.SubMenu;
import MenuTable from './MenuTable';
import ATMenuTable from './ATMenuTable';
@observer
export default class TeacherIndex extends React.Component {
  store = this.props.store;
  _mounted = false;

  constructor(props) {
    super(props);
    let arr = [];
    let pathname = window.location.pathname.split('/')[3];
    arr.push(pathname);
    this.state = {
      teacherGroup: [],
      groupName: '全体教师',
      menuKey: pathname ? pathname : null,
      defaultOpenKeys: pathname ? ['group'] : ['all'],
      defaultSelectedKeys: pathname ? arr : ['all']
    };
  }

  componentDidMount() {
    this._mounted = true;
    this.store.getGroupList().then(res => {
      if (this._mounted) {
        this.setState({
          teacherGroup: res,
        });
      }
    });
  }

  componentWillUnmount() {
    this._mounted = false;
  }

  handleClick = (item) => {
    let teacherGroup = this.state.teacherGroup;
    if (item.key === 'all') {
      this.setState({
        groupName: '全体教师',
        menuKey: null
      });
    } else {
      let groupIndex = Number(item.key-1);
      let groupName = teacherGroup[groupIndex].tgName;
      let menuKey = teacherGroup[groupIndex].id;
      this.setState({
        groupName: groupName,
        menuKey: menuKey
      });
    }

  };

  render() {

    let teacherGroup = this.state.teacherGroup ? this.state.teacherGroup : [];
    let defaultSelectedKeys=this.state.defaultSelectedKeys;
    let defaultOpenKeys=this.state.defaultOpenKeys;

    return (
      <div className="student">
        <div className="project-content-second">
          <div className="project-menu clear">
            <Menu
              onClick={this.handleClick}
              className="project-menu-item"
              defaultSelectedKeys={defaultSelectedKeys}
              defaultOpenKeys={defaultOpenKeys}
              mode="inline"
            >
              <Menu.Item key={'all'}>全体教师</Menu.Item>
              <SubMenu title='教研组' key={'group'}>
                {
                  teacherGroup.map((item) => {
                    return <Menu.Item key={(item.id).toString()}>{item.tgName}</Menu.Item>;
                  })
                }
              </SubMenu>
            </Menu>
            {this.state.menuKey && this.state.menuKey !== 'all' ?
              <MenuTable menuKey={this.state.menuKey} groupsName={this.state.groupName} store={this.store}/> :
              <ATMenuTable menuKey={this.state.menuKey} groupsName={this.state.groupName} store={this.store}/>}
          </div>
        </div>
      </div>
    );
  }
}
