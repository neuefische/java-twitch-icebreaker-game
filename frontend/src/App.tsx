import React, {useState} from 'react';
import './App.css';
import Questions from "./components/Questions";
import Players from "./components/Players";
import useWebSocket from "react-use-websocket";
import {Game} from "./Game";
import axios from "axios";

function App() {

    const [game, setGame] = useState<Game>()

    let host = window.location.host;
    if (host === "localhost:3000") {
        host = "localhost:8080"
    }

    useWebSocket("ws://" + host + "/api/ws/game", {
        onOpen: () => console.log("opened"),
        onMessage: (event) => {
            setGame(JSON.parse(event.data))
        },
        onClose: () => console.log("closed"),
    });

    if (!game) return (<>Loading...</>);

    return <>
        {
            game.gameState === "ENTER_QUESTION_SHOW_RESULT"
                ? <Questions></Questions>
                : game.currentQuestion?.text
        }
        <Players myId={game.myId} mySessionId={game.mySessionId} players={game.players} gameState={game.gameState}></Players>
        {
            game.gameState === "GUESS_AND_ANSWER" &&
            <button onClick={() => {
                axios.post("/api/game/switch-state")
            }}>Next</button>
        }
    </>;
}

export default App;
