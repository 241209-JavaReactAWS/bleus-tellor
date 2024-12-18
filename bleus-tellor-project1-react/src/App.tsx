import { BrowserRouter, Route, Routes } from "react-router-dom"
import Footer from "./components/footer/Footer"
import Header from "./components/header/Header"
import Nav from "./components/nav/Nav"
import Main from "./components/mainTag/Main"

function App() {

  return (
    <>
    <Header></Header>

    <BrowserRouter>
    <Nav></Nav>
    <Main></Main>
    <Routes>
    </Routes>
    
    </BrowserRouter>
    <Footer></Footer>
    </>
  )
}

export default App
