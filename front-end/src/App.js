import React from 'react';
import './App.css';
import {BrowserRouter} from "react-router-dom";
import Layout from "./common/Layout";

const App =()=> (
    <BrowserRouter>
        <div className="App">
            <Layout/>
        </div>
    </BrowserRouter>
    );



export default App;
