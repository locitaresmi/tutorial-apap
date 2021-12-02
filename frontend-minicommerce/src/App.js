import React from "react";
import { Switch, Route } from 'react-router-dom'
import ItemListPage from "./pages/itemlistpage";
import CartPage from "./pages/cartpage";

function App() {

  return (
    <Switch>
        <Route path="/" component={ItemListPage} exact />
        <Route path="/cart" component={CartPage} exact />
      </Switch>
    );

}

export default App;