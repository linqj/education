import React from 'react';
import {Menu} from 'antd';
import {observer} from 'mobx-react';
import MenuTable from './MenuTable';

@observer
export default class ClassIndex extends React.Component {
  store = this.props.store;
  _mounted = false;

  constructor(props) {
    super(props);
    this.state = {
      menuKey: null,
      gradeList: []
    };
  }

  componentDidMount() {
    this._mounted = true;
    //获取年级列表
    this.store.getGradeList().then(json => {
      if(this._mounted){
        this.setState({
          gradeList: json,
          menuKey: json[0].id,
          gradeName:json[0].gradeName
        });
      }
    });
  }

  componentWillUnmount() {
    this._mounted = false;
  }

  handleClick = (item) => {
    this.setState({
      menuKey: this.state.gradeList[Number(item.key)].id,
      gradeName:this.state.gradeList[Number(item.key)].gradeName
    });
  };

  render() {
    let gradeList = this.state.gradeList ? this.state.gradeList : [];
    let menuKey=this.state.menuKey;
    let gradeName=this.state.gradeName;
    return (
      <div className="project-content-second">
        <div className="project-menu clear">
          <Menu
            onClick={this.handleClick}
            className="project-menu-item"
            defaultSelectedKeys={['0']}
            mode="inline"
          >
            {gradeList.map((item,index) => {
              return <Menu.Item key={index}>{item.gradeName}</Menu.Item>;
            })}
          </Menu>
          <MenuTable gradeId={menuKey} gradeName={gradeName} store={this.store}/>
        </div>
      </div>
    );
  }
}
