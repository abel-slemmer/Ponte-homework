import React from 'react';

const ChannelListItem = props => {

let content=<div></div>

if(props.name!==""){
   content = (
      <div>
          <button onClick={props.getPosts} className="btn btn-info m-2">{props.name}</button>
      </div>
    )}
    return content;
}

export default ChannelListItem;