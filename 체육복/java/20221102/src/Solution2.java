import java.util.*;
import java.util.stream.*;

class Solution2 {
    public void test() {
        System.out.println("lenders(List.of(1,4), List.of(1,3,5)): new int[]{3,5} = " + lenders(List.of(1, 4), List.of(1, 3, 5)).toString());

        System.out.println("losts(List.of(1,4), List.of(1,3,5)): new int[]{4} = " + losts(List.of(1, 4), List.of(1, 3, 5)).toString());

        System.out.println("noSuitCount(5, new int[]{2, 4}, new int[]{1, 3, 5}): 0 = " + noSuitCount(5, new int[]{2, 4}, new int[]{1, 3, 5}));

        System.out.println("noSuitCount(4, new int[]{2, 3}, new int[]{3, 4}): 1 = " + noSuitCount(4, new int[]{2, 3}, new int[]{3, 4}));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        // test();
        int answer = n - noSuitCount(n, lost, reserve);
        return answer;
    }

    public List<Integer> lenders(List<Integer> lostList, List<Integer> reserveList) {
        return reserveList.stream()
                .filter(i -> !lostList.contains(i))
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> losts(List<Integer> lostList, List<Integer> reserveList) {
        return lostList.stream()
                .filter(i -> !reserveList.contains(i))
                .sorted()
                .collect(Collectors.toList());
    }

    public int noSuitCount(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        List<Integer> reserveStudents = lenders(lostList, reserveList);
        List<Integer> lostStudents = losts(lostList, reserveList);
        List<Integer> lentStudents = new ArrayList<>();

        lostStudents.stream()
                .forEach(i -> {
                    if (!lentStudents.contains(i - 1) && reserveStudents.contains(i - 1)) {
                        lentStudents.add(i - 1);

                        return;
                    }

                    if (!lentStudents.contains(i + 1) && reserveStudents.contains(i + 1)) {
                        lentStudents.add(i + 1);
                    }
                });

        return lostStudents.size() - lentStudents.size();
    }
}
