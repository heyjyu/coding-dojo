function test() {
  const dictionary = {};
  for (let i = 0; i < 26; i += 1) {
    dictionary[String.fromCharCode('A'.charCodeAt(0) + i)] = i + 1;
  }

  console.log(`wLength("K", dictionary): 1 = ${wLength('K', dictionary)}`);
  console.log(`wLength("KAKAO", dictionary): 1 = ${wLength('KAKAO', dictionary)}`);
  dictionary.KA = Object.keys(dictionary).length + 1;
  console.log(`wLength("AKAO", dictionary): 1 = ${wLength('AKAO', dictionary)}`);
  dictionary.AK = Object.keys(dictionary).length + 1;
  console.log(`wLength("KAO", dictionary): 2 = ${wLength('KAO', dictionary)}`);

  console.log(`findIndices("KAKAO"): [11,1,27,15] = ${findIndices('KAKAO')}`);
}

function solution(msg) {
  test();
  const answer = [];
  return answer;
}

function wLength(msg, dictionary) {
  if (dictionary[msg]) {
    return msg.length;
  }

  for (let i = 0; i < msg.length; i += 1) {
    if (!dictionary[msg.substring(0, i + 1)]) {
      return i;
    }
  }

  return -1;
}

function findIndices(msg) {
  let message = msg;
  const indices = [];

  const dictionary = {};
  for (let i = 0; i < 26; i += 1) {
    dictionary[String.fromCharCode('A'.charCodeAt(0) + i)] = i + 1;
  }

  while (message.length > 0) {
    const length = wLength(message, dictionary);
    const w = message.substring(0, length);
    indices.push(dictionary[w]);
    message = message.substring(length);
    if (message.length > 0) {
      dictionary[w + message.substring(0, 1)] = Object.keys(dictionary).length + 1;
    }
  }

  return indices;
}
