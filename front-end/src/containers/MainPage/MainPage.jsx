//@ts-check
import React, { useState, useEffect } from "react";
import axios from "axios";

const MainPage = props => {
  const [userName, setUserName] = useState("");


useEffect(() => {
  let myUrl = "http://localhost:8080/api/user/me";
  axios
  .get(myUrl)
  .then(response=>{
    setUserName(response.data.username)
    console.log(response.data);
    
  })
  .catch(error=>{
    console.log(error);
    props.history.push("/")
  });

},[])


  let content = (
    <>
      <div className="mx-auto px-auto h-100">
        <div className="row m-75">
          <div className="col-md-2 sidebar">
            <div className="d-flex justify-content-center">
              <h1>Üdvözlünk {userName}! </h1>
            </div>
            <div className="d-flex justify-content-center">
            <div className="d-flex flex-column bd-highlight mb-3">
            <h2>Csatornák</h2>
              <div className="p-2 bd-highlight">Flex item 1</div>
              <div className="p-2 bd-highlight">Flex item 2</div>
              <div className="p-2 bd-highlight">Flex item 3</div>
            </div>
            </div>
          </div>
          <div className="col-md-10">
          <div className="h-200">
            asdasd

          </div>
          </div>
        </div>
        <div className="row fixed-bottom">
        <div className="col-md-10 ml-auto align-self-end">
        <div className="d-flex justify-content-end ">
        <button className="btn btn-info mr-3 h-50">Send</button>
        <textarea placeholder="Write your message here!"  className="mr-5 mb-5" name="textare" id="input" rows={2} cols={120} ></textarea>
        </div>
          </div>
        </div>
      </div>
    </>
  );

  return content;
};

export default MainPage;
