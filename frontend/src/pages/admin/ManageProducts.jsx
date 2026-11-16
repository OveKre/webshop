import { useState } from "react";
import { useEffect } from "react";
function ManageProducts() {
    const [products, setProducts] = useState([]); /// Muutuja tektitamine ja pannakse products HTLMIS , setter muudab products setProducts(korraga uuendab ka HMTLIS )
   useEffect(() =>{

   
    fetch("http://localhost:7070/products")
    .then(res => res.json())
    .then(data => setProducts(data));
   }, [])
    return (
        <div>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nimi</th>
                        <th>Hind</th>
                        <th>Kogus</th>
                    </tr>
                </thead>
                <body>
            {products.map(product =>
                <tr key={product.id}>
                    <td>{product.id}</td>
                    <td>{product.price}</td>
                    <td>{product.name}</td>
                    <td>{product.stock}</td>
            
        </tr>)}
        </body>
        </table>
    </div>
    )
}

export default ManageProducts