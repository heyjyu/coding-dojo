function test() {
  console.log(`additionOfWidthAndHeight(10): 7 = ${additionOfWidthAndHeight(10)}`);

  console.log(`multiplicationOfWidthAndHeight(10, 2): 12 = ${multiplicationOfWidthAndHeight(10, 2)}`);

  console.log(`widthAndHeight(10, 2): [4, 3] = ${widthAndHeight(10, 2)}`);
}

function solution(brown, yellow) {
  test();
  const answer = widthAndHeight(brown, yellow);
  return answer;
}

function additionOfWidthAndHeight(brown) {
  return brown / 2 + 2;
}

function multiplicationOfWidthAndHeight(brown, yellow) {
  return brown + yellow;
}

function widthAndHeight(brown, yellow) {
  const addition = additionOfWidthAndHeight(brown);
  const multiplication = multiplicationOfWidthAndHeight(brown, yellow);

  return [(addition + Math.sqrt(addition ** 2 - 4 * multiplication)) / 2,
    (addition - Math.sqrt(addition ** 2 - 4 * multiplication)) / 2];
}
