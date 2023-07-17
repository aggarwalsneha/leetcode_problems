class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] r:image){
            for(int i=0;i<(r.length+1)/2;i++){
                int temp=r[i]^1;
                r[i]=r[r.length-i-1]^1;
                r[r.length-i-1]=temp;
            }
        }
        return image;
    }
}