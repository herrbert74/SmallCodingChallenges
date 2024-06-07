package com.zsoltbertalan.smallcodingchallenges.y202403reddit

import io.kotest.matchers.shouldBe
import java.util.stream.Stream
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource


class RedditMenuTest {

	@ParameterizedTest(name = "reddit menu for {0}")
	@MethodSource("menuProvider")
	fun `Function isPalindrome returns true for Palindromes`(
		menu: Map<String, Int>,
		coins: Int,
		expected: List<List<String>>
	) {
		getCombinations(menu, coins) shouldBe expected
	}

	companion object {
		@JvmStatic
		fun menuProvider(): Stream<Arguments> {
			return Stream.of(
				arguments(
					mapOf("a" to 150, "b" to 200, "c" to 100),
					400,
					listOf(listOf("a"), listOf("a", "b"), listOf("a", "c"), listOf("b"), listOf("b", "c"), listOf("c"))
				),
				arguments(
					mapOf("a" to 150, "b" to 200, "c" to 100, "d" to 50),
					400,
					listOf(listOf("a"), listOf("a", "b"), listOf("a", "b", "d"),  listOf("a", "c"), listOf("a", "c", "d"),  listOf("a", "d"), listOf("b"), listOf("b", "c"), listOf("b", "c", "d"), listOf("b", "d"), listOf("c"),  listOf("c", "d"), listOf("d"))
				)
			)
		}
	}
}
