import React from 'react';
import {Route, Switch} from 'react-router-dom';
import {observer} from 'mobx-react';
import './Index.less';
import Plan from './plan/Plan';
import EditPlan from './plan/EditPlan';
import Section from './Section/Section';
import TeacherTime from './TeacherTime';
import SectionStore from '../../stores/time/Sectionstore';
import PlanStore from '../../stores/time/PlanStore';
import TimeMangerStore from '../../stores/time/TimeMangerStore';


@observer
export default class TimeIndex extends React.Component {


  render() {

    return (
      <div>
        <Switch>
          <Route exact path={this.props.match.path}
            component={Section}/>
          <Route path={`${this.props.match.path}/section`}
            component={()=><Section store={new SectionStore()}/>}/>
          <Route exact path={`${this.props.match.path}/plan`}
            component={()=><Plan store={new PlanStore()}/>}/>
          <Route path={`${this.props.match.path}/plan/edit`}
            component={EditPlan}/>
          <Route path={`${this.props.match.path}/t_time`}
                 component={()=><TeacherTime store={new TimeMangerStore()}/>}/>
        </Switch>
      </div>
    );
  }
}
