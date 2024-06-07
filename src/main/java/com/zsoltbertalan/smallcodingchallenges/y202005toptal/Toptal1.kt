package com.zsoltbertalan.smallcodingchallenges.y202005toptal

/**

ABBBCCDDCCC -> A3B4C

K number of letters is to be removed from original

Return shortest possible

"ABBBCCDDCCC" "2" -> 8
 */

fun removeCode(S: String, K: Int): Int {
	val headPairs: Pair<List<Int>, List<Char>> = Pair(mutableListOf(), mutableListOf())

	//Coded Pairs: Pair<List<Int>, List<Char>>
	val charSizes = emptyList<Int>().toMutableList()
	val chars = emptyList<Char>().toMutableList()
	val tailPairs = S.substring(K).fold(charSizes to chars) { acc, elem ->
		val sizesList = acc.first
		val charsList = acc.second
		if (charsList.isNotEmpty() && charsList.last() == elem) {
			sizesList[sizesList.size - 1]++
		} else {
			sizesList.add(1)
			charsList.add(elem)
		}
		sizesList to charsList
	}
	var min = tailPairs.first.filterNot { it == 1 }.size + tailPairs.first.size
	val k = S.windowed(K, 1) { window ->
		val headSizes = headPairs.first as MutableList<Int>
		val headChars = headPairs.second as MutableList
		if (headChars.isEmpty() || headChars.last() == window[0]) {
			headSizes.add(1)
			headChars.add(window[0])
		} else {
			headSizes[headSizes.size - 1] = 1
		}
		val tailSizes = tailPairs.first
		val tailChars = tailPairs.second
		if (tailSizes.first() == 1) {
			tailSizes.removeAt(0)
			tailChars.removeAt(0)
		} else {
			headSizes[0] = headSizes[0] - 1
		}
		//Connect the head and the tail
		val connectedSizes: MutableList<Int> = headSizes
		if (headChars.last() == tailChars.first()) {
			connectedSizes[connectedSizes.size - 1] += tailSizes[0]
			connectedSizes.addAll(tailSizes.drop(1))
		} else {
			connectedSizes.addAll(tailSizes)
		}
		//Calculate new minimum
		min = kotlin.math.min(min, connectedSizes.filterNot { it == 1 }.size + connectedSizes.size)
	}
	return min
}

@ExperimentalStdlibApi
fun main(args: Array<String>) {

	val input = readln().trimEnd().split(" ")
	val r = removeCode(input[0], input[1].toInt())
	//val result = removeCode(args[0], args[1].toInt())

	println(r)
}