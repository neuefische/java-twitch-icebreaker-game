import React, {useState} from 'react';
import './App.css';
import Questions from "./components/Questions";
import Players from "./components/Players";
import useWebSocket from "react-use-websocket";
import {Game} from "./Game";

function App() {

    const [game, setGame] = useState<Game>()

    useWebSocket("ws://localhost:8080/api/ws/game", {
        onOpen: () => console.log("opened"),
        onMessage: (event) => {
            setGame(JSON.parse(event.data))
        },
        onClose: () => console.log("closed"),
    });

    if (!game) return (<>Loading...</>);

    return <>
        <Questions currentQuestion={game.currentQuestion}></Questions>
        <Players players={game.players}></Players>
    </>;
}

export default App;
