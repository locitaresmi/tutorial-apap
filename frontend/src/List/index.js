import Item from 'Item'
import React from 'react'

function List({ title, items, onItemClick, isShopList }) {
    return (
        <>
            <h3 style={StyleSheet.heading}>{title}</h3>
            <div className="list-group">
                {items.length === 0 ? (
                    <div className="text-center">
                        <h1>Belum ada item yang dipilih</h1>
                        <h2>Klik salah satu item di List Item</h2>
                    </div>
                ) : null}
                {items.map((item) => (
                    <Item key={item.id} item={item} onChange={onItemClick} isShopList={isShopList}/>
                ))}
            </div>
        </>
    )
}

export default List
