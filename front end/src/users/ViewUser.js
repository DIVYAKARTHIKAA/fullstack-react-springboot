import axios from "axios";
import React, { useEffect,useState } from "react";
import { Link, useParams } from "react-router-dom";
import Navbar from "../Navbar/NavBar";
export default function ViewUser() {
  const [user, setUser] = useState({
    name: "",
    phone: "",
    email: "",
    place:""
  });

  const { id } = useParams();

  useEffect(() => {
    loadUser();
  }, []);

  const loadUser = async () => {
    const result = await axios.get(`http://localhost:8080/user/${id}`);
    setUser(result.data);
  };

  return (
    <>
    <div>
    <Navbar/>
    </div>
    <div className="divt">
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">User Details</h2>

          <div className="card">
            <div className="card-header">
              <div className="text1">
               <b className="text1">Details of user id :
              {user.id}</b>
              <ul className="list-group list-group-flush"><br/>
                <li className="list-group-item"><p className="text1">
                  <b className="text1">Name:</b>
                  {user.name}</p>
                </li>
                <li className="list-group-item"><p className="text1">
                  <b className="text1">Phone Number:</b>
                  {user.phone}</p>
                </li>
                <li className="list-group-item"><p className="text1">
                  <b className="text1">Email:</b>
                  {user.email}</p>
                </li>
                <li className="list-group-item"><p className="text1">
                  <b className="text1">Place:</b>
                  {user.place}</p>
                </li>
              </ul>
            </div>
          </div>
          <Link className="btn btn-primary my-2" to={"/home"}>
            Back to Home
          </Link>
        </div>
      </div>
    </div>
    </div>
    </div>
    </>
  );
}
