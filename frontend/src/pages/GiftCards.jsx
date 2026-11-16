import { useState } from 'react'; 


function GiftCards() {

    const [summa, setSumma] = useState(50);
    const [arv, setArv] = useState(1);
    
    
    return (
    
        <div> 
            <button className={summa === 20 ? "summa-active" : undefined} onClick={() => setSumma(20)}>20€ </button>
            <button className={summa === 50 ? "summa-active" : undefined} onClick={() => setSumma(50)}>50€ </button>
            <button className={summa === 100 ? "summa-active" : undefined} onClick={() => setSumma(100)}>100€ </button>
            <div>Summa: {summa} €</div>

            <button disabled={arv === 1}onClick={() => setArv(arv - 1)}>-</button>
             <span className={arv > 10 ? "kuldne" : undefined}>{arv}</span>
            {/* <div>{arv}</div>         */}
            <button onClick={() => setArv(arv + 1)}>+</button>
        
            <div>Kokku: {summa * arv} €</div>
        </div>
    
    )
}

export default GiftCards