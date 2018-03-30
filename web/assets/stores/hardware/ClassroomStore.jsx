import BaseStore from '../BaseStore';
import {observable} from 'mobx';
class ClassroomStore extends BaseStore {
  @observable classList = [];
  //获取年级列表
  getBuildingList() {
    return this.get('/classroom/cblist');
  }
  //获得对应的班级列表
  getClassroomListByBuilding(gradeId){
    return this.get(`/classroom/crlist?cbId=${gradeId}`);
  }
  //保存修改后的班级
  saveOneNewClassroom(v){
    return this.post('/classroom/save',v);
  }
  deleteClassroom(crId){
    return this.delete(`/classroom/del/${crId}`);
  }
  addOneNewClassroom(v){
    return this.post('/classroom/save',v);
  }
}

export default ClassroomStore;
