package bakjun.dp

import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    var n = br.readLine().toInt()

    var sb = StringBuilder ()
    for (i in 0 until n) {
        var T = br.readLine().toInt()
        var arr = Array(2){ LongArray(T) }
        for (j in 0 ..1) {
            val st = StringTokenizer(br.readLine())
            arr[j] = LongArray(T){st.nextToken().toLong() }
        }

        var dp = Array(2){ LongArray(T) }
        dp[0][0] = arr[0][0]
        dp[1][0] = arr[1][0]

        if (T == 1) {
            sb.append(max(dp[0][T-1], dp[1][T-1])).append("\n")
            continue
        }

        dp[0][1] = dp[1][0] + arr[0][1]
        dp[1][1] = dp[0][0] + arr[1][1]

        if (T == 2) {
            sb.append(max(dp[0][T-1], dp[1][T-1])).append("\n")
            continue
        }

        for (j in 2 until  T) {
            dp[0][j] = max(dp[1][j-2] + arr[0][j], dp[1][j-1] + arr[0][j])
            dp[1][j] = max(dp[0][j-2] + arr[1][j], dp[0][j-1] + arr[1][j])
        }
        sb.append(max(dp[0][T-1], dp[1][T-1])).append("\n")
    }

    println(sb.trim())


}