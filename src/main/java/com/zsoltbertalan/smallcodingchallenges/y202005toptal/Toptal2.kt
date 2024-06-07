package com.zsoltbertalan.smallcodingchallenges.y202005toptal

/**

X = [2, -1, -4, -3, 3]
Y = [2, -2, 4, 1, -3]
S = "ABCDA"
Kth point is X[K], Y[K] tag is S[K]
circle centered on 0,0

Max number of points within circle
If two circles are equal length with same tag, don't add them
 */
/*
@ExperimentalStdlibApi
fun solution(S: String, X: IntArray, Y: IntArray): Int {

}

@ExperimentalStdlibApi
fun main(args: Array<String>) {
	//val scan = Scanner(System.`in`)

	val nm = args[0].split(" ")

	val n = nm[0].trim().toInt()

	val m = nm[1].trim().toInt()

	val queries = Array<Array<Int>>(m, { Array<Int>(3, { 0 }) })

	for (i in 0 until m) {
		queries[i] = args[i + 1].split(" ").map { it.trim().toInt() }.toTypedArray()
	}

	val result = arrayManipulation(n, queries)

	println(result)
}*/