package bakjun.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2590 {
    private static int[] pages = new int[6];
    private static int boardCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 6; i++) {
            pages[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 5; i >= 0; i--) {
            while(pages[i] >=1) {
                int block = 36 - (i+1) * (i+1);

                boardCnt++;
                pages[i]--;

                if (i==5) {
                    continue;
                }

                if (i==4) {
                    block = cutPage(1, block);
                }else if (i == 3) {
                    block = cutPage(2, block);
                }else if (i==2) {
                    block = cutPage(3, block);
                    if (block >= 27) {
                        int cnt = 5;
                        while (pages[1] > 0 && cnt>0) {
                            pages[1]--;
                            block -= 4;
                            cnt--;
                        }
                    } else if (block >= 18) {
                        int cnt = 3;
                        while (pages[1] > 0 && cnt>0) {
                            pages[1]--;
                            block -= 4;
                            cnt--;

                        }
                    } else if (block >= 9) {
                        int cnt = 1;
                        while (pages[1] > 0 && cnt>0) {
                            pages[1]--;
                            block -= 4;
                            cnt--;
                        }
                    }
                }else if (i==1) {
                    block = cutPage(2, block);
                }

                pages[0] -= block;
            }
        }

        System.out.println(boardCnt);
    }

    private static int cutPage(int size, int block) {
        while(pages[size-1] >= 1 && block>0) {
            block -= size*size;
            pages[size-1]--;
        }
        return block;
    }
}
