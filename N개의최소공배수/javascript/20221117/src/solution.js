function test() {
  console.log(`greatestCommonDivisor(1,1): 1 = ${greatestCommonDivisor(1, 1)}`);
  console.log(`greatestCommonDivisor(2,1): 1 = ${greatestCommonDivisor(2, 1)}`);
  console.log(`greatestCommonDivisor(6,8): 2 = ${greatestCommonDivisor(6, 8)}`);

  console.log(`leastCommonMultiple(1,1): 1 = ${leastCommonMultiple(1, 1)}`);
  console.log(`leastCommonMultiple(2,7): 14 = ${leastCommonMultiple(2, 7)}`);
  console.log(`leastCommonMultiple(2,6): 6 = ${leastCommonMultiple(2, 6)}`);

  console.log(`leastCommonMultipleOfArray([2,6,8,14]): 168 = ${leastCommonMultipleOfArray([2, 6, 8, 14])}`);
}

function solution(arr) {
  // test();
  const answer = leastCommonMultipleOfArray(arr);
  return answer;
}

function greatestCommonDivisor(x, y) {
  if (x === y) {
    return x;
  }

  if (x > y) {
    if (x % y === 0) {
      return y;
    }

    return greatestCommonDivisor(y, x % y);
  }

  return greatestCommonDivisor(y, x);
}

function leastCommonMultiple(x, y) {
  return x * y / greatestCommonDivisor(x, y);
}

function leastCommonMultipleOfArray(array) {
  return array
    .reduce((result, number) => leastCommonMultiple(result, number));
}
