package com.zsoltbertalan.smallcodingchallenges.y2024deliveroo

import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

/**
 * Given a city and a minimum vote number, download all the restaurants, filter for minimum number of votes, and return the restaurant with the highest rating.
 *
 * If more than one restaurant have the same rating, return the one with the more votes.
 *
 * API: https://jsonmock.hackerrank.com/api/food_outlets?city={city}&page={page}
 */

data class Response(
	val page: Int,
	val per_page: Int,
	val total: Int,
	val total_pages: Int,
	val data: List<Outlet>,
)

data class Outlet(
	val id: Int,
	val city: String,
	val name: String,
	val estimated_cost: Int,
	val user_rating: UserRating,
)

data class UserRating(
	val average_rating: Float,
	val votes: Int,
)

fun highestRatedOutlet(city: String, votes: Int): String {
	val url = URL("https://jsonmock.hackerrank.com/api/food_outlets?city=$city&page=1")
	val list = mutableListOf<Outlet>()
	val response = getPage(url)
	list.addAll(response?.data.orEmpty())
	val pageCount = response?.total_pages ?: 0

	for (i in 2..pageCount) {
		val url2 = URL("https://jsonmock.hackerrank.com/api/food_outlets?city=$city&page=$i")
		val response2 = getPage(url2)
		list.addAll(response2?.data.orEmpty())
	}

	list.removeAll { it.user_rating.votes < votes }

	val max = list.maxByOrNull { it.user_rating.average_rating }
	list.removeAll { it.user_rating.average_rating < (max?.user_rating?.average_rating ?: 0.0f) }

	val maxResult = list.maxByOrNull { it.user_rating.votes }
	return maxResult?.name ?: ""
}

fun getPage(url: URL): Response? {
	var result: Response? = null
	val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
	try {

		val br = BufferedReader(InputStreamReader(connection.inputStream))
		val sb = StringBuilder()
		var line: String?
		while ((br.readLine().also { line = it }) != null) {
			sb.append(line)
		}

		// use the string builder directly,
		// or convert it into a String
		val body = sb.toString()

		result = Gson().fromJson(body, Response::class.java)
	} catch (e: Exception) {
	} finally {

		connection.disconnect();
	}
	return result
}

fun main(args: Array<String>) {
	val city = readln()
	val votes = readln().toInt()
	println(highestRatedOutlet(city, votes))
}