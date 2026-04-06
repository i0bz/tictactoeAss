plugins {
    id("java")
    id("application")
}

application {
    mainClass.set("tictactoe.Main")
}

group = "tictactoe"
var groupName: String = group.toString()
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}


tasks.register<JavaExec>("runOnly") {
    group = "Custom"
    description = "run recent build"
    classpath = files("build/libs/${rootProject.name}-${version}.jar")
    mainClass.set("${groupName}.Main")
}

tasks.test {
    useJUnitPlatform()
}