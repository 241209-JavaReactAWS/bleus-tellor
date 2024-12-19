import { Card, CardMedia, CardContent, Typography, CardActions, Button } from "@mui/material"
import {Item} from "../../Interfaces/Item"
import { useEffect } from "react"
import axios from "axios"

function cartMUI() {

    const myItem : Item {};


    useEffect(() => {
        axios.get<Item>('http://localhost:8080/item/2')
        .then((res) => {

        })
        .catch((err) => {

        })
    })

  return (
      <Card sx={{ maxWidth: 345 }}>
        <CardMedia 
        sx={{heigth: 140}}
        image= {myItem.picUrl}
        title= {myItem.itemName} 
        />
      <CardContent>
        <Typography gutterBottom variant="h5" component="div">
          Lizard
        </Typography>
        <Typography variant="body2" sx={{ color: 'text.secondary' }}>
          Lizards are a widespread group of squamate reptiles, with over 6,000
          species, ranging across all continents except Antarctica
        </Typography>
      </CardContent>
      <CardActions>
        <Button size="small">Share</Button>
        <Button size="small">Learn More</Button>
      </CardActions>
        </Card>
  )
}

export default cartMUI
