# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
# 빌드
gradlew.bat build

# 테스트 전체 실행
gradlew.bat test

# 특정 테스트 클래스 실행
gradlew.bat test --tests "org.example.SomeTest"

# 특정 테스트 메서드 실행
gradlew.bat test --tests "org.example.SomeTest.methodName"

# 빌드 결과물 제거
gradlew.bat clean
```

## Architecture

Console MVC 패턴으로 구현하는 Java 콘솔 애플리케이션입니다.

- **Model** (`src/main/java/.../model/`): 도메인 데이터와 비즈니스 로직
- **View** (`src/main/java/.../view/`): `System.out` 기반 콘솔 출력 전담
- **Controller** (`src/main/java/.../controller/`): 사용자 입력(`Scanner`) 처리 및 Model/View 중개
- **Main** (`src/main/java/.../Main.java`): 진입점, Controller 초기화 및 실행 루프 시작

View는 데이터를 직접 가공하지 않고 Controller로부터 받은 데이터를 출력만 담당합니다. Model은 View/Controller를 참조하지 않습니다.

## Project Setup

- **언어**: Java, **빌드**: Gradle (Kotlin DSL)
- **테스트**: JUnit 5 (junit-bom:6.0.0)
- 소스: `src/main/java/`, 테스트: `src/test/java/`
- 패키지 루트: `org.example`
