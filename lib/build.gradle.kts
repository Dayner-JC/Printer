plugins {
    id("java-library")
}

java {
}
dependencies {
    implementation(kotlin("stdlib-jdk8"))
}
repositories {

}

java {
    sourceCompatibility = JavaVersion.VERSION_18
    targetCompatibility = JavaVersion.VERSION_18
}