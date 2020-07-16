plugins {
    id("java-library")
    id("kotlin")
}

dependencies {
    implementation(fileTree("libs") { include("*.jar") })
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}")
    implementation(project(":domain"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}