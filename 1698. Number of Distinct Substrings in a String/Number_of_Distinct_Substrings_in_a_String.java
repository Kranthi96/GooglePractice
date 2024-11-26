class Number_of_Distinct_Substrings_in_a_String {
    public int countDistinct(String s) {
        int n = s.length();

        // Step 1: Build the suffix array
        String[] suffixes = new String[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = s.substring(i);
        }

        // Sort the suffixes lexicographically
        Arrays.sort(suffixes);

        for(String str: suffixes)
            System.out.println(str);

        // Step 2: Build the LCP array
        int[] lcp = new int[n];
        for (int i = 1; i < n; i++) {
            lcp[i] = getLCP(suffixes[i - 1], suffixes[i]);
        }

        // Step 3: Count distinct substrings
        int totalSubstrings = 0;
        for (int i = 0; i < n; i++) {
            // Add the number of substrings in the current suffix
            // and Subtract the LCP (common part that overlaps with the previous suffix)
            totalSubstrings += suffixes[i].length() - lcp[i];
        }
        return totalSubstrings;
    }

    // Function to calculate the Longest Common Prefix (LCP) between two strings
    private int getLCP(String a, String b) {
        int minLength = Math.min(a.length(), b.length());
        for (int i = 0; i < minLength; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return i;
            }
        }
        return minLength;
    }
}
