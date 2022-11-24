import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.5"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "com.example.eqmanager"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc:2.7.5")
	implementation("org.springframework.boot:spring-boot-starter:2.7.5")
	implementation("org.springframework.boot:spring-boot-starter-web:2.7.5")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	developmentOnly("org.springframework.boot:spring-boot-devtools:2.7.5")
	testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.5")

	runtimeOnly("org.postgresql:postgresql:42.5.0")
	runtimeOnly("org.webjars:jquery:3.6.1")
	runtimeOnly("org.webjars:jquery-ui:1.13.2")
	runtimeOnly ("org.webjars:bootstrap:5.2.2")
	runtimeOnly ("org.webjars:webjars-locator:0.45")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
