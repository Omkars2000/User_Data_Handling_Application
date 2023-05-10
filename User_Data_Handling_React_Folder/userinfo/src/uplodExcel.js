import React, { useState } from "react";
import axios from "axios";

function App() {
  const [selectedFile, setSelectedFile] = useState(null);

  const onFileChange = (event) => {
    setSelectedFile(event.target.files[0]);
  };

  const onFileUpload = () => {
    const formData = new FormData();
    formData.append("file", selectedFile);

    axios.post("http://localhost:8080/api/o1/upload", formData).then((response) => {
      console.log(response.data);
    });
  };

  return (
    <div>
      <h1>Excel File Upload</h1>
      <input type="file" onChange={onFileChange} />
      <button onClick={onFileUpload}>Upload</button>
    </div>
  );
}

export default App;