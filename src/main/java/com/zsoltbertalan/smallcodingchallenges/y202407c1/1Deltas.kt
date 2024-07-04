package com.zsoltbertalan.smallcodingchallenges.y202407c1

fun solution(initialHealth: Int, deltas: List<Int>): Int {
	var result = initialHealth
	deltas.forEach {
		result += it
		if (result > 100) result = 100
		else if (result < 0) result = 0
	}
	return result
}