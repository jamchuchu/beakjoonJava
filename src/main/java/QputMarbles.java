class QputMarbles {
    static int min = Integer.MAX_VALUE;
    static int max = 0;

    public static void main(String[] args) {
    }

    public static long putMarbles(int[] weights, int k) {
        if (weights.length == k) { // 각 구슬을 개별적으로 가방에 넣는 경우
            return 0;
        }
        dfs(weights.length, k - 1, 0, 0, new int[k - 1], weights);
        return max - min;
    }

    static void dfs(int n, int k, int depth, int start, int[] dividers, int[] weights) {
        if (depth == k) {
            int now = calculateCost(dividers, weights, n, k);
            max = Math.max(max, now);
            min = Math.min(min, now);
            return;
        }
        for (int i = start; i < n - 1; i++) { // n-1까지 가능하게 하여 마지막 원소를 포함시키기
            dividers[depth] = i;
            dfs(n, k, depth + 1, i + 1, dividers, weights);
        }
    }

    static int calculateCost(int[] dividers, int[] weights, int n, int k) {
        int cost = weights[0] + weights[n - 1];
        int last = 0;
        for (int divider : dividers) {
            cost += weights[last] + weights[divider];
            last = divider + 1;
        }
        return cost;
    }

}
