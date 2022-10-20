function solution(s) {
  const answer = changeCase(s);
  return answer;
}

export function lowerCaseAtOddIndex(text) {
  return text.split('')
    .map((character, index) => (
      index % 2 === 0 ? character : character.toLowerCase()
    )).join('');
}

export function changeCase(string) {
  return string.toUpperCase().replace(/\w+/g, lowerCaseAtOddIndex);
}
