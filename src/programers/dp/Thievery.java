package programers.dp;

public class Thievery {

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        Thievery thievery = new Thievery();
        System.out.println(thievery.solution(arr));
    }
    public int solution(int[] money) {
        int[] getMoney = new int[money.length];
        int[] getNotMoney = new int[money.length];

        getMoney[0] = getMoney[1] = money[0];
        getNotMoney[1] = money[1];

        for (int i = 2; i < money.length; i++) {
            getNotMoney[i] = Math.max(getNotMoney[i - 2] + money[i], getNotMoney[i - 1]);
            if(i == money.length-1) break;
            getMoney[i] = Math.max(getMoney[i - 2] + money[i], getMoney[i - 1]);
        }

        return Math.max(getNotMoney[money.length-1], getMoney[money.length-2]);
    }
}
