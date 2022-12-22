function test() {
  console.log('canAddUpToTarget(1, 15): true = '
  + `${canAddUpToTarget(1, 15)}`);
  console.log('canAddUpToTarget(2, 15): false = '
  + `${canAddUpToTarget(2, 15)}`);

  console.log(`countAllCases(15): 4 = ${countAllCases(15)}`);
}

function solution(n) {
  // test();
  const answer = countAllCases(n);
  return answer;
}

function canAddUpToTarget(start, target) {
  let sum = 0;

  for (let i = start; i < target + 1; i += 1) {
    sum += i;

    if (sum > target) {
      return false;
    }

    if (sum === target) {
      return true;
    }
  }

  return false;
}

function countAllCases(target) {
  let count = 0;

  for (let i = 1; i < target + 1; i += 1) {
    if (canAddUpToTarget(i, target)) {
      count += 1;
    }
  }

  return count;
}
