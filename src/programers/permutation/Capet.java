package programers.permutation;

public class Capet {

    public static void main(String[] args) {

    }
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int totalBlock = brown + yellow;

        for (int i = 3; i < totalBlock / 2; i++) {
            if (totalBlock % i != 0) {
                continue;
            }

            int x = Math.max(i,totalBlock/i);
            int y = Math.min(i,totalBlock/i);

            if(yellow == ((x-2)*(y-2))){
                answer[0] = x;
                answer[1] = y;
                break;
            }
        }

        return answer;
    }

    public int[] solution2(int brown, int yellow) {
        int[] answer = new int[2];
        int totalBlock = brown + yellow;

        for (int i = 3; i < totalBlock / 2; i++) {
            if (totalBlock % i != 0) {
                continue;
            }

            int x = Math.max(i,totalBlock/i);
            int y = Math.min(i,totalBlock/i);

            if(yellow == ((x-2)*(y-2))){
                answer[0] = x;
                answer[1] = y;
                break;
            }
        }

        return answer;
    }
}
