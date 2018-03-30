import moment from 'moment';
import {message} from 'antd';

class Utility {
  dealUndefined = (v) => {
    // if (v && v != null || v == 0) {
    //   return v;
    // } else {
    //   return '--';
    // }
    if (v || v === 0) {
      return v;
    } else {
      return '--';
    }
  };
  conversionsUrl = (values) => {
    let query = '&';
    Object.keys(values).forEach(key => {
      if (values[key]) {
        query += `${key}=${values[key]}&`;
      }
    });
    return query;
  };
  formatNumberRgx = (num) => {
    let parts = num.toString().split('.');
    parts[0] = parts[0].replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    return parts.join('.');
  };
  //判断是否有新建的权限
  isCanCreate = (code, url, router) => {
    let userStr = localStorage.getItem('user');
    if (!userStr) return;
    let currentUser = JSON.parse(userStr);
    if (currentUser.permissions) {
      let isHave = false;
      currentUser.permissions.forEach(content => {
        if (content === code) {
          isHave = true;
          router.history.push(url);
        }
      });
      if (!isHave) {
        message.error('您没有该权限，请联系管理员');
      }
    }
  };

  getTotalForm(arr) {
    let error = false;
    let valuesList = {};
    arr.forEach(item => {
      if (!error) {
        item.validateFields((err, values) => {
          if (!err) {
            Object.keys(values).forEach(key => {
              valuesList[key] = values[key];
            });
          } else {
            error = true;
          }
        });
      }
    });
    return {'values': valuesList, 'error': error};
  }

  // 处理文件上传表单字段
  static getFilePublicKeys(fileFormValues) {
    let publicKeys = [];
    if (fileFormValues && Array.isArray(fileFormValues)) {
      fileFormValues.forEach(item => {
        if (item.publicKey) {
          publicKeys.push(item.publicKey);
        }
      });
    }
    return publicKeys;
  }

  //为数组数据添加id
  addId = (v) => {
    if (v.length > 0) {
      v.forEach((item, index) => {
        v[index].id = index;
      });
    }
    return v;
  };

  /***
   * 返回本月第一天到现在的时间
   */
  static getCurrentMonthDays() {
    let now = moment();
    let startDayOfMonth = moment({year: now.year(), month: now.month()});
    let format = 'YYYY-MM-DDTHH:mm:ss';
    return [startDayOfMonth.format(format), now.format(format)];
  }

  /***
   * 返回本周开始到现在的时间
   */
  static  getThisWeek() {
    let now = moment();
    let day = now.days();
    let sunday = now;
    if (day !== 0) {
      sunday = now.add(7 - day, 'days');
    }

    let ret = [];
    let monday = sunday.subtract(6, 'days');
    ret.push(monday.format('YYYY-MM-DD') + 'T00:00:00');
    ret.push(moment().format('YYYY-MM-DDTHH:mm:ss'));
    return ret;
  }

  /**
   * 2017-12-27T10:35:01.668
   * @param utcDateString
   */
  static utc2LocalTime(utcDateString) {
    let date = moment(utcDateString, 'YYYY-MM-DDTHH:mm:ss.SSS');
    date.add(8, 'hours');
    return date.format('YYYY-MM-DD HH:mm:ss');
  }

  //日期选择不可选今天以后的日期
  disabledDate = (current) => {
    // Can not select days before today and today
    return current > moment().endOf('day');
  };
  //解析二级联动数据
  conversionCode = (v) => {
    let arr = [];
    v.forEach(items => {
      let arrChildren=[];
      items.children.forEach(item=>{
        arrChildren.push({value: item.code,
          label: item.text,children:null});
      });
      arr.push({
        value: items.code,
        label: items.text,
        children:arrChildren
      });
    });
    return arr;
  };
}

export default Utility;
