import React, { useState } from "react";
import axios from "axios";

const DownloadPDF = () => {
  const [pdf, setPdf] = useState(null);

  const downloadPDF = () => {
    axios({
      url: "http://localhost:8080/api/o1/report",
      method: "GET",
      responseType: "blob",
    }).then((response) => {
      const url = window.URL.createObjectURL(new Blob([response.data]));
      setPdf(url);
    });
  };

  return (
    <div>
      <button onClick={downloadPDF}>Download PDF</button>
      {pdf && (
        <embed
          style={{ width: "100%", height: "800px" }}
          src={pdf}
          type="application/pdf"
        />
      )}
    </div>
  );
};

export default DownloadPDF;
