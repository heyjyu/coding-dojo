import java.util.*;
import java.util.stream.*;

class Solution {
    public void test() {
        System.out.println("sortByCarNumber(new String[]{\"05:34 5961 IN\", \"06:00 0000 IN\", \"06:34 0000 OUT\", \"07:59 5961 OUT\", \"07:59 0148 IN\", \"18:59 0000 IN\", \"19:09 0148 OUT\", \"22:59 5961 IN\", \"23:00 5961 OUT\"})" +
                ": [[\"06:00\", \"0000\", \"IN\"],[\"06:34\", \"0000\", \"OUT\"],[\"18:59\", \"0000\", \"IN\"],[\"07:59\", \"0148\", \"IN\"],[\"19:09\", \"0148\", \"OUT\"],[\"05:34\", \"5961\", \"IN\"],[\"07:59\", \"5961\", \"OUT\"],[\"22:59\", \"5961\", \"IN\"],[\"23:00\", \"5961\", \"OUT\"]] = "
                + sortByCarNumber(new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));

        System.out.println("computeTimeDifferenceInMinutes(\"05:34\", \"06:00\"): 26 = " + computeTimeDifferenceInMinutes("05:34", "06:00"));
        System.out.println("computeTimeDifferenceInMinutes(\"18:59\", \"23:59\"): 300 = " + computeTimeDifferenceInMinutes("18:59", "23:59"));

        System.out.println("getDurations(new String[]{\"05:34 5961 IN\", \"06:00 0000 IN\", \"06:34 0000 OUT\", \"07:59 5961 OUT\", \"07:59 0148 IN\", \"18:59 0000 IN\", \"19:09 0148 OUT\", \"22:59 5961 IN\", \"23:00 5961 OUT\"})" +
                ": [0148=670, 0000=334, 5961=146] = " + getDurations(new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
        System.out.println("getDurations(new String[]{\"16:00 3961 IN\", \"16:00 0202 IN\", \"18:00 3961 OUT\", \"18:00 0202 OUT\", \"23:58 3961 IN\"})" +
                ": [3961=121, 0202=120] = " + getDurations(new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"}));

        System.out.println("computeFee(334, new int[]{180, 5000, 10, 600}): 14600 = " + computeFee(334, new int[]{180, 5000, 10, 600}));
        System.out.println("computeFee(121, new int[]{120, 0, 60, 591}): 591 = " + computeFee(121, new int[]{120, 0, 60, 591}));

        System.out.println("computeFees(new int[]{180, 5000, 10, 600}, new String[]{\"05:34 5961 IN\", \"06:00 0000 IN\", \"06:34 0000 OUT\", \"07:59 5961 OUT\", \"07:59 0148 IN\", \"18:59 0000 IN\", \"19:09 0148 OUT\", \"22:59 5961 IN\", \"23:00 5961 OUT\"})" +
                ": new int[]{14600, 34400, 5000} = " + computeFees(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
    }

    public int[] solution(int[] fees, String[] records) {
        test();
        int[] answer = computeFees(fees, records);
        return answer;
    }

    public List<List<String>> sortByCarNumber(String[] records) {
        List<List<String>> list = Arrays.stream(records)
                .map(record -> Arrays.stream(record.split(" ")).collect(Collectors.toList()))
                .collect(Collectors.toList());

        Collections.sort(list, (a, b) -> Integer.valueOf(a.get(1)) - Integer.valueOf(b.get(1)));

        return list;
    }

    public int computeTimeDifferenceInMinutes(String inTime, String outTime) {
        int inHour = Integer.valueOf(inTime.split(":")[0]);
        int inMinute = Integer.valueOf(inTime.split(":")[1]);
        int outHour = Integer.valueOf(outTime.split(":")[0]);
        int outMinute = Integer.valueOf(outTime.split(":")[1]);

        return outHour * 60 + outMinute - (inHour * 60 + inMinute);
    }

    public Map<String, Integer> getDurations(String[] records) {
        List<List<String>> list = sortByCarNumber(records);

        Map<String, Integer> accumulatedTime = new HashMap<>();

        for (int i = 0; i < list.size(); i += 1) {
            if (list.get(i).get(2).equals("OUT")) {
                continue;
            }

            Integer accumulatedValue = accumulatedTime.getOrDefault(list.get(i).get(1), 0);

            if (i == list.size() - 1) {
                accumulatedTime.put(list.get(i).get(1), accumulatedValue + computeTimeDifferenceInMinutes(list.get(i).get(0), "23:59"));

                break;
            }

            if (list.get(i + 1).get(1).equals(list.get(i).get(1))) {
                accumulatedTime.put(list.get(i).get(1), accumulatedValue + computeTimeDifferenceInMinutes(list.get(i).get(0), list.get(i + 1).get(0)));
                continue;
            }

            accumulatedTime.put(list.get(i).get(1), accumulatedValue + computeTimeDifferenceInMinutes(list.get(i).get(0), "23:59"));
        }

        return accumulatedTime;
    }

    public int computeFee(int duration, int[] fees) {
        if (duration <= fees[0]) {
            return fees[1];
        }

        int excessiveAmount = ((int) Math.ceil((double) (duration - fees[0]) / fees[2])) * fees[3];

        return fees[1] + excessiveAmount;
    }

    public int[] computeFees(int[] fees, String[] records) {
        Map<String, Integer> durations = getDurations(records);

        List<String> keys = durations.entrySet().stream()
                .map(entry -> entry.getKey()).collect(Collectors.toList());

        Collections.sort(keys);

        int[] result = new int[keys.size()];

        for (int i = 0; i < keys.size(); i += 1) {
            int duration = durations.get(keys.get(i));

            result[i] = computeFee(duration, fees);
        }

        return result;
    }
}
