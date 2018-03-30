import React from 'react';
import {
  Row,Col
} from 'antd';
import {observer} from 'mobx-react';
import '../drag/Index.less';


@observer
export default class Drag extends React.Component {
  constructor(props){
    super(props);
    this.state={
      dataSource:[{
        id: '1',
        monday: '英语1',
        tuesday: '数学1',
        wednesday: '物理1',
        thursday: '政治1',
        friday: '化学1'
      }, {
        id: '2',
        monday: '英语2',
        tuesday: '数学2',
        wednesday: '物理2',
        thursday: '政治2',
        friday: '化学2'
      }, {
        id: '3',
        monday: '英语3',
        tuesday: '数学3',
        wednesday: '物理3',
        thursday: '政治3',
        friday: '化学3'
      }, {
        id: '4',
        monday: '英语4',
        tuesday: '数学4',
        wednesday: '物理4',
        thursday: '政治4',
        friday: '化学4'
      }, {
        id: '5',
        monday: '英语5',
        tuesday: '数学5',
        wednesday: '物理5',
        thursday: '政治5',
        friday: '化学5'
      }],
      startPosX:'',
      startPosY:'',
      endPosX:'',
      endPos:'',
      dragContent:'',
      ifDrag:false
    }
  }
  startDrag=(e)=>{
    let event=e||window.event;
    event.preventDefault();
    let drapDode=document.getElementById('drap');
    let dragLeft=drapDode.offsetLeft+200;
    let dragTop=drapDode.offsetTop+64;
    let mousePosX=event.clientX-dragLeft;
    let mousePosY=event.clientY-dragTop;

    this.setState({
      startPosX:mousePosX,
      startPosY:mousePosY,
    });
    this.setState({
      dragContent:<span>78956798574398</span>,
      // dragContent:event.target,
      ifDrag:true
    });
    let dragContent=document.getElementsByClassName('drag-content')[0];
    dragContent.style.left=mousePosX+'px';
    dragContent.style.top=mousePosY+'px';
    dragContent.style.display='inline-block';
  };
  endDrag=(e)=>{
    let event=e||window.event;
    event.preventDefault();
    this.setState({
      endPosX:event.clientX,
      endPosY:event.clientY,
      ifDrag:false
    });
    let dragContent=document.getElementsByClassName('drag-content')[0];
    dragContent.style.display='none';
  };
  dragOver=(e)=>{
    let event=e||window.event;
    event.preventDefault();
    let drapDode=document.getElementById('drap');
    let posX=event.clientX;
    let posY=event.clientY;
    //drag距离浏览器的距离
    let dragLeft=drapDode.offsetLeft+200;
    let dragTop=drapDode.offsetTop+64;
    if(this.state.ifDrag){
      let dragContent=document.getElementsByClassName('drag-content')[0];
      dragContent.style.left=posX - dragLeft+'px';
      dragContent.style.top=posY - dragTop+'px';
    }
  };
  render() {
    return (
      <div id="drap" onMouseDown={this.startDrag} onMouseUp={this.endDrag} onMouseOver={this.dragOver}>
        {this.state.dataSource.map((item,index)=>{
         return <Row key={index}>
            <Col span={4} className="div"><span>{item.monday}</span></Col>
            <Col span={4} className="div"><span>{item.tuesday}</span></Col>
            <Col span={4} className="div" ><span>{item.wednesday}</span></Col>
            <Col span={4} className="div"><span>{item.thursday}</span></Col>
            <Col span={4} className="div"><span>{item.friday}</span></Col>
          </Row>
        })}
        <div className="drag-content">
          {this.state.dragContent}
        </div>


      </div>
    );
  }
}
