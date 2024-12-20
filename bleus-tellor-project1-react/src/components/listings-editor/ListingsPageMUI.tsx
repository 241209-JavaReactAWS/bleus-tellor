import React, { useState, useEffect, useContext } from 'react';
import axios from 'axios';
import { Table, TableHead, TableRow, TableCell, TableBody, Container, Typography, Paper, Button } from '@mui/material';
import { Item } from '../../Interfaces/Item';
import { authContext } from "../../App";

function ListingsPageMUI() {
    const auth = useContext(authContext);
    const [trigger, setTrigger] = useState(0);
    const [allItems, setAllItems] = useState<any[]>([]);

    useEffect(() => {
        axios.get<Item[]>("http://localhost:8080/items")
            .then((res) => {
                setAllItems(res.data);
            })
            .catch((error) => {
                console.error("Error fetching items:", error);
            });
    }, [trigger]);


    const deleteListing = (itemId: number) => {
        console.log("Delete listing clicked");


        axios.delete(`http://localhost:8080/items/${itemId}`)
            .then((response) => {
                console.log("Item deleted:", response.data);

                setTrigger(prevTrigger => prevTrigger + 1);
            })
            .catch((error) => {
                console.error("Error deleting item:", error);
            });
    };

    return (
        <Container maxWidth="lg" sx={{ paddingTop: '20px' }}>
            <Paper sx={{ padding: '20px', boxShadow: 3 }}>
                <Typography variant="h3" component="h1" align="center" sx={{ marginBottom: '20px', fontWeight: 'bold' }}>
                    Listings Page
                </Typography>

                <Table sx={{ minWidth: 650 }}>
                    <TableHead>
                        <TableRow>
                            <TableCell sx={{ fontWeight: 'bold' }}>Item ID</TableCell>
                            <TableCell sx={{ fontWeight: 'bold' }}>Name</TableCell>
                            <TableCell sx={{ fontWeight: 'bold' }}>Brand</TableCell>
                            <TableCell sx={{ fontWeight: 'bold' }}>Price</TableCell>
                            <TableCell sx={{ fontWeight: 'bold' }}>Quality</TableCell>
                            <TableCell sx={{ fontWeight: 'bold' }}>picURL</TableCell>
                            {auth?.userName && <TableCell sx={{ fontWeight: 'bold' }}>Action</TableCell>}
                        </TableRow>
                    </TableHead>

                    <TableBody>
                        {allItems.map((item) => (
                            <TableRow
                                key={item.itemId}
                                sx={{
                                    hover: { backgroundColor: '#f1f1f1', cursor: 'pointer' }
                                }}
                            >
                                <TableCell>
                                    <img
                                        src={item.picURL}
                                        height="200px"
                                        width="400px"
                                        style={{ display: 'block', margin: 'auto' }}
                                    />
                                </TableCell>
                                <TableCell>{item.itemId}</TableCell>
                                <TableCell>{item.itemName}</TableCell>
                                <TableCell>{item.itemBrand}</TableCell>
                                <TableCell>{item.itemPrice}</TableCell>
                                <TableCell>{item.itemQuality}</TableCell>
                                <TableCell>{item.picUrl}</TableCell>

                                {/* Delete Item Button from entire listign */}
                                {auth?.userName && (
                                    <TableCell>
                                        <Button
                                            variant="contained"
                                            color="secondary"
                                            onClick={() => deleteListing(item.itemId)}
                                        >
                                            Delete Listing
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

export default ListingsPageMUI;
