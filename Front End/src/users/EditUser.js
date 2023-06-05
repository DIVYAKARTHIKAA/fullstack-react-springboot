import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
//import { Validator } from "react";

export default function EditUser() {
  let navigate = useNavigate();

  const { id } = useParams();

  const [user, setUser] = useState({
    name: "",
    phone: "",
    email: "",
    place: ""
  });

  const { name, phone, email, place } = user;

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  useEffect(() => {
    loadUser();
  }, []);
  

  const onSubmit = async (e) => {
    if( !(phone.match('[0-9]{10}')) ){
      alert('Please provide valid phone number');
 }
   
    e.preventDefault();
    await axios.put(`http://localhost:8080/user/${id}`, user);
    navigate("/home");
  };

  const loadUser = async () => {
    const result = await axios.get(`http://localhost:8080/user/${id}`);
    setUser(result.data);
  };
  

  return (
    <div className="divt">
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="font3">Edit User</h2><br/>

          <form onSubmit={(e) => onSubmit(e)}>
            <div className="font1">
              <label htmlFor="Name" className="form-label">
                Name
              </label>
              <input 
                type={"text"}
                className="form-control"
                placeholder="Enter your name"
                name="name"
                value={name}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="font1">
              <label htmlFor="PhoneNumber" className="form-label">
              Phone Number
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your phone number"
                name="phone"
                value={phone}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="font1">
              <label htmlFor="Email" className="form-label">
                E-mail
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your e-mail address"
                name="email"
                value={email}
                onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="font1">
              <label htmlFor="Email" className="form-label">
              place
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your tour spot"
                name="place"
                value={place}
                onChange={(e) => onInputChange(e)}
              /><br/>
              </div>
              {/* <Link to="/home"> */}
            <button type="submit" className="btn btn-outline-primary">
              Submit
            </button>
            {/* </Link> */}
            <Link className="btn btn-outline-danger mx-2" to="/home">
              Cancel
            </Link>
          </form>
        </div>
      </div>
    </div>
    </div>
  );
}
