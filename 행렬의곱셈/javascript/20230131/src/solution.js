function test() {
  console.log(`computeRow([[1, 4], [3, 2], [4, 1]], [[3, 3], [3, 3]], 0): [15,15] = ${computeRow([[1, 4], [3, 2], [4, 1]], [[3, 3], [3, 3]], 0)}`);
  console.log(`computeRow([[2, 3, 2], [4, 2, 4], [3, 1, 4]], [[5, 4, 3], [2, 4, 1], [3, 1, 1]], 0): [22,22,11] = ${computeRow([[2, 3, 2], [4, 2, 4], [3, 1, 4]], [[5, 4, 3], [2, 4, 1], [3, 1, 1]], 0)}`);

  console.log(`compute([[1, 4], [3, 2], [4, 1]], [[3, 3], [3, 3]]): [[15, 15], [15, 15], [15, 15]] = ${JSON.stringify(compute([[1, 4], [3, 2], [4, 1]], [[3, 3], [3, 3]]))}`);
}

function solution(arr1, arr2) {
  // test();
  const answer = compute(arr1, arr2);
  return answer;
}

function computeRow(arr1, arr2, row) {
  const result = [];

  const columnLength = arr2[0].length;

  for (let i = 0; i < columnLength; i += 1) {
    let sum = 0;

    for (let j = 0; j < arr1[0].length; j += 1) {
      sum += arr1[row][j] * arr2[j][i];
    }

    result.push(sum);
  }

  return result;
}

function compute(arr1, arr2) {
  const result = [];

  for (let i = 0; i < arr1.length; i += 1) {
    result.push(computeRow(arr1, arr2, i));
  }

  return result;
}
