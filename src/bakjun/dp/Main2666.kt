package bakjun.dp

import kotlin.math.abs
import kotlin.math.min


fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var door = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    var k = br.readLine().toInt()

    var seq = IntArray(k+1)
    for (i in 1 .. k) {
        seq[i] = br.readLine().toInt()
    }
    println(solve(1, door[0], door[1], k, seq))

}
val memo = Array(21) { Array(21) { IntArray(21) { -1 } } }
fun solve(step: Int, d1:Int, d2:Int, k:Int, seq:IntArray):Int {
    if(step > k) {
        return 0
    }
    if (memo[step][d1][d2] > -1) return memo[step][d1][d2]

    var min1 = abs(d1 - seq[step]) + solve(step+1,seq[step], d2, k, seq)
    var min2 = abs(d2 - seq[step]) + solve(step+1,d1, seq[step], k, seq)

    memo[step][d1][d2] = min(min1, min2)
    return memo[step][d1][d2]
}