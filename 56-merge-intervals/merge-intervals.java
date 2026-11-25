class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();

        for(int[] interval : intervals) {
            if(ans.isEmpty() || ans.get(ans.size() - 1)[1] < interval[0]) {
                ans.add(new int[] {interval[0], interval[1]});
            }
            else {
                int last = ans.size() - 1;
                ans.get(last)[1] = Math.max(ans.get(last)[1], interval[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}