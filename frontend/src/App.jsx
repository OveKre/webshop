
import './App.css'
import  {  Route, Routes } from 'react-router-dom'
import HomePage from './pages/HomePage';
import Cart from './pages/Cart';
import Admin from './pages/admin/Admin';
import MyOrders from './pages/MyOrders';
import NotFound from './pages/NotFound';
import AddProduct from './pages/admin/AddProduct';
import ManageProducts from './pages/admin/ManageProducts';
import EditProduct from './pages/admin/EditProduct';
import ManageCategories from './pages/admin/ManageCategories';
import GiftCards from './pages/GiftCards';
import Menu from './components/Menu';


function App() {
 

  /// Toodete kuvamine

  return (
    <>
      <Menu />
      <hr />
     
     <Routes>
      <Route path="/" element={< HomePage />} />
      <Route path="/ostukorv" element={<Cart />} />
      <Route path="/admin" element={<Admin />} />
      <Route path="/minu-tellimused" element={<MyOrders />} />
      <Route path="/lisa-toode" element={<AddProduct />} />
      <Route path="/halda-tooteid" element={<ManageProducts />} />
      <Route path="/muuda-toodet" element={<EditProduct />} />
      <Route path="/halda-kategooriaid" element={<ManageCategories />} />
      <Route path="/kinkekaardid" element={<GiftCards />} />
      <Route path="/*" element={<NotFound />} />    
     </Routes>
     
    </>
  )
}

export default App
