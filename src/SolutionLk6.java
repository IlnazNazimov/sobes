/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */
/*Мы играем в игру «Угадай». Игра выглядит следующим образом:

Я выбираю число от 1 до n. Вы должны угадать, какое число я выбрал.
Каждый раз, когда вы угадаете неправильно, я скажу вам, является ли выбранное мною число больше или меньше вашего предположения.

Вы вызываете предопределенный API int guess(int num), который возвращает три возможных результата:

-1: Ваше предположение больше, чем выбранное мною число (т.е. num > pick).
1: Ваше предположение меньше числа, которое я выбрал (т.е. num < pick).
0: ваша догадка равна выбранному мной числу (т.е. num == pick).
Верните номер, который я выбрал .*/
public class SolutionLk6 extends GuessGame {
    public int guessNumber(int n) {
        int mid, start = 1,end = n;
        while(start <= end) {
            mid = start + (end - start)/2;

            if (guess(mid) == 1) {
                start = mid + 1;
            } else if (guess(mid) == -1) {
                end = mid - 1;
            } else return mid;
        }
        return -1;
    }
}