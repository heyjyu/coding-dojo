function test() {
  const board1 = [[0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 0], [0, 0, 0, 3, 0, 3], [0, 0, 2, 5, 0, 1], [0, 0, 2, 4, 4, 2], [0, 0, 5, 1, 3, 1]];
  const moves = [4, 6];

  console.log(`countPopped(board,moves): 2 = ${countPopped(board1, moves)}`);

  const board2 = [[0, 0, 0, 0, 0], [0, 0, 1, 0, 3], [0, 2, 5, 0, 1], [4, 2, 4, 4, 2], [3, 5, 1, 3, 1]];
  const bag = [];
  const move = 1;
  const count = 0;
  console.log(`process({board,bag,move,count}): {board: [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[0,2,4,4,2],[3,5,1,3,1]], bag: [4], count:0} = ${JSON.stringify(process({
    board: board2, bag, move, count,
  }))}`);
}

function solution(board, moves) {
  // test();
  const answer = countPopped(board, moves);
  return answer;
}

function countPopped(board, moves) {
  return moves.reduce(({ board, bag, count }, move) => process({
    board, bag, move, count,
  }), { board, bag: [], count: 0 }).count;
}

function process({
  board, bag, move, count,
}) {
  const dollRow = [...Array(board.length).keys()]
    .find((row) => board[row][move - 1] > 0);

  if (dollRow === undefined) {
    return { board, bag, count };
  }

  const value = board[dollRow][move - 1];

  board[dollRow][move - 1] = 0;

  if (bag[bag.length - 1] === value) {
    return { board, bag: bag.slice(0, bag.length - 1), count: count + 2 };
  }

  return { board, bag: [...bag, value], count };
}
