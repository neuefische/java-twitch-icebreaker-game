import React, {useState} from 'react';
import './App.css';
import Questions from "./components/Questions";
import Players from "./components/Players";
import useWebSocket from "react-use-websocket";
import {Player} from "./Player";

function App() {

    const [players, setPlayers] = useState<Player[]>([])

    useWebSocket("ws://localhost:8080/api/ws/game", {
        onOpen: () => console.log("opened"),
        onMessage: (event) => {
            setPlayers(JSON.parse(event.data))
        },
        onClose: () => console.log("closed"),
    });

    return <>
        <Questions></Questions>
        <Players players={players}></Players>
    </>;
}

export default App;
