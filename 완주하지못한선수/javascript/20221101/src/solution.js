function test() {
  console.log('countMap(["mislav", "stanko", "mislav", "ana"]): '
    + `{"mislav": 2, "stanko": 1, "ana": 1} = ${JSON.stringify(countMap(['mislav', 'stanko', 'mislav', 'ana']))}`);

  console.log('findUncompleted(["mislav", "stanko", "mislav", "ana"], ["stanko", "ana", "mislav"]): mislav = '
    + `${findUncompleted(['mislav', 'stanko', 'mislav', 'ana'], ['stanko', 'ana', 'mislav'])}`);
}

function solution(participant, completion) {
  // test();

  const answer = findUncompleted(participant, completion);
  return answer;
}

function countMap(array) {
  const map = {};

  array.forEach((name) => map[name] = (map[name] ?? 0) + 1);

  return map;
}

function findUncompleted(participant, completion) {
  const participantMap = countMap(participant);
  const completionMap = countMap(completion);

  return Object.keys(participantMap)
    .find((name) => participantMap[name] != completionMap[name]);
}
