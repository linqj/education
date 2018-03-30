import React from 'react';
import {Table} from 'antd';
import {observer} from 'mobx-react';

@observer
export default class ClassGradeTable extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      startPosX: '',
      startPosY: '',
      endPosX: '',
      endPos: '',
      dragContent: '',
      ifDrag: false,
      dataSource: [],
      sectionData: []
    }
  }

  columns = [{
    title: '',
    dataIndex: 'section',
    key: 'section',
    width: '80px',
  }, {
    title: '周一',
    dataIndex: 'monday',
    key: 'monday',
    width: '150px',
    render: (text, record) => {
      return <div>
        <p>{text ? text.field1 : ''}</p>
        <p>{text ? text.field2 : ''}</p>
        <p>{text ? text.field3 : ''}</p>
      </div>
    }
  }, {
    title: '周二',
    dataIndex: 'tuesday',
    key: 'tuesday',
    width: '150px',
    render: (text, record) => {
      return <div>
        <p>{text ? text.field1 : ''}</p>
        <p>{text ? text.field2 : ''}</p>
        <p>{text ? text.field3 : ''}</p>
      </div>
    }
  }, {
    title: '周三',
    dataIndex: 'wednesday',
    key: 'wednesday',
    width: '150px',
    render: (text, record) => {
      return <div>
        <p>{text ? text.field1 : ''}</p>
        <p>{text ? text.field2 : ''}</p>
        <p>{text ? text.field3 : ''}</p>
      </div>
    }
  }, {
    title: '周四',
    dataIndex: 'thursday',
    key: 'thursday',
    width: '150px',
    render: (text, record) => {
      return <div>
        <p>{text ? text.field1 : ''}</p>
        <p>{text ? text.field2 : ''}</p>
        <p>{text ? text.field3 : ''}</p>
      </div>
    }
  }, {
    title: '周五',
    dataIndex: 'friday',
    key: 'friday',
    width: '150px',
    render: (text, record) => {
      return <div>
        <p>{text ? text.field1 : ''}</p>
        <p>{text ? text.field2 : ''}</p>
        <p>{text ? text.field3 : ''}</p>
      </div>
    }
  }];

  componentDidMount() {
    let sectionData = [
      {id: 18, name: '第一节'},
      {id: 19, name: '第二节'},
      {id: 20, name: '第三节'},
      {id: 21, name: '第四节'},
      // {id: 22, name: '第五节'},
      // {id: 23, name: '第六节'},
      // {id: 24, name: '第七节'},
      // {id: 25, name: '第八节'},
    ];
    let dataSource = [
      {week: 1, section: 18, field1: '数学', field2: 102, field3: '王老师',rules:{},rules2:{}},
      {week: 2, section: 19, field1: '物理', field2: 105, field3: '王老师'},
      {week: 3, section: 19, field1: '语文', field2: 103, field3: '张老师'},
      {week: 5, section: 20, field1: '化学', field2: 106, field3: '齐老师'},
      {week: 2, section: 21, field1: '生物', field2: 104, field3: '齐老师'},
      // {week: 5, section: 22, field1: '音乐', field2: 107, field3: '齐老师'},
      // {week: 1, section: 23, field1: '体育', field2: 108, field3: '齐老师'},
      // {week: 3, section: 24, field1: '政治', field2: 109, field3: '齐老师'},
    ];
    this.setState({
      dataSource: dataSource,
      sectionData: sectionData
    })
  }


//拖拽开始
  startDrag = (e) => {
    let event = e || window.event;
    event.preventDefault();
    let drapDode = document.getElementById('drap');
    let pos = drapDode.getBoundingClientRect();
    let dragLeft = pos.left;
    let dragTop = pos.top;
    let mousePosX = Math.ceil(event.clientX - dragLeft);
    let mousePosY = Math.ceil(event.clientY - dragTop);
    this.setState({
      startPosX: mousePosX,
      startPosY: mousePosY,
    });
    if ((mousePosX - 80) > 0 && (mousePosY - 52) > 0) {
      //判断内容是否为空
      let childNum = event.target.childNodes[0].childNodes;
      let targetList = event.target.parentNode.childNodes;
      let filed1Value = '';
      let filed2Value = '';
      let filed3Value = '';
      if (childNum.length == 0) {
        filed1Value = targetList[0].innerText;
        filed2Value = targetList[1].innerText;
        filed3Value = targetList[2].innerText;
      }
      this.setState({
        dragContent: <div><p>{filed1Value}</p><p>{filed2Value}</p><p>{filed3Value}</p></div>,
        ifDrag: true
      });
      let dragContent = document.getElementsByClassName('drag-content')[0];
      dragContent.style.left = mousePosX + 'px';
      dragContent.style.top = mousePosY + 'px';
      dragContent.style.display = 'inline-block';
    }
  };
  //拖拽结束
  endDrag = (e) => {
    let event = e || window.event;
    event.preventDefault();
    let drapDode = document.getElementById('drap');
    let pos = drapDode.getBoundingClientRect();
    let dragLeft = pos.left;
    let dragTop = pos.top;
    let mousePosX = Math.ceil(event.clientX - dragLeft);
    let mousePosY = Math.ceil(event.clientY - dragTop);
    this.setState({
      endPosX: mousePosX,
      endPosY: mousePosY,
      ifDrag: false
    });
    let dragContent = document.getElementsByClassName('drag-content')[0];
    dragContent.style.display = 'none';
    let ceilX = 150;
    let ceilY = 100;
    let startPosX = this.state.startPosX;
    let startPosY = this.state.startPosY;
    let numStartX = null;
    let numStartY = null;
    let numEndtX = null;
    let numEndY = null;
    if (startPosX - 80 > 0) {
      numStartX = Math.floor((startPosX - 80) / ceilX) + 1;
    }
    if (startPosY - 52 > 0) {
      numStartY = Math.floor((startPosY - 52) / ceilY);
    }
    if (mousePosX - 80 > 0) {
      numEndtX = Math.floor((mousePosX - 80) / ceilX) + 1;
    }
    if (mousePosY - 52 > 0) {
      numEndY = Math.floor((mousePosY - 52) / ceilY);
    }
    let arr = [];
    let dataSource = this.state.dataSource;
    let sectionData = this.state.sectionData;
    if (numStartX && (numStartY + 1) && numEndtX && (numEndY + 1)) {
      dataSource.forEach((item, index) => {
        if (item.week == numStartX && item.section == sectionData[numStartY].id) {
          item.week = numEndtX;
          item.section = sectionData[numEndY].id;
          arr.push(item);
        } else if (item.week == numEndtX && item.section == sectionData[numEndY].id) {
          item.week = numStartX;
          item.section = sectionData[numStartY].id;
          arr.push(item);
        } else {
          arr.push(item);
        }
      });
    } else {
      arr = dataSource;
    }
    this.setState({
      dataSource: arr
    })
  };
  dragOver = (e) => {
    let event = e || window.event;
    event.preventDefault();
    let drapDode = document.getElementById('drap');
    let pos = drapDode.getBoundingClientRect();
    let dragLeft = pos.left;
    let dragTop = pos.top;
    let mousePosX = Math.ceil(event.clientX - dragLeft);
    let mousePosY = Math.ceil(event.clientY - dragTop);
    if (this.state.ifDrag) {
      let dragWidth = drapDode.offsetWidth;
      let dragHeight = drapDode.offsetHeight;
      let left = mousePosX;
      if (mousePosX > dragWidth) {
        left = dragWidth;
      } else if (mousePosX < 80) {
        left = 80;
      }
      let top=mousePosY;
      if(mousePosY<52){
        top=52;
      }else if(mousePosY>dragHeight){
        top=dragHeight;
      }
      let dragContent = document.getElementsByClassName('drag-content')[0];
      dragContent.style.left = left + 'px';
      dragContent.style.top = top + 'px';
    }
  };

   //数据用于table显示
  dealData = () => {
    let sectionData = this.state.sectionData;
    let dataSource = this.state.dataSource;
    let arr = [];
    for (let i = 0; i < sectionData.length; i++) {
      arr[i] = {};
    }
    sectionData.forEach((items, index) => {
      let name = '';
      dataSource.forEach(item => {
        if (items.id == item.section) {
          if (item.week == 1) {
            name = 'monday';
          } else if (item.week == 2) {
            name = 'tuesday';
          } else if (item.week == 3) {
            name = 'wednesday';
          } else if (item.week == 4) {
            name = 'thursday';
          } else if (item.week == 5) {
            name = 'friday';
          }
          if (name) {
            arr[index][name] = item;
          }
        }
      });
      arr[index].section = items.name;
      arr[index].id = index;
    });
    return arr
  };

  render() {
    let tableList = this.dealData();
    return (
      <div id="drap" onMouseDown={this.startDrag} onMouseUp={this.endDrag}
           onMouseOver={this.dragOver}>
        <Table dataSource={tableList} rowKey="id" pagination={false} columns={this.columns}
               bordered={true}/>
        <div className="drag-content">
          {this.state.dragContent}
        </div>
      </div>
    );
  }
}
