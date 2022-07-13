import React, {useEffect, useState} from "react";
import "./DMSDashboard.css";

import SubmissionTreeGrid from "./dashboardComponents/submissionFolders/SubmissionTreeGrid";
import PDFViewer from "./dashboardComponents/pdfViewer/PDFViewer";
import File from "../../classes/File";

export default function DMSDashboard() {




    
    const [activeSub, setActiveSub] = useState(1);

    useEffect(()=>{
        console.log(`activeSubmission: ${activeSub}`)
        // this set's the fileId to the fist file, in the new submission folder you switch to.
        setFileId(File.getFiles(activeSub)[0].id)
    },[activeSub])


    const [fileId, setFileId] = useState(1)

    useEffect(()=>{
        console.log(`File id: ${fileId}`);

    },[fileId])
   
    const handleActiveSub = (id)=>{
        setActiveSub(id)
    }

    const handleFileId = (id)=>{
        setFileId(id)
    }
    

  return (
    <div className="grid">
        <SubmissionTreeGrid  activeSub={activeSub} handleActiveSub={handleActiveSub} handleFileId={handleFileId} fileId={fileId}/>
      
       <div className="two gridColumn">
        PDF / Image Viewer
        <PDFViewer fileId={fileId}></PDFViewer>
       </div>
       
      
    </div>
  );
}

