const map = {
  zero: '0',
  one: '1',
  two: '2',
  three: '3',
  four: '4',
  five: '5',
  six: '6',
  seven: '7',
  eight: '8',
  nine: '9',
};

function test() {
  console.log(`replaceCharacter('one4'): 14 = ${replaceCharacter('one4')}`);
  console.log(`replaceCharacter('oneoneoneone'): 1111 = ${replaceCharacter('oneoneoneone')}`);
}

function solution(s) {
  // test();
  const answer = replaceCharacter(s);
  return answer;
}

function replaceCharacter(string) {
  return parseInt(Object.keys(map)
    .reduce((acc, key) => acc.replaceAll(key, map[key]), string), 10);
}
