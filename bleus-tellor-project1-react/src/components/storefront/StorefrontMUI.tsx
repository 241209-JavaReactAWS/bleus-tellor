import { useEffect, useState } from "react"
import axios from "axios"
import { Button, Fab, Table, TableBody, TableCell, TableHead, TableRow } from "@mui/material"
import { Item } from "../../Interfaces/Item"

function StorefrontMUI() {
  const [allItems, setAllItems] = useState<Item[]>([])
  useEffect(() => {
    
      axios.get<Item[]>("http://localhost:8080/items")
      .then((res) => {
          setAllItems(res.data)
      })
  }, [])


  return (
    <div>
        <h1>All Players</h1>
        <Table>
            <TableHead>
                <TableRow>
                    <TableCell>Item Serial</TableCell>
                    <TableCell>Name</TableCell>
                    <TableCell>Brand</TableCell>
                    <TableCell>Price</TableCell>
                    <TableCell>Quality</TableCell>
                    <TableCell>picURL</TableCell>
                </TableRow>
            </TableHead>
            <TableBody>
                
                {allItems.map((item) => {
                    return (
                        <TableRow key={item.itemId}>
                            <TableCell>{item.itemName}</TableCell>
                            <TableCell>{item.itemBrand}</TableCell>
                            <TableCell>{item.itemPrice}</TableCell>
                            <TableCell>{item.itemQuality}</TableCell>
                            <TableCell>{item.picUrl}</TableCell>
                        </TableRow>
                    )
                })}
            </TableBody>
        </Table>
      

    </div>
  )
}

export default StorefrontMUI
