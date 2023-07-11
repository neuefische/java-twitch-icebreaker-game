import React from "react";
import {Question} from "../Question";
import axios from "axios";

type Props = {
    currentQuestion: Question | undefined
}
export default function Questions(props: Props) {
    const [nextQuestion, setNextQuestion] = React.useState<string>("");

    const onQuestionSave = () => {
        axios.put('/api/questions/current', {text: nextQuestion})
            .then(() => setNextQuestion(""))
    }

    if (props.currentQuestion === undefined) {
        return <>Loading...</>;
    }

    return <>
        {props.currentQuestion?.text}
        <input placeholder={"Question?"} type={"text"} onChange={event => setNextQuestion(event.target.value)}
               value={nextQuestion}/>
        <button onClick={onQuestionSave}>Save</button>
    </>
}