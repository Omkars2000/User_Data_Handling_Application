import React from "react";
import UserPdf from "./UserPdf";

const UserDetail = ({ user }) => {
  return (
    <div>
      <h2>{user.firstName} {user.lastName}</h2>
      <p>Email: {user.email}</p>
      <p>Phone: {user.phone}</p>
      <UserPdf userId={user.id} />
    </div>
  );
};

export default UserDetail;
