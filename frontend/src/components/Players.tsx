import {useState} from "react";
import {Player} from "../Player";
import axios from "axios";

type Props = {
    players: Player[]
}
export default function Players(props: Props) {

    const [name, setName] = useState<string>("")

    const onPlayerAdd = () => {
        axios.post('/api/players', {name: name})
            .then(() => setName(""))
    }

    const onPlayerDelete = (player: Player) => {
        axios.delete(`/api/players/${player.name}`)
    }

    function changeGuess(player: Player, event: React.ChangeEvent<HTMLInputElement>) {
        if (player.guess === event.target.value) return
        player.guess = event.target.value
        axios.put(`/api/players/${player.name}`, player)
    }

    return (
        <>
            <ul>
                {props.players.map((player, index) => <li key={index}>
                        <p>
                            {player.name}
                            <input type={"number"} value={player.guess}
                                   onChange={event => changeGuess(player, event)}/>
                            <button onClick={() => onPlayerDelete(player)}>🗑</button>
                        </p>
                    </li>
                )}
            </ul>
            <input placeholder={"Username"} type={"text"} value={name} onChange={event => setName(event.target.value)}/>
            <button onClick={() => onPlayerAdd()}>Save</button>
        </>
    )

}








