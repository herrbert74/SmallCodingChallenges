package com.zsoltbertalan.smallcodingchallenges.y202005toptal

import kotlin.math.min

/**

Merge list K and L
It takes K+L ms.

Three lists have 3 combinations
More have more

Find the minimum time needed

A is the size of the lists

Tests
"100 250 1000" -> 1700
"100 200 300 400" -> 1900
"34 1 200 30 69 45 128" -> 1199
"1 2 3 4 5 6 7 8" -> 102
"10 10 10 10" -> 40
 */

/*
Original solution doesn't work in all cases
@ExperimentalStdlibApi
fun solution(A: IntArray): Int {
	A.sortDescending()
	val result = A.foldIndexed(0) { index, acc, elem ->
		acc + (index + 1) * elem
	}
	return result - A[A.size - 1]
}*/

@ExperimentalStdlibApi
fun solution(A: IntArray): Int {
	A.sortDescending()
	return getMinimumTime(A)
}

fun getMinimumTime(a: IntArray): Int {
	var result = 0
	for (i in 1 until a.size) {
		val first = a.copyOfRange(0, i)
		val second = a.copyOfRange(i, a.size)
		val x = if (first.size == 1)
			0
		else
			getMinimumTime(first)
		val y = if (second.size == 1)
			0
		else
			getMinimumTime(second)
		result = if (result == 0) a.sum() + x + y else min(result, a.sum() + x + y)
	}
	a.sum()
	return result
}

@ExperimentalStdlibApi
fun main(args: Array<String>) {

	val lists = readln().trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

	val result = solution(lists.toIntArray())

	println(result)
}