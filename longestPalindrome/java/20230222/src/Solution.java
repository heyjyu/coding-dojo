// 일단 a~Z로 sort하고
// 짝을 맞추고, 남는 글자가 있으면 1 더하기

class Solution {
    public int longestPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        String[] characters = s.split("");
        Arrays.sort(characters);

        int length = 0;

        for (int i = 0; i < characters.length; i += 1) {
            if (stack.size() == 0) {
                stack.push(characters[i].charAt(0));

                continue;
            }

            if (stack.get(stack.size() - 1) == characters[i].charAt(0)) {
                length += 2;
                stack.pop();

                continue;
            }

            stack.push(characters[i].charAt(0));
        }

        if (stack.size() > 0) {
            length += 1;
        }

        return length;
    }
}
