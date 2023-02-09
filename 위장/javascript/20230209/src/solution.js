function test() {
  console.log(`convertToObject([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]): {headgear:["yellow_hat","green_turban"], eyewear: ["blue_sunglasses"]} = ${JSON.stringify(convertToObject([['yellow_hat', 'headgear'], ['blue_sunglasses', 'eyewear'], ['green_turban', 'headgear']]))}`);

  console.log(`countAllPossibilities([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]): 5 = ${countAllPossibilities([['yellow_hat', 'headgear'], ['blue_sunglasses', 'eyewear'], ['green_turban', 'headgear']])}`);
}

function solution(clothes) {
  // test();
  const answer = countAllPossibilities(clothes);
  return answer;
}

function convertToObject(clothes) {
  const object = {};

  clothes.forEach(([name, type]) => {
    const previousArray = object[type] || [];
    object[type] = [...previousArray, name];
  });

  return object;
}

function countAllPossibilities(clothes) {
  const object = convertToObject(clothes);
  const keys = Object.keys(object);

  let count = 1;

  keys.forEach((key) => { count *= (object[key].length + 1); });

  return count - 1;
}
