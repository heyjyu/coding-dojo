// eslint-disable-next-line import/prefer-default-export
export default function addDigits(n) {
  return [...`${n}`].map(Number).reduce((a, b) => a + b);
}

function solution(n) {
  const answer = addDigits(n);

  return answer;
}
