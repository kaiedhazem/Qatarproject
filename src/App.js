import React, { useState, useEffect } from "react";
import { Routes, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import { AiOutlineUnlock,AiOutlineUser,
  AiOutlineHome,AiOutlineTrophy,
  AiOutlineDribbble,AiOutlineCreditCard,
  AiOutlineEuroCircle,AiOutlineBars } from 'react-icons/ai';


import AuthService from "./services/auth.service";

import Login from "./components/Login";
import Register from "./components/Register";
import Home from "./components/Home";
import Profile from "./components/Profile";
import BoardUser from "./components/BoardUser";
import BoardAdmin from "./components/BoardAdmin";
import AjoutPartie from "./components/AjoutPartie";
import Billets from "./components/Billets";

import EventBus from "./common/EventBus";



const App = () => {
  const [showModeratorBoard, setShowModeratorBoard] = useState(false);
  const [showAdminBoard, setShowAdminBoard] = useState(false);
  const [currentUser, setCurrentUser] = useState(undefined);

  useEffect(() => {
    const user = AuthService.getCurrentUser();

    if (user) {
      setCurrentUser(user);
      setShowModeratorBoard(user.roles.includes("ROLE_USER"));
      setShowAdminBoard(user.roles.includes("ROLE_ADMIN"));
    }

    EventBus.on("logout", () => {
      logOut();
    });

    return () => {
      EventBus.remove("logout");
    };
  }, []);

  const logOut = () => {
    AuthService.logout();
    setShowModeratorBoard(false);
    setShowAdminBoard(false);
    setCurrentUser(undefined);
  };

  return (
    <div>
      <nav className="navbar navbar-expand-lg navbar-light " style={{backgroundColor: "#e3f2fd"}}>
        <Link to={"/"} className="navbar-brand" style={{fontWeight: "bold"}}>
          <AiOutlineTrophy />WorldCup
        </Link>
        <div className="navbar-nav mr-auto">
          <li className="nav-item nav-link active">
            <Link to={"/home"} className="nav-link">
              <AiOutlineHome /> Home
            </Link>
          </li>

          {showModeratorBoard && (
            <li className="nav-item nav-link active">
              <Link to={"/billets"} className="nav-link">
                <AiOutlineCreditCard /> Réservation Billet
              </Link>
            </li>
          )}

          {showModeratorBoard && (
            <li className="nav-item nav-link active">
              <Link to={"/mod"} className="nav-link">
                <AiOutlineEuroCircle /> Paiement
              </Link>
            </li>
          )}

          {showModeratorBoard && (
            <li className="nav-item nav-link active">
              <Link to={"/mod"} className="nav-link">
                <AiOutlineBars /> Billets
              </Link>
            </li>
          )}

          

          {showAdminBoard && (
            <li className="nav-item nav-link active">
              <Link to={"/ajoutPartie"} className="nav-link">
              <AiOutlineDribbble /> Gestion des parties
              </Link>
            </li>
          )}

        
        </div>

        {currentUser ? (
          <div className="navbar-nav ml-auto">
            <li className="nav-item nav-link active">
              <Link to={"/profile"} className="nav-link">
              <AiOutlineUser /> {currentUser.username}
              </Link>
            </li>
            <li className="av-item nav-link active">

           
              <a href="/login" className="nav-item nav-link active" onClick={logOut}>
                <AiOutlineUnlock /> Logout
              </a>
            </li>
          </div>
        ) : (
          <div className="navbar-nav ml-auto">
            <li className="nav-item nav-link active">
              <Link to={"/login"} className="nav-link">
                Login
              </Link>
            </li>

            <li className="nav-item nav-link active">
              <Link to={"/register"} className="nav-link">
                Sign Up
              </Link>
            </li>
          </div>
        )}
      </nav>

      <div className="container mt-3">
        <Routes>
          <Route path="/" element={<Home/>} />
          <Route path="/home" element={<Home/>} />
          <Route path="/login" element={<Login/>} />
          <Route path="/register" element={<Register/>} />
          <Route path="/profile" element={<Profile/>} />
          <Route path="/user" element={<BoardUser/>} />

          <Route path="/admin" element={<BoardAdmin/>} />
          <Route path="/ajoutPartie" element={<AjoutPartie/>} />


          <Route path="/billets" element={<Billets/>} />

        </Routes>
      </div>

    </div>
  );
};

export default App;
