package com.zsoltbertalan.smallcodingchallenges.y202405flohealth

import kotlin.concurrent.thread

//Deadlock example - does not work
val resA = Object()
val resB = Object()

//Thread(){
//	val lockA = lock(resA)
//	val lockB = lock(resB)
//	actor.processA()
//	actor.processB()
//	actor.releaseA()
//	actor.processA()
//	actor.releaseB()
//	actor.releaseA()
//}

//Deadlock that works

object CoolObject {
	@Synchronized
	fun method1() {
		Thread.sleep(10 * 1000.toLong())
		HotObject.method2()
	}
}

object HotObject {
	@Synchronized
	fun method2() {
		Thread.sleep(10 * 1000.toLong())
		CoolObject.method1()
	}
}

fun main() {
	println("DeadlockApp:started")
	thread {
		CoolObject.method1()
	}
	thread {
		HotObject.method2()
	}
}