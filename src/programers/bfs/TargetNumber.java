package programers.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class TargetNumber {
    private static int answer = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        System.out.println(solution(numbers, 3));
    }

    public static int solution(int[] numbers, int target) {
        return BFS(numbers, target);
    }

    private static int BFS(int[] numbers, int target) {
        int cnt = 0;

        Queue<Node> que = new LinkedList<Node>();
        que.add(new Node(-1, 0));
        while (!que.isEmpty()) {
            Node node = que.poll();
            if (node.depth == numbers.length-1) {
                if (node.value == target) {
                    cnt++;
                }
                continue;
            }

            que.add(new Node(node.depth + 1, node.value + numbers[node.depth+1]));
            que.add(new Node(node.depth + 1, node.value + -numbers[node.depth+1]));
        }

        return cnt;
    }
}

class Node {
    int depth;
    int value;

    public Node(int depth, int value) {
        this.depth = depth;
        this.value = value;
    }
}
