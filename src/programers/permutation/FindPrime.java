package programers.permutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class FindPrime {

    public static void main(String[] args) {
        FindPrime findPrime = new FindPrime();
        System.out.println(findPrime.solution("9910"));

    }

    private HashSet set = new HashSet();
    public int solution(String numbers) {
        int answer = 0;
        for (int i = 1; i <= numbers.length(); i++) {
            answer += permutation(i, new boolean[numbers.length()], new LinkedList<>(), numbers);
        }
        return answer;
    }

    private int permutation(int r, boolean[] visit, LinkedList<String> list,String numbers) {
        int chk=0;
        if (list.size() == r && isPrime(Integer.valueOf(list.stream().collect(Collectors.joining())))) {
            return 1;
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                list.add(String.valueOf(numbers.charAt(i)));
                chk+=permutation(r, visit, list, numbers);
                list.removeLast();
                visit[i] = false;
            }
        }
        return chk;
    }

    private boolean isPrime(int num) {
        if (num == 1 || num == 0 || set.contains(num)) {
            return false;
        }

        set.add(num);

        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


//    문제 설명
//    한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
//
//    각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
//
//    제한사항
//    numbers는 길이 1 이상 7 이하인 문자열입니다.
//    numbers는 0~9까지 숫자만으로 이루어져 있습니다.
//            "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
//    입출력 예
//    numbers	return
//            "17"	3
//            "011"	2
//    입출력 예 설명
//    예제 #1
//            [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
//
//    예제 #2
//            [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
//
//            11과 011은 같은 숫자로 취급합니다.
}
