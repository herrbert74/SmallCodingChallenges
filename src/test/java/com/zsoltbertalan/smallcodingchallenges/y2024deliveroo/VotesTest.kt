package com.zsoltbertalan.smallcodingchallenges.y2024deliveroo

import io.kotest.matchers.shouldBe
import java.util.stream.Stream
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

class VotesTest {

	@ParameterizedTest(name = "Best outlet for {0}, {1}")
	@MethodSource("votesProvider")
	fun `Function isPalindrome returns true for Palindromes`(
		city: String,
		votes: Int,
		expected: String
	) {
		highestRatedOutlet(city, votes) shouldBe expected
	}

	companion object {
		@JvmStatic
		fun votesProvider(): Stream<Arguments> {
			return Stream.of(
				arguments(
					"Seattle",
					400,
					"Cafe Juanita"
				),
				arguments(
					"Seattle",
					16204,
					""
				),
				arguments(
					"Miami",
					400,
					"Decode Air Bar"
				),
				arguments(
					"Miami",
					12869,
					""
				),
				arguments(
					"Omaha",
					400,
					"Barbeque Nation"
				),
				arguments(
					"Omaha",
					8200,
					"Peter Cat"
				),
				arguments(
					"Dallas",
					114,
					"AB's - Absolute Barbecues"
				),
				arguments(
					"Dallas",
					9063,
					"AB's - Absolute Barbecues"
				),
				arguments(
					"Denver",
					114,
					"Palladium Social"
				),
				arguments(
					"Denver",
					8000,
					"Joey's Pizza"
				)
			)
		}
	}
}
