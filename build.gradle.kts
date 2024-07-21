import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "2.0.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0")
	implementation("com.google.code.gson:gson:2.11.0")
	testImplementation(platform("org.junit:junit-bom:5.10.0"))
	testImplementation("org.junit.jupiter:junit-jupiter")
	testImplementation("org.jetbrains.kotlin:kotlin-test")
	testImplementation("org.junit.jupiter:junit-jupiter-params:5.1.0")
	testImplementation("io.kotest:kotest-assertions-core:5.8.1")
}

tasks.test {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile>().configureEach {
	kotlin.compilerOptions.freeCompilerArgs.add("-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi")
}