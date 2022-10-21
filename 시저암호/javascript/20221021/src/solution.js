function solution(s, n) {
  const answer = convert({ string: s, times: n });
  return answer;
}

export function moveCharacter({ character, times }) {
  const lastCharCode = character === character.toLowerCase()
    ? 'z'.charCodeAt(0)
    : 'Z'.charCodeAt(0);

  return lastCharCode > character.charCodeAt(0) + times
    ? String.fromCharCode(character.charCodeAt(0) + times)
    : String.fromCharCode(character.charCodeAt(0) + times - 26);
}

export default function convert({ string, times }) {
  return string.replaceAll(/\w/g, (character) => moveCharacter({ character, times }));
}
