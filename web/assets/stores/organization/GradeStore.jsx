import BaseStore from '../BaseStore';
import {observable} from 'mobx';
class GradeStore extends BaseStore {
  @observable gradeListObject = {};
  @observable gradeTypeList = [];
  //获取页面列表
  getAllGradeList(v) {
    let pageNum = 1;
    if (v) {
      pageNum = v;
    }
    this.get(`/grade/list?pageNum=${pageNum}`).then(json => {
      let childAllList = [];
      let gradeAllList = [];
      if (json.list.length > 0) {
        json.list.forEach(item => {
          childAllList.push(item.classList);
          gradeAllList.push(item.grade);
        });
        json.childAllList = childAllList;
        json.gradeAllList = gradeAllList;
      }
      this.gradeListObject = json;
    });
  }

  //添加年级
  addGrade = (v) => {
    return this.post('/grade', v);
  };
  //
  editGrade(v) {
    return this.post('/grade', v);
  }

  deleteGrade(gradeId) {
    return this.delete(`/grade/${gradeId}`);
  }

  //年级列表
  getAllGradeTypeList() {
    this.get('/dictionary/paike_grade_type').then(json => {
      this.gradeTypeList = json.data;
    });
  }

}

export default GradeStore;
