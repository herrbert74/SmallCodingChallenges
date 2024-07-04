package com.zsoltbertalan.smallcodingchallenges.y202407c1

fun solution(laps: MutableList<MutableList<String>>): MutableList<String> {
	val eliminations = mutableListOf<String>()
	val bests = mutableMapOf<String, Int>()
	laps.forEach { lap ->
		var max = 0
		val currentEliminations = mutableListOf<String>()
		lap.forEach { playerResult ->
			val sp = playerResult.split(" ")
			if (!eliminations.contains(sp.first())) {
				if (!bests.containsKey(sp.first())) {
					bests[sp.first()] = 1000
				}
				if (sp[1].toInt() < bests.getOrElse(sp.first()) { 1000 }) {
					bests[sp.first()] = sp[1].toInt()
				}
				if (bests[sp.first()]!! > max) {
					max = bests[sp.first()]!!
					currentEliminations.clear()
					currentEliminations.add(sp.first())
				} else if (bests[sp.first()]!! == max) {
					currentEliminations.add(sp.first())
				}
			}
		}
		currentEliminations.sort()
		eliminations.addAll(currentEliminations)

	}
	return eliminations
}
