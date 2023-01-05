function test() {
  console.log(`twoPeopleAvailable([50,50,70,80], 100): false = ${twoPeopleAvailable([50, 50, 70, 80], 100)}`);
  console.log(`twoPeopleAvailable([50,50,70,80], 130): true = ${twoPeopleAvailable([50, 50, 70, 80], 130)}`);
  console.log(`twoPeopleAvailable([50,50], 100): true = ${twoPeopleAvailable([50, 50], 100)}`);

  console.log(`countBoats([70,50,80,50], 100): 3 = ${countBoats([70, 50, 80, 50], 100)}`);
  console.log(`countBoats([70,50,80], 100): 3 = ${countBoats([70, 50, 80], 100)}`);
  console.log(`countBoats([70,50,80], 130): 2 = ${countBoats([70, 50, 80], 130)}`);
  console.log(`countBoats([50,50,50,50], 100): 2 = ${countBoats([50, 50, 50, 50], 100)}`);
  console.log(`countBoats([50], 70): 1 = ${countBoats([50], 70)}`);
  console.log(`countBoats([30,40,50,60], 100): 2 = ${countBoats([30, 40, 50, 60], 100)}`);
}

function solution(people, limit) {
  test();
  const answer = countBoats(people, limit);
  return answer;
}

function twoPeopleAvailable(sortedPeople, limit) {
  if (sortedPeople.length < 2) {
    return false;
  }

  if (sortedPeople[0] + sortedPeople[sortedPeople.length - 1] > limit) {
    return false;
  }

  return true;
}

function countBoats(people, limit) {
  const sortedPeople = [...people].sort((a, b) => a - b);
  let count = 0;

  while (sortedPeople.length > 0) {
    if (twoPeopleAvailable(sortedPeople, limit)) {
      sortedPeople.shift();
    }

    sortedPeople.pop();
    count += 1;
  }

  return count;
}
