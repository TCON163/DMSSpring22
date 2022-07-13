import React, {useState,useEffect} from 'react'
import File from '../../../../classes/File'
import "./FolderTree.css"

export default function FolderTree(props) {
    
    const [fileList, setFileList] = useState(File.getFiles(props.subId))



    useEffect(()=>{

    
      setFileList(File.getFiles(props.subId))
    },[props.subId])



    const clickFile = (id)=>{
      props.updateFileId(id)
    }


    function isActive(id){
      if(props.fileId ===id){
        return "fileName-active"
      }
      return "fileName"
    }




  
   
  if(fileList !== undefined){
    return fileList.map(file=>{
        return (<div className="fileNameBox" key={file.id}>
            <p className="fileLabel" >{file.id} - {file.folder} - {file.subFolder}:</p>
          
            <p className={isActive(file.id)} onClick={e=>clickFile(file.id)}>{file.fileName}</p>
            
        </div>)
    })
  }

  return <div></div>
}
