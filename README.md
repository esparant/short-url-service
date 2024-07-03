# URL 단축 서비스

Spring Boot로 구축된 간단하고 효율적인 URL 단축 서비스로, 긴 URL을 짧고 공유하기 쉬운 링크로 변환할 수 있습니다.

## 목차

- [기능](#기능)
- [시작하기](#시작하기)
- [필수 조건](#필수-조건)
- [설치](#설치)
- [사용법](#사용법)
- [사용 기술](#사용-기술)


## 기능

- 긴 URL을 짧은 URL로 변환
- 짧은 URL을 원본 URL로 리다이렉트
- URL 생성 및 관리를 위한 간단한 웹 인터페이스
- 유효성 검사 및 오류 처리
- P6Spy를 사용한 SQL 쿼리 로깅

## 시작하기

다음 지침은 로컬 머신에서 개발 및 테스트를 위해 프로젝트를 설정하고 실행하는 방법을 안내합니다.

### 필수 조건

- Java 8 이상
- Gradle
- H2 데이터베이스 (또는 다른 선호하는 데이터베이스)

### 설치

1. 리포지토리를 클론합니다:
    ```sh
    git clone https://github.com/esparant/short-url-service.git
    cd short-url-service
    ```

2. Gradlew을 사용하여 프로젝트를 빌드합니다:

    ```sh
    ./gradlew build
    ```

3. 애플리케이션이 `http://localhost:8080`에서 실행 중인지 확인합니다.

### 사용법

1. 웹 브라우저를 열고 `http://localhost:8080`으로 이동합니다.
2. 입력 필드에 변환하고 싶은 URL을 입력하고 "완료" 버튼을 클릭합니다.
3. 생성된 짧은 URL을 복사하여 공유합니다.
4. 짧은 URL을 브라우저에 입력하여 원본 URL로 리다이렉트됩니다.

### 사용 기술
	•	Spring Boot - 애플리케이션 개발을 위한 메인 프레임워크
	•	Spring MVC - 웹 애플리케이션 구축
	•	Spring Data JPA - 데이터베이스 액세스 및 관리
	•	H2 Database - 개발 및 테스트용 인메모리 데이터베이스
	•	Hibernate - 데이터베이스 엔터티 관리를 위한 ORM 프레임워크
	•	Thymeleaf - 서버 사이드 Java 템플릿 엔진
	•	Gradle - 빌드 자동화 및 의존성 관리
	•	JUnit - 테스트 프레임워크
	•	Lombok - 보일러플레이트 코드를 줄이는 Java 라이브러리
	•	P6Spy - 애플리케이션이 실행하는 SQL 문을 로깅하는 프레임워크
	•	Spring Boot Validation - 폼 입력 유효성 검사 프레임워크

