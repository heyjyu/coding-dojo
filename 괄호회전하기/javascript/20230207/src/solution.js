function test() {
  console.log(`rotate(0,"[](){}"): [](){} = ${rotate(0, '[](){}')}`);
  console.log(`rotate(1,"[](){}"): ](){}[ = ${rotate(1, '[](){}')}`);

  console.log(`matched("(",")"): true = ${matched('(', ')')}`);

  console.log(`isProperString("[](){}"): true = ${isProperString('[](){}')}`);
  console.log(`isProperString("}}}"): false = ${isProperString('}}}')}`);

  console.log(`countAllCases("[](){}"): 3 = ${countAllCases('[](){}')}`);
}

function solution(s) {
  // test();
  const answer = countAllCases(s);
  return answer;
}

function rotate(x, string) {
  return string.substring(x) + string.substring(0, x);
}

function matched(x, y) {
  if (x === '(') {
    if (y === ')') {
      return true;
    }
  }

  if (x === '{') {
    if (y === '}') {
      return true;
    }
  }

  if (x === '[') {
    if (y === ']') {
      return true;
    }
  }

  return false;
}

function isProperString(string) {
  const stack = [];

  for (let i = 0; i < string.length; i += 1) {
    if (stack.length === 0) {
      stack.push(string[i]);
      continue;
    }

    if (stack.length !== 0 && matched(stack[stack.length - 1], string[i])) {
      stack.pop();
      continue;
    }

    stack.push(string[i]);
  }

  return stack.length === 0;
}

function countAllCases(string) {
  let count = 0;

  for (let i = 0; i < string.length; i += 1) {
    if (isProperString(rotate(i, string))) {
      count += 1;
    }
  }

  return count;
}
