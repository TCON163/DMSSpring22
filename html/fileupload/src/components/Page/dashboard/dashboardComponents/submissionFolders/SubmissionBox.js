import React from 'react';
// import Submission from '../../../../classes/Submission';
import "./SubmissionBox.css";

export default function SubmissionBox(props) {

   let bold = "bold";

   if(!props.active){
    bold = "normal"
   }
    
  return (
    <div>
      <h5 className={bold}>Submission: {props.submission.id}; {props.submission.customerName}</h5>
    
      
    
    </div>
  )
}
