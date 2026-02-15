package bakjun.dp

fun main() {
    val br = System.`in`.bufferedReader()
    var n = br.readLine().toInt()

    var dp = Array(n){LongArray(3) }
    dp[0][0] = 1
    dp[0][1] = 1
    dp[0][2] = 1

    if (n <= 1) {
        println((dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2]) % 9901L)
        return;
    }

    for(i in 1 until n) {
        dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%9901L
        dp[i][1] = (dp[i-1][0] + dp[i-1][2])%9901L
        dp[i][2] = (dp[i-1][0] + dp[i-1][1])%9901L
    }

    println((dp[n-1][0] +dp[n-1][1] + dp[n-1][2])%9901L)

}