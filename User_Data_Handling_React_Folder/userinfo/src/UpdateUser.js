import { useState } from 'react';
import axios from 'axios';

function UpdateUser() {
  const [userName, setUserName] = useState('');
  const [userEmail, setUserEmail] = useState('');
  const [userPhone, setUserPhone] = useState('');

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.put('http://localhost:5000/api/o1/update', {
        userName,
        userEmail,
        userPhone,
      });

      console.log('User updated successfully', response.data);
      // Do something with the response
    } catch (error) {
      console.error('Error occurred while updating user', error);
      // Handle error
    }
  };

  return (
    <div className="container">
    <form onSubmit={handleSubmit}>
      <div className="form-group">
        <label htmlFor="userName">User Name:</label>
        <input
          type="text"
          className="form-control"
          id="userName"
          value={userName}
          onChange={(event) => setUserName(event.target.value)}
        />
      </div>
      <div className="form-group">
        <label htmlFor="userEmail">User Email:</label>
        <input
          type="email"
          className="form-control"
          id="userEmail"
          value={userEmail}
          onChange={(event) => setUserEmail(event.target.value)}
        />
      </div>
      <div className="form-group">
        <label htmlFor="userPhone">User Phone</label>
        <input
          type="number"
          className="form-control"
          id="userPhone"
          value={userPhone}
          onChange={(event) => setUserPhone(event.target.value)}
        />
      </div>
      <button type="submit" className="btn btn-primary">Update</button>
    </form>
    </div>
  );
}

export default UpdateUser;
