import React from "react";
import Button from "../button";
import classes from "./styles.module.css";

const Item = (props) => {
    
    const { id, title, price, description, category, quantity, cartItem, handleEdit, handleDelete, handleAddToCart, handleChangeField} = props;
    
    return (
        <>
            {!cartItem ? (
            <div className={classes.item}>
                <h3>{`ID: ${id}`}</h3>
                <p>{`Nama Barang: ${title}`}</p>
                <p>{`Harga: ${price}`}</p>
                <p>{`Deskripsi: ${description}`}</p>
                <p>{`Kategori: ${category}`}</p>
                <p>{`Stok: ${quantity}`}</p>
                <div>
                    <Button action={handleEdit}>
                        Edit
                    </Button>
                    {/* <Button action={handleDelete}>
                        Delete
                    </Button> */}
                    <form className="mt-4">
                        <input
                            type="number"
                            placeholder="Kuantitas"
                            name="cartQuantity"
                            onChange={handleChangeField}
                        />
                        <Button action={handleAddToCart}>
                            Add to cart
                        </Button>
                    </form>
                </div>
            </div>
            ) : (
                <div className={classes.item}>
                    <h3>{`ID Cart: ${id}`}</h3>
                    <p>{`Nama Barang: ${title}`}</p>
                    <p>{`Harga: ${price}`}</p>
                    <p>{`Jumlah: ${quantity}`}</p>
                    <p>{`Deskripsi: ${description}`}</p>
                    <p>{`Kategori: ${category}`}</p>
                    <p><b>{`Total Harga: ${price*quantity}`}</b></p>
                </div>
            )
            }
        </>
    );

};

export default Item;