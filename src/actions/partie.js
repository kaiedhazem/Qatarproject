import {
    CREATE_PARTIE,
 
  } from "./types";
  
  import PartieDataService from "../services/PartieService";
  
  export const createPartie = (ref,tour,eq_local,eq_visiteur) => async (dispatch) => {
    try {
      const res = await PartieDataService .create({ ref,tour,eq_local,eq_visiteur });
  
      dispatch({
        type: CREATE_PARTIE,
        payload: res.data,
      });
  
      return Promise.resolve(res.data);
    } catch (err) {
      return Promise.reject(err);
    }
  };
  
  
  
  