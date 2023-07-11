import {useState} from "react";
import {Player} from "../Player";
import axios from "axios";

type Props = {
    players: Player[]
}
export default function Players(props: Props) {

    const [name, setName] = useState<string>("")

    function changeGuess(player: Player, event: React.ChangeEvent<HTMLInputElement>) {
        let input = Number(event.target.value);
        if (player.guess === input) return
        player.guess = input
        axios.put(`/api/players/${player.id}`, player)
    }

    function changeAnswer(player: Player) {
        player.answer = !player.answer
        axios.put(`/api/players/${player.id}`, player)
    }

    return (
        <>
            <ul>
                {props.players.map((player, index) => <li key={index}>
                        <p>
                            {player.name}
                            <input type={"number"} value={player.guess}
                                   onChange={event => changeGuess(player, event)}/>
                            <input type={"checkbox"} checked={player.answer}
                                   onChange={event => changeAnswer(player)}/>
                        </p>
                    </li>
                )}
            </ul>
        </>
    )

}








