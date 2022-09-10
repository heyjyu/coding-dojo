import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        String[] reportsWithoutRepeat = (new HashSet<>(Arrays.asList(reports))).toArray(new String[0]);
        HashMap<String, List<String>> map = new HashMap<>();

        for (String report : reportsWithoutRepeat) {
            String[] users = report.split(" ");
            String reporter = users[0];
            String reportedPerson = users[1];

            if (map.get(reportedPerson) != null) {
                List<String> reporters = map.get(reportedPerson);
                reporters.add(reporter);
                map.put(reportedPerson, reporters);
            }

            if (map.get(reportedPerson) == null) {
                List<String> reporters = new ArrayList<>();
                reporters.add(reporter);
                map.put(reportedPerson, reporters);
            }
        }

        String[] reportedPeople = map.keySet().toArray(new String[0]);
        int[] answer = new int[id_list.length];

        for (String reportedPerson : reportedPeople) {
            List<String> reporters = map.get(reportedPerson);

            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    for (int i = 0; i < id_list.length; i += 1) {
                        if (reporter.equals(id_list[i])) {
                            answer[i] += 1;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
