plugins {
    id("java")
    id("application")
}

application {
    mainClass.set("Main")
    applicationDefaultJvmArgs = listOf("--enable-native-access=ALL-UNNAMED")
}

group = "tictactoe"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.formdev:flatlaf:3.7")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}



tasks.jar {
    manifest {
        attributes["Main-Class"] = "Main"
    }
}
tasks.register<JavaExec>("runLatest") {
    val jarFile = file(tasks.jar.get().archiveFile.get().asFile)

    if (!jarFile.exists()) {
        dependsOn(tasks.jar)
    }

    description = "run latest build"
    classpath = files(jarFile) + sourceSets.main.get().runtimeClasspath
    mainClass.set("Main")

    jvmArgs("--enable-native-access=ALL-UNNAMED")
}
tasks.test {
    useJUnitPlatform()
}