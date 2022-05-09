import http from "../http-common";

const getAll = () => {
  return http.get("/parties/allparties");
};



const create = data => {
  return http.post("/parties/addpartie", data);
};


const TutorialService = {
  getAll,
  create
  
};

export default TutorialService;
