import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import  { BrowserRouter } from 'react-router-dom'

// navigeeerimiseks
// 1. npm install react-router-dom --> paneb kõik vajalikud failid node_module kasusta
// 2.importida BrowserRouter src/main.jsx ---> võtab sealt moodulist vajaliku
// 3. ümbritseda <App /> BrowserRouteriga, navigeerimieks
// 4. App.jsx failis the URL ja faildie vahelisi seoseid

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>
    <App />
    </BrowserRouter>
  </StrictMode>,
)
