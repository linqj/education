import BaseStore from '../BaseStore';
import {observable} from 'mobx';
class CourseStore extends BaseStore {
  @observable courseTypeList = [];

  getTabsMenu() {
    return this.get('/grade/all');
  }

  getAllCourseList(gradeId, pageNum) {
    let current = 1;
    if (pageNum) {
      current = pageNum;
    }
    return this.get(`/course/list?gradeId=${gradeId}&pageNum=${current}`);
  }

  //学科
  getCourseTypeList() {
    this.get('/dictionary/paike_course_type').then(json => {
      this.courseTypeList = json.data;
    });
  }

  //edit
  editCourse(v) {
    return this.post('/course/edit', v);
  }

  deleteCourse(courseId) {
    return this.delete(`/course/del/${courseId}`);
  }

  //获取课程管理列表
  getCourseObject(gradeId) {
    return this.get(`/course/manage/${gradeId}`);
  }
  //添加课程
  addCourse(v){
    return this.post('/course/savemanage',v);
  }
}

export default new CourseStore();
