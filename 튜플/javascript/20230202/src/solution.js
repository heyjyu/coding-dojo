function test() {
  console.log(`getElements("{{2},{2,1},{2,1,3},{2,1,3,4}}"): ["2","2,1","2,1,3","2,1,3,4"] = ${JSON.stringify(getElements('{{2},{2,1},{2,1,3},{2,1,3,4}}'))}`);

  console.log(`getTuple("{{2},{2,1},{2,1,3},{2,1,3,4}}"): [2,1,3,4] = ${getTuple('{{2},{2,1},{2,1,3},{2,1,3,4}}')}`);
}

function solution(s) {
  // test();
  const answer = getTuple(s);
  return answer;
}

function getElements(string) {
  return string.substring(2, string.length - 2).split('},{');
}

function getTuple(string) {
  const set = new Set();
  const tuple = [];

  const sortedElements = getElements(string).sort((a, b) => a.length - b.length);

  sortedElements.map((element) => element.split(',').forEach((value) => {
    const numberOfElements = set.size;
    set.add(value);

    if (numberOfElements < set.size) {
      tuple.push(Number(value));
    }
  }));

  return tuple;
}
