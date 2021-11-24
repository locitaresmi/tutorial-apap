import List from 'List'
import listItems from "../../items.json"
import React, { Component } from 'react'
import "./index.css"
import { TrainRounded } from '@material-ui/icons';
import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import { Fab } from "@material-ui/core";
import ViewStreamIcon from '@mui/icons-material/ViewStream';


export class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            shopItems: listItems,
            cartItems: [],
            cartHidden: true,
            balance: 120
        };
    }

    //Latihan 2
    updateBalance = (itemPrice, inCart) => {
        if (inCart) {
            this.setState({ balance: this.state.balance-itemPrice})
        } else {
            this.setState({ balance: this.state.balance+itemPrice})
        }
    }

    handleAddItemToCart = (item) => {
        const newItems = [...this.state.cartItems];
        const newItem = { ...item };
        const targetInd = newItems.findIndex((it) => it.id === newItem.id);

        if (targetInd < 0) {
            if (this.state.balance < newItem.price) {
                //Latihan 3
                alert("Balance not sufficient!");
                return;
            }
            newItem.inCart = true;
            newItems.push(newItem);
            this.updateShopItem(newItem, true)
        }
        this.setState({ cartItems: newItems });
    }

    //Latihan 1
    handleRemoveItemFromCart = (item) => {
        const newItems = [...this.state.cartItems];
        const removedItem = { ...item };
        const targetInd = newItems.findIndex((it) => it.id === removedItem.id);
        if (targetInd >= 0) {
            removedItem.inCart = false;
            newItems.splice(targetInd, 1);
            this.updateShopItem(removedItem, false)
        }
        this.setState({ cartItems: newItems });
    }

    updateShopItem = (item, inCart) => {
        const tempShopItems = this.state.shopItems;
        const targetInd = tempShopItems.findIndex((it) => it.id === item.id);
        tempShopItems[targetInd].inCart = inCart;
        this.updateBalance(item.price, tempShopItems[targetInd].inCart);
        this.setState({ shopItems: tempShopItems });
    }

    handleToggle = () => {
        const cartHidden = this.state.cartHidden;
        this.setState({ cartHidden: !cartHidden });
    }

    render() {
        return (
            <div className="container-fluid">
                <h1 className="text-center mt-3 mb-0">Mini Commerce</h1>  
                <div style={{ position: "fixed", top: 25, right: 25}}>
                    <Fab variant="extended" onClick={this.handleToggle}>
                        {this.state.cartHidden ? <Badge color="secondary" badgeContent={this.state.cartItems.length}>
                            <ShoppingCartIcon />
                        </Badge>
                        : <ViewStreamIcon />}
                    </Fab>
                </div>        
                <p className="text-center text-secondary text-sm font-italic">(this is a <strong>class-based</strong> application)</p>      
                <p className="text-center text-primary">Your Balance: <b>{this.state.balance}</b></p>
                <div className="container pt-3">
                    <div className="row mt-3">
                        {!this.state.cartHidden ? (
                            <div className="col-sm">
                                <List
                                    title="My Cart"
                                    items={this.state.cartItems}
                                    onItemClick={this.handleRemoveItemFromCart}
                                ></List>
                            </div>
                        ) : 
                            <div className="col-sm">
                                <List 
                                    title="List Items" 
                                    items={this.state.shopItems}
                                    onItemClick={this.handleAddItemToCart}
                                    isShopList={TrainRounded}
                                ></List>
                            </div>
                        }
                        
                    </div>
                </div>
            </div>
        )
    }
}

export default Home
