package programers.dfs.transformWord;
class TransformWordV1 {
    public int solution(String begin, String target, String[] words) {
        Find find = new Find(begin, target, words);
        for(String checkWrod : words) {
            if(target.equals(checkWrod)) {
                find.result = 999;
            }
        }
        find.dfs(begin, 0);
        return find.result;
    }

    static class Find{
        private final String target;
        private String[] words;
        private int relation[][];
        private boolean visit[][];
        public int result = 0;
        private int min = 0;

        public Find(String begin, String target, String[] words){
            this.target = target;
            this.words = words;
            this.relation = new int[words.length][words.length];
            this.visit = new boolean[words.length][words.length];
        }

        public void init(String begin, int n) {
            for(int i=0;i<this.words.length;i++) {
                int count = 0;
                if(!begin.equals(this.words[i]) && begin.length() == this.words[i].length() && this.visit[n][i] == false) {
                    for(int j=0;j<this.words[i].length();j++) {
                        if(begin.charAt(j) != this.words[i].charAt(j))
                            count++;
                    }

                    if(count == 1) {
                        this.relation[n][i] = 1;
                    }
                }
            }
        }

        public void dfs(String begin, int i) {
            if(begin.equals(this.target)) {
                this.result = this.result > this.min ? this.min : this.result;
                return;
            }

            if(i>=this.words.length)
                return;

            init(begin, i);

            for(int j=0; j<this.words.length;j++) {
                if(this.relation[i][j] == 1 && this.visit[i][j] == false && !begin.equals(this.words[j])) {
                    this.visit[i][j] = true;
                    this.min++;
                    dfs(this.words[j], i+1);
                    this.min--;
                }
            }
        }
    }
}
