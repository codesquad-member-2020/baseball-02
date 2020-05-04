# 온라인 야구게임 2조⚾️

## 팀원

| Class | 🐱                            |
| ----- | ---------------------------- |
| BE    | [Dingo][dingo], [Dion][dion] |
| FE    | [Reese][reese]               |
| iOS   | [모스][모스]                 |

## [Wiki](https://github.com/codesquad-member-2020/baseball-02/wiki)

## Ground Rule

### 1. ⏰Time rule
- 오전 11시 스크럼 `google hangout`을 사용, `hackMd` 사용
    - 컨디션, 하루 목표, 어제 공유했던 사항 회고를 한다.
- 스크럼 마스터를 매일 매일 돌아가면서 한다. (딩고-리즈-디온-모스)
    - 스크럼 마스터는 스크럼을 주도한다.
    - 스크럼 마스터는 hangout Link, hackMd Link를 공유해준다.
    - 스크럼 마스터는 스크럼 내용을 정리해서 github Wiki에 업로드한다.

### 2. 📝Commit convention

| 타입     | 설명                                         |
| -------- | -------------------------------------------- |
| feat     | 새로운 기능 추가                             |
| fix      | 버그 수정                                    |
| docs     | 문서 수정                                    |
| refactor | 코드 리팩토링                                |
| style    | 코드 포맷팅 (코드 변경이 없는 경우)          |
| test     | 테스트 코드 작성                             |
| chore    | 소스 코드를 건들지 않는 작업(빌드 업무 수정) |

- 예시
    - **[#22] docs: README.md 수정**
    - 그리고 어떤 내용을 수정했는지 작성하기
- [참고](https://doublesprogramming.tistory.com/256)

### 3. 🌲Git branch rule

- master: 배포용 브랜치
- develop: 개발 브랜치
- 작업을 시작할 때: 자신의 클래스 개발 브랜치에서 <클래스>-feature/기능명 으로 브랜치 생성
    - ex) iOS-feature/기능명
- review를 위해 리뷰 브랜치를 생성한다.
    - ex) fe-review
- 이슈 단위로 개발한다.
- 작업이 완료되었으면, 작업하던 브랜치에서 개발 브랜치(develop)로 Pull Request를 생성한다.
- 머지를 완료했으면 기능(feature)브랜치는 github과 local git에 모두 삭제한다.
- BE는 Pull request 시 상대방은 assignee에 할당하고, 할당받은 사람은 해당 pull request를 확인 후, merge 한다.
- dev 브랜치로 merge 될 때, PR 메시지로 해당하는 issue를 닫아준다.
  - 예시: Resolve #1, Closed #1..
- default branch는 develop으로 설정한다.

### 4. 🧑‍💻구현 기능

- 선택 기능을 제외한 나머지
- 파트별 스프레트시트에 적어서 공유
- BE가 구현한 API에 대해서는 위키 공유

[dingo]: https://github.com/kyungrae
[reese]: https://github.com/reesekimm
[모스]: https://github.com/kjoonk
[dion]: https://github.com/ksundong

