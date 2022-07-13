import React, {useState,useEffect} from 'react'
import File from '../../../../classes/File'
import "./FolderTree.css"

export default function FolderTree(props) {
    
    const [fileList, setFileList] = useState(File.getFiles(props.subId))

    console.log(`fileList: ${fileList}`)

    useEffect(()=>{

      console.log(`active Folder Tree: ${props.subId}`)
      setFileList(File.getFiles(props.subId))
    },[props.subId])



    const clickFile = (id)=>{
      props.updateFileId(id)
    }

    
   
  if(fileList !== undefined){
    return fileList.map(file=>{
        return (<div className="fileLabel" key={file.id}>
            <h5>{file.id} - {file.folder} - {file.subFolder}:</h5>
            <button onClick={e=>clickFile(file.id)}><h6>{file.fileName}</h6></button>

        </div>)
    })
  }

  return <div></div>
}
