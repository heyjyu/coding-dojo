## 있었는데요 없었습니다
보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 문제
https://school.programmers.co.kr/learn/courses/30/lessons/59043

#### 1. 이해
- JOIN을 통해 두 테이블을 합치고, WHERE을 이용하면 필터링을 할 수 있다.

#### 2. 계획
- INNER JOIN을 해서 두 테이블의 datetime을 비교해서 입양일이 보호시작일보다 이전인 동물을 찾는다.

#### 3. 실행

#### 4. 반성
- 빠른 순으로 조회해야한다는 것은 datetime 오름차순으로 정렬하라는 뜻이다.
