function test() {
  console.log('findUncompleted(["mislav", "stanko", "mislav", "ana"], ["stanko", "ana", "mislav"]): mislav = '
    + `${findUncompleted(['mislav', 'stanko', 'mislav', 'ana'], ['stanko', 'ana', 'mislav'])}`);
}

function solution(participant, completion) {
  // test();

  const answer = findUncompleted(participant, completion);
  return answer;
}

function findUncompleted(participant, completion) {
  const sortedParticipant = [...participant].sort();
  const sortedCompletion = [...completion].sort();

  return sortedParticipant[[...Array(sortedParticipant.length).keys()]
    .find((i) => sortedParticipant[i] !== sortedCompletion[i])];
}
