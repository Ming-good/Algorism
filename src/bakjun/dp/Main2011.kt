package bakjun.dp

fun main() {
    val br = System.`in`.bufferedReader()
    var chars = br.readLine()
    var n = chars.length
    var dp = LongArray(n+1)
    val MOD = 1_000_000L

    if (chars[0] == '0') {
        println(0)
        return
    }

    dp[0] = 1
    dp[1] = 1
    for(i in 2 ..  n) {
        val oneDigit = chars[i-1] - '0'
        val twoDigit = (chars[i-2] - '0') * 10 + oneDigit

        if (oneDigit in 1..9) {
            dp[i] = dp[i-1]%MOD
        }

        if (twoDigit in 10..26) {
            dp[i] = (dp[i] + dp[i-2])%MOD
        }
    }
    println(dp[n])
}