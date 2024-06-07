package com.zsoltbertalan.smallcodingchallenges.y202404freetrade

data class Shop(val name: String, val customers: List<Customer>)
data class Customer(val name: String, val city: City, val orders: List<Order>)
data class Order(val products: List<Product>, val isDelivered: Boolean)
data class Product(val name: String, val price: Double)
data class City(val name: String)

/*
A supermarket wants to calculate the value of a customer's basket:

Prices
Coffee - £1
Orange - £2
Bread - £3

Basket
["coffee", "coffee", "orange", "orange", "orange", "bread"]
Normally, this basket would cost £11, but today we have a special offer: you can now buy 2 oranges for £3.

This means that, today, the basket costs £10.

Please implement a function that calculates the total value of the basket, including the special offer, and prints it to the console.
*/

fun main(s: Array<String>) {
	calculate(s)
}

fun calculate(s: Array<String>) {
	val m = s.groupingBy { it }.eachCount()
	val newMap = m.map {
		if(it.key == "orange") {
			val a = it.value / 2 * 3
			val b = (it.value % 2) * 2
			a + b
		} else {
			println(it.key)
			if(it.key.equals("coffee")) it.value
			else it.value * 3
		}
	}
	println("Cost is ${newMap.sum()}")
}
