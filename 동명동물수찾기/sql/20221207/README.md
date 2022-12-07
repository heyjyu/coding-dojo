## 동명 동물 수 찾기
같은 이름을 가진 동물이 두 마리 이상인 이름과 이름이 쓰인 횟수를 조회하는 sql문 작성하기
https://school.programmers.co.kr/learn/courses/30/lessons/59041

#### 1. 이해
- GROUP BY를 한 결과를 필터링 할 때는 HAVING을 이용하면 된다.

#### 2. 계획
- COUNT와 GROUP BY와 HAVING을 통해 COUNT가 2 이상인 동물을 찾기

#### 3. 실행

#### 4. 반성
- 조건을 잘 읽도록 하자.
- 이름이 없는 동물은 집계에서 제외해야 하고, 이름 순으로 조회해달라는 조건이 있었다.
