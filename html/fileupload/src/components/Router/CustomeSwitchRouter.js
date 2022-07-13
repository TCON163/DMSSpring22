import React from 'react';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import DMSDashboard from '../Page/dashboard/DMSDashboard';


export default function CustomeSwitchRouter() {
  return (
        <Router>
            <Routes>
                <Route exact path="/" element={<DMSDashboard/>} />
            

     
            </Routes>
        </Router>
  )
}
