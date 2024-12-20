import { useContext, useState } from "react";
import { useNavigate } from "react-router-dom"
import { authContext } from "../../App";
import axios from "axios";
import { AppBar, Box, Button, Container, Divider, Menu, MenuItem, Toolbar, Typography } from "@mui/material";


function NavMUI() {
    const navigate = useNavigate();
    const auth = useContext(authContext);

    //State for the dropdown menu
    const [anchorEl, setAnchorEl] = useState<null | HTMLElement>(null);

    const handleMenuClick = (event: React.MouseEvent<HTMLElement>) => {
        setAnchorEl(event.currentTarget);
    };

    const handleMenuClose = () => {
        setAnchorEl(null);
    };

    let navToPage = (location: string) => {
        navigate(location)
        handleMenuClose();
    }

    let logOut = () => {
        axios.post('http://localhost:8080/customers/logout', {}, { withCredentials: true })
            .then((res) => {
                auth?.setUsername('')
                auth?.setRole('CUSTOMER')

                navigate('/login')
                handleMenuClose();
            })
    }

    return (
        <AppBar position="sticky">
            <Container>
                <Toolbar>
                    {/* button for the dropdown menu */}
                    <Button color="inherit" onClick={handleMenuClick}>
                        Menu
                    </Button>
                    
                    <Typography variant="h6" sx={{ flexGrow: 1 }}>
                        TellorBleus
                    </Typography>

                    <Menu
                        anchorEl={anchorEl}
                        open={Boolean(anchorEl)}
                        onClose={handleMenuClose}>
                        <MenuItem onClick={() => navToPage('/itemCart')}>Shopping Cart</MenuItem>
                        <Divider orientation="vertical" flexItem sx={{ mx: .5 }} />

                        <MenuItem onClick={() => navToPage('/')}>Storefront</MenuItem>
                    </Menu>

                    <Box sx={{ flexGrow: 1 }} />

                    {auth?.userName ? (
                        <Button color="inherit" onClick={logOut}>
                            Logout
                        </Button>
                    ) : (
                        <Button color="inherit" onClick={() => navToPage('/login')}>
                            Login
                        </Button>
                    )}
                </Toolbar>
            </Container>
        </AppBar>
    );
}

export default NavMUI
