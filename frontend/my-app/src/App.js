import logo from './logo.svg';
import './App.css';
import {useState} from "react";

function App() {
    const [data, setData] = useState(null);

    function simulateError() {
        throw new Error("Sentry Test Error");
    }

    function handleClick() {
        const xhr = new XMLHttpRequest();
        xhr.open('GET', 'http://localhost:8080/data');
        xhr.onload = function () {
            if (xhr.status === 200) {
                setData(JSON.parse(xhr.responseText));
            }
        };
        xhr.send();
    }

    return (
        <div className="App">
            <header className="App-header">
                <img src={logo} className="App-logo" alt="logo"/>
                <div>
                    <button onClick={simulateError}>
                        Simulate local error
                    </button>
                </div>
                <div>
                    <button onClick={handleClick}>Fetch data from backend (wrong url)</button>
                    {data ? <div>{JSON.stringify(data)}</div> : <div>Loading...</div>}
                </div>
            </header>
        </div>
    )
        ;
}

export default App;
