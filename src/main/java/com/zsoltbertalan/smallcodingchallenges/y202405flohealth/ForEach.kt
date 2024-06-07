package com.zsoltbertalan.smallcodingchallenges.y202405flohealth

//What will be printed?
fun numbers(list: List<Int>) {
	list.forEach {
		if (it > 2) return
		print(it)
	}
	print("ok")
}

fun main(args: Array<String>) {
	numbers(listOf(1, 2, 3, 2, 1))
}

// output: 12

//Implement forEach
inline fun <K> List<K>.forEach(lambda: (K) -> Unit) : Unit {
	for(i in 0..this.size) {
		val k = this[i]
		lambda.invoke(k)
	}
}