function test() {
  console.log(`matchedCount([44, 1, 0, 0, 31, 25],[31, 10, 45, 1, 6, 19]): 2 = ${matchedCount([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19])}`);

  console.log(`zeroCount([44, 1, 0, 0, 31, 25]): 2 = ${zeroCount([44, 1, 0, 0, 31, 25])}`);

  console.log(`rank(6): 1 = ${rank(6)}`);
  console.log(`rank(1): 6 = ${rank(1)}`);
  console.log(`rank(0): 6 = ${rank(0)}`);

  console.log(`highestAndLowestRank([44, 1, 0, 0, 31, 25],[31, 10, 45, 1, 6, 19]): [3,5] = ${highestAndLowestRank([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19])}`);
}

function solution(lottos, win_nums) {
  // test();
  const answer = highestAndLowestRank(lottos, win_nums);
  return answer;
}

function matchedCount(lottos, win_nums) {
  return lottos
    .filter((number) => win_nums.includes(number))
    .length;
}

function zeroCount(lottos) {
  return lottos
    .filter((number) => number === 0)
    .length;
}

function rank(count) {
  if (count === 2) {
    return 5;
  }
  if (count === 3) {
    return 4;
  }
  if (count === 4) {
    return 3;
  }
  if (count === 5) {
    return 2;
  }
  if (count === 6) {
    return 1;
  }

  return 6;
}

function highestAndLowestRank(lottos, win_nums) {
  const lowestMatchedCount = matchedCount(lottos, win_nums);
  const highestMatchedCount = lowestMatchedCount + zeroCount(lottos);

  return [rank(highestMatchedCount), rank(lowestMatchedCount)];
}
