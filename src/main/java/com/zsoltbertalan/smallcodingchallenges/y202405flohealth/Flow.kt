package com.zsoltbertalan.smallcodingchallenges.y202405flohealth

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

suspend fun main() {
	coroutineScope { //was: viewModelScope
		flowOf(loadData()) // Thread: original -> IO
			.map { data -> data.grade } // Thread: original -> IO
			.filter { grade -> grade > 5 } // Thread: original -> IO
			.flowOn(Dispatchers.IO) // Thread: IO
			.flatMapConcat { grade -> loadUsers(grade) } // Thread: IO -> Default
			.map { user -> user.name } // Thread: IO -> default
			.flowOn(Dispatchers.Default) // Thread: Default
			.collect {
				println(it)
				//textView.setText(it)
			} // Thread: original
	}
}

fun loadData() = Data(42) // takes 20 seconds

suspend fun loadUsers(grade: Int) = flowOf(User("Alice"), User("Bob"), User("Michael"))

data class Data(val grade: Int)
data class User(val name: String)

// output: "Alice", "Bob", "Michael"