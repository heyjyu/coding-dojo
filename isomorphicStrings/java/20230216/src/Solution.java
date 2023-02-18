class Solution {
    // 1 대 1 매핑이 되어야 한다
    // 같은 단어는 같은 단어끼리 다른 단어는 다른 단어끼리 매핑되어야 한다
    // 처음 나온 s 단어면 맵에 추가하기 근데 맵에 있는 values중에 있으면 안된다
    // 만약 맵에 있는 s단어면 value가 동일한지 확인

    public boolean isIsomorphic(String s, String t) {
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < s.length(); i += 1) {
            String word1 = s.substring(i, i + 1);
            String word2 = t.substring(i, i + 1);

            if (map.getOrDefault(word1, "").equals("")) {
                if (map.values().contains(word2)) {
                    return false;
                }

                map.put(word1, word2);
            }

            if (!map.getOrDefault(word1, "").equals(word2)) {
                return false;
            }
        }

        return true;
    }
}
