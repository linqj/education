import BaseStore from '../BaseStore';
import {observable} from  'mobx';
class SectionStore extends BaseStore{
  @observable allCodeData=[];
  getAllSectionList(v){
    let pageNum=1;
    if(v){
      pageNum=v;
    }
    return this.get(`/timetables/list?pageNum=${pageNum}`);
  }
  getCodeList(){
    this.get('/dictionary/paike_timetables_num').then(res=>{
      this.allCodeData=res.data;
    });
  }
  saveSectionList(v){
    return this.post('/timetables/save',v);
  }
  delSectionList(tgId){
    return this.delete(`/timetables/del/${tgId}`);
  }
  initSectionList(v){
    return this.post('/timetables/init',v);
  }
  editSectionList(v){
    return this.post('/timetables/edit',v);
  }
}
export  default SectionStore;
