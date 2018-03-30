import React from 'react';
import {Breadcrumb, Icon, Row, Col} from 'antd';
import {observer} from 'mobx-react';

@observer
export default class ArrangeIndex extends React.Component {

  render() {

    return (
      <div className="arrange">
        <div className="project-breadcrumb">
          <Breadcrumb>
            <Breadcrumb.Item>User</Breadcrumb.Item>
            <Breadcrumb.Item>Bill</Breadcrumb.Item>
          </Breadcrumb>
          <p className="project-title-first">排课列表</p>
          <p>段落示意：蚂蚁金服务设计平台-design.alipay.com，用最小的工作量，无缝接入蚂蚁金服生态，
              提供跨越设计与开发的体验解决方案。</p>
          <div className="project-description">
            <span className="project-description-item"><Icon type="exclamation-circle-o" /><span className="project-description-item-text">排课导引</span></span>
            <span className="project-description-item"><Icon type="exclamation-circle-o" /><span className="project-description-item-text">排课说明</span></span>
            <span className="project-description-item"><Icon type="exclamation-circle-o" /><span className="project-description-item-text">排课日志</span></span>
          </div>
        </div>
        <div className="arrange-content">
          <Row gutter={32}>
            <Col span={8}>
              <div className="arrange-content-blank"></div>
            </Col>
            <Col span={8}></Col>
          </Row>
        </div>

      </div>
    );
  }
}
