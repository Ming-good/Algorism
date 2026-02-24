package bakjun.dp

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    var n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    var boxs = Array(n){st.nextToken().toInt()}

    var dp = IntArray(n){1}
    for (i in 0 until n) {
        for (j in 0 until i) {
            if (boxs[j] < boxs[i]) {
                dp[i] = maxOf(dp[i], dp[j]+1)
            }
        }
    }

    println(dp.maxOrNull())
}