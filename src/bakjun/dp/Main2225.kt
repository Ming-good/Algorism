package bakjun.dp

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()

    val st = StringTokenizer(br.readLine())
    var n = st.nextToken().toInt()
    var k = st.nextToken().toInt()

    var dp = Array(k+1){ LongArray(n+1) }

    val MOD = 1_000_000_000

    for (i in 1..n) {
        dp[1][i] = 1
    }

    for (i in 1..k) {
        dp[i][0] = 1
        for (j in 1..n) {
            dp[i][j] = (dp[i-1][j] + dp[i][j-1])%MOD
        }
    }
    println(dp[k][n]%MOD)
}