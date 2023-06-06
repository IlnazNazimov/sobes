import java.util.HashMap;
/*Дан массив целых чисел nums и целое число target, вернуть индексы двух чисел так, чтобы они в сумме составляли target .*/

class SolutionLk12 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++) {
            if(map.get(target - nums[i]) != null) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                break;
            }
            else map.put(nums[i], i);
        }
        return result;
    }
}