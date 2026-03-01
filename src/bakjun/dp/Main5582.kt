package bakjun.dp

import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    var s = br.readLine()
    var t = br.readLine()

    var dp = Array(s.length+1) {IntArray(t.length+1)}

    var maxSize = 0
    for (i in 1 .. s.length ) {
        for (j in 1 .. t.length) {
            if (s[i-1] == t[j-1]) {
                dp[i][j] = dp[i-1][j-1] + 1
                maxSize = max(maxSize, dp[i][j])
            }
        }
    }

    println(maxSize)
}