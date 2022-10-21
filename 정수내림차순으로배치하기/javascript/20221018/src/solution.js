function solution(n) {
  const answer = sort(n);
  return answer;
}

export function sort(n) {
  return parseInt(n.toString()
    .split('')
    .sort()
    .reverse()
    .join(''), 10);
}
