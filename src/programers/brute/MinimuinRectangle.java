package programers.brute;

public class MinimuinRectangle {

    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        MinimuinRectangle minimuinRectangle = new MinimuinRectangle();
        System.out.println(minimuinRectangle.solution(sizes));
    }
    public int solution(int[][] sizes) {
        return brute(sizes);
    }

    private int brute(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        for (int w = 0; w < sizes.length; w++) {
            swap(sizes, w);
            maxW = Math.max(maxW,sizes[w][0]);
            maxH = Math.max(maxH, sizes[w][1]);
        }

        return maxW*maxH;
    }

    private void swap(int[][] sizes, int w){
        int temp = 0;
        if (sizes[w][0] < sizes[w][1]) {
            temp = sizes[w][0];
            sizes[w][0] = sizes[w][1];
            sizes[w][1] = temp;
        }
    }
}
