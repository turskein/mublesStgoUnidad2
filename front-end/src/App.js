import './App.css';
import "bootstrap/dist/css/bootstrap.min.css";
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import IndexComponent from './components/IndexComponent';
import NavbarComponent from './components/NavbarComponent';
import UploadTimestampsComponent from './components/UploadTimestampsComponent';

function App() {
  return (
    <div>
      <Router>
        <NavbarComponent />
        <div className="container">
          <Routes>
            <Route path="/" exact element={<IndexComponent/>}></Route>
            <Route path="/uploadtimestamps" exact element={<UploadTimestampsComponent/>}></Route>
          </Routes>
        </div>
      </Router>
    </div>

  );
}

export default App;
