import java.util.HashMap;
import java.util.Map;
/*Учитывая непустой  массив целых чисел nums, каждый элемент встречается дважды , кроме одного. Найди ту единственную.*/
class SolutionLk11 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> result = new HashMap<>();

        for (int num : nums) {
            result.merge(num, 1, Integer::sum);
        }
        for(Map.Entry<Integer,Integer> entry : result.entrySet()) {
            if(entry.getValue() == 1) return entry.getKey();
        }
        return -1;
    }
    //Или
    public int singleNumber2(int[] nums) {
        int result=0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}