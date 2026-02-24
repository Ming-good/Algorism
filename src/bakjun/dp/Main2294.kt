package bakjun.dp

import java.util.*
import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val st = StringTokenizer(br.readLine())
    var N = st.nextToken().toInt()
    var K = st.nextToken().toInt()

    val coins = mutableSetOf<Int>()
    repeat(N) {
        coins.add(br.readLine().toInt())
    }
    var dp = Array<Int>(K+1){10001}
    dp[0] = 0

    for (coin in coins) {
        for(i in coin .. K) {
            dp[i] = min(dp[i], dp[i-coin] + 1)
        }
    }
    if (dp[K] == 10001) {
        println(-1)
        return
    }
    println(dp[K])
}