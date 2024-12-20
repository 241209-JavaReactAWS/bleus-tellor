import React, { useState, useEffect, useContext } from 'react';
import axios from 'axios';
import { Table, TableHead, TableRow, TableCell, TableBody, Container, Typography, Paper, Box, Button } from '@mui/material';
import { Item } from '../../Interfaces/Item';
import { authContext } from "../../App";


function StorefrontMUI() {
  const auth = useContext(authContext);
  const [allItems, setAllItems] = useState<any[]>([]);

  useEffect(() => {
    axios.get<Item[]>("http://localhost:8080/items")
      .then((res) => {
        setAllItems(res.data);
      });
  }, []);

  let addToCart = (itemId: number) => {
    console.log("Add to cart clicked")

    axios.post('http://localhost:8080/customers/itemCart/${itemId}')
      .then((response) => {
        console.log("Item added to cart:", response.data);
      })
      .catch((error) => {
        console.error("There was an error adding the item to the cart:", error);
      })

  }

  return (
    <Container maxWidth="lg" sx={{ paddingTop: '20px' }}>
      <Paper sx={{ padding: '20px', boxShadow: 3 }}>
        <Typography variant="h3" component="h1" align="center" sx={{ marginBottom: '20px', fontWeight: 'bold' }}>
          Items List
        </Typography>

        <Table sx={{ minWidth: 650 }}>
          <TableHead>
            <TableRow>
              <TableCell sx={{ fontWeight: 'bold' }}>Name</TableCell>
              <TableCell sx={{ fontWeight: 'bold' }}>Brand</TableCell>
              <TableCell sx={{ fontWeight: 'bold' }}>Price</TableCell>
              <TableCell sx={{ fontWeight: 'bold' }}>Quality</TableCell>
              <TableCell sx={{ fontWeight: 'bold' }}>picURL</TableCell>
            </TableRow>
          </TableHead>

          <TableBody>
            {allItems.map((item, index) => (
              <TableRow
                key={item.itemId}
                sx={{
                  backgroundColor: index % 2 === 0 ? '#f9f9f9' : '#ffffff',
                  '&:hover': { backgroundColor: '#f1f1f1', cursor: 'pointer' }
                }}
              >
                <TableCell>
                  <img
                    src="https://www.nintendo.com/eu/media/images/10_share_images/support_9/H2x1_GameBoy_support_no_logo_image1280w.jpg"
                    height="200px"
                    width="400px"
                    style={{ display: 'block', margin: 'auto' }}
                  />
                </TableCell>
                <TableCell>{item.itemName}</TableCell>
                <TableCell>{item.itemBrand}</TableCell>
                <TableCell>{item.itemPrice}</TableCell>
                <TableCell>{item.itemQuality}</TableCell>
                <TableCell>{item.picUrl}</TableCell>
                {auth?.userName && (
                  <TableCell>
                    <Button
                      variant="contained"
                      color="inherit"
                      onClick={() => addToCart(item.itemId)}
                    >
                      Add To Cart
                    </Button>
                  </TableCell>
                )}
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </Paper>
    </Container>
  );
}

export default StorefrontMUI;