import React from "react";




const Billets = () => {



    return (
        
    <div className="card" style={{backgroundColor: "#F5EEF8"}}>
        <h5 className="card-header" style={{backgroundColor: "white"}}>Réserver Billet</h5>
        <div className="card-body">
            



            <form>

            <div className="form-group row">
                <label  className="col-sm-2 col-form-label">Partie</label>
                <div className="col-sm-10">
                <input type="number" className="form-control" id="" />
                </div>
            </div>

            <div className="form-group row">
                <label  className="col-sm-2 col-form-label">Type chaise</label>
                <div className="col-sm-10">
                <input type="number" className="form-control" id="" />
                </div>
            </div>
            
            
            <div className="form-group row">
                <label  className="col-sm-2 col-form-label">Repas</label>

                <div className="col-sm-10">

               
                     

                

               
                </div>
            </div>

            <div className="form-group row">
                <label  className="col-sm-2 col-form-label">Nombre de Place</label>
                <div className="col-sm-10">
                <input type="number" className="form-control" id="" />
                </div>
            </div>

            </form>
           

        </div>
    </div>
    )




    
    
}


export default Billets;