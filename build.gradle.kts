plugins {
	java
	id("org.springframework.boot") version "2.7.8"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	id("org.openapi.generator") version "6.3.0"
}

group = "com.betoola"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.liquibase:liquibase-core")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

openApiGenerate {
	generatorName.set("kotlin")
	inputSpec.set("$rootDir/src/main/resources/openapi/api.yaml")
	outputDir.set("$buildDir/generated")
	apiPackage.set("org.openapi.example.api")
	modelPackage.set("org.openapi.example.model")

}