import java.util.*;

class Solution {
    List<List<Character>> b;

    public int solution(int m, int n, String[] board) {
        b = new ArrayList<>();
        int ans = 0;

        for (int i = 0; i < n; i += 1) {
            b.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i += 1)
            for (int j = m - 1; j >= 0; j--) {
                b.get(i).add(board[j].charAt(i));
            }

        while (true) {
            int cnt = 0;

            for (int i = 0; i < n - 1; i += 1) {
                for (int j = b.get(i).size() - 1; j > 0; j--) {
                    check(i, j);
                }
            }

            for (int i = 0; i < n; i += 1) {
                for (int j = b.get(i).size() - 1; j >= 0; j--) {
                    if (Character.isLowerCase(b.get(i).get(j))) {
                        b.get(i).remove(j);
                        cnt += 1;
                    }
                }
            }

            if (cnt == 0) {
                break;
            }

            ans += cnt;
        }

        return ans;
    }


    public void check(int i, int j) {
        if (b.get(i).size() <= 1 || j >= b.get(i + 1).size()) {
            return;
        }

        char cUp = Character.toUpperCase(b.get(i).get(j));
        char cLow = Character.toLowerCase(cUp);
        if ((Character.toUpperCase(b.get(i).get(j - 1)) == cUp)
                && (Character.toUpperCase(b.get(i + 1).get(j)) == cUp)
                && (Character.toUpperCase(b.get(i + 1).get(j - 1)) == cUp)) {
            b.get(i).set(j, cLow);
            b.get(i + 1).set(j, cLow);
            b.get(i + 1).set(j - 1, cLow);
            b.get(i).set(j - 1, cLow);
        }
    }
}
