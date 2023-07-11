import React from 'react';
import './App.css';
import Questions from "./components/Questions";
import Players from "./components/Players";
import useWebSocket from "react-use-websocket";

function App() {

    return <>
        <Questions></Questions>
        <Players></Players>
    </>;
}

export default App;
