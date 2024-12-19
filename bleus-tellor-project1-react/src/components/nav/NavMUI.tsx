import { useContext } from "react";
import { useNavigate } from "react-router-dom"
import { authContext } from "../../App";
import axios from "axios";
import { Button } from "@mui/material";


function NavMUI() {
    const navigate = useNavigate();
    const auth = useContext(authContext);

    let navToPage = (location: string) => {
        navigate(location)
    }

    let logOut = () => {
        axios.post('http://localhost:8080/customers/logout', {}, {withCredentials: true})
        .then((res) => {
            auth?.setUsername('')
            auth?.setRole('CUSTOMER')

            navigate('/login')
        })
    }

  return (
    <div>
        <Button color="inherit" onClick={() => navToPage('/itemCart')}>Shopping Cart</Button>
        <Button color="inherit" onClick={() => navToPage('/')}>Home</Button>
    </div>
  )
}

export default NavMUI
