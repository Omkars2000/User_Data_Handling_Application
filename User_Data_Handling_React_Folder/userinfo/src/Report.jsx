import React, { useState, useEffect } from "react";
import axios from "axios";

const Report = () => {
  const [pdf, setPdf] = useState(null);

  useEffect(() => {
    const getPdf = async () => {
      const response = await axios.get(
        "http://localhost:8080/api/o1/report",
        { responseType: "blob" }
      );
      const pdfBlob = new Blob([response.data], { type: "application/pdf" });
      setPdf(URL.createObjectURL(pdfBlob));
    };
    getPdf();
  }, []);

  return (
    <div>
      <h1>User Report</h1>
      {pdf && (
        <embed src={pdf} width="100%" height="500px" type="application/pdf" />
      )}
    </div>
  );
};

export default Report;