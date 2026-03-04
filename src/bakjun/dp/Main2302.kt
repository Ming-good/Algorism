package bakjun.dp

fun main() {
    // 12 21   dp[2] = 2
    // 123 213 132 dp[3] = dp[2]+1
    // 1234 2134 1324 1243 2143  = dp[3]+dp[4-2]
    // 12345 21345 13245 12435 21435 12354 21354 13254 = dp[4]+ dp[5-2]

    // 12345 21345 13245 12435 21435 dp[5] = dp[4]
    // 123456 213456 132456 124356 214356 dp[6] = dp[5]
    // 1234567 2134567 1324567 1243567 2143567 1234576 2134576 1324576 1243576 2143576 dp[7] =  dp[6] + dp[6]
    // dp[8] = dp[7] + dp[8-2]

    // 123 213 dp[3] = dp[2] -- 0 = 이전값 유지
    // 1234 2134 dp[4] = dp[3] == 1 == 이전값 유지
    // 12345 12354 21345 21354 dp[5] = dp[4] + 2 == 2 = 이전값 + 2  ==> dp[4] + dp[4]
    // 123456 123546 213456 213546 123465 213465 dp[5] + 2

    val br = System.`in`.bufferedReader()
    val n:Int = br.readLine().toInt()
    val m:Int = br.readLine().toInt()
    var stableNum = IntArray(n+1)
    for (i in 1 .. m) {
        stableNum[br.readLine().toInt()] = 1
    }

    var dp = LongArray(n+1)
    dp[0] = 1
    dp[1] = 1
    for(i in 2 .. n) {
        if (stableNum[i] == 1 || stableNum[i-1] == 1) {
            dp[i] = dp[i-1]
        } else {
            dp[i] = dp[i-1] + dp[i-2]
        }
    }

    println(dp[n])
}