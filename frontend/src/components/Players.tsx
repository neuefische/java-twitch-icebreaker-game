import {Player} from "../Player";
import PlayerCard from "./PlayerCard";
import MyPlayerCard from "./MyPlayerCard";
import {GameState} from "../GameState";

type Props = {
    myId: string
    mySessionId: string
    players: Player[]
    gameState: GameState
}
export default function Players(props: Props) {

    return (
        <>
            <ul>
                {props.players.map((player, index) =>
                    player.id === props.myId &&
                    <MyPlayerCard gameState={props.gameState} key={index} player={player} myId={props.myId} mySessionId={props.mySessionId}/>
                )}
                {props.players.map((player, index) =>
                    player.id !== props.myId &&
                    <PlayerCard gameState={props.gameState} key={index} player={player}/>
                )}
            </ul>
        </>
    )

}








