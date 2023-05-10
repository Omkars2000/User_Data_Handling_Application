import React, { useState } from "react";
import axios from "axios";
import getAll from '../src/services/user_services'
const AddUser = () => {
  const [user, setUser] = useState({
    userName: "",
    userEmail: "",
    userPhone: "",
  });

  const { userName, userEmail, userPhone } = user;

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    await axios.post("/api/o1/save", user);
    setUser({
        userName: "",
        userEmail: "",
        userPhone: "",
    });
  };

  return (
    
    <div className="container">
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="userName">User Name</label>
          <input
            type="text"
            className="form-control"
            name="userName"
            value={userName}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label htmlFor="userEmail">User Eamil</label>
          <input
            type="email"
            className="form-control"
            name="userEmail"
            value={userEmail}
            onChange={handleChange}
          /><br></br>
        </div>
        <div className="form-group">
          <label htmlFor="phone">User Phone</label>
          <input
            type="number"
            className="form-control"
            name="userPhone"
            value={userPhone}
            onChange={handleChange}
          />
        </div>
       
        <button type="submit" className="btn btn-primary">
          Add User
        </button>
      </form>
    </div>
  );
};

export default AddUser;
