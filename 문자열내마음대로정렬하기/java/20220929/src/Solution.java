class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = sortByNthChar(strings, n);
        return answer;
    }

    public String[] dictionarySort(String string1, String string2) {
        String[] strings = new String[2];

        for (int i = 0; i < minLength(string1, string2); i += 1) {
            if (string1.charAt(i) == string2.charAt(i)) {
                if (i == minLength(string1, string2) - 1) {
                    if (string1.length() == minLength(string1, string2)) {
                        strings = new String[]{string1, string2};

                        break;
                    }

                    strings = new String[]{string2, string1};
                }

                continue;
            }

            strings = sortByNthChar(new String[]{string1, string2}, i);

            break;
        }

        return strings;
    }

    public String[] sortByNthChar(String[] strings, int n) {
        for (int i = 0; i < strings.length; i += 1) {
            for (int j = i + 1; j < strings.length; j += 1) {
                if (strings[i].charAt(n) == strings[j].charAt(n)) {
                    String temp1 = dictionarySort(strings[i], strings[j])[0];
                    String temp2 = dictionarySort(strings[i], strings[j])[1];

                    strings[i] = temp1;
                    strings[j] = temp2;
                }

                if (strings[i].charAt(n) > strings[j].charAt(n)) {
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
            }
        }

        return strings;
    }

    public int minLength(String string1, String string2) {
        if (string1.length() < string2.length()) {
            return string1.length();
        }

        return string2.length();
    }
}
