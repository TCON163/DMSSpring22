import React, {useState, useEffect} from 'react'
import File from '../../../../classes/File'

export default function PDFViewer(props) {

  const [file,setFile] = useState();

  useEffect(()=>{
    setFile(File.getFile(props.fileId))
  },[props.fileId])


  if(file !== undefined){
  return (
    <div>
      PDFViewer
      <h1>File Name: {file.fileName}</h1>
    
      </div>
  )
}
}
