package bakjun.dp

import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    var maxDp = IntArray(3)
    var minDp = IntArray(3)
    val st = StringTokenizer(br.readLine())
    for(i in 0 until 3) {
        var v = st.nextToken().toInt()
        maxDp[i] = v
        minDp[i] = v
    }

    for (i in 1 until n) {
        val st = StringTokenizer(br.readLine())
        val x0 = st.nextToken().toInt()
        val x1 = st.nextToken().toInt()
        val x2 = st.nextToken().toInt()

        val nextMax0 = maxOf(maxDp[0], maxDp[1]) + x0
        val nextMax1 = maxOf(maxDp[0], maxDp[1], maxDp[2]) + x1
        val nextMax2 = maxOf(maxDp[1], maxDp[2]) + x2

        val nextMin0 = minOf(minDp[0], minDp[1]) + x0
        val nextMin1 = minOf(minDp[0], minDp[1], minDp[2]) + x1
        val nextMin2 = minOf(minDp[1], minDp[2]) + x2

        maxDp[0]=nextMax0;maxDp[1]=nextMax1;maxDp[2]=nextMax2
        minDp[0]=nextMin0;minDp[1]=nextMin1;minDp[2]=nextMin2
    }
    println("${maxOf(maxDp[0], maxDp[1], maxDp[2])} ${minOf(minDp[0], minDp[1], minDp[2])}")
}
