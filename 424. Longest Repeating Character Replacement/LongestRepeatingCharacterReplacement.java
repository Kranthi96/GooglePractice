class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        
        // int[] chars = new int[26];
        // int max=0;
        // int left = 0, right ;
        // for(right =0; right<s.length();right++ ){
        //     int curr = s.charAt(right)-'A';
        //     chars[curr]++;
        //     max = Math.max(max,chars[curr]);
        //     boolean isValid = (right-left+1-max) <= k;
        //     if(!isValid){
        //         chars[s.charAt(left++)-'A']--;
        //     }
        // }
        // return right-left;

        char[] chars = s.toCharArray();
        int[] count = new int[128];
        int maxCount = 0;
        int res =0;
        int left = 0, right =0;
        int n = s.length();
        while(right<n){
            count[chars[right]]++;
            maxCount = Math.max(maxCount, count[chars[right]]);
            right++;
            if(right-left-maxCount <= k) res = Math.max(res, right-left);
            while(right-left-maxCount >k){
                count[chars[left++]]--;
            }
            
        }
        return res;

    }
}
