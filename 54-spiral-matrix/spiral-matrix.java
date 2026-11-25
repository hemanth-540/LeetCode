class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length; 
        int n = matrix[0].length;
        int minr = 0, maxr = m-1;
        int minc = 0, maxc = n-1;
        List<Integer> ans = new ArrayList<>();
        while(minc <= maxc && minr <= maxr){
            for(int j=minc;j<=maxc;j++){
                ans.add(matrix[minr][j]);
            }minr++;
            if(minr>maxr || minc>maxc) break;
            for(int i=minr;i<=maxr;i++){
                ans.add(matrix[i][maxc]);
            }maxc--;
            if(minr>maxr || minc>maxc) break;
            for(int j=maxc;j>=minc;j--){
                ans.add(matrix[maxr][j]);
            }maxr--;
            for(int i=maxr;i>=minr;i--){ 
                ans.add(matrix[i][minc]);
            }minc++;
            if(minr>maxr || minc>maxc) break;
        }
        return ans;
    }
}