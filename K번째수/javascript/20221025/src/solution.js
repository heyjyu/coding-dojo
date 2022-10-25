function test() {
  console.log(`getNumberForCommand([1,5,2,6,3,7,4], [2,5,3]): ${getNumberForCommand([1, 5, 2, 6, 3, 7, 4], [2, 5, 3])}`);
  console.log(`getNumbersForCommands([1,5,2,6,3,7,4], [[2,5,3],[4,4,1]]): ${getNumbersForCommands([1, 5, 2, 6, 3, 7, 4], [[2, 5, 3], [4, 4, 1]])}`);
}

function solution(array, commands) {
  // test();
  const answer = getNumbersForCommands(array, commands);
  return answer;
}

function getNumberForCommand(array, command) {
  return [...array].slice(command[0] - 1, command[1])
    .sort((a, b) => a - b)[command[2] - 1];
}

function getNumbersForCommands(array, commands) {
  return commands.map((command) => getNumberForCommand(array, command));
}
