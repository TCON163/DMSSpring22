import { useEffect } from 'react';
import './App.css';
import CustomeSwitchRouter from './components/Router/CustomeSwitchRouter';


function App() {
  document.title = "DMS"

useEffect(() => {
  window.resizeTo(1000, 750)
})




  return (
    <div className="App">
 
      <CustomeSwitchRouter></CustomeSwitchRouter>
    </div>
  );
}

export default App;
