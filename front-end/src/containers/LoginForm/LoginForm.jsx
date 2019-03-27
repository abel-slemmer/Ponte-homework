//@ts-check
import React, { useState } from "react";
import axios from "axios";

const LoginForm = props => {
  const [userName, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [loginValid, setLoginValid] = useState(true);

  const inputChangeHandler = event => {
    setLoginValid(true);
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

    let myUrl = "http://localhost:8080/api/login";

    axios
      .post(myUrl, formData)
      .then(response => {
        //  props.history.push("/mainPage")
        console.log(response.data);
        console.log(response.data.headers["Set-Cookie"][0]);
        console.log(response.data.headers["Set-Cookie"][1]);
        document.cookie = response.data.headers.Token[0];
        document.cookie = response.data.headers["Set-Cookie"][1];
      })
      .catch(error => {
        console.log(error);
        setLoginValid(false);
      });
  };

  let content = (
    <>
      <div className="container">
        <div className="d-flex justify-content-center mt-5">
          <div className="col-md-5">
            <h1>Üdvözlünk a Csevegő alkalmazásunkban</h1>
            <h2>Login</h2>
            <form>
              <label
                htmlFor="username"
                className={
                  loginValid ? "control-labe" : "control-labe invalid-label"
                }
              >
                Username:
              </label>
              <input
                className={
                  loginValid ? "form-control" : "form-control is-invalid"
                }
                name="username"
                value={userName}
                onChange={inputChangeHandler}
                placeholder="Username or e-mail"
              />
              <div className="form-group">
                <label
                  htmlFor="password"
                  className={
                    loginValid ? "control-labe" : "control-labe invalid-label"
                  }
                >
                  Password:
                </label>
                <input
                  type="password"
                  className={
                    loginValid ? "form-control" : "form-control is-invalid"
                  }
                  name="Password"
                  onChange={inputChangeHandler}
                  value={password}
                  placeholder="Password"
                />
                <span className=" invalid-feedback mt-3">
                  Wrong Password or Username
                </span>
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
