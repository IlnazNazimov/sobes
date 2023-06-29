import java.util.HashMap;
import java.util.Map;
/*
* Вам дана строка sи целое число k. Вы можете выбрать любой символ строки и заменить его на любой другой
* заглавный английский символ. Вы можете выполнять эту операцию в большинстве k случаев.

Возвращает длину самой длинной подстроки, содержащей ту же букву,
* которую вы можете получить после выполнения вышеуказанных операций .
* */
class SolutionLk20 {
    public int characterReplacement(String s, int k) {
        //holds all repeated characters
        Map<Character, Integer> charCountMap = new HashMap<>();
        //left pointer, max repeated char count, max window size
        int left = 0, maxRepeatCount = 0, maxWindow = 0;

        for(int right = 0; right < s.length(); right++) {

            //increase current char count
            char ch = s.charAt(right);
            //put character count in map
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);

            // max repeated char count
            maxRepeatCount = Math.max(maxRepeatCount, charCountMap.get(ch));

            int currentSizeOfWindow = right - left + 1;
            //if current size of the window - max repeated count greater than k
            if(currentSizeOfWindow - maxRepeatCount > k) {
                char charToDecrease = s.charAt(left);
                //decrease char count
                charCountMap.put(charToDecrease, charCountMap.get(charToDecrease) - 1);
                left++;

                //update current size of window
                currentSizeOfWindow = right - left + 1;
            }

            maxWindow = Math.max(maxWindow, currentSizeOfWindow);
        }
        return maxWindow;
    }
}