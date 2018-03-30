import BaseStore from '../BaseStore';
import {observable} from 'mobx';
export default class ScheduleStore extends BaseStore{
  @observable groupList = [];
  @observable tableListObject = [];
  @observable gradeList = [];
  getAllYearList() {
    return this.get('/coursetime/sylist');
  }

  getGroupList() {
    this.get('/coursetime/tglist').then(json => {
      this.groupList = json;
    });
  }
  getGradeList(yearId,semesterId){
    return this.get(`/grade/class?yearId=${yearId}&semesterId=${semesterId}`);
  }
}

