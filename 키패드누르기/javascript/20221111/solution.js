const numberPosition = {
  0: [3, 1],
  1: [0, 0],
  2: [0, 1],
  3: [0, 2],
  4: [1, 0],
  5: [1, 1],
  6: [1, 2],
  7: [2, 0],
  8: [2, 1],
  9: [2, 2],
};

function test() {
  console.log(`numberPosition[1]: [0,0] = ${numberPosition[1]}`);

  console.log(`fingerPositions(1, [[3,0],[3,2]], 'left'): {finger: L, positions: [[0,0],[3,2]]} = ${JSON.stringify(fingerPositions(1, [[3, 0], [3, 2]], 'left'))}`);
  console.log(`fingerPositions(1, [[0,0],[3,2]], 'left'): {finger: L, positions: [[0,0],[3,2]]} = ${JSON.stringify(fingerPositions(1, [[0, 0], [3, 2]], 'left'))}`);
  console.log(`fingerPositions(5, [[0,0],[1,1]], 'left'): {finger: R, positions: [[0,0],[1,1]]} = ${JSON.stringify(fingerPositions(5, [[0, 0], [1, 1]], 'right'))}`);

  console.log(`distance(2, [3,0]): 4 = ${distance(2, [3, 0])}`);

  console.log(`whichFingers([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], 'right'): LRLLLRLLRRL = ${whichFingers([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], 'right')}`);
}

function solution(numbers, hand) {
  // test();
  const answer = whichFingers(numbers, hand);
  return answer;
}

function fingerPositions(number, currentPositions, preferredHand) {
  const leftHandModified = { finger: 'L', positions: [numberPosition[number], currentPositions[1]] };
  const rightHandModified = { finger: 'R', positions: [currentPositions[0], numberPosition[number]] };

  if ([1, 4, 7].includes(number)) {
    return leftHandModified;
  }

  if ([3, 6, 9].includes(number)) {
    return rightHandModified;
  }

  const leftHandDistance = distance(number, currentPositions[0]);
  const rightHandDistance = distance(number, currentPositions[1]);

  if (leftHandDistance === rightHandDistance) {
    if (preferredHand === 'left') {
      return leftHandModified;
    }

    return rightHandModified;
  }

  if (leftHandDistance < rightHandDistance) {
    return leftHandModified;
  }

  return rightHandModified;
}

function distance(number, position) {
  return [...Array(2).keys()]
    .reduce((sum, i) => sum + Math.abs(numberPosition[number][i] - position[i]), 0);
}

function whichFingers(numbers, hand) {
  return numbers
    .reduce((acc, number, i) => {
      if (i === 0) {
        return [fingerPositions(number, [[3, 0], [3, 2]], hand)];
      }
      return [...acc, fingerPositions(number, acc[acc.length - 1].positions, hand)];
    }, []).reduce((acc, positions) => acc + positions.finger, '');
}
