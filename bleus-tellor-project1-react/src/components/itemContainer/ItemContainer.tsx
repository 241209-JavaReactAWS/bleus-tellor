import "./ItemContainer.css"

function ItemContainer() {
    return (
        <div className='item-container'>
            <div>
                <figure>
                    <img id="pic" src="https://www.nintendo.com/eu/media/images/10_share_images/support_9/H2x1_GameBoy_support_no_logo_image1280w.jpg" />
                </figure>
            </div>
            <div>
                <div><strong>Item Name:</strong> item name</div>
                <div><strong>Item Description:</strong> item description</div>
                <div><strong>Sale Price:</strong>  sale price</div>
                <div><strong>Vendor ID:</strong>  vendor name</div>
            </div>
        </div>
    )
}

export default ItemContainer
