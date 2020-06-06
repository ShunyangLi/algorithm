public class BestTimeBuySell {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int max = 0, stock = prices[0];

        for (int price : prices) {
            int receive = price - stock;
            if (receive >= 0) max = Math.max(max, price-stock);

            stock = Math.min(stock, price);
        }

        return max;
    }

    public static void main(String[] args) {
        BestTimeBuySell b = new BestTimeBuySell();
        System.out.println(b.maxProfit(new int[] {7,6,4,3,1}));
    }
}
