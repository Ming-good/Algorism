package bakjun.dp

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    var n = br.readLine().toInt()

    var tk = StringTokenizer(br.readLine())
    var arr = IntArray(n){tk.nextToken().toInt()}

    var dp = IntArray(n){1}
    for (i in 0 until n) {
        for (j in 0 until i) {
            if (arr[j] < arr[i]) {
                dp[i] = maxOf(dp[i], dp[j]+1)
            }
        }
    }

    println(dp.maxOrNull())
}