import java.util.*;
import java.util.stream.*;

class Solution {
    public void test() {
        System.out.println("removeDuplicate(new String[]{\"muzi frodo\",\"muzi frodo\",\"apeach frodo\",\"frodo neo\",\"muzi neo\",\"apeach muzi\"}: [apeach frodo, muzi frodo, apeach muzi, frodo neo, muzi neo] = )" + removeDuplicate(new String[]{"muzi frodo","muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}).toString());

        System.out.println("removeDuplicate(new String[]{\"ryan con\", \"ryan con\", \"ryan con\", \"ryan con\"}) : [ryan con] = " + removeDuplicate(new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}));

        System.out.println("reportedCounts(new String[]{\"muzi\", \"frodo\", \"apeach\", \"neo\"}, new String[]{\"muzi frodo\",\"apeach frodo\",\"frodo neo\",\"muzi neo\",\"apeach muzi\"}): [1, 2, 0, 2] = " + reportedCounts(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}));

        System.out.println("reportedCounts(new String[]{\"con\",\"ryan\"}, new String[]{\"ryan con\", \"ryan con\", \"ryan con\", \"ryan con\"}) : [1,0] = " + reportedCounts(new String[]{"con","ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}));

        System.out.println("reportedCounts(new String[]{\"muzi\", \"frodo\", \"apeach\", \"neo\"}, new String[]{\"muzi frodo\", \"apeach frodo\", \"apeach neo\", \"muzi neo\"}): [0,2,0,2] = " + reportedCounts(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "apeach neo", "muzi neo"}));

        System.out.println("bannedUser(new String[]{\"muzi\", \"frodo\", \"apeach\", \"neo\"}, new String[]{\"muzi frodo\",\"apeach frodo\",\"frodo neo\",\"muzi neo\",\"apeach muzi\"}, 2): [frodo, neo] = " + bannedUser(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2));

        System.out.println("bannedUserReport(new String[]{\"muzi\", \"frodo\", \"apeach\", \"neo\"}, new String[]{\"muzi frodo\",\"apeach frodo\",\"frodo neo\",\"muzi neo\",\"apeach muzi\"}, 2): [muzi frodo, apeach frodo, frodo neo, muzi neo] = " + bannedUserReport(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2));

        System.out.println("bannedUserReport(new String[]{\"muzi\", \"frodo\", \"apeach\", \"neo\"}, new String[]{\"muzi frodo\", \"muzi frodo\", \"apeach frodo\", \"apeach neo\", \"muzi neo\"}, 1): [\"muzi frodo\", \"apeach frodo\", \"apeach neo\", \"muzi neo\"] = " + bannedUserReport(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "apeach neo", "muzi neo"}, 1));

        System.out.println("receivedMailCount(new String[]{\"muzi\", \"frodo\", \"apeach\", \"neo\"}, new String[]{\"muzi frodo\",\"apeach frodo\",\"frodo neo\",\"muzi neo\",\"apeach muzi\"}, 2): [2,1,1,0] = " + receivedMailCount(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2)[0]);

        System.out.println("receivedMailCount(new String[]{\"muzi\", \"frodo\", \"apeach\", \"neo\"}, new String[]{\"muzi frodo\", \"apeach frodo\", \"apeach neo\", \"muzi neo\"}, 1): [2,0,2,0] = " + receivedMailCount(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "apeach neo", "muzi neo"}, 1)[3]);
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        // test();
        int[] answer = receivedMailCount(id_list, report, k);
        return answer;
    }

    public List<String> removeDuplicate(String[] report) {
        return Arrays.stream(report).distinct().collect(Collectors.toList());
    }

    public List<Integer> reportedCounts(String[] id_list, String[] reports) {
        List<String> reportedUser = removeDuplicate(reports).stream()
                .map(report -> report.split(" ")[1])
                .collect(Collectors.toList());

        return IntStream.range(0, id_list.length)
                .map(i -> reportedUser.stream().filter(userId -> userId.equals(id_list[i])).toArray().length)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<String> bannedUser(String[] id_list, String[] report, int k) {
        List<Integer> reportedCount = reportedCounts(id_list, report);

        int[] reportedId = IntStream.range(0, id_list.length)
                .filter(i -> reportedCount.get(i) >= k)
                .toArray();

        return Arrays.stream(reportedId)
                .mapToObj(i -> id_list[i])
                .collect(Collectors.toList());
    }

    public List<String> bannedUserReport(String[] id_list, String[] reports, int k) {
        List<String> bannedUsers = bannedUser(id_list, reports, k);

        return removeDuplicate(reports)
                .stream()
                .filter(report -> {
                    return bannedUsers.stream()
                            .filter(user -> report.endsWith(" " + user))
                            .count() > 0;})
                .collect(Collectors.toList());
    }

    public int[] receivedMailCount(String[] id_list, String[] reports, int k) {
        List<String> bannedUserReports = bannedUserReport(id_list, reports, k);

        int[] counts = new int[id_list.length];

        return Arrays.stream(id_list)
                .mapToInt(id -> {
                    return bannedUserReports.stream()
                            .filter(report -> report.startsWith(id + " "))
                            .toArray().length;
                })
                .toArray();
    }
}
