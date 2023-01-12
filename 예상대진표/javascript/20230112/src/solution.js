function test() {
  console.log(`isMatched(2,3): false = ${isMatched(2, 3)}`);
  console.log(`isMatched(2,4): false = ${isMatched(2, 4)}`);
  console.log(`isMatched(3,4): true = ${isMatched(3, 4)}`);

  console.log(`nextNumber(2): 1 = ${nextNumber(2)}`);
  console.log(`nextNumber(1): 1 = ${nextNumber(1)}`);

  console.log(`matchedRound(4, 7): 3 = ${matchedRound(4, 7)}`);
}

function solution(n, a, b) {
  test();

  const answer = matchedRound(a, b);

  return answer;
}

function isMatched(x, y) {
  const max = x > y ? x : y;
  const min = x > y ? y : x;

  if (max - min !== 1) {
    return false;
  }

  if (max % 2 === 0) {
    return true;
  }

  return false;
}

function nextNumber(number) {
  return Math.floor((number + 1) / 2);
}

function matchedRound(x, y) {
  let currentX = x;
  let currentY = y;
  let round = 1;

  while (!isMatched(currentX, currentY)) {
    currentX = nextNumber(currentX);
    currentY = nextNumber(currentY);

    round += 1;
  }

  return round;
}
