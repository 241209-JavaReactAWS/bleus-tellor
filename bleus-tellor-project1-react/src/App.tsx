import { BrowserRouter, Route, Routes } from "react-router-dom"
import Footer from "./components/footer/Footer"
import Header from "./components/header/Header"
import Nav from "./components/nav/Nav"
import Main from "./components/mainTag/Main"
import cartMUI from "./components/cart-page/CartMUI"
import { createContext, useEffect, useState } from "react"
import axios from "axios"
import { Customer } from "./Interfaces/Customer"
import StorefrontMUI from "./components/storefront/StorefrontMUI"
import CartMUI from "./components/cart-page/CartMUI"
import NavMUI from "./components/nav/NavMUI"
import ListingsPageMUI from "./components/listings-editor/ListingsPageMUI"

export interface AuthContextType{
  userName: string,
  setUsername: (userName: string) => void,
  role: "CUSTOMER" | "ADMIN",
  setRole: (role: "CUSTOMER" | "ADMIN") => void
}

export const authContext = createContext<AuthContextType | null>(null);

function App() {
  const [userName, setUsername] = useState<string>('');
  const [role, setRole] = useState<"CUSTOMER" | "ADMIN">('CUSTOMER')
  
  useEffect(()=>{
    // So whenever the page loads I want to send an axios request to make sure we're still logged in, if we are
    // we should have the proper nav bar and if we are we should also see "log out" as an option
    axios.get<Customer>('http://localhost:8080/users', {withCredentials: true})
    .then((res) => {
      setUsername(res.data.userName)
      setRole(res.data.role)
    })
    .catch((err) => {
      console.log(err)
      // If we are NOT logged in, make sure it's set appropriately
      setUsername('')
      setRole('CUSTOMER')
    })
  }, [])


  return (
    <authContext.Provider value={
      {
      userName,
      setUsername,
      role,
      setRole
      }
    }>
    <>
    <Header></Header>

    <BrowserRouter>
    <NavMUI/>
    <Routes>
      <Route path='/' element={<StorefrontMUI/>}/>
      <Route path='/itemCart' element={<CartMUI/>}/>
      <Route path='/listings' element={<ListingsPageMUI/>}/>
    </Routes>
    
    </BrowserRouter>
    <Footer></Footer>
    </>
    </authContext.Provider>
  )
}

export default App
