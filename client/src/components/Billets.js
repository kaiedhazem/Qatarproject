import React, { useEffect, useState } from "react";
import authHeader from "../services/auth-header";
import http from "../http-common";
import Stripe from "react-stripe-checkout";
import axios from "axios";

const Billets = () => {
  const [dataApi, setDataApi] = useState([]);
  const [dataApiPartie, setDataApiPartie] = useState([]);
  const user = JSON.parse(localStorage.getItem("user"));

  const initialBilletState = {
    partie: { id: "" },
    type_chaise: "",
    repas_inclus: 0,
    nb_place: "",
    spectateur: { id: user.id },
    montant: 0,
  };

  const [billet, setBillet] = useState(initialBilletState);
  const [submitted, setSubmitted] = useState(false);
  const [errorMsg, setErrorMsg] = useState(false);

  let radioValue = {
    zero: 0,
    one: 1,
  };

  const validCapacity = {
    virage: "virage",
    pelouse: "pelouse",
    "enceinte superieure": "enceinte_sup",
    "enceinte inferieur": "enceinte_inf",
  };

  const [capacity, setCapacity] = useState({
    virage: 0,
    pelouse: 0,
    enceinte_sup: 0,
    enceinte_inf: 0,
  });

  const [isDisable, setIsDisable] = useState(true);

  const isCapacityPossible = (valueRequired, capacityPossible) => {
    //console.log("comparaison", valueRequired, capacityPossible);

    return capacityPossible >= valueRequired;
  };

  //console.log(user.accessToken);

  async function handleToken(token) {
    await axios
      .post("http://localhost:8091/api/payment/charge", "", {
        headers: {
          Authorization: `Bearer ${user.accessToken}`,
          token: token.id,
          amount: billet.montant,
        },
      })
      .then(() => {
        alert("Paiement effectué avec succès !");
      })
      .catch((error) => {
        alert(error);
      });

    window.location.reload();
  }

  const handleChange = (event) => {
    let { name, value } = event.target;

    if (name === "partie") {
      setIsDisable(true);
      setErrorMsg(false);

      value = { id: value };

      http
        .get(`/parties/capacite/${value.id}`, authHeader())

        .then((response) => {
          console.log("response capacityyyy", response);
          setCapacity({
            virage: response.data.virage,
            pelouse: response.data.pelouse,
            enceinte_sup: response.data.enceinte_sup,
            enceinte_inf: response.data.enceinte_inf,
          });
        });
    }
    if (name === "repas_inclus") {
      // convert to integer =+
      value = +value;
    }

    if (name === "nb_place") {
      //console.log("value", value);
      //console.log("capacity", capacity);
      //console.log("billet", billet);
      //console.log("keys", Object.keys(billet.type_chaise));

      if (isCapacityPossible(value, capacity[validCapacity[billet.type_chaise]])) {
        setErrorMsg(false);

        setIsDisable(false);
      } else {
        setErrorMsg(true);
        setIsDisable(true);
      }
    }

    if (name === "type_chaise") {
      setIsDisable(true);
    }

    setBillet({ ...billet, [name]: value });
  };

  const saveBillet = (e) => {
    e.preventDefault();

    http.post("/billets/add", billet, authHeader()).then((response) => {
      //console.log("billet after reservation", response);
      setBillet(initialBilletState);
      setBillet({ ...billet, montant: response.data });
      setSubmitted(true);
    });
  };

  const getData = () => {
    http.get("/parties/alltypes", authHeader()).then((response) => {
      //console.log("response", response);
      setDataApi(response.data);
    });
  };

  const getDataPartie = () => {
    http.get("/parties/allparties", authHeader()).then((response) => {
      setDataApiPartie(response.data);
    });
  };

  useEffect(() => {
    getData();
    //console.log("id user" + user.id);
  }, []);

  useEffect(() => {
    getDataPartie();
  }, []);

  return (
    <div className="card" style={{ backgroundColor: "#F8F9F9" }}>
      {console.log("billet", billet)}
      {console.log("capacity", capacity)}

      <h5 className="card-header" style={{ backgroundColor: "white" }}>
        Réserver Billet
      </h5>
      <div className="card-body">
        {submitted ? (
          <div>
            <br></br>
            <br></br>

            <div className="alert alert-success" role="alert">
              <h6>Réservation effectué avec succès !</h6>
            </div>
            <div style={{ textAlign: "center" }}>
              <Stripe
                stripeKey="pk_test_51KoDUhFslqXZA62tjLT35NVePOu1LjFbX4s6KHta91EK23Lwt8CjkTQLwxVEz7z4qkdIYbuacv28eQxHdLdO1Ppt00KfPs5wVv"
                token={handleToken}
              />
            </div>
          </div>
        ) : (
          <form>
            <div className="form-group row">
              <label className="col-sm-4 col-form-label">Partie</label>
              <div className="col-sm-8">
                <select
                  className="form-control"
                  name="partie"
                  onChange={handleChange}
                >
                  <option defaultValue hidden>
                    {"choisir partie"}{" "}
                  </option>
                  {dataApiPartie.map((option, key) => (
                    <option key={key} value={option.id}>
                      Tour : {option.tour} : {option.eq_local} vs{" "}
                      {option.eq_visiteur}
                    </option>
                  ))}
                </select>
              </div>
            </div>

            <div className="form-group row">
              <label className="col-sm-4 col-form-label">Type chaise</label>
              <div className="col-sm-8">
                <select
                  className="form-control"
                  id="type_chaise"
                  name="type_chaise"
                  onChange={handleChange}
                >
                  <option defaultValue hidden>
                    {"choisir type chaise"}{" "}
                  </option>
                  {dataApi.map((option, key) => (
                    <option
                      key={key}
                      id="type_chaise"
                      name="type_chaise"
                      value={option.nom_type}
                    >
                      {option.nom_type}
                    </option>
                  ))}
                </select>
              </div>
            </div>

            <div className="form-group row">
              <label className="col-sm-4 col-form-label">Repas Inclus</label>

              <div className="col-sm-8">
                <div className="form-check form-check-inline">
                  <input
                    className="form-check-input"
                    type="radio"
                    name="repas_inclus"
                    id="repas_inclus"
                    value={radioValue.one}
                    onChange={handleChange}
                  />
                  <label className="form-control">Oui</label>
                </div>
                <div className="form-check form-check-inline">
                  <input
                    className="form-check-input"
                    type="radio"
                    name="repas_inclus"
                    id="repas_inclus"
                    value={radioValue.zero}
                    onChange={handleChange}
                  />
                  <label className="form-control">Non</label>
                </div>
              </div>
            </div>

            <div className="form-group row">
              <label className="col-sm-4 col-form-label">
                Nombre de Places
              </label>
              <div className="col-sm-8">
                <input
                  type="number"
                  className="form-control"
                  id="nb_place"
                  name="nb_place"
                  onChange={handleChange}
                />
              </div>
            </div>

            {errorMsg && (
              <div className="alert alert-danger" role="alert">
                Nombre de places ne doivent pas dépasser <strong> {capacity[validCapacity[billet.type_chaise]]}</strong>
              </div>
            )}

            <button
              onClick={saveBillet}
              className="btn btn-secondary btn-lg btn-block"
              disabled={isDisable}
            >
              {" "}
              Réserver
            </button>
          </form>
        )}
      </div>
    </div>
  );
};

export default Billets;
