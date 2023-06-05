//import "./App.css";
//import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Register from "./Login/Register";
import Login from "./Login/Login";
import Home from "./pages/Home ";
import AddUser from "./users/AddUser";
import EditUser from "./users/EditUser";
import ViewUser from "./users/ViewUser";
//import Navbar from "./layout/Navbar";
//import "./App.css";

function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<Login/>} />
          <Route path="/signup" element={<Register/>} />
          <Route path="/a" element={<Home />} />
          <Route path="/home" element={<Home />} />
          <Route path="/adduser" element={<AddUser />} />
          <Route path="/edituser/:id" element={<EditUser />} />
          <Route path="/viewuser/:id" element={<ViewUser />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App; 



/*import Register from './Login/Register';
import Login from './Login/Login';

function App() {

  return (
    <main className="App">
      <Login />
    </main>
  );
}

export default App;*/