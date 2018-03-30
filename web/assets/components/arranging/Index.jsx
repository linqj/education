import React from 'react';
import {Route, Switch} from 'react-router-dom';
import {observer} from 'mobx-react';
import './Index.less';
import ArrangeIndex from './arrange/Index';
import ScheduleIndex from './schedule/Index';
import ScheduleStore from '../../stores/schedule/ScheduleStore';

@observer
export default class ArrangingIndex extends React.Component {


  render() {

    return (
      <div>
        <Switch>
          <Route exact path={this.props.match.path}
            component={ArrangeIndex}/>
          <Route path={`${this.props.match.path}/arrange`}
            component={ArrangeIndex}/>
          <Route path={`${this.props.match.path}/schedule`}
            component={()=><ScheduleIndex store={new ScheduleStore()}/>}/>
        </Switch>
      </div>
    );
  }
}
