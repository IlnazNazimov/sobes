/*Дан массив целых чисел nums, отсортированных в порядке возрастания, и целое число target,
напишите функцию для поиска targetв nums. Если targetсуществует, верните его индекс. В противном случае возвращайтесь -1.*/
class SolutionLk5 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return binSearch(nums, target, 0, nums.length);
    }

    private int binSearch(int[] nums, int target, int start, int end) {
        if (start == end) return -1;
        int middle = start + (end-start)/2;
        if(nums[middle] < target) {
            start = middle + 1;
            return binSearch(nums, target, start, end);
        } else if (nums[middle] == target) {
            return middle;
        } else {
            end = middle;
            return binSearch(nums, target, start, end);
        }
    }
}