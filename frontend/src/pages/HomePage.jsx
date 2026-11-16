import { useEffect, useState } from 'react'

function HomePage() {
 // const [count, setCount] = useState(0) // useState mis hoiustab muutujaid HTMLIS!
  const [products, setProducts] = useState([]);
  // useState([]) -- sulud ja masiiv on useState kohahoidja kuhu tuleb backendist toodete andmed sisse 
const [categories, setCategories] = useState([]);
const [selectedCategory, setSelectedCategory] = useState(0);
const [isLoading, setLoading] = useState(true);
  

useEffect(() => {     
    fetch("http://localhost:7070/products?categoryId=" + selectedCategory)
    .then(res => res.json())
    .then(data => {
      setProducts(data);
    setLoading(false);
  })  // Toodete sisse läheb seProduct sisse
  }, [selectedCategory])

  useEffect(() => {     
    fetch("http://localhost:7070/categories")
    .then(res => res.json())
    .then(data => setCategories(data))  // Toodete sisse läheb setProduct sisse
  }, [])  // dependency array - kui selectedCategory muutub , siis käivitatakse useEffect uuesti

  if (isLoading === true) {  
    return <div> </div>
  }
 

    
  


    return (
        <div>
           <div>
              <button onClick={() => selectedCategory(0)}>Kõik tooted</button>
      {/* map- Array (listi) seest ükshaaval tooteid || key = key jätab mällu  */}
      {categories.map(category =>  
        <button key={category.id}
         onClick={() => setSelectedCategory(category.id)}
        className={selectedCategory === category.id ? 'category-active' : undefined}>   
          <div>{category.name}</div>
          </button>)}
      </div>
     

    {/*  length - andmete kogu pikkus ehk list! */}
     <div>Toodete koguarv: {products.length}</div>   
     <div>
      {/*  */}
      {products.map(product =>  
        <div key={product.id}>
          <div>{product.name}</div>
          <div>{product.price}</div>
      </div>)}
     </div>

        </div>
    
    )
}

export default HomePage