import BaseStore from '../BaseStore';
import {observable} from 'mobx';
class TeacherStore extends BaseStore {
  @observable TeacherList = {};
  @observable allTeacherList = {};
  @observable teaLevelList = [];
  @observable genderList = [];
  @observable TeacherAddList = [];
  @observable LeaderList = [];
  @observable LeaderTwoList = [];
  @observable MoveGroupList = [];

  //获取左侧教研组列表
  getGroupList() {
    return this.get('/teachergroup/tglist');
  }

  //获取全体教师列表
  getAllTeacherList(pageNum) {
    this.get(`/teacher/list?pageNum=${pageNum}`).then(json => {
      this.allTeacherList = json;
    });
  }
  //获取教研组教师列表------------
  getGroupTeacherList(groupId, pageNum) {
    if(groupId){
      this.get(`/teachergroup/teacherlist?tgId=${groupId}&pageNum=${pageNum}`).then(json => {
        this.TeacherList = json.data;
      });
    }
  }

  //获取性别字典
  getGenderList() {
    this.get('/dictionary/paike_gender_type').then(json => {
      this.genderList = json.data;
    });
  }

  //获取教师级别字典
  getTeaLevelList() {
    this.get('/dictionary/paike_teacher_level	').then(json => {
      this.teaLevelList = json.data;
    });
  }

  //全体教师中的模糊查询
  getSearchName(v) {
    this.get(`/teacher/list?name=${v}`).then(json => {
      this.allTeacherList = json;
    });
  }

  //教研组中的模糊查询
  getTeaSearchName(tgId, v) {
    this.get(`/teachergroup/teacherlist?tgId=${tgId}&search=${v}`).then(json => {
      this.TeacherList = json.data;
    });
  }

  //全体教师中的添加教师
  addTeacher(v) {
    return this.post('/teacher', v);
  }

  //全体教师中的编辑教师
  editTeacher(v) {
    return this.post('/teacher', v);
  }

  //教研组中的编辑教师
  editTea(v) {
    return this.post('/teachergroup/saveteacher', v);
  }

  //全体教师中的删除教师
  deleteTeacher(id) {
    return this.delete(`/teacher/${id}`);
  }

  //教研中的删除教师
  delTeacher(id) {
    return this.delete(`/teachergroup/delteacher/${id}`);
  }

  //全体教师中的批量删除教师
  onRowTeacherDelete(v) {
    return this.post('/teacher/delete', {ids: v});
  }

  //教研组中批量删除教师
  onRowTeacherDel(v) {
    return this.post('/teachergroup/delmulti', {tIds: v});
  }

  //教研组中获取未分配教师列表
  getTeacherAddList() {
    this.get('/teachergroup/tgadd').then(res => {
      this.TeacherAddList = res.data.teacherList;
    });
  }

  //教研组中添加教师
  saveTeacherToTg(srId, tgId) {
    return this.post(`/teachergroup/saveteachertotg?tIds=${srId}&tgId=${tgId}`);
  }

  //获取教研组除组长外人员列表--------------
  getLeaderList(tgId) {
    this.get(`/teachergroup/editleader?tgId=${tgId}`).then(res => {
      this.LeaderList = res.data.teacherList;
    });
  }

  //获取教研组除副组长外人员列表-------------
  getLeaderTwoList(tgId) {
    this.get(`/teachergroup/editleadertwo?tgId=${tgId}`).then(res => {
      this.LeaderTwoList = res.data.teacherList;
    });
  }

  //保存新教研组长
  saveLeader(tgId, tId) {
    return this.post('/teachergroup/saveleader', {tgId: tgId, tId: tId});
  }

  //保存新教研副组长
  saveLeaderTwo(tgId, tId) {
    return this.post('/teachergroup/saveleadertwo', {tgId: tgId, tId: tId});
  }

  //教研组-获取调整教研组列表------------
  getMoveGroupList(tgId){
    this.get(`/teachergroup/tomove?tgId=${tgId}`).then(res=>{
      this.MoveGroupList=res;
    });
  }
  //教研组中批量调整教研组
  moveTeacher(tgId, tIds) {
    return this.post('/teachergroup/move', {tgId: tgId, tIds: tIds});
  }
}
export  default TeacherStore;
