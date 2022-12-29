function test() {
  console.log(`isRemovable("baabaa"): 1 = ${isRemovable('baabaa')}`);
  console.log(`isRemovable("cdcd"): 0 = ${isRemovable('cdcd')}`);
}

function solution(s) {
  // test();

  const answer = isRemovable(s);

  return answer;
}

function isRemovable(string) {
  const stack = [];

  string.split('')
    .forEach((character) => {
      if (stack.length === 0) {
        stack.push(character);

        return;
      }

      if (stack[stack.length - 1] === character) {
        stack.pop();

        return;
      }

      stack.push(character);
    });

  return stack.length === 0 ? 1 : 0;
}
