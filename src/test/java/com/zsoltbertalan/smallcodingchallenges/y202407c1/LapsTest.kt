package com.zsoltbertalan.smallcodingchallenges.y202407c1

import io.kotest.matchers.shouldBe
import java.util.stream.Stream
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource


class LapsTest {

	@ParameterizedTest(name = "laps test for {0}")
	@MethodSource("lapProvider")
	fun `laps returns correct order`(
		laps: MutableList<MutableList<String>>,
		expected: List<String>
	) {
		solution(laps) shouldBe expected
	}

	companion object {
		@JvmStatic
		fun lapProvider(): Stream<Arguments> {
			return Stream.of(
				arguments(
					listOf(
						listOf("Harold 154", "Gina 155", "Albert 151", "Joy 156"),
						listOf("Harold 145", "Gina 151", "Albert 160", "Joy 168"),
						listOf("Harold 154", "Gina 150", "Albert 145", "Joy 156"),
						listOf("Harold 154", "Gina 150", "Albert 145", "Joy 156"),
					),
					listOf("Joy", "Albert", "Gina", "Harold"),
				),
				arguments(
					listOf(
						listOf("Harold 159", "Gina 155", "Albert 151", "Joy 150"),
						listOf("Harold 145", "Gina 145", "Albert 151", "Joy 167"),
						listOf("Harold 154", "Gina 150", "Albert 145", "Joy 156"),
						listOf("Harold 154", "Gina 150", "Albert 145", "Joy 156"),
					),
					listOf("Harold", "Albert", "Joy", "Gina"),
				)
			)
		}
	}
}