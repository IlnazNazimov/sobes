import java.util.*;
/*
Учитывая массив nums целых nчисел, верните массив всех уникальных четверок, [nums[a], nums[b], nums[c], nums[d]] таких что:

0 <= a, b, c, d < n
a, b, c и d различны . _
nums[a] + nums[b] + nums[c] + nums[d] == target
Вы можете вернуть ответ в любом порядке .
Ввод: nums = [1,0,-1,0,-2,2], цель = 0
Вывод: [[-2,-1,1,2],[-2,0,0,2],[ -1,0,0,1]]
 */
class SolutionLk13 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> map = new HashSet<>();
        Arrays.sort(nums);

        Integer repeat = null;
        for(int i = 0; i < nums.length - 3; i++) {
            if ((repeat != null && nums[i] == repeat) || (i!=0 && nums[i] == nums[i-1])) continue;
            for(int j = i + 1; j < nums.length - 2; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[left] + (long)nums[right];
                    if (sum == target) {
                        map.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                        if (nums[i] == nums[j] && nums[j] == nums[left] && nums[j] == nums[right]) repeat = nums[i];
                    } else if (sum < target) {
                        left++;
                    } else right--;
                }
            }
        }

        return new ArrayList<>(map);
    }
}