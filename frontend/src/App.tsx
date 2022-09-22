import React, {ChangeEvent, useEffect} from 'react';
import './App.css';
import {Question} from './Question'
import axios from "axios";

function App() {

    const [currentQuestion, setCurrentQuestion] = React.useState<Question>();
    const [nextQuestion, setNextQuestion] = React.useState<string>("");

    useEffect(() => {
        axios.get('/api/questions/current')
            .then((response) => response.data)
            .then((data) => setCurrentQuestion(data))
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
        <input type={"text"} onChange={event => setNextQuestion(event.target.value)} value={nextQuestion}/>
        <button onClick={onQuestionSave}>Save</button>
    </>;
}

export default App;
