package stringAlgorithms;

public class ZFunction {
    public static int[] trivial(String s) {
        final int n = s.length();
        int[] z = new int[n];
        z[0] = 0;

        for (int i = 1; i < n; ++i) {
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                ++z[i];
            }
        }
        return z;
    }

    public static int[] effective(String s) {
        final int n = s.length();
        int[] z = new int[n];
        z[0] = 0;

        for (int i = 1, l = 0, r = 0; i < n; ++i) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                ++z[i];
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }
}
