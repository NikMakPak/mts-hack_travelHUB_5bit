import { makeAutoObservable } from 'mobx';
import axios from 'axios';

class UserStore {
  JWT_Token = '';
  id = 0;
  name = '';
  surname = '';
  email = '';
  password = '';
  grade = 0;
  passport = '';
  bids = [];
  squad = {};
  role = {};
  isAuth = false;

  constructor() {
    makeAutoObservable(this);
  }

  setUserData(data) {
    this.JWT_Token = data.JWT_Token;
    this.id = data.id;
    this.name = data.name;
    this.surname = data.surname;
    this.email = data.email;
    this.password = data.password;
    this.grade = data.grade;
    this.passport = data.passport;
    this.bids = data.bids;
    this.squad = data.squad;
    this.role = data.role;
  }

  async login(credentials) {
    try {
      const response = await axios.post(`${import.meta.env.VITE_REACT_API_URL}/login`, credentials);
      const { data } = response;
      this.setUserData(data);
      localStorage.setItem('JWT_Token', data.JWT_Token);
      this.isAuth = true;
      return true;
    } catch (error) {
      console.error('Login failed:', error);
      return false;
    }
  }
}

export default new UserStore();
