import BaseStore from '../BaseStore';
import {observable} from  'mobx';
class ResearchStore extends BaseStore{
  @observable allCourseData=[];
  getAllResearchList(v){
    let pageNum=1;
    if(v){
      pageNum=v;
    }
    return this.get(`/teachergroup/list?pageNum=${pageNum}`);
  }
  getAllCourseList(){
    this.get('/course/coursetree').then(json=>{
      this.allCourseData=json.data;
    });
  }
  saveResearchList(v){
    return this.post('/teachergroup/save',v);
  }

  delResearchList(tgId){
    return this.delete(`/teachergroup/del/${tgId}`);
  }
}
export  default ResearchStore;
