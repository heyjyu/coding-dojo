import java.util.*;
import java.util.stream.*;

class Solution {
    public void test() {
        System.out.println("numberPosition(1): [0,0] = " + numberPosition(1));
        System.out.println("numberPosition(5): [1,1] = " + numberPosition(5));
        System.out.println("numberPosition(0): [3,1] = " + numberPosition(0));

        System.out.println("distance(5, List.of(1,0)): 1 = " + distance(5, List.of(1,0)));
        System.out.println("distance(5, List.of(2,2)): 2 = " + distance(5, List.of(2,2)));
        System.out.println("distance(2, List.of(3,2)): 4 = " + distance(2, List.of(3,2)));

        System.out.println("nextFinger(1, new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, \"\", \"right\"): L = " + nextFinger(1, new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "", "right"));
        System.out.println("nextFinger(3, new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, \"L\", \"right\"): R = " + nextFinger(3, new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "L", "right"));
        System.out.println("nextFinger(7, new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, \"\", \"left\"): L = " + nextFinger(7, new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "", "left"));
        System.out.println("nextFinger(2, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, \"L\", \"right\"): L = " + nextFinger(2, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "L", "right"));

        System.out.println("whichFingers(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, \"right\"): \"LRLLLRLLRRL\" = " + whichFingers(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }

    public String solution(int[] numbers, String hand) {
        // test();
        String answer = whichFingers(numbers, hand);
        return answer;
    }

    public List<Integer> numberPosition(int number) {
        Map<Integer, List<Integer>> positionMap = new HashMap<>();

        positionMap.put(0, List.of(3,1));
        positionMap.put(1, List.of(0,0));
        positionMap.put(2, List.of(0,1));
        positionMap.put(3, List.of(0,2));
        positionMap.put(4, List.of(1,0));
        positionMap.put(5, List.of(1,1));
        positionMap.put(6, List.of(1,2));
        positionMap.put(7, List.of(2,0));
        positionMap.put(8, List.of(2,1));
        positionMap.put(9, List.of(2,2));

        return positionMap.get(number);
    }

    public int distance(int number, List<Integer> position) {
        return IntStream.range(0, 2)
                .map(i -> Math.abs(numberPosition(number).get(i) - position.get(i)))
                .sum();
    }

    public String whichFingers(int[] numbers, String hand) {
        return Arrays.stream(numbers)
                .mapToObj(i -> String.valueOf(i))
                .reduce("", (fingers, number) -> {
                    return fingers + nextFinger(Integer.valueOf(number), numbers, fingers, hand);
                });
    }

    public String nextFinger(int number, int[] numbers, String fingers, String preferredHand) {
        if (List.of(1, 4, 7).contains(number)) {
            return "L";
        }

        if (List.of(3, 6, 9).contains(number)) {
            return "R";
        }

        List<Integer> initialLeftFingerPosition = List.of(3, 0);
        List<Integer> initialRightFingerPosition = List.of(3, 2);

        int lastLeftFingerIndex = fingers.lastIndexOf("L");
        int lastRightFingerIndex = fingers.lastIndexOf("R");

        List<Integer> currentLeftFingerPosition
                = lastLeftFingerIndex >= 0
                ? numberPosition(numbers[lastLeftFingerIndex])
                : initialLeftFingerPosition;

        List<Integer> currentRightFingerPosition
                = lastRightFingerIndex >= 0
                ? numberPosition(numbers[lastRightFingerIndex])
                : initialRightFingerPosition;

        System.out.println(List.of(currentLeftFingerPosition, currentRightFingerPosition));

        int leftFingerDistance = distance(number, currentLeftFingerPosition);
        int rightFingerDistance = distance(number, currentRightFingerPosition);

        if (leftFingerDistance < rightFingerDistance) {
            return "L";
        }

        if (leftFingerDistance == rightFingerDistance) {
            if (preferredHand.equals("left")) {
                return "L";
            }
        }

        return "R";
    }
}
