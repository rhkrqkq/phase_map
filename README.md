# handson-project

로드맵(hands_on_roadmap.md)의 Phase 1~6을 직접 구현하기 위한 빈 프로젝트.
엔티티/서비스/테스트는 전부 직접 작성. 여기엔 빌드 설정과 패키지 구조만 잡아뒀음.

## 실행 환경
- Java 17, Spring Boot 3.3, H2(인메모리 DB, 별도 설치 불필요)
- IntelliJ에서 프로젝트 열고 Gradle 동기화 → `HandsOnApplication` 실행
- H2 콘솔: 앱 실행 후 `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:handson`)
- (이 컨테이너는 네트워크 제약으로 직접 빌드 확인은 못 했음 — 표준 Spring Boot 3.3 세팅이라 로컬에선 바로 돌아갈 것)

## 패키지 구조
로드맵 Phase 순서에 맞춰 패키지만 미리 만들어둠. 각 패키지 안에 엔티티, 레포지토리, 서비스, 테스트를 직접 채워나갈 것.

```
com.study.handson
├── phase1_jpa            # Author/Book, N+1 재현·해결
├── phase2_transaction     # Account/AuditLog, 트랜잭션 전파
├── phase3_concurrency     # ReservationSlot, 동시성 제어
├── phase4_testing         # 임의 서비스 + Mockito 테스트
├── phase5_security        # 로그인/JWT 필터
└── phase6_db              # 더미 데이터 + 인덱스 실험용 (엔티티는 이 패키지에 자유롭게)
```

## 진행 순서
로드맵 문서 그대로 Phase 1부터. 각 Phase 시작할 때 해당 패키지에 필요한 클래스를 하나씩 직접 만들면 됨.

Phase 5(Spring Security)에 들어갈 때는 `build.gradle`에 주석 처리해둔 의존성(spring-boot-starter-security, jjwt)을 그때 직접 주석 해제.
