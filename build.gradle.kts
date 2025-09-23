buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:8.10.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.22")
    }
}

plugins {
    // If you apply Kotlin DSL for root, you can omit Android plugin here
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
