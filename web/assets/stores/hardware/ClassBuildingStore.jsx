import BaseStore from '../BaseStore';
import {observable} from 'mobx';
class ClassBuilding extends BaseStore {
  @observable buildingListObject = {};
  //获取页面列表
  getAllBuildingList(v) {
    let pageNum = 1;
    if (v) {
      pageNum = v;
    }
    return this.get(`/classbuilding/list?pageNum=${pageNum}`).then(json => {
      this.buildingListObject = json.data;
    });
  }

  //添加
  addBuilding = (v) => {
    return this.post('/classbuilding/save', v);
  };
  //修改
  editBuilding(v) {
    return this.post('/classbuilding/save', v);
  }

  //删除
  deleteBuilding(cbId) {
    return this.delete(`/classbuilding/del/${cbId}`);
  }
}

export default ClassBuilding;
