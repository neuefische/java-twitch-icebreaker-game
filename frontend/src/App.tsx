import React, {useEffect} from 'react';
import './App.css';
import {Question} from './Question'
import axios from "axios";

function App() {

  const [currentQuestion, setCurrentQuestion] = React.useState<Question>();

  useEffect(()=> {
    axios.get('/api/questions/current')
        .then((response) => response.data)
        .then((data) => setCurrentQuestion(data))
  }, [])

  if (currentQuestion === undefined) {
    return <>Loading...</>;
  }

  return <>
    {currentQuestion.text}
  </>;
}

export default App;
