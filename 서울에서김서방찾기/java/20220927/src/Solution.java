import java.util.OptionalInt;
import java.util.stream.IntStream;

class Solution {
    public String solution(String[] seoul) {
        String answer = print(findKim(seoul));
        return answer;
    }

    public int findKim(String[] list) {
        OptionalInt index = IntStream.range(0, list.length)
                .filter(i -> list[i].equals("Kim"))
                .findFirst();

        return index.getAsInt();
    }

    public String print(int index) {
        return "김서방은 " + index + "에 있다";
    }
}
