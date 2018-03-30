import BaseStore from '../BaseStore';
import {observable} from  'mobx';
class TimeMangerStore extends BaseStore {
  @observable groupList = [];
  @observable tableListObject = [];

  getAllYearList() {
    return this.get('/coursetime//sylist');
  }

  getGroupList() {
    this.get('/coursetime/tglist').then(json => {
      this.groupList = json;
    });
  }

  getTableObjects(syId, xqId, tgId,v) {
    let tgIdA = (tgId && tgId != 'all') ? tgId : null;
    let pageNum = v ? v : 1;
    return this.post(`/coursetime/ctlist`, {syId: syId, xqId: xqId, tgId: tgIdA, pageNum: pageNum}).then(json => {
      this.tableListObject = json.data;
    });
  }
  editTimeManger(v){
    return this.post('/coursetime/save',v);
  }
}
export  default TimeMangerStore;
