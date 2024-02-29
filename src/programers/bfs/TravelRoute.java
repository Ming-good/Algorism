package programers.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TravelRoute {

    public static void main(String[] args) {
        TravelRoute travelRoute = new TravelRoute();
        String[][] tikets = {{"ICN", "AAA"}, {"ICN", "CCC"}, {"CCC", "DDD"}, {"AAA", "BBB"}, {"AAA", "BBB"}, {"DDD", "ICN"}, {"BBB", "AAA"}};
        System.out.println(Arrays.toString(travelRoute.solution(tikets)));
    }
    public String[] solution(String[][] tickets) {
        Set<String> visitSet = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.add("ICN");
        return DFS(tickets, visitSet, "ICN", stack);
    }

    private String[] DFS(String[][] tickets, Set<String> visitSet, String start, Stack<String> stack) {
        String[] answer = null;
        System.out.println(stack.size());
        if (stack.size() == tickets.length + 1) {
            return stack.toArray(new String[0]);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0]) && !visitSet.contains(tickets[i][1]+i)) {
                list.add(tickets[i][1]+i);
            }
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            visitSet.add(list.get(i));
            stack.add(list.get(i).substring(0, 3));
            answer = DFS(tickets, visitSet, list.get(i).substring(0, 3), stack);
            stack.pop();
            visitSet.remove(list.get(i));
            if (answer != null && answer.length == tickets.length + 1) {
                break;
            }
        }
        return answer;
    }

}
