import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
* Вам дана строка s. Мы хотим разделить строку на как можно больше частей,
чтобы каждая буква встречалась не более чем в одной части.
Обратите внимание, что разбиение сделано таким образом,
что после объединения всех частей по порядку результирующая строка должна быть s.

Возвращает список целых чисел, представляющих размер этих частей .
* Ввод: s = "ababcbacadefegdehijhklij"
 Вывод: [9,7,8]
 Объяснение:
Раздел «ababcbaca», «defegde», «hijhklij».
Это разбиение, так что каждая буква появляется не более чем в одной части.
Раздел типа «ababcbacadefegde», «hijhklij» неверен, потому что он разбивает s на меньшее количество частей.
*/
class SolutionLk21 {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] mas = s.toCharArray();

        for(int i = 0; i < mas.length; i++) {
            map.put(mas[i], i);
        }

        int max = 0;
        int start = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < mas.length; i++) {
            if (map.get(mas[i]) > max) {
                max = map.get(mas[i]);
            }

            if (i==max) {
                res.add(max - start + 1);
                start = max + 1;
            }
        }
        return res;
    }
}