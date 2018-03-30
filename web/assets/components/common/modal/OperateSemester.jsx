import React from 'react';
import './Index.less';


export default class OperateSemester extends React.Component {
  onCloseWrap = (e) => {
    this.props.handleCancel();
  };
  onOk = () => {
    this.props.handleOk();
  };
  onCancel = () => {
    this.props.handleCancel();
  };


  render() {
    let modalMask = document.getElementsByClassName('modal-mask')[0];
    let modalBody = document.getElementsByClassName('modal-body')[0];
    if(this.props.tableIndex){
      modalMask = document.getElementsByClassName('modal-mask')[this.props.tableIndex];
      modalBody = document.getElementsByClassName('modal-body')[this.props.tableIndex];
    }
    if (this.props.visible) {
      //蒙版
      modalMask.style.display = 'block';
      //弹出框
      if (modalBody) {
        modalBody.style.right = 0;
      }
    }

    if (typeof this.props.visible == 'boolean' && !(this.props.visible)) {
      modalMask.style.display = 'none';
      //弹出框
      modalBody.style.right = '-520px';
    }

    let modalTitle = this.props.title ? this.props.title : '';
    return (
      <div className="modal">
        <div className="modal-mask" onClick={this.onCloseWrap}></div>
        <div className="modal-body">
          <div className="modal-body-header">
            <button className="modal-body-header-button" onClick={this.onClose}>
              <span className="button-icon-close"></span>
            </button>
            <div className="modal-body-header-title">{modalTitle}</div>
          </div>
          <div className="modal-body-content">
            {this.props.children}
          </div>
          <div className="modal-body-footer">
            <button className="button-ok" onClick={this.onOk}>确定</button>
            <button className="button-cancel" onClick={this.onCancel}>取消</button>
          </div>
        </div>
      </div>
    );
  }
}
