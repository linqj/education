import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import 'babel-polyfill';
import 'isomorphic-fetch';
import Layout from './Layout';
import SemesterIndex from './components/semester/Index';
import OrganizationIndex from './components/organization/Index';
import MembersIndex from './components/members/Index';
import HardwareIndex from './components/hardware/Index';
import ArrangingIndex from './components/arranging/Index';
import CourseIndex from './components/course/Index';
import TimeIndex from './components/time/Index';
import SelectCourseIndex from './components/selectCourses/Index';

ReactDOM.render(
  <BrowserRouter>
    <Switch>
      <Layout>
        <Route exact path='/' component={SemesterIndex}/>
        <Route path='/semester' component={SemesterIndex}/>
        <Route path='/organization' component={OrganizationIndex}/>
        <Route path='/members' component={MembersIndex}/>
        <Route path='/hardware' component={HardwareIndex}/>
        <Route path='/arranging' component={ArrangingIndex}/>
        <Route path='/course' component={CourseIndex}/>
        <Route path='/time' component={TimeIndex}/>
        <Route path='/s_course' component={SelectCourseIndex}/>
      </Layout>
    </Switch>
  </BrowserRouter>,
  document.getElementById('app')
);
