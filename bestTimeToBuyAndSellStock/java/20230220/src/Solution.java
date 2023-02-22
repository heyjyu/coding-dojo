// 가장 큰 수익을 찾기
// 가장 쉬운 방법은 모두 순회하기
// 시간이 초과했기 때문에 다른 방법을 생각해보자.
// 무조건 어느 날 팔기 때문에 그 날 파는 최대 금액은 그 날까지 중에 가장 작은 값과 비교하면 된다.

class Solution {
    public int maxProfit(int[] prices) {
        int minimumInThePast = prices[0];
        int maximumProfit = 0;

        for (int i = 1; i < prices.length; i += 1) {
            int profit = prices[i] - minimumInThePast;

            if (prices[i] < minimumInThePast) {
                minimumInThePast = prices[i];
            }

            if (profit > maximumProfit) {
                maximumProfit = profit;
            }
        }

        return maximumProfit;
    }
}
