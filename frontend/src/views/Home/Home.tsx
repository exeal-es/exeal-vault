import React, { useEffect } from 'react';
import logo from './logo.svg';
import './_home.css';

function Home() {
  const [secrets, setSecrets] = React.useState([]);
  useEffect(() => {
    fetch('http://localhost:8080/secrets')
      .then(res => res.json())
      .then(data => setSecrets(data))
  }, [])

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
       {secrets.map((secret: {key: string, value: string}) => <><p key={secret.key}>{secret.key}</p><p key={secret.value}>{secret.value}</p></>)}
        <a
          className="App-link"
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

export default Home;