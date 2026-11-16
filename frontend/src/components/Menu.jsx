
import { Link } from 'react-router-dom';

function Menu() {
  return (
    <div>

      <Link to="/"><button>Avaleht</button></Link>
      <Link to="/ostukorv"><button>Ostukorv</button></Link>
      <Link to="/admin"><button>admin paneeli</button></Link>
      <Link to="/minu-tellimused"><button>Minu Tellimused</button></Link>
       <Link to="/kinkekaardid"><button>Kinkekaardid</button></Link>

    </div>
  )
}

export default Menu