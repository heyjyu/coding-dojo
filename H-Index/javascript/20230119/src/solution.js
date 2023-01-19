function test() {
  console.log(`hIndex([3, 0, 6, 1, 5]): 3 = ${hIndex([3, 0, 6, 1, 5])}`);
  console.log(`hIndex([0, 2, 3]): 2 = ${hIndex([0, 2, 3])}`);
  console.log(`hIndex([0, 2, 0]): 1 = ${hIndex([0, 2, 0])}`);
}

function solution(citations) {
  test();
  const answer = hIndex(citations);
  return answer;
}

function hIndex(citations) {
  const copy = [...citations].sort((a, b) => b - a);

  let index = 0;
  for (let i = 0; i < copy.length; i += 1) {
    if (copy[i] >= i + 1) {
      index += 1;
    }
  }

  return index;
}
