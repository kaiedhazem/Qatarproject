import React from "react";
import AuthService from "../services/auth.service";

const Profile = () => {
  const currentUser = AuthService.getCurrentUser();

  return (
    <div className="container">
      <header className="jumbotron">
        <h3>
           Profil
        </h3>
      </header>

      <div className="card">
        <div className="card-body">

      <h5>
        <strong>Email :</strong> {currentUser.email}
      </h5>
      <h5>
      <strong>Authorities :</strong>
      </h5>
      <ul>
        {currentUser.roles &&
          currentUser.roles.map((role, index) => <li key={index}>{role}</li>)}
      </ul>
          
        </div>
      </div>
     
     
      
    </div>
  );
};

export default Profile;
