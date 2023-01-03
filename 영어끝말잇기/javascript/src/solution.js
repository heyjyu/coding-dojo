function test() {
  console.log(`failedIndex(["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]): 8 = ${
    failedIndex(['tank', 'kick', 'know', 'wheel', 'land', 'dream', 'mother', 'robot', 'tank'])}`);
  console.log(`failedIndex(["tank", "k", "know", "wheel", "land", "dream", "mother", "robot", "tank"]): 1 = ${
    failedIndex(['tank', 'k', 'know', 'wheel', 'land', 'dream', 'mother', 'robot', 'tank'])}`);
  console.log(`failedIndex(["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"]): 1 = ${
    failedIndex(['hello', 'observe', 'effect', 'take', 'either', 'recognize', 'encourage', 'ensure', 'establish', 'hang', 'gather', 'refer', 'reference', 'estimate', 'executive'])}`);

  console.log(`numberOfFailedPerson(8, 3): 3 = ${numberOfFailedPerson(8, 3)}`);
  console.log(`numberOfFailedPerson(-1, 3): 0 = ${numberOfFailedPerson(-1, 3)}`);
  console.log(`numberOfFailedPerson(4, 2): 1 = ${numberOfFailedPerson(4, 2)}`);

  console.log(`failedRound(8, 3): 3 = ${failedRound(8, 3)}`);
  console.log(`failedRound(-1, 3): 0 = ${failedRound(-1, 3)}`);
  console.log(`failedRound(4, 2): 3 = ${failedRound(4, 2)}`);

  console.log(`getResult(3, ["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]): [3, 3] = ${
    getResult(3, ['tank', 'kick', 'know', 'wheel', 'land', 'dream', 'mother', 'robot', 'tank'])}`);
}

function solution(n, words) {
  test();
  const answer = [];

  return answer;
}

function failedIndex(words) {
  for (let i = 0; i < words.length; i += 1) {
    if (words[i].length < 2) {
      return i;
    }

    const lastWord = words[i - 1];

    if (i > 0 && lastWord[lastWord.length - 1] !== words[i][0]) {
      return i;
    }

    if (words.slice(0, i).includes(words[i])) {
      return i;
    }
  }

  return -1;
}

function numberOfFailedPerson(failedIndex, n) {
  if (failedIndex < 0) {
    return 0;
  }

  return (failedIndex % n) + 1;
}

function failedRound(failedIndex, n) {
  if (failedIndex < 0) {
    return 0;
  }

  return Math.floor(failedIndex / n) + 1;
}

function getResult(n, words) {
  const index = failedIndex(words);

  return [numberOfFailedPerson(index, n), failedRound(index, n)];
}
