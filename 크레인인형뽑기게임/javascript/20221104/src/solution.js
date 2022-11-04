function test() {
  const board = [[0, 0, 0, 0, 0], [0, 0, 1, 0, 3], [0, 2, 5, 0, 1], [4, 2, 4, 4, 2], [3, 5, 1, 3, 1]];
  const moves = [1, 4];

  console.log(`process(board,moves): 2 = ${process(board, moves)}`);
}

function solution(board, moves) {
  // test();
  const answer = process(board, moves);
  return answer;
}

function process(board, moves) {
  let count = 0;
  let bag = [];

  for (i of moves) {
    for (let j = 0; j < board.length; j += 1) {
      const value = board[j][i - 1];

      if (value > 0) {
        board[j][i - 1] = 0;

        if (bag[bag.length - 1] === value) {
          bag.pop();
          count += 2;
          break;
        }

        bag = [...bag, value];

        break;
      }
    }
  }

  return count;
}
