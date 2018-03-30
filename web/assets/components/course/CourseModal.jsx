import React from 'react';
import {Checkbox, Button} from 'antd';
import {observer} from 'mobx-react';
import OperateSemester from '../common/modal/OperateSemester';
const CheckboxGroup = Checkbox.Group;

@observer
class CourseModal extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      indeterminate: true,
      initdeterminate: true,
      checkAll: false,
      checkInitAll: false,
      exist: [],
      noexist: [],
      checkedList: [],
      checkedInitList: [],
      initExist: [],
      initNoexist: []
    };
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.gradeIdIndex) {
      //调取课程接口
      this.props.courseStore.getCourseObject(nextProps.gradeIdIndex).then(json => {
        this.setState({
          exist: this.transformWord(json.data.exist),
          noexist: this.transformWord(json.data.noexist),
          initExist: this.transformWord(json.data.exist),
          initNoexist: this.transformWord(json.data.noexist),
        });
      });
    }
  }

  onHandleSubmit = () => {
    let exist=this.transformForm(this.state.exist);
    this.props.handleSubmit(exist);

  };

  onChange = (checkedList) => {
    let noexist = this.state.noexist;
    this.setState({
      checkedList,
      indeterminate: !!checkedList.length && (checkedList.length < noexist.length),
      checkAll: checkedList.length === noexist.length,
    });
  };
  onCheckAllChange = (e) => {
    let noexist = this.state.noexist;
    this.setState({
      checkedList: e.target.checked ? this.transformForm(noexist) : [],
      indeterminate: false,
      checkAll: e.target.checked,
    });
  };
  onInitChange = (checkedInitList) => {
    let exist = this.state.exist;
    this.setState({
      checkedInitList,
      initdeterminate: !!checkedInitList.length && (checkedInitList.length < exist.length),
      checkInitAll: checkedInitList.length === exist.length,
    });
  };

  onInitCheckAllChange = (e) => {
    let exist = this.state.exist;
    this.setState({
      checkedInitList: e.target.checked ? this.transformForm(exist) : [],
      initdeterminate: false,
      checkInitAll: e.target.checked,
    });
  };
  //转换字段
  transformWord(arr) {
    let arrList = [];
    arr.forEach(item => {
      arrList.push({label: item.name, value: item.code});
    });
    return arrList;
  }

  addToRight = () => {
    let checkedList = this.state.checkedList;
    let noexist = this.state.noexist;
    let exist = this.state.exist;
    let addExist = [];
    let deleteExist = [];
    noexist.forEach(items => {
      let isHave=false;
      checkedList.forEach(item => {
        if (items.value === item) {
          addExist.push(items);
          isHave=true;
        }
      });
      if(!isHave){
        deleteExist.push(items);
      }
    });
    this.setState({
      noexist:deleteExist,
      exist:exist.concat(addExist),
    });
  };
  addToLeft=()=>{
    let checkedInitList = this.state.checkedInitList;
    let noexist = this.state.noexist;
    let exist = this.state.exist;
    let addExist = [];
    let deleteExist = [];
    exist.forEach(items => {
      let isHave=false;
      checkedInitList.forEach(item => {
        if (items.value === item) {
          addExist.push(items);
          isHave=true;
        }
      });
      if(!isHave){
        deleteExist.push(items);
      }
    });
    this.setState({
      noexist:noexist.concat(addExist),
      exist:deleteExist,
    });
  };
  transformForm(arr) {
    let arrList = [];
    arr.length > 0 && arr.forEach(item => {
      arrList.push(item.value);
    });
    return arrList;
  }

  render() {
    let exist = this.state.exist;
    let noexist = this.state.noexist;
    let checkedList = this.state.checkedList;
    let checkedInitList = this.state.checkedInitList;
    return (
      <OperateSemester visible={this.props.modalVisible} title={this.props.modalTitle} handleOk={this.onHandleSubmit}
                       handleCancel={this.props.handleCancel}
                       tableIndex={this.props.tabsIndex}
      >
        <p className="project-content-title">{this.props.gradeName}课程管理</p>
        <div className="course-modal">
          <div className="course-modal-content">
            <Checkbox
              indeterminate={this.state.indeterminate}
              onChange={this.onCheckAllChange}
              checked={this.state.checkAll}
              className='course-modal-content-checkbox clear'
            >
              <span className='course-modal-content-checkbox-text'>备选课程</span>
            </Checkbox>
            <CheckboxGroup className='modal-checkbox-group' options={noexist} value={checkedList}
                           onChange={this.onChange}/>
          </div>
          <div className="course-modal-operate">
            <Button onClick={this.addToRight}>加入右侧&gt;</Button>
            <Button className="course-modal-operate-button" onClick={this.addToLeft}>&lt;加入左侧</Button>
          </div>
          <div className="course-modal-content">
            <Checkbox
              indeterminate={this.state.initdeterminate}
              onChange={this.onInitCheckAllChange}
              checked={this.state.checkInitAll}
              className='course-modal-content-checkbox clear'
            >
              <span className='course-modal-content-checkbox-text'>已选课程</span>
            </Checkbox>
            <CheckboxGroup className='modal-checkbox-group' options={exist} value={checkedInitList}
                           onChange={this.onInitChange}/>
          </div>
        </div>
      </OperateSemester>
    );
  }
}

export default CourseModal;
