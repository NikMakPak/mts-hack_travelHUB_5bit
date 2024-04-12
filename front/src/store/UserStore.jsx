import { makeAutoObservable, toJS } from 'mobx';
import axios from 'axios';

class UserStore {
  userInfo = {
    token: '',
    id: 0,
    name: '',
    surname: '',
    email: '',
    password: '',
    grade: 0,
    passport: '',
    bids: [],
    squad: {},
    role: {},
  };
  isAuth = false;

  constructor() {
    makeAutoObservable(this);
  }

  setUserData = (data) => {
    this.userInfo = { ...this.userInfo, ...data };
  };

  login = async (credentials) => {
    try {
      const response = await axios.post(`api/login`, credentials, {
        headers: {
          'Content-Type': 'application/json',
          'Access-Control-Allow-Origin': '*',
        },
      });
      const { data } = response;
      this.setUserData(data);
      this.isAuth = true;
      console.log(toJS(this.userInfo))
      return true;
    } catch (error) {
      console.error('Login failed:', error);
      return false;
    }
  };
}

export default new UserStore();
