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

     
      
          
        </div>
      </div>
     
     
      
    </div>
  );
};

export default Profile;
