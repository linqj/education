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
      buildingList: []
    };
  }

  componentDidMount() {
    this._mounted = true;
    //获取教学楼列表
    this.store.getBuildingList().then(json => {
      if(this._mounted){
        this.setState({
          buildingList: json,
          menuKey: json[0].id,
          buildingName:json[0].buildingName
        });
      }
    });
  }

  componentWillUnmount() {
    this._mounted = false;
  }

  handleClick = (item) => {
    this.setState({
      menuKey: this.state.buildingList[Number(item.key)].id,
      buildingName:this.state.buildingList[Number(item.key)].buildingName
    });
  };

  render() {
    let buildingList = this.state.buildingList ? this.state.buildingList : [];
    let menuKey=this.state.menuKey;
    let buildingName=this.state.buildingName;
    return (
      <div className="project-content-second">
        <div className="project-menu clear">
          <Menu
            onClick={this.handleClick}
            className="project-menu-item"
            defaultSelectedKeys={['0']}
            mode="inline"
          >
            {buildingList.map((item,index) => {
              return <Menu.Item key={index}>{item.buildingName}</Menu.Item>;
            })}
          </Menu>
          <MenuTable roomBuildingId={menuKey} buildingName={buildingName} store={this.store}/>
        </div>
      </div>
    );
  }
}
