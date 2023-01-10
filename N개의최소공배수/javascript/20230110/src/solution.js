function test() {
  console.log(`GCD(2,6): 2 = ${GCD(2, 6)}`);
  console.log(`GCD(2,14): 2 = ${GCD(2, 14)}`);

  console.log(`LCM(2,14): 14 = ${LCM(2, 14)}`);

  console.log(`LCMOfArray([1,2,3]): 6 = ${LCMOfArray([1, 2, 3])}`);
}

function solution(arr) {
  test();
  const answer = LCMOfArray(arr);
  return answer;
}

function GCD(x, y) {
  const min = x > y ? y : x;

  let divisor = 1;

  for (let i = 1; i < min + 1; i += 1) {
    if (x % i === 0 && y % i === 0) {
      divisor = i;
    }
  }

  return divisor;
}

function LCM(x, y) {
  return (x * y) / GCD(x, y);
}

function LCMOfArray(array) {
  let multiple = 1;

  for (let i = 0; i < array.length; i += 1) {
    multiple = LCM(multiple, array[i]);
  }

  return multiple;
}
