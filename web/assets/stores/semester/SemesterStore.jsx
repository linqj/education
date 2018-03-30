import BaseStore from '../BaseStore';
import {observable} from 'mobx';
class SemesterStore extends BaseStore{
  @observable valueList = [];

  getAllSemesterList(value){
    let pageNum=1;
    if(value){
      pageNum=value;
    }
    return this.get(`/semester/list?pageNum=${pageNum}`);
  }
  saveSemesterList(v){
    return this.post('/semester/save.do',v);
  }
  delSemesterList(xnId){
    return this.delete(`/semester/del/${xnId}`);
  }
}

export default SemesterStore;
