import React from 'react';
import {Route, Switch} from 'react-router-dom';
import {observer} from 'mobx-react';
import './Index.less';
import StudentIndex from './student/Index';
import TeacherIndex from './teacher/Index';
import TeacherAddModal from './teacher/TeacherAddModal';
import StudentStore from '../../stores/members/StudentStore';
import TeacherStore from '../../stores/members/TeacherStore';
@observer
export default class MembersIndex extends React.Component {


  render() {

    return (
      <div>
        <Switch>
          <Route exact path={this.props.match.path}
            component={()=><StudentIndex store={new StudentStore()}/>}/>
          <Route path={`${this.props.match.path}/student`}
            component={()=><StudentIndex store={new StudentStore()}/>}/>
          <Route exact path={`${this.props.match.path}/teacher`}
            component={()=><TeacherIndex store={new TeacherStore()}/>}/>
          <Route exact path={`${this.props.match.path}/teacher/:id(\\d+)`}
                 component={()=><TeacherIndex store={new TeacherStore()}/>}/>
          <Route path={`${this.props.match.path}/teacher/add/:id(\\d+)`}
                 component={()=><TeacherAddModal store={new TeacherStore()}/>}/>
        </Switch>
      </div>
    );
  }
}
