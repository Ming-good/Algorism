package programers.dfs;

public class Fatigue {

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        Fatigue fatigue = new Fatigue();
        System.out.println(fatigue.solution(k, dungeons));
    }
    public int solution(int k, int[][] dungeons) {
        return dfs(k, dungeons);
    }

    private int dfs(int k, int[][] dungeons) {
        int visitCnt = 0;
        for (int i = 0; i < dungeons.length; i++) {
            int a = dungeons[i][0], b = dungeons[i][1];
            if (k>=dungeons[i][0]) {
                dungeons[i][0] = 9999;
                visitCnt = Math.max(1+dfs(k - b, dungeons), visitCnt);
                dungeons[i][0] = a;
            }
        }
        return visitCnt;
    }
}
