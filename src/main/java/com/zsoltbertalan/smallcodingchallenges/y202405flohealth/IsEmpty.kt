package com.zsoltbertalan.smallcodingchallenges.y202405flohealth

@Suppress("KotlinConstantConditions")
fun main(args: Array<String>) {
	val s: String? = null
	val v : Boolean? = s?.isEmpty()
	if (v == true) println("is empty")
	if (s.isNullOrEmpty()) println("is null or empty")
}

// output: is null or empty

//Implement isEmpty

@Suppress("EXTENSION_SHADOWED_BY_MEMBER", "ReplaceSizeZeroCheckWithIsEmpty")
fun String.isEmpty(): Boolean {
	return this.length == 0
}

//Implement isNullOrEmpty

@Suppress("ReplaceSizeZeroCheckWithIsEmpty")
fun String?.isNullOrEmpty(): Boolean {
	return this == null || this.length == 0
}


















