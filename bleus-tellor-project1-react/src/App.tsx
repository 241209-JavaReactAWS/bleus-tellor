import { BrowserRouter, Route, Routes } from "react-router-dom"
import Footer from "./components/footer/Footer"
import Header from "./components/header/Header"
import Nav from "./components/nav/Nav"

function App() {

  return (
    <>
    <Header></Header>

    <BrowserRouter>
    <Nav></Nav>
    
    <Routes>
    </Routes>
    
    </BrowserRouter>
    <Footer></Footer>
    </>
  )
}

export default App
