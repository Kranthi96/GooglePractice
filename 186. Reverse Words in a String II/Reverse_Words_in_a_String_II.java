class Reverse_Words_in_a_String_II {
    public void reverseWords(char[] s) {
        int n = s.length;
        reverse(s, 0, n-1);
        int l=0, r=0;
        while(l < n) {
            while(r < n && s[r] != ' ') ++r;
            reverse(s, l, r-1);
            l = r+1;
            ++r;
        }
    }
    public void reverse(char[] s, int l, int r){
        while(l<r){
            char c = s[l];
            s[l++] = s[r];
            s[r--] = c;
        }
    }
}
