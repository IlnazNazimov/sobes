/*
* Вам дан целочисленный массив height длины n. Нарисованы n вертикальные линии так,
что двумя конечными точками линии являются и .ith(i, 0)(i, height[i])
Найдите две линии, которые вместе с осью абсцисс образуют контейнер, содержащий наибольшее количество воды.

Возвращает максимальное количество воды, которое может хранить контейнер .*/

class SolutionLk22 {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right) {
            int area = Math.min(height[left], height[right]) * (right-left);
            max = Math.max(max,area);

            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return max;
    }
}