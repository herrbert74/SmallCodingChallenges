package com.zsoltbertalan.smallcodingchallenges.y202407c1

/**
 * @param commands List of Unix commands, or the ordinal of a command in the form of !ordinal, like !1
 * @return list of three Integers, count of: "cp", "ls", "mv"
 */
fun solution(commands: List<String>): List<Int> {
	val result = mutableListOf<String>()
	commands.forEach {
		if (it.startsWith("!")) {
			val ordinal = it.drop(1).toInt()
			result.add(result[ordinal])
		} else result.add(it)
	}
	val groups = result.groupingBy { it }.eachCount()
	return listOf(groups.getOrElse("cp") { 0 }, groups.getOrElse("ls") { 0 }, groups.getOrElse("mv") { 0 })
}