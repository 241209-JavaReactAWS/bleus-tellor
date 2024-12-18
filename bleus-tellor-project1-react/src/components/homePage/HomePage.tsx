import Paper from "@mui/material/Paper"




function HomePage(){
    return(
        
        <><header>
            <Paper elevation={3} >TellorBleus Vintage Tech!</Paper>
        </header><nav>
                <ul>
                    <li><a href="./StoreFront.html">StoreFront</a></li>
                    <li><a href="./ItemList.html">EditItemList</a></li>
                    <li><a href="./CustomerLogin.html">CustomerLogin</a></li>
                    <li><a href="./SellerLogin.html">SellerLogin</a></li>

                </ul>
            </nav></>

            
    )

}

export default HomePage