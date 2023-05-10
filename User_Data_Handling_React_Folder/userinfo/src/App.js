
import React from "react";
import { Routes, Route } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import AddUser from "./AddUser";
import DownloadPDF from "./downloadPdf";
import Report from "./Report";
import ExcelUpload from './uplodExcel';
import UpdateUser from "./UpdateUser";
function App() {
  return (
   <div>
    <Report/>
    <h1>Add User UserDetail</h1>
    <AddUser/><br></br>
    <ExcelUpload/><br></br>
    <h1>Update User UserDetail</h1>
    <UpdateUser/>
   </div>
  //   <div className="container">
  //   <Navbar />
  //   <Routes>
  //     <Route path="/uploadExcel" component={ExcelUpload} />
  //     <Route exact path="/Report" component={Report} />
  //     <Route path="/AddUser" component={AddUser} />
  //   </Routes>
  // </div>
  );
}
export default App;
