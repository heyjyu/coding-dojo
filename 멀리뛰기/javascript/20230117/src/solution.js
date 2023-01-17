function test() {
  console.log(`remainder(1): 1 = ${remainder(1)}`);
  console.log(`remainder(2): 2 = ${remainder(2)}`);
  console.log(`remainder(4): 5 = ${remainder(4)}`);
}

function solution(n) {
  // test();
  const answer = remainder(n);
  return answer;
}

function remainder(n) {
  const array = new Array(n + 1);

  array[0] = 1;
  array[1] = 2;

  for (let i = 2; i < n; i += 1) {
    array[i] = (array[i - 2] + array[i - 1]) % 1234567;
  }

  return array[n - 1];
}
