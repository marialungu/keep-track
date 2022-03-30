import React from 'react';
import logo from './logo.svg';
import './App.css';
import "./tailwind.generated.css";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo text-yellow-400" alt="logo" />
        <p className="text-yellow-400">
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link text-yellow-400"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
