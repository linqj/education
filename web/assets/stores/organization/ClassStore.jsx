import BaseStore from '../BaseStore';
import {observable} from 'mobx';
class ClassStore extends BaseStore {
  @observable classList = [];
  @observable classTypeList = [];
  @observable classNameList = [];
  //获取年级列表
  getGradeList() {
    return this.get('/grade/all');
  }

  //获得对应的班级列表
  getClassListByGrad(gradeId) {
    return this.get(`/class/bygrade/${gradeId}`);
  }

  //保存修改后的班级
  saveOneNewClass(v) {
    return this.post('/class', v);
  }

  deleteClass(classId) {
    return this.delete(`/class/${classId}`);
  }

  addOneNewClass(v) {
    return this.post('/class', v);
  }

  //获取班级类型
  getClassTypeList() {
    this.get('/dictionary/paike_class_type').then(json => {
      this.classTypeList = json.data;
    });
  }

  //获取所在教室
  getClassNameList() {
    return this.get('/classbuilding/child').then(json => {
      this.classNameList = json.data.cbList;
    });
  }
}

export default ClassStore;
