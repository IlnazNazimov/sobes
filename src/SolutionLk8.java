/*Поиск в отсортированном массиве с поворотом
Имеется целочисленный массив nums, отсортированный в порядке возрастания (с различными значениями).

Перед тем, как быть переданным вашей функции, numsон может быть повернут по неизвестному
опорному индексу k( 1 <= k < nums.length), так что результирующий массив
будет [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]( 0-индексирован ).
Например, [0,1,2,4,5,6,7]может быть повернут по опорному индексу 3и станет [4,5,6,7,0,1,2].

Учитывая массив nums после возможного поворота и целое число target, вернуть индекс,
target если он находится в nums, или -1если он не находится вnums .

Вы должны написать алгоритм со O(log n)сложностью выполнения.
*/
class SolutionLk8 {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start <= end) {
            mid = start + (end - start)/2;
            if (nums[mid]== target) {
                return mid;
            } else if ((target > nums[mid] && nums[end] >= target) ||
                    (nums[mid] > nums[end] && (target >= nums[mid] || target <= nums[end]))) {
                start = mid + 1;
            } else end = mid - 1;
        }
        return -1;
    }
}