package stringAlgorithms;

public class KnuteMorris {
    public static int[] trivial(String s) {
        final int n = s.length();
        int[] pi = new int[n];
        for (int i = 0; i < n; ++i)
            for (int k = 0; k <= i; ++k)
                if (s.substring(0, k) == s.substring(i - k + 1, k))
                    pi[i] = k;
        return pi;
    }

    public static int[] effective(String s) {
        final int n = s.length();
        int[] pi = new int[n];
        for (int i = 1; i < n; ++i) {
            int j = pi[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j))
                j = pi[j - 1];
            if (s.charAt(i) == s.charAt(j)) ++j;
            pi[i] = j;
        }
        return pi;
    }
}
