function test() {
  console.log(`removeDuplicates(["ryan con", "ryan con", "ryan con", "ryan con"]): ["ryan con"] = ${removeDuplicates(['ryan con', 'ryan con', 'ryan con', 'ryan con'])}`);

  console.log(`receivedMailCounts(["muzi", "frodo", "apeach", "neo"], ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"], 2): [2,1,1,0] = ${receivedMailCounts(['muzi', 'frodo', 'apeach', 'neo'], ['muzi frodo', 'apeach frodo', 'frodo neo', 'muzi neo', 'apeach muzi'], 2)}`);
}

function solution(id_list, reports, k) {
  // test();
  const answer = receivedMailCounts(id_list, reports, k);
  return answer;
}

function removeDuplicates(reports) {
  return [...new Set(reports)];
}

function receivedMailCounts(id_list, reports, k) {
  const distinctReports = new Map();

  removeDuplicates(reports)
    .forEach((report) => {
      const [reporter, reportedUser] = report.split(' ');
      distinctReports.set(reportedUser, distinctReports.get(reportedUser)
        ? [...distinctReports.get(reportedUser), reporter]
        : [reporter]);
    });

  return [...Array(id_list.length).keys()]
    .map((i) => (
      [...distinctReports.keys()]
        .filter((reportedUser) => {
          const reporters = distinctReports.get(reportedUser);
          return reporters.length >= k && reporters.includes(id_list[i]);
        }).length
    ));
}
