package programers.dp;

public class SchoolLoad {

    public static void main(String[] args) {
        int[][] puddles = {{2, 2}};
        SchoolLoad schoolLoad = new SchoolLoad();
        System.out.println(schoolLoad.solution(4, 3, puddles));

    }
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m+1][n+1];
        for (int i = 0; i < puddles.length; i++) {
            map[puddles[i][0]][puddles[i][1]] = -1;
        }
        map[1][1] = 1;

        for (int i = 1; i <= m; i++) {
            int left = i-1;
            for (int z = 1; z <= n; z++) {
                if (map[i][z] < 0) {
                    map[i][z] = 0;
                    continue;
                }
                if ((i==1 && z==1)) {
                    continue;
                }
                map[i][z] = (map[left][z] + map[i][z - 1])%1000000007;
            }
        }
        return map[m][n];
    }
}
