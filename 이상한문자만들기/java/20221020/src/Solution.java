import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public String solution(String s) {
        String answer = process(s);
        return answer;
    }

    public String process(String string) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(string.toUpperCase());

        return matcher.replaceAll(x -> lowerCaseAtOddIndex(x.group()));
    }

    public String lowerCaseAtOddIndex(String string) {
        return IntStream.range(0, string.length())
                .mapToObj(i -> i % 2 == 0
                        ? string.substring(i, i + 1)
                        : string.substring(i, i + 1).toLowerCase())
                .collect(Collectors.joining());
    }
}
