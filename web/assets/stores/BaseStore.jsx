import {observable} from 'mobx';

// const headers = {
//   'Accept': 'application/json',
//   'Content-Type': 'application/json',
//   // "Content-Type": "application/x-www-form-urlencoded"
// };

export default class BaseStore {
  @observable error = null;

  handleError = (status, error) => {
    this.error = {
      code: status,
      message: error
    };
  };

  constructor() {
    // this.baseUrl = 'http://paike.chinayouthedu.com:1234';
    this.baseUrl = 'http://10.3.2.201';
    // this.baseUrl = 'http://10.3.30.2';
    // this.baseUrl = 'http://10.3.30.1';
    // this.baseUrl = 'http://10.3.30.4';
  }

  get = (url) =>
    fetch(this.baseUrl + url, {
      method: 'GET',
      credentials: 'same-origin',
    }).then(resp =>{
      return Promise.all([resp.ok, resp.status, resp.headers, resp.json()]);
      }
    ).then(([ok, status, headers, json]) => {
      if (ok) {
        let total = headers.get('x-total');
        if (total) {
          return {
            total: parseInt(total),
            data: json
          };
        }
        return json;
      } else {
        this.handleError(status, json.message);
        throw new Error(json.message);
      }
    }).catch(error => {
      throw error;
    });

  post = (url, body) => this._request(url, body, 'POST');

  // put = (url, body) => this._request(url, body, 'PUT');

  delete = (url, body) => this._request(url, body, 'DELETE');

  _request = (url, body, method) => {
    let formData = new FormData();
    if (body) {
      Object.keys(body).forEach(item => {
        if (body[item]) {
          formData.append(item.toString(), body[item]);
        }
      });
    }

    return fetch(this.baseUrl + url, {
      method: method,
      headers: {},
      body: formData
    }).then(resp => {
      let ret = '';
        if (resp.status !== 204) {
          ret = resp.json();
        }
        return Promise.all([resp.ok, resp.status, ret]);
      }
    ).then(([ok, status, json]) => {
      if (ok && json&& json.success) {
        return json;
      } else {
        this.handleError(status, json.msg + json.code);
        throw new Error(json.msg);
      }
    }).catch(error => {
      throw error;
    });
  };

}
