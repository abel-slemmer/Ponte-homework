import React, { useState, useEffect } from 'react';
import axios from "axios";


const PostItem = props => {
    const[postDetails,setPostDetails] = useState();


    useEffect(() => {
        axios
        .get("/api/user/post/"+props.id)
        .then(response => {
          console.log(response.data);
          setPostDetails(response.data)
        })
        .catch(error => {
          console.log(error);
        });
    },[])


let content=<div></div>

if(postDetails){
   content = (
      <div className="p-2 bd-highlight">
          <p>{postDetails.message}</p>
      </div>
    )}
    return content;
}

export default PostItem;