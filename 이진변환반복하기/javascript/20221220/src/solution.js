function test() {
  console.log(`convertToBase2(4): "100" = ${convertToBase2(4)}`);

  console.log(`convertTo1("01110"): [3,3] = ${convertTo1('01110')}`);
}

function solution(s) {
  // test();
  const answer = convertTo1(s);
  return answer;
}

function convertToBase2(number) {
  const list = [];

  while (number > 0) {
    const remainder = number % 2;
    list.push(remainder);
    number = (number - remainder) / 2;
  }

  return list.reverse().join('');
}

function convertTo1(string) {
  let convertCount = 0;
  let removedZeroCount = 0;

  while (string !== '1') {
    const countOfOne = string.split('')
      .filter((character) => character === '1')
      .length;

    removedZeroCount += string.length - countOfOne;

    convertCount += 1;

    string = convertToBase2(countOfOne);
  }

  return [convertCount, removedZeroCount];
}
