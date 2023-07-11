import {Player} from "../Player";
import {GameState} from "../GameState";

type Props = {
    player: Player
    gameState: GameState
}
export default function PlayerCard(props: Props) {
    return (
        <li>
            {props.player.name}
            {
                props.gameState === "ENTER_QUESTION_SHOW_RESULT" &&
                <>{" "} {props.player.guess} ({props.player.answer ? "Ja" : "Nein"})</>
            }
        </li>
    )
}
