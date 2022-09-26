class Solution {
    public long solution(long n) {
        long answer = process(n);
        return answer;
    }

    public boolean isSquare(long n) {
        if (Math.sqrt(n) == (long) Math.sqrt(n)) {
            return true;
        }

        return false;
    }

    public long process(long n) {
        if (isSquare(n)) {
            return (long) Math.pow((Math.sqrt(n) + 1), 2);
        }

        return -1;
    }
}
