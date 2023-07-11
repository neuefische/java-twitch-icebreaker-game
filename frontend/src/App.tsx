import React, {useState} from 'react';
import './App.css';
import Questions from "./components/Questions";
import Players from "./components/Players";
import useWebSocket from "react-use-websocket";
import {Game} from "./Game";

function App() {

    const [game, setGame] = useState<Game>()

    let host = window.location.host;
    if (host === "localhost:3000") {
        host = "localhost:8080"
    }

    useWebSocket("ws://" + host+"/api/ws/game", {
        onOpen: () => console.log("opened"),
        onMessage: (event) => {
            setGame(JSON.parse(event.data))
        },
        onClose: () => console.log("closed"),
    });

    if (!game) return (<>Loading...</>);

    return <>
        <Questions currentQuestion={game.currentQuestion}></Questions>
        <Players myId={game.myId} mySessionId={game.mySessionId} players={game.players}></Players>
    </>;
}

export default App;
