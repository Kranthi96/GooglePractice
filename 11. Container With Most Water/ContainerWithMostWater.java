class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result =0;
        int l =0, h = height.length-1;
        while(l<h){
            int min = Math.min(height[l], height[h]);
            result = Math.max(result, (h-l) * min);
            while(l < h && min>= height[l]) l++;
            while(l < h && min>= height[h]) h--;
        }
        return result;
        
    }
}
