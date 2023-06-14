import java.util.HashMap;
import java.util.Map;
/*Даны две строки sи t, вернуть, true если t это анаграмма s, и false в противном случае .

Анаграмма — это слово или фраза, образованная путем перестановки букв другого слова или фразы,
обычно с использованием всех исходных букв ровно один раз .*/
class SolutionLk16 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
            map.merge(t.charAt(i), -1, Integer::sum);
        }

        for(int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
    //////////////////ИЛИ
    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
            a[t.charAt(i) - 'a']--;
        }

        for (int n : a) {
            if (n != 0) return false;
        }
        return true;
    }
}