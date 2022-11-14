package stringAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class RabinCarp {
    public static List<Integer> trivial(String s, String t) {
        // считаем все степени p
        final long p = 31;
        long[] pPow = new long[t.length()];
        pPow[0] = 1;
        for (int i = 1; i < t.length(); ++i)
            pPow[i] = pPow[i - 1] * p;
        // считаем хэши от всех префиксов строки T
        long[] h = new long[t.length()];
        h[0] = (t.charAt(0) - 'a' + 1) * pPow[0];
        for (int i = 1; i < t.length(); ++i)
            h[i] = (t.charAt(i) - 'a' + 1) * pPow[i] + h[i - 1];

        // считаем хэш от строки S
        long hs = 0;
        for (int i = 0; i < s.length(); ++i)
            hs += (s.charAt(0) - 'a' + 1) * pPow[0];

        List<Integer> answer = new ArrayList<Integer>();
        // перебираем все подстроки T длины |S| и сравниваем их
        if (h[s.length() - 1] == hs * pPow[0])
            answer.add(0);
        for (int i = 1; i + s.length() - 1 < t.length(); ++i) {
            long curH = h[i + s.length() - 1] - h[i - 1];
            // приводим хэши к одной степени и сравниваем
            if (curH == hs * pPow[i])
                answer.add(i);
        }

        return answer;
    }
}
