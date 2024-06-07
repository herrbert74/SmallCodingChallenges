package com.zsoltbertalan.smallcodingchallenges.y202403reddit

/**
 * They serve an arbitrary long menu in the Reddit canteen.
 * The menu is described with a map of Strings and Ints.
 * We have a k number of coins.
 * Return all the possible combinations we can buy from the menu.
 */
fun getCombinations(menu: Map<String, Int>, coins: Int): List<List<String>> {
	val result = mutableListOf<List<String>>()
	val otherMenu = menu.toMutableMap()
	menu.forEach { item ->
		if (item.value <= coins) result.add(listOf(item.key))
		otherMenu.remove(item.key)
		val others = getCombinations(otherMenu, coins - item.value)
		others.forEach { otherList ->
			val l = mutableListOf(item.key)
			l.addAll(otherList)
			result.add(l)
		}
	}
	return result
}

fun main(args: Array<String>) {
	val coins = readLine()!!.trim().toInt()

	val arr = readLine()!!.trimEnd().split(" ").map { it }.toTypedArray()

	val brr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

	val menu = mutableMapOf<String, Int>()
	for (i in arr.indices) {
		menu[arr[i]] = brr[i]
	}

	val combinations = getCombinations(menu, coins)

	combinations.forEach {
		println(it)
	}

}
