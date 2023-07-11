import {Player} from "../Player";
import axios from "axios";

export type Props = {
    player: Player
    myId: string
    mySessionId: string
}

export default function MyPlayerCard(props: Props) {

    function changeGuess(player: Player, event: React.ChangeEvent<HTMLInputElement>) {
        let input = Number(event.target.value);
        if (player.guess === input) return
        player.guess = input
        axios.put(`/api/players/${props.mySessionId}`, player)
    }

    function changeAnswer(player: Player, event: React.ChangeEvent<HTMLInputElement>) {
        player.answer = event.target.checked
        axios.put(`/api/players/${props.mySessionId}`, player)
    }

    return (
            <li>
                <p>
                    {props.player.name}
                    {
                        props.player.id === props.myId &&
                        <>
                            <input type={"number"} value={props.player.guess}
                                   onChange={event => changeGuess(props.player, event)}/>
                            <input type={"checkbox"}
                                   onChange={event => changeAnswer(props.player, event)}/>
                        </>
                    }
                </p>
            </li>
    )
}