import {Player} from "./Player";
import {Question} from "./Question";

export type Game = {
    players: Player[],
    currentQuestion: Question,
}