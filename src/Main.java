import com.sun.source.tree.BreakTree;

import java.sql.PreparedStatement;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

    }
























    private static int kenguru(int n, int k) {
        int sum = 1;
        Queue<Integer> queue = new ArrayDeque<>(k);
        queue.add(sum);


        return sum;
    }
    private static List<Integer> rukzak(int[] mas, int size) {
        int[][] dp = new int[mas.length + 1][ size + 1];

        for (int i = 1; i < mas.length + 1; i++) {
            for(int j = 1; j < size + 1; j++) {
                if (mas[i] <= size) {
                    dp[i][j] = Math.max(dp[i - 1][j], mas[i - 1] + dp[i - 1][j - mas[i]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return new ArrayList<>();
    }

    public static int calculateDistance(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] mas = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            mas[i][0] = i;
        }

        for(int i = 0; i <= n; i++){
            mas[0][i] = i;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                int equal = s.charAt(i - 1) == t.charAt(j - 1) ? 0 : 1;
                mas[i][j] = Math.min(mas[i - 1][j] + 1, Math.min(mas[i][j - 1] + 1, mas[i - 1][j - 1] + equal));
            }
        }

        return mas[m][n];
    }

    public static int findMaxIncreasingSubsequence(int[] arr) {
        int N = arr.length;
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }

        return maxLength;
    }

private static List<String> generate(int open, int close, String s, List<String> list) {
        if(close == 0) {
            list.add(s);
            return list;
        } else if (open != 0) generate(open - 1, close, s + '(', list);
        if (open < close) {
            generate(open, close - 1, s + ')', list);
        }
        return list;
    }

    public static int FindSumOfSubarray(int[] arr, int k)
    {
        int total = 0;
        int partSum = 0;
        int len = arr.length;

        Map<Integer,Integer> dict = new HashMap<>();

        for (int i = 0; i < len; i++)
        {
            partSum += arr[i];

            // found a subarray that sum of this subarray equals k
            if (dict.containsKey(partSum - k))
            {
                total += dict.get(partSum - k);
            }

            // add new part sum to dictionary
            if (!dict.containsKey(partSum))
            {
                dict.put(partSum, 0);
            }
            dict.merge(partSum,1, Integer::sum);
        }

        return total;
    }

    private static int fibo(int n) {
        int a = 1;
        int b = 1;

        for (int i = 3; i <=n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return a + b;
    }
    private static int[] minRazn(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int[] res = new int[2];
        while(i < a.length && j < b.length) {
            int razn = a[i] - b[j];
            if (razn == 0) {
                return new int[]{a[i],b[j]};
            } else if (razn > 0){
                if (min > razn) {
                    min = razn;
                    res[0] = a[i];
                    res[1] = b[j];
                }
                j++;
            } else {
                if(min > Math.abs(razn)) {
                    min = Math.abs(razn);
                    res[0] = a[i];
                    res[1] = b[j];
                }
                i++;
            }
        }
        return res;
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];

        if (k == 1) {
            return Arrays.stream(nums).mapToDouble(i -> i).toArray();
        }
        int start = 0;
        int end = k - 1;
        List<Integer> sort = new ArrayList<>(Arrays.stream(nums).limit(k).boxed().toList());
        Collections.sort(sort);


        while(end < nums.length) {
            if (k % 2 == 0) {
                res[start] = ((double)sort.get(k/2 - 1) + sort.get(k/2)) / 2;
            } else {
                res[start] = sort.get(k/2);
            }
            sort.remove(Integer.valueOf(nums[start]));
            start++;
            end++;
            if (end < nums.length) {
                for (int i = 0; i < k - 1; i++) {
                    if (nums[end] < sort.get(i)) {
                        sort.add(i, nums[end]);
                        break;
                    } else if (k - 2 == i) {
                        sort.add(nums[end]);
                    }
                }
            }
        }
        return res;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i : nums) {
            map.merge(i, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        pq.addAll(map.entrySet());
        int[] res = new int[k];
        int size = pq.size();
        for(int i = 0; i < k && i < size; i++) {
            res[i] = Objects.requireNonNull(pq.poll()).getKey();
        }
        return res;
    }

    public static int[][] merge(int[][] intervals) {
        int[][] sortedMas = sort(intervals, 0 , intervals.length - 1);
        int min = -1;
        int max = 0;

        List<int[]> result = new ArrayList<>();

        for(int i = 0; i < sortedMas.length; i++) {
            if (min == -1) {
                min = sortedMas[i][0];
                max = sortedMas[i][1];
            }
            if (i < sortedMas.length -1 && max >= sortedMas[i + 1][0]) {
                max = Math.max(sortedMas[i][1], sortedMas[i + 1][1]);
            } else {
                result.add(new int[]{min,max});
                min = -1;
            }
        }
        return result.toArray(int[][]::new);
    }

    private static int[][] sort(int[][] intervals, int start, int end) {
        if (start == end) {
            return new int[][] {intervals[start]};
        }
        int[][] left = sort(intervals, start, start + (end - start) / 2);
        int[][] right = sort(intervals, start + (end - start) / 2 + 1, end);

        int[][] result = new int[left.length + right.length][2];

        int l = 0;
        int r = 0;
        for(int i = 0; i < result.length; i++) {
            if(r == right.length) {
                result[i] = left[l];
                l++;
                continue;
            }
            if (l == left.length) {
                result[i] = right[r];
                r++;
                continue;
            }
            if (left[l][0] <= right[r][0]) {
                result[i] = left[l];
                l++;
            } else {
                result[i] = right[r];
                r++;
            }
        }
        return result;
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer>  map= new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            map.merge( words[i], 1, Integer::sum);
        }

        return map.entrySet()
                .stream()
                .filter(e -> e.getValue() >= k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<Integer, List<String>> allStr = new HashMap<>();

        for(String s : strs) {
            List<String> a = allStr.getOrDefault(s.length(), new ArrayList<String>());
            a.add(s);
            allStr.put(s.length(), a);
        }
        Set<String> useStrSet = new HashSet<>();

        for(int i = 0; i < strs.length; i++) {
            if (!useStrSet.contains(strs[i])) {
                useStrSet.add(strs[i]);
                List<String> group = new ArrayList<>();
                List<String> s = allStr.get(strs[i].length());
                for(int j = 0; j < s.size(); j++) {
                    char[] current = strs[i].toCharArray();
                    char[] next = s.get(j).toCharArray();
                    Arrays.sort(current);
                    Arrays.sort(next);
                    if (Arrays.equals(current, next)) {
                        useStrSet.add(strs[j]);
                        group.add(s.get(j));
                    }
                }
                result.add(group);
            }
        }

        return result;
    }

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

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> result = new HashMap<>();

        for(Map.Entry<Integer,Integer> entry : result.entrySet()) {
            result.keySet();
            if(entry.getValue() == 1) return entry.getKey();
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
    //81 . Поиск в отсортированном массиве с поворотом II c дубликатами
    public static boolean search81(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(nums[mid] == target) return true;
            if (nums[start] == nums[end] && nums[mid] == nums[end] && nums[start] == nums[mid]) {
                for(int i = start; i <= end; i++) {
                    if (nums[i] == target) return true;
                }
                return false;
            }
            if ((nums[mid] > nums[end] && nums[end] >= target)  || (nums[mid] < target && nums[end] >= target)) {
                start = mid + 1;
            } else end = end -1;
        }
        return false;
    }
    public static int search33(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 1;
        while(start <= end) {
            mid = start + (end - start)/2;
            if (nums[mid]== target) {
                return mid;
            } else if ((target > nums[mid] && nums[end] >= target) ||
                    (nums[mid] > nums[end] && (target > nums[mid] || target < nums[end]))) {
                start = mid + 1;
            } else end = mid - 1;
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return binSearch(nums, target, 0, nums.length);
    }

    private static int binSearch(int[] nums, int target, int start, int end) {
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

    private static boolean isPolendrom(int x) {
        if (x < 0) {
            return false;
        }
        int count = 1;
        int k = x;
        while (k / 10 > 0) {
            k = k / 10;
            count++;
        }

        for (int i = 1; i < count / 2 + 1; i++) {
            if ((int) ((x % Math.pow(10, i)) / Math.pow(10, i - 1)) != ((int) (x / (Math.pow(10, count - i)))) % 10) {
                return false;
            }
        }
        return true;
    }

    public static int romanToInt(String s) {
        int sum = 0;
        int x = 0;
        int pred = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'M' -> x = 1000;
                case 'D' -> x = 500;
                case 'C' -> x = 100;
                case 'L' -> x = 50;
                case 'X' -> x = 10;
                case 'V' -> x = 5;
                case 'I' -> x = 1;
            }
            if (x < pred) {
                sum -= x;
            } else sum += x;
            pred = x;
        }
        return sum;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sum(l1, l2);
    }

    private ListNode sum(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode newNode = new ListNode(0);
        ListNode result = newNode;
        boolean flag = false;

        while(l1 != null || l2 != null || flag) {
            int sum = 0;
            if (l1!=null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if (l2!=null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            if (flag) {
                sum = sum + 1;
                flag = false;
            }
            if (sum > 9) {
                newNode.next = new ListNode(sum % 10);
                flag = true;
            } else newNode.next = new ListNode(sum);
            newNode = newNode.next;
        }
        return result.next;
    }

    private int getLength(ListNode node) {
        int length = 1;
        while (node!=null) {
            node = node.next;
            length++;
        }
        return length -1;
    }

    private ListNode reverse(ListNode list) {
        ListNode current = list;
        ListNode next = null;
        ListNode pred = null;
        while (current != null) {
            next = current.next;
            current.next = pred;
            pred = current;
            current = next;
        }
        return pred;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    private ListNode mergeKMas(ListNode[] mas) {
        if (mas == null || mas.length == 0) {
            return null;
        }
        return mergeMas(mas, 0, mas.length - 1);
    }

    private ListNode mergeMas(ListNode[] mas, int start, int end) {
        if (start == end) {
            return mas[start];
        }

        int k = start + (end - start) / 2;
        ListNode a = mergeMas(mas, start, k);
        ListNode b = mergeMas(mas, k + 1, end);

        ListNode result = new ListNode(0);
        ListNode current = result;

        while (a != null && b != null) {
            if (a.val < b.val) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }

        current.next = a == null ? b : a;
        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    private static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int k = 0;
        int l = 0;
        int i = 0;
        while (i < a.length && i < b.length) {
            if (a[l] <= b[k]) {
                result[i++] = a[l++];
            } else {
                result[i++] = b[k++];
            }
        }

        while (k < b.length) {
            result[i++] = b[k++];
        }
        while (l < a.length) {
            result[i++] = a[l++];
        }
        return result;
    }
}
