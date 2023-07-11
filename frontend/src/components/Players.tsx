import {Player} from "../Player";
import PlayerCard from "./PlayerCard";
import MyPlayerCard from "./MyPlayerCard";

type Props = {
    myId: string
    mySessionId: string
    players: Player[]
}
export default function Players(props: Props) {

    return (
        <>
            <ul>
                {props.players.map((player, index) =>
                    player.id === props.myId &&
                    <MyPlayerCard key={index} player={player} myId={props.myId} mySessionId={props.mySessionId}/>
                )}
                {props.players.map((player, index) =>
                    player.id !== props.myId &&
                    <PlayerCard key={index} player={player}/>
                )}
            </ul>
        </>
    )

}








