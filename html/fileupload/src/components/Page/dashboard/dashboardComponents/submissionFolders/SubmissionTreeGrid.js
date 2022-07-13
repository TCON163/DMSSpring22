import React, {useState} from 'react'
import FolderTree from './FolderTree';
import OpenSubmissionFolders from './OpenSubmissionFolders'

export default function SubmissionTreeGrid(props) {

    


    const updateActiveSub = (id)=>{
        props.handleActiveSub(id)
    }

    const updateFileId = (id)=>{
        props.handleFileId(id)
    }

  
 



  return (
    <div className="one gridColumn">
        <div className="openFileHeader">
            place button to retract this part of grid. 
        </div>
        <div className="openSubmissions">
            Open Submission Folders
            <OpenSubmissionFolders activeSub={props.activeSub} updateActiveSub={updateActiveSub}/>
        </div>
        <div className="submissionFolders">

            Folder Tree for active Submission
            <FolderTree subId={props.activeSub} updateFileId={updateFileId} fileId={props.fileId}> </FolderTree>
        </div>
    </div>
  )
}
