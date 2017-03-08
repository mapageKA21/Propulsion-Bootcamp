function shuffle(array) {
  var currentIndex = array.length, temporaryValue, randomIndex;

  // While there remain elements to shuffle...
  while (0 !== currentIndex) {

    // Pick a remaining element...
    randomIndex = Math.floor(Math.random() * currentIndex);
    currentIndex -= 1;

    // And swap it with the current element.
    temporaryValue = array[currentIndex];
    array[currentIndex] = array[randomIndex];
    array[randomIndex] = temporaryValue;
  }

  return array;
}

export default (state, props) => {
  const question = Object.values(state.questions).filter(question =>
    question.order === parseInt(props.params.order, 10)
  )[0];

  if (!question) {
    return { question: null }
  }

  var answers = question.incorrect_answers.map(answer => ({ content: answer, isCorrect: false }));
  answers.push({
    content: question.correct_answer,
    isCorrect: true,
  });
  delete question.incorrect_answers;
  delete question.correct_answer;
  question.answers = shuffle(answers);

  const isLast = parseInt(props.params.order, 10) === (Object.keys(state.questions).length);

  return {
    question,
    isLast,
  };
}
