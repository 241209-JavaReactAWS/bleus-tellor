import {Link} from 'react-router-dom'
import "./Nav.css"

function Nav() {
  return (
    <nav>
        <ul>
            <li><Link to="./StoreFront.html">StoreFront</Link></li>
            <li><Link to="./ItemList.html">EditItemList</Link></li>
            <li><Link to="./CustomerLogin.html">CustomerLogin</Link></li>
            <li><Link to="./SellerLogin.html">SellerLogin</Link></li>

        </ul>
    </nav>
  )
}

export default Nav
