package com.zsoltbertalan.smallcodingchallenges.y202406sporty

import java.util.*


/*
* Complete the 'matchingBraces' function below.
*
* The function is expected to return a STRING_ARRAY.
* The function accepts STRING_ARRAY braces as parameter.
*/

fun matchingBraces(braces: Array<String>): Array<String> {
	return braces.map { s ->
		match(s)
	}.toTypedArray()

}

private fun match(s: String): String {
	val openers = "[{("
	val stack = Stack<Char>()
	s.forEach {
		if (openers.contains(it)) {
			stack.add(it)
		} else {
			if (stack.empty()) return "NO"
			val top = stack.peek()
			if ((it == ')' && top == '(') || (it == ']' && top == '[') || (it == '}' && top == '{')) {
				stack.pop()
			} else {
				return "NO"
			}
		}
	}

	return if (stack.empty()) "YES" else "NO"
}

fun main(args: Array<String>) {
	val bracesCount = readLine()!!.trim().toInt()

	val braces = Array<String>(bracesCount, { "" })
	for (i in 0 until bracesCount) {
		val bracesItem = readLine()!!
		braces[i] = bracesItem
	}

	val result = matchingBraces(braces)

	println(result.joinToString("\n"))
}