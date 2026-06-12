# ConsoleMVC

Java 콘솔 애플리케이션에서 MVC 패턴의 역할 분리를 검증하는 PoC 프로젝트입니다.

## 패키지 구조

```
src/main/java/org/example/
├── Main.java                        # 의존성 조립 및 실행 진입점
├── model/
│   ├── Item.java                    # 도메인 데이터 (POJO)
│   └── ItemRepository.java          # 비즈니스 로직 (CRUD)
├── view/
│   └── ItemView.java                # 콘솔 출력 전담
└── controller/
    └── ItemController.java          # 사용자 입력 처리, Model ↔ View 중개
```

## MVC 역할 경계

| 레이어 | 책임 | 금지 사항 |
|--------|------|-----------|
| **Model** | 데이터 저장·조회·삭제 | `System.out`, View/Controller 참조 |
| **View** | `System.out` 출력만 | 비즈니스 로직, `Scanner` |
| **Controller** | `Scanner` 입력 처리, Model·View 호출 | 직접 출력, 도메인 로직 구현 |

## 실행 방법

```bash
# 빌드
gradlew.bat build

# 테스트
gradlew.bat test

# 특정 테스트
gradlew.bat test --tests "org.example.ItemRepositoryTest"
```

## 기술 스택

- Java
- Gradle (Kotlin DSL)
- JUnit 5
