function test() {
  console.log(`distinctReports(["ryan con", "ryan con", "ryan con", "ryan con"]): ["ryan con"] = ${distinctReports(['ryan con', 'ryan con', 'ryan con', 'ryan con'])}`);

  console.log(`splitReports(["ryan con","muzi frodo"]): [[ryan, con],[muzi, frodo]] = ${JSON.stringify(splitReports(['ryan con', 'muzi frodo']))}`);

  console.log(`reportedCounts(["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]): {frodo: 2, neo: 2, muzi:1} = ${[...reportedCounts(['muzi frodo', 'apeach frodo', 'frodo neo', 'muzi neo', 'apeach muzi'])]}`);

  console.log(`mailCounts(["muzi", "frodo", "apeach", "neo"],["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"],2): [2,1,1,0] = ${mailCounts(['muzi', 'frodo', 'apeach', 'neo'], ['muzi frodo', 'apeach frodo', 'frodo neo', 'muzi neo', 'apeach muzi'], 2)}`);
}

function solution(id_list, reports, k) {
  // test();
  const answer = mailCounts(id_list, reports, k);
  return answer;
}

function distinctReports(reports) {
  return [...new Set(reports)];
}

function splitReports(reports) {
  return reports.map((report) => report.split(' '));
}

function reportedCounts(reports) {
  const reportedCountsMap = new Map();

  splitReports(distinctReports(reports))
    .forEach(([reporter, reportedUser]) => {
      reportedCountsMap.set(reportedUser, (reportedCountsMap.get(reportedUser) ?? 0) + 1);
    });

  return reportedCountsMap;
}

function mailCounts(id_list, reports, k) {
  const mailCountsMap = new Map();

  const reportedCountsMap = reportedCounts(reports);

  splitReports(distinctReports(reports))
    .forEach(([reporter, reportedUser]) => {
      if (reportedCountsMap.get(reportedUser) >= k) {
        mailCountsMap.set(reporter, (mailCountsMap.get(reporter) ?? 0) + 1);
      }
    });

  return id_list.map((id) => mailCountsMap.get(id) ?? 0);
}
