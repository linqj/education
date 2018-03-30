import React from 'react';
import {Route, Switch} from 'react-router-dom';
import {observer} from 'mobx-react';
import './Index.less';
import GradeIndex from './grade/Index';
import ClassIndex from './class/Index';
import ResearchIndex from './research/Index';
import GradeStore from '../../stores/organization/GradeStore';
import ResearchStore from '../../stores/organization/ResearchStore';
import ClassStore from '../../stores/organization/ClassStore';

@observer
export default class OrganizationIndex extends React.Component {


  render() {

    return (
      <div>
        <Switch>
          <Route exact path={this.props.match.path}
            component={()=><GradeIndex store={new GradeStore()}/>}/>
          <Route path={`${this.props.match.path}/grade`}
            component={()=><GradeIndex store={new GradeStore()}/>}/>
          <Route path={`${this.props.match.path}/class`}
            component={()=><ClassIndex store={new ClassStore()}/>}/>
          <Route path={`${this.props.match.path}/research`}
            component={()=><ResearchIndex store={new ResearchStore()}/>}/>
        </Switch>
      </div>
    );
  }
}
