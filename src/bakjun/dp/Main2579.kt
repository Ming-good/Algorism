package bakjun.dp

fun main() {
    val br = System.`in`.bufferedReader()

    val n: Int = br.readLine().toInt()
    var stageArr = Array(n+1){0}
    for(i in 1..n step 1) {
        stageArr[i] = br.readLine().toInt()
    }

    if (n == 1) {
        println(stageArr[1])
        return
    }

    var dpArr = Array(n+1){0}
    dpArr[1] = stageArr[1]
    dpArr[2] = stageArr[1] + stageArr[2]
    for (i in 3..n step 1) {
        dpArr[i] = Math.max(dpArr[i-2] + stageArr[i], dpArr[i-3] + stageArr[i-1] + stageArr[i])
    }
    println(dpArr[n])
}