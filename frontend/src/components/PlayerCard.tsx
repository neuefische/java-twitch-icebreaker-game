import {Player} from "../Player";

type Props = {
    player: Player
}
export default function PlayerCard(props: Props) {
    return (
        <li>{props.player.name}</li>
    )
}
