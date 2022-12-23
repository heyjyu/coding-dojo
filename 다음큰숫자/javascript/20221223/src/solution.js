function test() {
  console.log(`countOne('1011'): 3 = ${countOne('1011')}`);

  console.log(`nextNumber(78): 83 = ${nextNumber(78)}`);
}

function solution(n) {
  // test();
  const answer = nextNumber(n);
  return answer;
}

function countOne(string) {
  return string.split('')
    .filter((i) => i === '1')
    .length;
}

function nextNumber(number) {
  let next = number + 1;

  while (true) {
    if (countOne(number.toString(2)) === countOne(next.toString(2))) {
      return next;
    }

    next += 1;
  }
}
