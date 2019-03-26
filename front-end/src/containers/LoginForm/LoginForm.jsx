//@ts-check
import React, { useState } from "react";
import axios from "axios";


const LoginForm = props => {
  const [userName, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const inputChangeHandler = event => {
    if (event.target.name === "username") {
      setUsername(event.target.value);
    } else {
      setPassword(event.target.value);
    }
  };

  const submitHandler = event => {
    event.preventDefault();
    const formData = {
      login_id: userName,
      password: password
    };
    
    let myUrl = "http://localhost:8080/api/user/login";

    axios.post(myUrl,formData)
        .then(response=>{
            console.log(formData);
            console.log(response);
        })
        .catch(error=>{
            console.warn("error");
            console.warn(formData);
            
        })
    };

  let content = (
    <>
      <div className="container">
        <div className="d-flex justify-content-center mt-5">
          <div className="col-md-5">
            <h1>Üdvözlünk a Csevegő alkalmazásunkban</h1>
            <h2>Login</h2>
            <form>
              <label htmlFor="username" className="control-labe input-label">
                Username:
              </label>
              <input
                className="form-control"
                name="username"
                value={userName}
                onChange={inputChangeHandler}
                placeholder="Username or e-mail"
              />
              <div className="form-group">
                <label htmlFor="password" className="control-labe input-label">
                  Password:
                </label>
                <input
                  type="password"
                  className="form-control "
                  name="Password"
                  onChange={inputChangeHandler}
                  value={password}
                  placeholder="Password"
                />
                <button
                  type="submit"
                  className="btn btn-primary mt-3 p-2"
                  onClick={submitHandler}
                >
                  Login
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </>
  );

  return content;
};

export default LoginForm;
