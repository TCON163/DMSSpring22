import React , {useState, useEffect} from 'react';
import "./OpenSubmissionFolders.css";

import SubmissionBox from './SubmissionBox';
import Submission from '../../../../classes/Submission';

export default function OpenSubmissionFolders(props) {

    let list = Submission.getSubmissions();
    
   

   function addToList(sub){
    list.push(sub)
    // setList(list);
   }

   
   const clickSubmission = (id)=>{
    props.updateActiveSub(id)
   }
  

    function isActive(id){
     if(id === props.activeSub) return true;
     return false;   
    }

    // const OpenSubmissionsList = ()=>{

        if(list!==undefined){
        return list.map((sub)=>{
            return(
            <button className="subBox" key={sub.id} onClick={e=> clickSubmission(sub.id)}>
                
                <SubmissionBox  submission={sub} active={isActive(sub.id)} />
            </button>
        )})
        
    
    }

        return(<div></div>)
    }


    


 
