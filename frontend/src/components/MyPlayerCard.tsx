import {Player} from "../Player";
import axios from "axios";
import {GameState} from "../GameState";
import {useState} from "react";

export type Props = {
    player: Player
    myId: string
    mySessionId: string
    gameState: GameState
}

export default function MyPlayerCard(props: Props) {

    const [guess, setGuess] = useState<number>(0)
    const [answer, setAnswer] = useState<boolean>(false)

    function changeGuess(player: Player, event: React.ChangeEvent<HTMLInputElement>) {
        let input = Number(event.target.value);
        if (player.guess === input) return
        setGuess(input)
        sendUpdate(player, input, answer);
    }

    function changeAnswer(player: Player, event: React.ChangeEvent<HTMLInputElement>) {
        let input = event.target.checked;
        setAnswer(input)
        sendUpdate(player, guess, input);
    }

    function sendUpdate(player: Player, guess: number, answer: boolean) {
        player.guess = guess
        player.answer = answer
        axios.put(`/api/players/${props.mySessionId}`, player)
    }

    return (
        <li>
            <p>
                {props.player.name}
                {
                    props.player.id === props.myId && props.gameState === "GUESS_AND_ANSWER" &&
                    <>
                        <input type={"number"} value={props.player.guess}
                               onChange={event => changeGuess(props.player, event)}/>
                        <input type={"checkbox"}
                               checked={answer}
                               onChange={event => changeAnswer(props.player, event)}/>
                    </>
                }
                {
                    props.gameState === "ENTER_QUESTION_SHOW_RESULT" &&
                    <>{" "} {props.player.guess} ({props.player.answer ? "Ja" : "Nein"})</>
                }
            </p>
        </li>
    )
}