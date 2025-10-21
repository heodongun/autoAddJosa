# autoAddJosa

A lightweight Kotlin library that automatically adds the correct Korean particle (Josa) based on the final consonant.

단어 끝 받침에 따라 올바른 조사를 자동으로 붙여주는 Kotlin 경량 라이브러리입니다.

---

## Features

- Automatically adds correct Josa (은/는, 이/가, 을/를, 와/과, 으로/로)
- Kotlin extension function 기반의 간결한 사용법
- Enum 타입 안전성 — 오타 없는 Josa 열거형
- Batchim(받침) 규칙 완전 지원 (ㄹ 받침 예외 포함)
- 한국어 챗봇, 텍스트 생성, 현지화(Localization)에 유용

---

## Installation

### Using Gradle (Groovy)
```kotlin
repositories {
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation("io.github.heodongun:1.0.0")
}
```

### Using Gradle Kotlin DSL
```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.plutodesu:autoAddJosa:1.0.0")
}
```

---

## Usage

```kotlin
import io.github.plutodesu.autoaddjosa.Josa
import io.github.plutodesu.autoaddjosa.josa

fun main() {
    println("사과".josa(Josa.은는))   // 사과는
    println("밥".josa(Josa.은는))     // 밥은
    println("책".josa(Josa.이가))     // 책이
    println("바나나".josa(Josa.이가)) // 바나나가
    println("문자열".josa(Josa.을를)) // 문자열을
    println("학교".josa(Josa.와과))   // 학교와
    println("산".josa(Josa.으로))     // 산으로
    println("길".josa(Josa.으로))     // 길로 (ㄹ 받침 특례)
}
```

---

## Supported Josa List

| Enum | Example | Output |
|------|----------|---------|
| `Josa.은는` | `"사과".josa(Josa.은는)` | `사과는` |
| `Josa.이가` | `"책".josa(Josa.이가)` | `책이` |
| `Josa.을를` | `"문자열".josa(Josa.을를)` | `문자열을` |
| `Josa.와과` | `"학교".josa(Josa.와과)` | `학교와` |
| `Josa.으로` | `"길".josa(Josa.으로)` | `길로` |

---

## Technical Details

- Written in pure Kotlin
- Compatible with JVM, Android, Kotlin Multiplatform (JVM Target)
- Zero dependencies, extremely lightweight (<10KB)
- Unicode-based consonant detection for precise rule matching

---

## License

```
Apache License 2.0

Copyright 2025 heodongun

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0
```

---

## Author

Created by [heodongun](https://github.com/heodongun)  
Inspired by the beauty of the Korean language.
