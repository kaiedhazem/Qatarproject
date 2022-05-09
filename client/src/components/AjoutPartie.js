import React, { useState, useEffect } from "react";
import http from "../http-common";

import authHeader from "../services/auth-header";
import { AiOutlineEdit,AiFillPushpin} from 'react-icons/ai';




const AjoutPartie = () => {


  const initialPartieState = {
   
    ref: "",
    tour: "",
    eq_local:"",
    eq_visiteur:"",
    date_h:""
  };
  

  const [dataApiStade , setDataApiStade] = useState([])
  const [stade , setStade] = useState()
  const [reponseData , setResponseData] = useState()
  const [isStadeSubmit , setIsStadeSubmit] = useState(false) 
  const [partie, setPartie] = useState(initialPartieState);
  const [submitted, setSubmitted] = useState(false);


  const getDataStade = () => {
        
    http.get('/parties/allstades', authHeader())

        .then((response)=>{
             setDataApiStade(response.data)
        });
    
  };

  useEffect(() => {

      getDataStade();
  
  }, []);

  const handleChangeStade = event => {


    let { name, value } = event.target;

    setStade(value)

  };


  

  const handleInputChange = event => {

    let { name, value } = event.target;
 
    setPartie({ ...partie, [name]: value });

  };


  const submitParties = (finalData) =>{
    http.post('/parties/addpartie', finalData , authHeader()).then((response)=>{
     
      setResponseData(response.data.id)
      setPartie(initialPartieState)
  })
  }

  
  const submitStade = () =>{
    
    http.post(`/parties/addpartietostade/${reponseData}/${stade}`, '' , authHeader()).then((response)=>{
     
      setIsStadeSubmit(true)

      setTimeout(() => {

      setSubmitted(false)
      setIsStadeSubmit(false)
        
      }, 5000);
     })
  }

  const savePartie = () => {

   let value = partie.date_h.replace("T" , " ") + ":00"
   const finalData = {...partie , ['date_h']: value }

 
   submitParties(finalData)
   setSubmitted(true);
   

  
  };

  /*
  const newPartie = () => {
    setPartie(initialPartieState);
    setSubmitted(false);
  };
  */
 

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
                <h5>Partie ajouté !</h5>
            </div>

            {isStadeSubmit && 
              <div className="alert alert-success" role="alert">
                   <h5>Partie affectée au stade !</h5>
              </div>

            }
            <h4><AiFillPushpin /> Affectation partie au stade</h4><br></br>

          <div className="form-group row">
          
          

            <label  className="col-sm-4 col-form-label" style={{fontWeight:"bold"}}>Stade</label>
            <div className="col-sm-8">

            <select className="form-control" name="stade" onChange={handleChangeStade} >
                
            <option defaultValue hidden>{'choisir stade'} </option>
            {       dataApiStade.map((option , key) => (

                        <option key={key} value={option.id} name="stade">{option.nom}</option>
                    ))
            }
            </select>

            

          


            </div>
           
          </div>
         <button onClick={submitStade} className="btn btn-primary btn-lg btn-block">
            Affecter
          </button>

            </div>

           
          
          
        </div>
      ) : (

        
        <div>
          <div className="form-group">
            <label htmlFor="title" style={{fontWeight:"bold"}}>Référence</label>
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
            <label htmlFor="title" style={{fontWeight:"bold"}}>Tour</label>
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
            <label htmlFor="title" style={{fontWeight:"bold"}}>Equipe locale</label>
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
          <label htmlFor="title" style={{fontWeight:"bold"}}>Equipe visiteur</label>
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
    
         <label htmlFor="title" style={{fontWeight:"bold"}}>Date et Heures </label>
         <input
           type="datetime-local"
           className="form-control"
           id="date_h"
           required
           value={partie.date}
           onChange={handleInputChange}
           name="date_h"
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
