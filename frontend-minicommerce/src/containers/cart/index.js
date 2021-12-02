import React, { Component } from "react";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/button";
import Item from "../../components/item";
import classes from "./styles.module.css";

class Cart extends Component {    
    constructor(props) {
        super(props);
        this.state = {
            items: []
        };
        this.handleCheckout = this.handleCheckout.bind(this);
    }

    componentDidMount() {
        console.log("componentDidMount()");
        this.loadData();
    }

    async loadData() {
        try {
            const { data } = await APIConfig.get("/cart");
            this.setState({ items: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }
    
    async handleCheckout() {
        try {
            await APIConfig.get("/cart/checkout");
            alert("Checkout berhasil!");
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    render() {
        console.log("render()");
        return (
            <div className={classes.itemList}>
                <div className="row">
                    <div className="col-12 d-flex justify-content-between">
                        <a href="/">
                            <Button>
                                BACK
                            </Button>
                        </a>
                        {this.state.items.length !== 0 ? 
                            (
                                <Button action={this.handleCheckout}>
                                    CHECKOUT
                                </Button>
                            ) : null
                        }
                    </div>
                </div>
                <h1 className={classes.title}>
                    Cart Items
                </h1>
                <div>
                    {this.state.items.map((item) => (
                    <Item
                        key={item.item.id}
                        id={item.item.id}
                        title={item.item.title}
                        price={item.item.price}
                        description={item.item.description}
                        category={item.item.category}
                        quantity={item.quantity}
                        cartItem={true}
                    />
                    ))}
                </div>
            </div>
        );
    }
}

export default Cart;
