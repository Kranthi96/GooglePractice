class MaximumNumberofBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] chars = new int[26];
        for(char c: text.toCharArray())
            chars[c%26]++;
        int min = Integer.MAX_VALUE;
        min = Integer.min(min, chars['b'%26]);
        min = Integer.min(min, chars['a'%26]);
        min = Integer.min(min, chars['l'%26]/2);
        min = Integer.min(min, chars['o'%26]/2);
        min = Integer.min(min, chars['n'%26]);
        return min;
        
    }
}
