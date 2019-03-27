import React from 'react';
import './Layout.css';
import {Switch, Route} from 'react-router-dom';
import LoginForm from '../containers/LoginForm/LoginForm';
import MainPage from '../containers/MainPage/MainPage';
import SecurityRout from './RedirectRoute';


function Layout() {


    const cookies = document.cookie;
    console.log(cookies)
    return(<div>

        <div className="mx-auto px-auto h-100">
            <Switch>
                <Route path="/" exact component={LoginForm}/>
                <Route path="/mainPage" exact component={MainPage}/>
            </Switch>
        </div>
    </div>)
}
export default Layout;