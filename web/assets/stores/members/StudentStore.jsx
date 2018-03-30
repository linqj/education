import BaseStore from '../BaseStore';
import {observable} from 'mobx';
class StudentStore extends BaseStore {
  @observable StudentListObject = [];
  @observable genderList = [];
  @observable stuLevelList = [];
  @observable classManger = {};
  @observable teacherList = [];
  @observable stuClassList = [];
  @observable allClass = [];

  getGradeList() {
    return this.get('/grade/class');
  }

  getAllStudentList(classId, pageNum) {
    let pageNumber = pageNum ? pageNum : 1;
    if (classId) {
      this.get(`/student/list?claId=${classId}&pageNum=${pageNumber}`).then(json => {
        this.StudentListObject = json;
      });
    } else {
      this.get(`/student/list?pageNum=${pageNumber}`).then(json => {
        this.StudentListObject = json;
      });
    }
  }

  addStudent(v) {
    return this.post('/student', v);

  }

  editStudent(v) {
    return this.post('/student', v);
  }

  deleteStudent(studentId) {
    return this.delete(`/student/${studentId}`);
  }

  getGenderList() {
    this.get('/dictionary/paike_gender_type').then(json => {
      this.genderList = json.data;
    });
  }

  getStuLevelList() {
    this.get('/dictionary/paike_student_type').then(json => {
      this.stuLevelList = json.data;
    });
  }
  getStuClassList(){
    return this.get('/dictionary/paike_class_position').then(json => {
      this.stuClassList = json.data;
    });
  }
  getSearchName(v) {
    return this.get(`/student/list?name=${v}`).then(json => {
      this.StudentListObject = json;
    });
  }

  onRowStudentDelete(v) {
    return this.post('/student/delete', {ids: v});
  }
  //获取班主任
  getTeacherManger(classId){
    this.get(`/class/${classId}`).then(json=>{
      this.classManger=json;
    });
  }
  getAllTeacher(){
    this.get('/teacher/all').then(json=>{
      this.teacherList=json;
    });
  }
  editMangerTeacher(teacherId,classId){
    return this.post('/class/headteacher',{teacherId:teacherId,claId:classId});
  }
  getMoveClassList(){
    this.get('/class/all').then(res=>{
      this.allClass=res;
    });
  }
  moveStudent(classId,studentIds){
    return this.post('/student/adjustclass',{classId:classId,studentId:studentIds});
  }
}

export default StudentStore;
