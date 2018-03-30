import React from 'react';
import {Route, Switch} from 'react-router-dom';
import {observer} from 'mobx-react';
import './Index.less';
import SelectCourseTable from './SelectCourseTable';
import SelectResultTable from './SelectResultTable';
import DivideClassTable from './DivideClassTable';
import SelectResultList from './SelectResultList';
import SelectCourseStore from '../../stores/selectCourse/SelectCourseStore';

@observer

export default class SelectCourseIndex extends React.Component{
  render(){
    return(
      <div>
        <Switch>
          <Route exact path={this.props.match.path}
          component={()=><SelectCourseTable store={new SelectCourseStore()}/>}/>
          <Route exact path={`${this.props.match.path}/result`}
                 component={()=><SelectResultTable store={new SelectCourseStore()}/>}/>
          <Route path={`${this.props.match.path}/result/divide`}
                 component={()=><DivideClassTable store={new SelectCourseStore()}/>}/>
          <Route path={`${this.props.match.path}/result/list`}
                 component={()=><SelectResultList store={new SelectCourseStore()}/>}/>
        </Switch>
      </div>
    );
  }
}
