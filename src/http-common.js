import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:8091/api",
  headers: {
    "Content-type": "application/json",
  
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS"
   
  }
});
