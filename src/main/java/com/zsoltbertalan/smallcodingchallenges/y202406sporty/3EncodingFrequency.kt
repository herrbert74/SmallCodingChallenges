package com.zsoltbertalan.smallcodingchallenges.y202406sporty

/*
 * Complete the 'frequency' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts STRING s as parameter.
 *
 * 1226#24# -> 1,2,26,24 -> return the frequency array
 * 1(2)23(3) -> 1,1,2,3,3,3 -> return the frequency array
 * 1(2)23#(3) -> 1,1,23,23,23 -> return the frequency array
 */

fun frequency(s: String): Array<Int> {
	val result = Array(26) { 0 }
	var pointer = 0
	while (pointer < s.length) {
		if (pointer + 5 < s.length && s.substring(pointer + 2, pointer + 4) == "#(") {
			val code = s.substring(pointer, pointer + 2).toInt()
			val count = s[pointer + 4].digitToInt()
			result[code - 1] += count
			pointer += 6
		} else if (pointer + 2 < s.length && s[pointer + 2] == '#') {
			val code = s.substring(pointer, pointer + 2).toInt()
			result[code - 1]++
			pointer += 3
		} else if (pointer + 3 < s.length && s[pointer + 1] == '(') {
			val count = s[pointer + 2].digitToInt()
			result[s[pointer].digitToInt() - 1] += count
			pointer += 4
		} else {
			result[s[pointer].digitToInt() - 1]++
			pointer++
		}
	}
	return result
}

fun main(args: Array<String>) {
	val s = readLine()!!

	val result = frequency(s)

	println(result.joinToString("\n"))
}
