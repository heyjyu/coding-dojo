import java.util.*;
import java.util.stream.*;

class Solution {
    public void test() {
        System.out.println("lenders(new int[]{1, 4}, new int[]{1, 3, 5}): new int[]{3,5} = " + lenders(new int[]{1, 4}, new int[]{1, 3, 5}).toString());

        System.out.println("losts(new int[]{1, 4}, new int[]{1, 3, 5}): new int[]{4} = " + losts(new int[]{1, 4}, new int[]{1, 3, 5}).toString());
        
        System.out.println("noSuitCount(5, new int[]{2, 4}, new int[]{1, 3, 5}): 0 = " + noSuitCount(5, new int[]{2, 4}, new int[]{1, 3, 5}));

        System.out.println("noSuitCount(4, new int[]{2, 3}, new int[]{3, 4}): 1 = " + noSuitCount(4, new int[]{2, 3}, new int[]{3, 4}));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        // test();
        int answer = n - noSuitCount(n, lost, reserve);
        return answer;
    }

    public List<Integer> lenders(int[] lost, int[] reserve) {
        List<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());

        return reserveList.stream()
                .filter(i -> !lostList.contains(i))
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> losts(int[] lost, int[] reserve) {
        List<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());

        return lostList.stream()
                .filter(i -> !reserveList.contains(i))
                .sorted()
                .collect(Collectors.toList());
    }

    public int noSuitCount(int n, int[] lost, int[] reserve) {
        List<Integer> lendedStudents = new ArrayList<>();
        List<Integer> reserveStudents = lenders(lost, reserve);
        List<Integer> lostStudents = losts(lost, reserve);

        for (int i : lostStudents) {
            if (!lendedStudents.contains(i - 1) && reserveStudents.contains(i - 1)) {
                lendedStudents.add(i - 1);

                continue;
            }

            if (!lendedStudents.contains(i + 1) && reserveStudents.contains(i + 1)) {
                lendedStudents.add(i + 1);

                continue;
            }
        }

        return lostStudents.size() - lendedStudents.size();
    }
}
