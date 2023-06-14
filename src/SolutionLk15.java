import java.util.*;

/*Учитывая массив строк strs, сгруппируйте анаграммы вместе. Вы можете вернуть ответ в любом порядке.
* Анаграмма — это слово или фраза, образованная путем перестановки букв другого слова или фразы,
* обычно с использованием всех исходных букв ровно один раз.
* */

class SolutionLk15 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> allStr = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            List<String> list = allStr.getOrDefault(str, new ArrayList<String>());
            list.add(s);
            allStr.put(str, list);
        }

        return new ArrayList<>(allStr.values());
    }
}