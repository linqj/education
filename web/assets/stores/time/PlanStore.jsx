import BaseStore from '../BaseStore';
import {observable} from  'mobx';
export  default class PlanStore extends BaseStore {
  @observable coursePlanList = [];
  @observable gradeList = [];

  getYearList() {
    return this.get('/semester/schoolyearlist');
  }

  getAllCoursePlanList(yearId, semesterId) {
    return this.get(`/courseplan/list?yearId=${yearId}&semesterId=${semesterId}`);
  }

  // saveCourseList(v) {
  //   return this.post('/semester/save.do', v);
  // }
  // getGradeList(){
  //   this.get('/dictionary/paike_grade_type').then(json=>{
  //     this.gradeList=json.data
  //   })
  // }

  editCoursePlan(v) {
    return this.post('/courseplan/edit', v);
  }

  deleteCoursePlan(courseId) {
    return this.delete(`/courseplan/del/${courseId}`);
  }
}
