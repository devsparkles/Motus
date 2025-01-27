tasks.withType<Test> {
    useJUnitPlatform()
    configure<JacocoTaskExtension> {
        isIncludeNoLocationClasses = true
        excludes = listOf("jdk.internal.*")
    }
}

tasks.register<JacocoReport>("jacocoTestReport") {
    dependsOn("testDebugUnitTest", "testReleaseUnitTest")

    reports {
        xml.required.set(true)
        html.required.set(true)
        html.outputLocation.set(layout.buildDirectory.dir("reports/jacoco"))
    }

    val excludes = listOf(
        "**/R.class",
        "**/R$*.class",
        "**/BuildConfig.*",
        "**/Manifest*.*",
        "**/*Test*.*",
        "android/**/*.*",
        "**/*MapperImpl*.*",
        "**/*\$ViewInjector*.*",
        "**/*\$ViewBinder*.*",
        "**/*Component*.*",
        "**/*BR*.*",
        "**/*\$Lambda$*.*",
        "**/*Module_*Factory*.*",
        "**/*Companion*.*",
        "**/*_Factory.*",
        "**/*_MembersInjector.*",
        "**/*_HiltModules*",
        "**/*_Provide*Factory*",
        "**/Hilt_*",
        "**/*_GeneratedInjector*",
        "**/dagger/hilt/**",
        "**/*Repository_Factory*",
        "**/*_Generated*",
        "**/*Generated*",
        "**/generated/**",
        "**/build/**",
        "**/databinding/*Binding.*"
    )

    classDirectories.setFrom(
        layout.buildDirectory.files(
            "tmp/kotlin-classes/debug"
        ).asFileTree.matching {
            exclude(excludes)
        }
    )

    sourceDirectories.setFrom(files(
        "src/main/java",
        "src/main/kotlin",
        "src/debug/java",
        "src/debug/kotlin"
    ).filter { it.exists() })

    executionData.setFrom(layout.buildDirectory.files(
        "jacoco/testDebugUnitTest.exec","jacoco/testReleaseUnitTest.exec"
    ).filter { it.exists() })
}

tasks.named("check") {
    dependsOn("jacocoTestReport")
}