import java.util.regex.*;

class Solution {
    public void test() {
        System.out.println("modifyFirstLetter(\"people\"): People = " + modifyFirstLetter("People"));
        System.out.println("modifyFirstLetter(\"3people\"): 3people = " + modifyFirstLetter("3people"));

        System.out.println("modifyLetterAfterSpace(\"3people unFollowed me\"): 3people Unfollowed Me = " + modifyLetterAfterSpace("3people unFollowed me"));
        System.out.println("modifyLetterAfterSpace(\"for the last week\"): for The Last Week = " + modifyLetterAfterSpace("for the last week"));

        System.out.println("toJadenCase(\"for the last week\"): For The Last Week = " + toJadenCase("for the last week"));
    }

    public String solution(String s) {
        // test();
        String answer = toJadenCase(s);
        return answer;
    }

    public String modifyFirstLetter(String string) {
        Character firstLetter = string.charAt(0);

        if (firstLetter <= 'z' && firstLetter >= 'a') {
            return Character.toUpperCase(firstLetter) + string.substring(1);
        }

        return string;
    }

    public String modifyLetterAfterSpace(String string) {
        Pattern pattern = Pattern.compile(" [a-z]");
        Matcher matcher = pattern.matcher(string.toLowerCase());

        return matcher.replaceAll(x -> x.group().toUpperCase());
    }

    public String toJadenCase(String string) {
        return modifyFirstLetter(modifyLetterAfterSpace((string)));
    }
}
