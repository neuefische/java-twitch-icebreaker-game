import {useEffect, useState} from "react";
import {Player} from "../Player";
import axios from "axios";

export default function Players() {

    const [players, setPlayers] = useState<Player[]>([])
    const [name, setName] = useState<string>("")

    useEffect(() => {
        axios.get('/api/players')
            .then((response) => response.data)
            .then((data) => setPlayers(data))
    }, [])

    const onPlayerAdd = () => {
        axios.post('/api/players', {name: name})
            .then((response) => response.data)
            .then((data) => setPlayers((currentState) => [...currentState, data]))
            .then(() => setName(""))
    }

    return (
        <>
            <ul>
                {players.map((player, index) => <li key={index}>
                        <p>
                            {player.name}
                        </p>
                    </li>
                )}
            </ul>
            <input placeholder={"Username"} type={"text"} value={name} onChange={event => setName(event.target.value)}/>
            <button onClick={() => onPlayerAdd()}>Save</button>
        </>
    )

}








