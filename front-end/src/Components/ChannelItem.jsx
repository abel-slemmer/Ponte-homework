import React from 'react';

const ChannelListItem = props => {



    return (
      <div>
          <button onClick={props.getPosts} className="btn btn-info m-2">{props.name}</button>
      </div>
    )
}

export default ChannelListItem;