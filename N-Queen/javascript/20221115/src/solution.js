function test() {
  console.log(`possible(0, [2,0,0,0]): true = ${possible(0, [2, 0, 0, 0])}`);
  console.log(`possible(1, [1,3,0,0]): true = ${possible(1, [1, 3, 0, 0])}`);
  console.log(`possible(1, [1,2,0,0]): false = ${possible(1, [1, 2, 0, 0])}`);
  console.log(`possible(1, [1,1,0,0]): false = ${possible(1, [1, 1, 0, 0])}`);
  console.log(`possible(1, [2,1,0,0]): false = ${possible(1, [2, 1, 0, 0])}`);

  console.log(`backtrack(0, [0,0,0,0]): 2 = ${backtrack(0, [0, 0, 0, 0])}`);
}

function solution(n) {
  // test();
  const answer = backtrack(0, [...Array(n)].fill(0));
  return answer;
}

function backtrack(level, array) {
  let count = 0;

  if (level === array.length) {
    return 1;
  }

  for (let i = 0; i < array.length; i += 1) {
    array[level] = i;
    if (possible(level, array)) {
      count += backtrack(level + 1, array);
    }
  }

  return count;
}

function possible(level, array) {
  for (let i = 0; i < level; i += 1) {
    if (array[i] === array[level] || Math.abs(array[i] - array[level]) === Math.abs(i - level)) {
      return false;
    }
  }

  return true;
}
