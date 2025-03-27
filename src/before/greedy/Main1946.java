package before.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main1946 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] passedPerson = new int[n];
        for(int i=0;i<n;i++) {
           int interviewSize =  Integer.parseInt(br.readLine());
           PriorityQueue<Integer> queueA = new PriorityQueue<Integer>();
           PriorityQueue<Integer> queueB = new PriorityQueue<Integer>();

           for(int j=0;j<interviewSize;j++) {
               String[] persons = br.readLine().split(" ");
               queueA.add(Integer.parseInt(persons[0]));
               queueB.add(Integer.parseInt(persons[1]));
           }
            passedPerson[i] = Math.max(interview(queueA), interview(queueB));
        }

        for(int person : passedPerson) {
            System.out.println(person);
        }

    }

    private static int interview(PriorityQueue<Integer> queue) {
        int cnt = 0;
        int personA = queue.poll();
        while(!queue.isEmpty()) {
            int personB = queue.poll();
            if(personA < personB) {
                cnt++;
            }
        }

        return cnt;
    }

}
