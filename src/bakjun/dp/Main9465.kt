package bakjun.dp

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    var n = br.readLine().toInt()

    for(i in 0 until n) {
        var t = br.readLine().toInt()
        val st1 = StringTokenizer(br.readLine())
        val st2 = StringTokenizer(br.readLine())
        val stekers = arrayOf(IntArray(t) { st1.nextToken().toInt() }, IntArray(t) { st2.nextToken().toInt() })
        var dp = Array(2){ IntArray(t) }

        dp[0][0] = stekers[0][0]
        dp[1][0] = stekers[1][0]
        if (t > 1) {
            dp[0][1] = dp[1][0] + stekers[0][1]
            dp[1][1] = dp[0][0] + stekers[1][1]
            for (j in 2 until t) {
                dp[0][j] = maxOf(dp[1][j - 1], dp[1][j - 2]) + stekers[0][j]
                dp[1][j] = maxOf(dp[0][j - 1], dp[0][j - 2]) + stekers[1][j]
            }
        }

        println(maxOf(dp[0][t - 1], dp[1][t - 1]))
    }
}