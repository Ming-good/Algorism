package bakjun.dp

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    var n = br.readLine().toInt()

    val map = Array(n) { IntArray(n) {0} }
    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        map[i] = IntArray(n){st.nextToken().toInt() }
    }

    var dp = Array(n) { LongArray(n) {0} }
    dp[0][0] = 1
    for (i in 0 until n) {
        for (j in 0 until n) {
            var jump = map[i][j]
            if (dp[i][j] == 0L || (i == n-1 && j == n-1)) continue

            if (j+jump < n) {
                dp[i][j+jump] += dp[i][j]
            }

            if (i+jump < n) {
                dp[i+jump][j] += dp[i][j]
            }
        }
    }
    println(dp[n-1][n-1])

}