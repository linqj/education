import React from 'react';
import {Route, Switch} from 'react-router-dom';
import './Index.less';
import BuildingIndex from './building/Index';
import ClassroomIndex from './classroom/Index';
import ClassBuilding from '../../stores/hardware/ClassBuildingStore';
import ClassroomStore from '../../stores/hardware/ClassroomStore';

export default class OrganizationIndex extends React.Component {


  render() {

    return (
      <div>
        <Switch>
          <Route exact path={this.props.match.path}
            component={()=><BuildingIndex store={new ClassBuilding()}/>}/>
          <Route path={`${this.props.match.path}/building`}
            component={()=><BuildingIndex store={new ClassBuilding()}/>}/>
          <Route path={`${this.props.match.path}/classroom`}
            component={()=><ClassroomIndex store={new ClassroomStore()}/>}/>
        </Switch>
      </div>
    );
  }
}
