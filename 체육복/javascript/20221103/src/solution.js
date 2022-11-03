function test() {
  console.log(`initialCounts(3, [3], [1]): [2,1,0] = ${initialCounts(3, [3], [1])}`);
  console.log(`processedCounts([2,1,0]): [2,1,0] = ${processedCounts([2, 1, 0])}`);
  console.log(`processedCounts([2,0,2,0,2]): [1,1,1,1,2] = ${processedCounts([2, 0, 2, 0, 2])}`);
  console.log(`countParticipants(3, [3], [1]): 2 = ${countParticipants(3, [3], [1])}`);
}

function solution(n, lost, reserve) {
  // test();
  const answer = countParticipants(n, lost, reserve);
  return answer;
}

function initialCounts(n, lost, reserve) {
  return [...Array(n)]
    .fill(1)
    .map((count, i) => {
      if (lost.includes(i + 1)) {
        return count - 1;
      }

      return count;
    })
    .map((count, i) => {
      if (reserve.includes(i + 1)) {
        return count + 1;
      }

      return count;
    });
}

function processedCounts(counts) {
  return [...Array(counts.length).keys()]
    .filter((i) => counts[i] === 0)
    .reduce((acc, i) => {
      if (acc[i - 1] > 1) {
        return Object.values({ ...acc, [i - 1]: 1, [i]: 1 });
      }

      if (acc[i + 1] > 1) {
        return Object.values({ ...acc, [i]: 1, [i + 1]: 1 });
      }

      return acc;
    }, counts);
}

function countParticipants(n, lost, reserve) {
  return processedCounts(initialCounts(n, lost, reserve))
    .filter((count) => count > 0)
    .length;
}
