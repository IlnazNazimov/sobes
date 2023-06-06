/*Поиск в отсортированном массиве с поворотом с повторяющимися элементами
Имеется целочисленный массив nums, отсортированный в неубывающем порядке (не обязательно с различными значениями).

Перед тем, как быть переданным вашей функции, nums он вращается по неизвестному опорному индексу k( 0 <= k < nums.length),
так что результирующий массив [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]( 0-indexed ).
Например, [0,1,2,4,4,4,5,6,6,7]может быть повернут по опорному индексу 5и станет [4,5,6,6,7,0,1,2,4,4].
*/
class SolutionLk10 {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return true;

            //if there are duplicates
            if(nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start ++;
                end --;
            }

            //left half is sorted
            else if(nums[start] <= nums[mid]) {
                if(target >= nums[start] && target <= nums[mid])
                    end = mid - 1;

                else
                    start = mid + 1;
            }

            //right half is sorted
            else {
                if(target <= nums[end] && target >= nums[mid])
                    start = mid + 1;

                else
                    end = mid - 1;
            }
        }
        return false;
    }
}