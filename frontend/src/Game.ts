import {Player} from "./Player";
import {Question} from "./Question";
import {GameState} from "./GameState";

export type Game = {
    players: Player[],
    currentQuestion: Question,
    myId: string,
    mySessionId: string,
    gameState: GameState,
}