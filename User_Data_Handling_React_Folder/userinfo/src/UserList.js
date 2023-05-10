import React, { useState, useEffect } from 'react';
import axios from 'axios';
import getAll from '../src/services/user_services'
function UserList() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    axios.get('/api/o1/all')
      .then(response => setUsers(response.data))
      .catch(error => console.error(error));
  }, []);

  return (
    <div>
      <h1>User List</h1>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
          </tr>
        </thead>
        <tbody>
          {users.map(user => (
            <tr key={user.userId}>
              <td>{user.userName}</td>
              <td>{user.userEmail}</td>
              <td>{user.userPhone}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default UserList;
