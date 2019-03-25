import React from 'react';
import {Switch, Route} from 'react-router-dom';
import LoginForm from '../containers/LoginForm/LoginForm';



function Layout() {
    return(<div>

        <div className="container">
            <Switch>
                <Route component={LoginForm}/>
            </Switch>
        </div>
    </div>)
}
export default Layout;