import React from 'react';
import {Layout, Menu, Icon} from 'antd';
const {SubMenu} = Menu;
const {Header, Content, Sider} = Layout;
import './Layout.less';
import Logo from './logo.png';
import {Link} from 'react-router-dom';

class App extends React.Component {
  constructor() {
    super();
    this.state = {
      collapsed: false,
    };
  }

  toggle = () => {
    this.setState({
      collapsed: !this.state.collapsed,
    });
  };

  render() {
    const path = window.location.pathname.split('/');
    let menuKey = path[1];
    let childMenuKey = path[2]||menuKey;
    if (menuKey === ''){
      menuKey = 'semester';
    }
    if (childMenuKey === ''){
      childMenuKey = 'semester';
    }
    let collapsed = this.state.collapsed;
    return (
      <Layout className="layout">
        <Sider
          trigger={null}
          collapsible
          collapsed={collapsed}
        >
          <div className="layout-header"><img src={Logo} alt="" className="layout-header-img"/>
            {!collapsed && <span className="layout-header-content">智能排课系统</span>}
          </div>
          <Menu theme="dark" defaultSelectedKeys={[childMenuKey]} defaultOpenKeys={[menuKey]} mode="inline">
            <SubMenu
              key="semester"
              title={<span><Icon type="team"/><span>学期</span></span>}
            >
              <Menu.Item key="semester"><Link to="/semester">学年与学期管理</Link></Menu.Item>
            </SubMenu>
            <SubMenu
              key="organization"
              title={<span><Icon type="user"/><span>组织</span></span>}
            >
              <Menu.Item key="grade"><Link to="/organization/grade">年级管理</Link></Menu.Item>
              <Menu.Item key="class"><Link to="/organization/class">班级管理</Link></Menu.Item>
              <Menu.Item key="research"><Link to="/organization/research">教研组管理</Link></Menu.Item>
            </SubMenu>
            <SubMenu
              key="members"
              title={<span><Icon type="team"/><span>成员</span></span>}
            >
              <Menu.Item key="student"><Link to="/members/student">学生成员管理</Link></Menu.Item>
              <Menu.Item key="teacher"><Link to="/members/teacher">教师成员管理</Link></Menu.Item>
            </SubMenu>
            <SubMenu
              key="hardware"
              title={<span><Icon type="team"/><span>硬件</span></span>}
            >
              <Menu.Item key="building"><Link to="/hardware/building">教学楼管理</Link></Menu.Item>
              <Menu.Item key="classroom"><Link to="/hardware/classroom">教室管理</Link></Menu.Item>
            </SubMenu>
            <SubMenu
              key="course"
              title={<span><Icon type="team"/><span>课程</span></span>}
            >
              <Menu.Item key="course"><Link to="/course">课程管理</Link></Menu.Item>
            </SubMenu>
            <SubMenu
              key="time"
              title={<span><Icon type="team"/><span>课时</span></span>}
            >
              <Menu.Item key="section"><Link to="/time/section">节次管理</Link></Menu.Item>
              <Menu.Item key="plan"><Link to="/time/plan">课程开设计划</Link></Menu.Item>
              <Menu.Item key="t_time"><Link to="/time/t_time">教师课时管理</Link></Menu.Item>
            </SubMenu>
            <SubMenu
              key="s_course"
              title={<span><Icon type="team"/><span>选课</span></span>}
            >
              <Menu.Item key="s_course"><Link to="/s_course">学生选课管理</Link></Menu.Item>
            </SubMenu>
            <SubMenu
              key="arranging"
              title={<span><Icon type="team"/><span>排课</span></span>}
            >
              <Menu.Item key="arrange"><Link to="/arranging/arrange">开始排课</Link></Menu.Item>
              <Menu.Item key="schedule"><Link to="/arranging/schedule">课表查看</Link></Menu.Item>
            </SubMenu>
            <SubMenu
              key="setting"
              title={<span><Icon type="team"/><span>设置</span></span>}
            >
              <Menu.Item key="6">setting</Menu.Item>
            </SubMenu>
          </Menu>
        </Sider>
        <Layout>
          <Header className="header">
            <Icon
              className="trigger"
              type={this.state.collapsed ? 'menu-unfold' : 'menu-fold'}
              onClick={this.toggle}
            />
          </Header>
          <Content>
            {this.props.children}
          </Content>
        </Layout>
      </Layout>
    );
  }
}
export default App;
