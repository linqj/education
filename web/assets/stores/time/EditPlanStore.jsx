import BaseStore from '../BaseStore';
class EditPlanStore extends BaseStore {

  getGradeList() {
    return this.get('/grade/all');
  }

  getCourseList(gradeId) {
    return this.get(`/course/gradecourse/${gradeId}`);
  }

  getCourseTableList(yearId, semesterId, gradeId) {
    return this.get(`/courseplan/list?yearId=${yearId}&semesterId=${semesterId}&gradeId=${gradeId}`);
  }
  postCourseList(v){
    return this.postJson('/courseplan/save',v);
  }
}
export  default new EditPlanStore();
