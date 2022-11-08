import java.util.*;
import java.util.stream.*;

class Solution2 {
    public void test() {
        System.out.println("distinctReports(new String[]{\"ryan con\", \"ryan con\", \"ryan con\", \"ryan con\"}): [ryan con] = " + distinctReports(new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}));

        System.out.println("reportedCounts(new String[]{\"muzi frodo\",\"apeach frodo\",\"frodo neo\",\"muzi neo\",\"apeach muzi\"}): {frodo= 2, neo= 2, muzi= 1}" + reportedCounts(new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}));

        System.out.println("receivedMailCounts(new String[] {\"muzi\", \"frodo\", \"apeach\", \"neo\"}, new String[]{\"muzi frodo\",\"apeach frodo\",\"frodo neo\",\"muzi neo\",\"apeach muzi\"},2): [2,1,1,0]" + Arrays.stream(receivedMailCounts(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)).boxed().collect(Collectors.toList()));
    }

    public int[] solution(String[] id_list, String[] reports, int k) {
        // test();
        int[] answer = receivedMailCounts(id_list, reports, k);
        return answer;
    }

    public List<String> distinctReports(String[] reports) {
        return Arrays.stream(reports).distinct().collect(Collectors.toList());
    }

    public Map<String, Integer> reportedCounts(String[] reports) {
        Map<String, Integer> reportedCountsMap = new HashMap<>();

        distinctReports(reports).stream()
                .forEach(report -> {
                    String reporter = report.split(" ")[0];
                    String reportedUser = report.split(" ")[1];

                    reportedCountsMap.put(reportedUser, reportedCountsMap.getOrDefault(reportedUser, 0) + 1);
                });

        return reportedCountsMap;
    }

    public int[] receivedMailCounts(String[] id_list, String[] reports, int k) {
        Map<String, Integer> receivedMailCountsMap = new HashMap<>();
        Map<String, Integer> reportedCountsMap = reportedCounts(reports);

        distinctReports(reports).stream()
                .forEach(report -> {
                    String reporter = report.split(" ")[0];
                    String reportedUser = report.split(" ")[1];

                    if (reportedCountsMap.get(reportedUser) >= k) {
                        receivedMailCountsMap.put(reporter, receivedMailCountsMap.getOrDefault(reporter, 0) + 1);
                    }
                });

        return Arrays.stream(id_list).mapToInt(id -> receivedMailCountsMap.getOrDefault(id, 0)).toArray();
    }
}
