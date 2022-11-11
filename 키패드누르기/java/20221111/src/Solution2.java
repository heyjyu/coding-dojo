import java.util.*;
import java.util.stream.*;

class Solution {
    public void test() {
        System.out.println("numberPosition(1): [0,0] = " + numberPosition(1));
        System.out.println("numberPosition(5): [1,1] = " + numberPosition(5));
        System.out.println("numberPosition(0): [3,1] = " + numberPosition(0));

        System.out.println("fingersPosition(1, List.of(List.of(3, 0), List.of(3, 2)), \"left\"): [[0,0],[3,2]] = " + fingersPosition(1, List.of(List.of(3, 0), List.of(3, 2)), "left"));
        System.out.println("fingersPosition(5, List.of(List.of(1, 0), List.of(3, 2)), \"left\"): [[1,1],[3,2]] = " + fingersPosition(5, List.of(List.of(1, 0), List.of(3, 2)), "left"));
        System.out.println("fingersPosition(5, List.of(List.of(1, 0), List.of(0, 1)), \"left\"): [[1,1],[0,1]] = " + fingersPosition(5, List.of(List.of(1, 0), List.of(0, 1)), "left"));
        System.out.println("fingersPosition(5, List.of(List.of(1, 0), List.of(0, 1)), \"right\"): [[1,0],[1,1]] = " + fingersPosition(5, List.of(List.of(1, 0), List.of(0, 1)), "right"));

        System.out.println("distance(5, List.of(1,0)): 1 = " + distance(5, List.of(1, 0)));
        System.out.println("distance(5, List.of(2,2)): 2 = " + distance(5, List.of(2, 2)));
        System.out.println("distance(2, List.of(3,2)): 4 = " + distance(2, List.of(3, 2)));

        System.out.println("whichFingers(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, \"left\"): \"LRLLLRLLRRL\" = " + whichFingers(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "left"));
    }

    public String solution(int[] numbers, String hand) {
        // test();
        String answer = whichFingers(numbers, hand);
        return answer;
    }

    public List<Integer> numberPosition(int number) {
        Map<Integer, List<Integer>> positionMap = new HashMap<>();

        positionMap.put(0, List.of(3, 1));
        positionMap.put(1, List.of(0, 0));
        positionMap.put(2, List.of(0, 1));
        positionMap.put(3, List.of(0, 2));
        positionMap.put(4, List.of(1, 0));
        positionMap.put(5, List.of(1, 1));
        positionMap.put(6, List.of(1, 2));
        positionMap.put(7, List.of(2, 0));
        positionMap.put(8, List.of(2, 1));
        positionMap.put(9, List.of(2, 2));

        return positionMap.get(number);
    }

    public List<List<Integer>> fingersPosition(int number, List<List<Integer>> currentPositions, String preferHand) {
        if (number == 1 || number == 4 || number == 7) {
            return List.of(numberPosition(number), currentPositions.get(1));
        }

        if (number == 3 || number == 6 || number == 9) {
            return List.of(currentPositions.get(0), numberPosition(number));
        }

        int leftFingerDistance = distance(number, currentPositions.get(0));
        int rightFingerDistance = distance(number, currentPositions.get(1));

        if (leftFingerDistance < rightFingerDistance) {
            return List.of(numberPosition(number), currentPositions.get(1));
        }

        if (leftFingerDistance == rightFingerDistance) {
            if (preferHand.equals("left")) {
                return List.of(numberPosition(number), currentPositions.get(1));
            }
        }

        return List.of(currentPositions.get(0), numberPosition(number));
    }

    public int distance(int number, List<Integer> position) {
        return IntStream.range(0, 2)
                .map(i -> Math.abs(numberPosition(number).get(i) - position.get(i)))
                .sum();
    }

    public String whichFingers(int[] numbers, String hand) {
        StringBuilder stringBuilder = new StringBuilder();
        List<List<Integer>> currentPositions = List.of(List.of(3, 0), List.of(3, 2));

        List<List<Integer>> fingerPositions = fingersPosition(numbers[0], currentPositions, hand);

        if (fingerPositions.equals(currentPositions)) {
            if (distance(numbers[0], fingerPositions.get(0)) == 0) {
                stringBuilder.append("L");
            }

            if (distance(numbers[0], fingerPositions.get(1)) == 0) {
                stringBuilder.append("R");
            }
        }

        if (!fingerPositions.get(0).equals(currentPositions.get(0))) {
            stringBuilder.append("L");
        }

        if (!fingerPositions.get(1).equals(currentPositions.get(1))) {
            stringBuilder.append("R");
        }

        for (int i = 1; i < numbers.length; i += 1) {
            currentPositions = fingerPositions;
            fingerPositions = fingersPosition(numbers[i], currentPositions, hand);

            if (fingerPositions.equals(currentPositions)) {
                if (distance(numbers[i], fingerPositions.get(0)) == 0) {
                    stringBuilder.append("L");
                }
                if (distance(numbers[i], fingerPositions.get(1)) == 0) {
                    stringBuilder.append("R");
                }
            }

            if (!fingerPositions.get(0).equals(currentPositions.get(0))) {
                stringBuilder.append("L");
            }

            if (!fingerPositions.get(1).equals(currentPositions.get(1))) {
                stringBuilder.append("R");
            }
        }

        return stringBuilder.toString();
    }
}
