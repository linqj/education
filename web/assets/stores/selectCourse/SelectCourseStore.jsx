import BaseStore from '../BaseStore';
import {observable} from 'mobx';
class SelectCourseStore extends BaseStore{
  @observable allSemesterData=[];
  @observable allGradeData=[];

  //modal中获取所有学年学期列表
  getAllSemesterList(){
    this.get('/semester/schoolyearlist').then(res=>{
      this.allSemesterData=res;
    });
  }
  //modal中获取所有年级列表
  getAllGradeList(){
    this.get('/grade/all').then(res=>{
      this.allGradeData=res;
    });
  }
}
export  default  SelectCourseStore;
