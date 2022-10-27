function test() {
  console.log(`score([2,1,2,3,2,4,2,5],[1,2,3,4,5]): 0 = ${score([2, 1, 2, 3, 2, 4, 2, 5], [1, 2, 3, 4, 5])}`);
  console.log(`score([1,2,3,4,5],[1,2,3,4,5]): 5 = ${score([1, 2, 3, 4, 5], [1, 2, 3, 4, 5])}`);

  console.log(`scores([1,2,3,4,5]): [5,0,0] = ${scores([1, 2, 3, 4, 5])}`);
  console.log(`scores([1,3,2,4,2]): [2,2,2] = ${scores([1, 3, 2, 4, 2])}`);

  console.log(`bestSolver([1,2,3,4,5]): [1] = ${bestSolver([1, 2, 3, 4, 5])}`);
  console.log(`bestSolver([1,3,2,4,2]): [1,2,3] = ${bestSolver([1, 3, 2, 4, 2])}`);
  console.log(`bestSolver([3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5]): [3] = ${bestSolver([3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5])}`);
}

function solution(answers) {
  // test();
  const answer = bestSolver(answers);
  return answer;
}

function score(pattern, answers) {
  return answers.reduce((score, answer, i) => (
    answer === pattern[i % pattern.length]
      ? score + 1
      : score
  ), 0);
}

function scores(answers) {
  const patterns = [
    [1, 2, 3, 4, 5],
    [2, 1, 2, 3, 2, 4, 2, 5],
    [3, 3, 1, 1, 2, 2, 4, 4, 5, 5],
  ];

  return patterns.map((pattern) => score(pattern, answers));
}

function bestSolver(answers) {
  const scoresOfSolvers = scores(answers);
  const bestScore = Math.max(...scoresOfSolvers);

  return [...Array(scoresOfSolvers.length).keys()]
    .filter((i) => scoresOfSolvers[i] === bestScore)
    .map((i) => i + 1);
}
