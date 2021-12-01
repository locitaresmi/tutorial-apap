import React, { Component } from "react";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/button";
import Item from "../../components/item";
import Modal from "../../components/modal";
import Search from "../../components/search";
import classes from "./styles.module.css";
import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import { Fab } from "@material-ui/core";

class ItemList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],
            cartItems: [],
            isLoading: false,
            isCreate: false,
            isEdit: false,
            id: "",
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0,
            cartQuantity: 0
        };
        this.handleClickLoading = this.handleClickLoading.bind(this);
        this.handleAddItem = this.handleAddItem.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleEditItem = this.handleEditItem.bind(this);
        this.handleSubmitItem = this.handleSubmitItem.bind(this);
        this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
        this.handleSearch = this.handleSearch.bind(this);
        this.handleAddToCart = this.handleAddToCart.bind(this);
    }

    componentDidMount() {
        console.log("componentDidMount()");
        this.loadData();
    }

    async loadData() {
        try {
            const { data } = await APIConfig.get("/item");
            this.setState({ items: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async handleSubmitItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.post("/item", data);
            this.setState({
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleSubmitEditItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.put(`/item/${this.state.id}`, data);
            this.setState({
                id: "",
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleSearch(event) {
        event.preventDefault();
        try {
            const { data } = await APIConfig.get(`/item?title=${this.state.title}`);
            this.setState({ items: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async handleAddToCart(event, item) {
        event.preventDefault();
        try {
            if (this.state.cartQuantity > item.quantity) {
                alert("Stok tidak mencukupi!")
                return
            }
            const data = {
                idItem: item.id,
                quantity: this.state.cartQuantity
            };
            await APIConfig.post("/cart", data);
            this.setState({ cartQuantity: 0 })
            alert("Berhasil menambahkan item ke cart!");
            this.getCartItems();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    shouldComponentUpdate(nextProps, nextState) {
        console.log("shouldComponentUpdate()");
        return true;
    }

    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({ isLoading: !currentLoading });
        console.log(this.state.isLoading);
    }

    handleAddItem() {
        this.setState({ isCreate: true });
    }

    handleCancel(event) {
        event.preventDefault();
        this.setState({
            id: "",
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0
        })
        this.setState({ isCreate: false, isEdit: false });
    }

    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }

    handleEditItem(item) {
        this.setState({
            isEdit: true,
            id: item.id,
            title: item.title,
            price: item.price,
            description: item.description,
            category: item.category,
            quantity: item.quantity
        })
    }        

    async getCartItems() {
        try {
            const { data } = await APIConfig.get("/cart");
            this.setState({ cartItems: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    render() {
        console.log("render()");
        return (
            <div className={classes.itemList}>
                <h1 className={classes.title}>
                    All Items
                </h1>
                <div style={{ position: "fixed", top: 25, right: 25 }}>
                    <a href="/cart">
                        <Fab variant="extended">
                            <Badge color="secondary" badgeContent={this.state.cartItems.length}>
                                <ShoppingCartIcon />
                            </Badge>
                        </Fab>
                    </a>
                </div>
                <div className="row mt-5">
                    <div className="col-12 d-flex justify-content-center">
                    <Search>
                        <input
                        type="text"
                        id="form1"
                        className="form-control"
                        name="title"
                        value={this.state.title} 
                        onChange={this.handleChangeField}
                        />
                        <Button action={this.handleSearch}>
                            Search
                        </Button>
                    </Search>
                    </div>
                </div>
                <div className="row mb-5">
                    <div className="col-12 d-flex justify-content-center">
                        <Button action={this.handleAddItem}>
                            Add Item
                        </Button>
                    </div>
                </div>
                <div>
                    {this.state.items.map((item) => (
                    <Item
                        key={item.id}
                        id={item.id}
                        title={item.title}
                        price={item.price}
                        description={item.description}
                        category={item.category}
                        quantity={item.quantity}
                        cartItem={false}
                        handleEdit={() => (this.handleEditItem(item))}
                        handleAddToCart={(e) => (this.handleAddToCart(e, item))}
                        handleChangeField={this.handleChangeField}
                    />
                    ))}
                </div>
                <Modal
                    show={this.state.isCreate || this.state.isEdit}
                    handleCloseModal={this.handleCancel}
                    modalTitle={this.state.isCreate ? "Add Item" : `Edit Item ID ${this.state.id}`}
                >
                    <form>
                        <input
                            className={classes.textField}
                            type="text"
                            placeholder="Nama Item"
                            name="title"
                            value={this.state.title}
                            onChange={this.handleChangeField}
                        />
                        <input
                            className={classes.textField}
                            type="number"
                            placeholder="Harga"
                            name="price"
                            value={this.state.price}
                            onChange={this.handleChangeField}
                        />
                        <input
                            className={classes.textField}
                            placeholder="Deskripsi"
                            name="description"
                            rows="4"
                            value={this.state.description}
                            onChange={this.handleChangeField}
                        />
                        <input
                            className={classes.textField}
                            type="text"
                            placeholder="Kategori"
                            name="category"
                            value={this.state.category}
                            onChange={this.handleChangeField}
                        />
                        <input
                            className={classes.textField}
                            type="number"
                            placeholder="Qty"
                            name="quantity"
                            value={this.state.quantity}
                            onChange={this.handleChangeField}
                        />
                        <Button action={this.state.isCreate ? this.handleSubmitItem : this.handleSubmitEditItem}>
                            Save
                        </Button>
                        <Button action={this.handleCancel}>
                            Cancel
                        </Button>
                    </form>
                </Modal>
            </div>
        );
    }
}

export default ItemList;

//36, 