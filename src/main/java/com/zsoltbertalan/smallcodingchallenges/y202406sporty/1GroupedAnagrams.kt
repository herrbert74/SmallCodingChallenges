package com.zsoltbertalan.smallcodingchallenges.y202406sporty

/*
 * Complete the 'getGroupedAnagrams' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING_ARRAY words as parameter.
 *
 * [cat, cat] -> 2 possible groups
 * [cat, act] -> 1
 * [cat, cat, act] -> 2 (1 match)
 * [cat, cat, act, act] -> 2 (2 matches)
 * [cat, cat, cat, act] -> 3 (3 matches)
 * [cat, cat, cat, act, act, act] -> 3 (3 matches)
 */

fun getGroupedAnagrams(words: Array<String>): Int {
	val sortedToOriginalHashes = hashMapOf<Int, MutableList<Int>>()
	words.forEach { word ->
		val counts = word.groupingBy { it }.eachCount()
		val originalHash = word.hashCode()
		val sortedHash = counts.toSortedMap().hashCode()
		sortedToOriginalHashes.getOrPut(sortedHash) { mutableListOf() }.add(originalHash)
	}
	var result = 0
	sortedToOriginalHashes.forEach { entry ->
		val counts = entry.value.groupingBy { it }.eachCount()
		result += counts.values.max()
	}
	return result
}

fun main(args: Array<String>) {
	val wordsCount = readLine()!!.trim().toInt()

	val words = Array<String>(wordsCount, { "" })
	for (i in 0 until wordsCount) {
		val wordsItem = readLine()!!
		words[i] = wordsItem
	}

	val result = getGroupedAnagrams(words)

	println(result)
}