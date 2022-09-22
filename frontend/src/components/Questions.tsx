import React, {useEffect} from "react";
import {Question} from "../Question";
import axios from "axios";

export default function Questions() {
    const [currentQuestion, setCurrentQuestion] = React.useState<Question>();
    const [nextQuestion, setNextQuestion] = React.useState<string>("");

    let fetchQuestion = () => {
        axios.get('/api/questions/current')
            .then((response) => response.data)
            .then((data) => setCurrentQuestion(data))
    };
    useEffect(fetchQuestion, [])

    useEffect(() => {
        setInterval(() => {
            fetchQuestion();
        }, 1000);
    }, [])

    const onQuestionSave = () => {
        axios.put('/api/questions/current', {text: nextQuestion})
            .then((response) => response.data)
            .then((data) => setCurrentQuestion(data))
            .then(() => setNextQuestion(""))
    }

    if (currentQuestion === undefined) {
        return <>Loading...</>;
    }

    return <>
        {currentQuestion.text}
        <input placeholder={"Question?"} type={"text"} onChange={event => setNextQuestion(event.target.value)} value={nextQuestion}/>
        <button onClick={onQuestionSave}>Save</button>
    </>
}