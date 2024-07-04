package com.zsoltbertalan.smallcodingchallenges.y202407c1

/**
 * How many distinct pairs you can get by swapping no more than two digits to get another of the input numbers?
 * For example for [123, 321, 123], You can get three: {123->123}, {123->321}, {321->123}
 * @return number of pairs
 */
fun solution(numbers: List<Int>): Int {
	var result = initialHealth
	numbers.forEach {
		result += it
		if (result > 100) result = 100
		else if (result < 0) result = 0
	}
	return result
}