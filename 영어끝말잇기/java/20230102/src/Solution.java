import java.util.*;
import java.util.stream.*;

class Solution {
    public void test() {
        System.out.println("isDuplicated(new String[]{\"tank\", \"kick\", \"know\", \"wheel\", \"land\", \"dream\", \"mother\", \"robot\", \"tank\"}, 0): false = "
                + isDuplicated(new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}, 0));
        System.out.println("isDuplicated(new String[]{\"tank\", \"kick\", \"know\", \"wheel\", \"land\", \"dream\", \"mother\", \"robot\", \"tank\"}, 8): true = "
                + isDuplicated(new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}, 8));

        System.out.println("firstFailedIndex(new String[]{\"tank\", \"kick\", \"know\", \"wheel\", \"land\", \"dream\", \"mother\", \"robot\", \"tank\"}): 8 = "
                + firstFailedIndex(new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}));
        System.out.println("firstFailedIndex(new String[]{\"hello\", \"one\", \"even\", \"never\", \"now\", \"world\", \"draw\"}): 4 = "
                + firstFailedIndex(new String[]{"hello", "one", "even", "never", "now", "world", "draw"}));

        System.out.println("failedPersonIndex(8, 3): 3 = " + failedPersonIndex(8, 3));
        System.out.println("failedPersonIndex(7, 3): 2 = " + failedPersonIndex(7, 3));
        System.out.println("failedPersonIndex(-1, 3): 0 = " + failedPersonIndex(-1, 3));

        System.out.println("failedRound(-1, 3): 0 = " + failedRound(-1, 3));
        System.out.println("failedRound(8, 3): 3 = " + failedRound(8, 3));

        System.out.println("getResult(new String[]{\"tank\", \"kick\", \"know\", \"wheel\", \"land\", \"dream\", \"mother\", \"robot\", \"tank\"}, 3): {3, 3} = "
                + Arrays.stream(getResult(new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}, 3)).boxed().collect(Collectors.toList()));
    }

    public int[] solution(int n, String[] words) {
        test();
        int[] answer = getResult(words, n);

        return answer;
    }

    public boolean isDuplicated(String[] words, int index) {
        Map<String, Integer> wordsMap = new HashMap<>();

        for (int i = 0; i < index; i += 1) {
            int count = wordsMap.getOrDefault(words[index], 0);

            if (count > 0) {
                return true;
            }

            wordsMap.put(words[i], 1);
        }

        return false;
    }

    public int firstFailedIndex(String[] words) {
        for (int i = 0; i < words.length; i += 1) {
            if (words[i].length() < 2) {
                return i;
            }

            if (i == 0) {
                continue;
            }

            if (isDuplicated(words, i)) {
                return i;
            }

            String previousWord = words[i - 1];

            if (previousWord.charAt(previousWord.length() - 1) != words[i].charAt(0)) {
                return i;
            }
        }

        return -1;
    }

    public int failedPersonIndex(int firstFailedIndex, int n) {
        if (firstFailedIndex < 0) {
            return 0;
        }

        return firstFailedIndex % n + 1;
    }

    public int failedRound(int firstFailedIndex, int n) {
        if (firstFailedIndex < 0) {
            return 0;
        }

        return firstFailedIndex / n + 1;
    }

    public int[] getResult(String[] words, int n) {
        int index = firstFailedIndex(words);

        return new int[] {failedPersonIndex(index, n), failedRound(index, n)};
    }
}
