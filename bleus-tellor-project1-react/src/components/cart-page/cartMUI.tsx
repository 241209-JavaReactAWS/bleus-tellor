import { useEffect, useState } from "react"
import axios from "axios"
import { Button, Fab } from "@mui/material"
import { Item } from "../../Interfaces/Item"
import { Customer } from "../../Interfaces/Customer"
import CartItemMUI from "./cartItemMUI"


function CartMUI() {

  const [itemsInCart, setItems] = useState<Item[]>([])

  useEffect(() => {

    axios.get<Customer>('http://localhost:8080/customers/myAccount', { withCredentials: true })
      .then((res) => {
        setItems(res.data.itemCart)
      })
      .catch((err) => {


      })
  }, [])


  return (
    <div>
      <h1> Shopping Cart </h1>

      <div style={{
        display: "flex",
        flexDirection: "row",
        justifyContent: "space-evenly"
      }}>
        {itemsInCart.map((item) => {
          return (

            <CartItemMUI {...item} key={"item-" + item.itemId}/>
          )
        })}
      </div>
    </div>
  )
}

export default CartMUI
