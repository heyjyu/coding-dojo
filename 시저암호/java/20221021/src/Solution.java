import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public String solution(String s, int n) {
        String answer = convert(s, n);
        return answer;
    }

    public String moveCharacter(String character, int times) {
        char lastCharacter = character.equals(character.toLowerCase())
                ? 'z'
                : 'Z';

        return character.charAt(0) + times > lastCharacter
                ? String.valueOf((char) (character.charAt(0) + times - 26))
                : String.valueOf((char) (character.charAt(0) + times));
    }

    public String convert(String string, int times) {
        Pattern pattern = Pattern.compile("\\w");
        Matcher matcher = pattern.matcher(string);

        return matcher.replaceAll(character -> moveCharacter(String.valueOf(character.group()), times));
    }
}
