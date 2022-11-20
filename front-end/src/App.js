import './App.css';
import "bootstrap/dist/css/bootstrap.min.css";
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import IndexComponent from './components/IndexComponent';
import NavbarComponent from './components/NavbarComponent';
import UploadTimestampsComponent from './components/UploadTimestampsComponent';
import UploadJustifivesComponent from './components/UploadJustifivesComponent';
import SheetSalary from './components/SheetSalary';
import ReportSalaries from './components/ReportSalaries';

function App() {
  return (
    <div>
      <Router>
        <NavbarComponent />
        <div className="container">
          <Routes>
            <Route path="/" exact element={<IndexComponent/>}></Route>
            <Route path="/uploadtimestamps" exact element={<UploadTimestampsComponent/>}></Route>
            <Route path="/upload-justifive" exact element={<UploadJustifivesComponent/>}></Route>
            <Route path="/salary/sheet-salary" exact element={<SheetSalary/>}></Route>
            <Route path="/salary/reports" exact element={<ReportSalaries/>}></Route>
          </Routes>
        </div>
      </Router>
    </div>

  );
}

export default App;
