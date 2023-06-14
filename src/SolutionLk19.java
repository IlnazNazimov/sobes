/*Учитывая m x n двумерную двоичную сетку grid, которая представляет карту '1's (суша) и '0's (вода),
верните число островов.

Остров окружен водой и образован путем соединения соседних земель по горизонтали или вертикали .
Вы можете предположить, что все четыре края сетки окружены водой.
Вход: сетка = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Выход: 1
*/

import java.util.LinkedList;
import java.util.Queue;

class SolutionLk19 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int numRows = grid.length;
        int numCols = grid[0].length;
        int numIslands = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int row, int col) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        if (row < 0 || col < 0 || row >= numRows || col >= numCols || grid[row][col] != '1') {
            return;
        }

        // Помечаем текущую ячейку как посещенную
        grid[row][col] = '0';

        // Рекурсивно исследуем соседние ячейки
        dfs(grid, row - 1, col); // Верхняя соседняя ячейка
        dfs(grid, row + 1, col); // Нижняя соседняя ячейка
        dfs(grid, row, col - 1); // Левая соседняя ячейка
        dfs(grid, row, col + 1); // Правая соседняя ячейка
    }
    ///Или вариант второй с очередью
    public int numIslands2(char[][] grid) {
        Queue<Node> q = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    q.offer(new Node(i,j));
                    search2(grid, q);
                    count++;
                }
            }
        }
        return count;
    }

    private void search2(char[][] grid, Queue<Node> q) {
        Node node = q.poll();

        if ( node.j + 1 < grid[node.i].length && grid[node.i][node.j + 1] == '1') {
            q.offer(new Node(node.i, node.j + 1));
            grid[node.i][node.j + 1] = '0';
        }
        if ( node.i + 1 < grid.length && grid[node.i + 1][node.j] == '1') {
            q.offer(new Node(node.i + 1, node.j));
            grid[node.i + 1][node.j] = '0';
        }
        if ( node.i - 1 >= 0 && grid[node.i - 1][node.j] == '1') {
            q.offer(new Node(node.i - 1, node.j));
            grid[node.i - 1][node.j] = '0';
        }
        if ( node.j - 1 >= 0 && grid[node.i][node.j - 1] == '1') {
            q.offer(new Node(node.i, node.j - 1));
            grid[node.i][node.j - 1] = '0';
        }
        while(!q.isEmpty()) {
            search2(grid, q);
        }
    }

    private class Node {
        public int i = 0;
        public int j = 0;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}