import React from 'react';
import {Breadcrumb} from 'antd';
import './Index.less';
import Semester from './Semester';
import SemesterStore from '../../stores/semester/SemesterStore';

export default class EnterpriseIndex extends React.Component {

  render() {
    return (
      <div className="semester">
        <div className="project-breadcrumb">
          <Breadcrumb>
            <Breadcrumb.Item>学期</Breadcrumb.Item>
            <Breadcrumb.Item>学年与学期管理</Breadcrumb.Item>
          </Breadcrumb>
          <p className="project-title-first">学年与学期管理</p>
          <p>学年管理包括学年管理、学期管理以及学期开学和放假日期的管理</p>
        </div>
        <Semester store={new SemesterStore()}/>
      </div>
    );
  }
}
