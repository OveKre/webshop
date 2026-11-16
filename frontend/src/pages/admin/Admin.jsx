import { Link } from 'react-router-dom'
function Admin() {
    return (
        <div>
            <Link to="/lisa-toode"><button>Lisa toode</button></Link>
            <Link to="/halda-tooteid"><button>Halda tooteid</button></Link>
            <Link to="/halda-kategooriaid"><button>Halda kategooriaid</button></Link>
        </div>
    
    )
}

export default Admin