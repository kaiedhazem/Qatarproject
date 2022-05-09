import React, { useState } from "react";
import http from "../http-common";

import authHeader from "../services/auth-header";
import { AiOutlineEdit} from 'react-icons/ai';




const AjoutPartie = () => {


  const initialPartieState = {
   
    ref: "",
    tour: "",
    eq_local:"",
    eq_visiteur:"",
    date:""
    
  };



  const [partie, setPartie] = useState(initialPartieState);
  const [submitted, setSubmitted] = useState(false);


  const handleInputChange = event => {

    const { name, value } = event.target;

    console.log(partie);

    setPartie({ ...partie, [name]: value });





  };

  const savePartie = () => {

    http.post('/parties/addpartie', partie , authHeader()).then((response)=>{
        console.log("repsonse data" , response );
        setPartie(initialPartieState)
        setSubmitted(true);
    })
  };

  const newPartie = () => {
    setPartie(initialPartieState);
    setSubmitted(false);
  };

  return (

   
    <div className="submit-form">

      <div className="container" >
        <header className="jumbotron" style={{backgroundColor: "#ffebd8"}}>
        <h3><AiOutlineEdit /> Ajouter une partie</h3>
        </header>
      </div>
      {submitted ? (
        <div>
             
        
            <div className="card">
            <div className="alert alert-success" role="alert">
                <h5>Partie ajouté avec succès !</h5>
            </div>
            </div>
          
          
        </div>
      ) : (

        
        <div>
          <div className="form-group">
            <label htmlFor="title">Référence</label>
            <input
              type="text"
              className="form-control"
              id="ref"
              required
              value={partie.ref}
              onChange={handleInputChange}
              name="ref"
            />
          </div>

          <div className="form-group">
            <label htmlFor="title">Tour</label>
            <input
              type="text"
              className="form-control"
              id="tour"
              required
              value={partie.tour}
              onChange={handleInputChange}
              name="tour"
            />
          </div>
          <div className="form-group">
            <label htmlFor="title">Equipe locale</label>
            <input
              type="text"
              className="form-control"
              id="eq_local"
              required
              value={partie.eq_local}
              onChange={handleInputChange}
              name="eq_local"
            />
          </div>

          <div className="form-group">
          <label htmlFor="title">Equipe visiteur</label>
          <input
            type="text"
            className="form-control"
            id="eq_visiteur"
            required
            value={partie.eq_visiteur}
            onChange={handleInputChange}
            name="eq_visiteur"
          />
         </div>

         <div className="form-group">
    
         <label htmlFor="title">Date & Heures</label>
         <input
           type="datetime-local"
           className="form-control"
           id="date"
           required
           value={partie.date}
           onChange={handleInputChange}
           name="date"
         />
        </div>

        

          

          <button onClick={savePartie} className="btn btn-primary btn-lg btn-block">
            Ajouter
          </button>
          <br></br>
        
        </div>
      )}
    </div>
  
  );
};

export default AjoutPartie;
