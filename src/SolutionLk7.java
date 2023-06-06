/*  Поиск 2D-матрицы.
Вам дана m x n целочисленная матрица matrix со следующими двумя свойствами:
Каждая строка сортируется в порядке неубывания.
Первое целое число каждой строки больше, чем последнее целое число предыдущей строки.
Учитывая целое число target, вернуть true , если target находится в matrix или false в противном случае .

Вы должны написать решение по O(log(m * n))временной сложности. */
class SolutionLk7 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m - 1;

        while (lo != hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[mid][n - 1] < target) lo = mid + 1;
            else hi = mid;
        }
        if (matrix[lo][n - 1] < target) return false;

        int i = lo;
        lo = 0; hi = n - 1;
        while (lo != hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[i][mid] < target) lo = mid + 1;
            else hi = mid;
        }
        return matrix[i][lo] == target;
    }
}