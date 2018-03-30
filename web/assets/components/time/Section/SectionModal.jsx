import React from 'react';
import OperateSemester from '../../common/modal/OperateSemester';
import {observer} from 'mobx-react';
import SectionAddModal from './SectionAddModal';
import SectionInitModal from './SectionInitModal';

@observer
class SectionModal extends React.Component {
  store = this.props.store;

  constructor(props) {
    super(props);
    this.state = {};
  }
  componentDidMount(){
    this.store.getCodeList();
  }
  handleSubmit = () => {
    if(this.props.formSign==='add'){
      this.addFormValues.validateFields((err, values) => {
        if (!err) {
          this.props.onHandleSubmit(values);
        }
      });
    }else if(this.props.formSign==='init'){
      this.initFormValues.validateFields((err, values) => {
        if (!err) {
          this.props.onHandleSubmit(values);
        }
      });
    }
  };
  addForm=(form)=>{
    this.addFormValues=form;
  };
  InitForm=(form)=>{
    this.initFormValues=form;
  };
  render() {

    return (
      <OperateSemester visible={this.props.modalVisible} title={this.props.modalTitle} handleOk={this.handleSubmit} handleCancel={this.props.handleCancel} >
        {
          this.props.formSign==='init'?<SectionInitModal initValues={this.props.initValues} ref={this.InitForm} store={this.props.store} />:<SectionAddModal initValues={this.props.initValues} ref={this.addForm} store={this.props.store} />
        }
      </OperateSemester>

    );
  }
}

export default SectionModal;
