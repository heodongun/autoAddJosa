import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("buildsrc.convention.kotlin-jvm") // Kotlin JVM 플러그인 적용
    id("com.vanniktech.maven.publish") version "0.28.0" // maven 배포 플러그인
}

dependencies {
    testImplementation(kotlin("test"))
}

mavenPublishing {
    // 이 세가지가 합쳐져서 implementation("io.github.username:my-library:1.0.0") 과 같이 사용됩니다.
    coordinates(
        groupId = "io.github.heodongun", // namespace
        artifactId = "autoAddJosa", // 배포하려는 library artifact id
        version = "1.0.0" // version
    )

    pom {
        name.set("autoAddJosa") // 라이브러리 이름
        description.set("autoAddJosa is a lightweight Kotlin library that automatically adds the correct Korean particle (Josa, 조사) to words based on their final consonant.\n" +
                "It helps you write natural Korean sentences without manually checking for batchim (final consonant) rules.") // 라이브러리 설명
        inceptionYear.set("2025") // 라이브러리 시작 년도
        url.set("https://github.com/heodongun/autoAddJosa") // 라이브러리 배포 url

        licenses {
            license { // 라이센스 이름과 라이센스 정보 url 세팅
                name.set("The Apache License, Version 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }

        developers {
            developer { // 개발자 정보 세팅
                id.set("heodongun")
                name.set("heodongun")
                email.set("heodongun08@gmail.com")
            }
        }

        scm {
            connection.set("scm:git:https://github.com/heodongun/autoAddJosa.git")
            developerConnection.set("scm:git:ssh://github.com/heodongun/autoAddJosa.git")
            url.set("https://github.com/heodongun/autoAddJosa")
        }
    }

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL) // maven central 배포 위치 설정

    signAllPublications() // 배포 gpg signing 설정
}
