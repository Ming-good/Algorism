package programers.brute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*[문제점]
* 1. 문제를 제대로 파악하지 못함.
* */
public class Album {

    public static void main(String[] args) {
        String[] genres = {"classic","classic","classic", "pop","pop", "classic", "classic", "ko"};
        int[] plays = {500,500,500, 600,600, 150, 800, 1000};
        Album album = new Album();
        int[] solution = album.solution(genres, plays);
        System.out.println(Arrays.toString(solution));
    }
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> resultList = new ArrayList();
        HashMap<String, List<Integer>> genresListMap = new HashMap<String, List<Integer>>();
        HashMap<String,Integer> bestPlays = new HashMap<String, Integer>();

        for (int i = 0; i < genres.length; i++) {
            if (!genresListMap.containsKey(genres[i])) {
                genresListMap.put(genres[i], new ArrayList<>());
                bestPlays.put(genres[i], 0);
            }
            List<Integer> playList = genresListMap.get(genres[i]);
            playList.add(i);

            bestPlays.put(genres[i], plays[i]+bestPlays.get(genres[i]));
        }
        while (genresListMap.size() > 0) {
            String genre = "";
            int tmpBestPlay = 0;
            for (String genreNm : bestPlays.keySet()) {
                if (tmpBestPlay < bestPlays.get(genreNm)) {
                    tmpBestPlay = bestPlays.get(genreNm);
                    genre = genreNm;
                }
            }

            List<Integer> genresList = genresListMap.get(genre);
            int firstI = -1;
            int secondI = -1;
            int firstPlay = 0;
            int secondPlay = 0;
            for (int i=0;i<genresList.size();i++) {
                if (firstPlay < plays[genresList.get(i)]) {
                    secondPlay = firstPlay;
                    secondI = firstI;
                    firstPlay = plays[genresList.get(i)];
                    firstI = genresList.get(i);
                } else if (secondPlay<plays[genresList.get(i)]) {
                    secondPlay = plays[genresList.get(i)];
                    secondI = genresList.get(i);
                }
            }
            resultList.add(firstI);
            if(secondI != -1) {
                resultList.add(secondI);
            }

            genresListMap.remove(genre);
            bestPlays.remove(genre);
        }
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}
