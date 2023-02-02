## 튜플
튜플을 표현하는 집합이 담긴 문자열이 주어질 때 그 문자열이 표현하는 튜플을 반환하는 문제이다.
https://school.programmers.co.kr/learn/courses/30/lessons/64065?language=javascript

#### 1. 이해
- 집합의 원소 개수가 튜플 원소 개수와 동일하다.

#### 2. 계획
- 집합 원소들로 이뤄진 배열을 만들고, 길이를 오름차순으로 정렬을 한다.
- set과 list를 만들고, 각 원소를 돌면서 set.add를 해서 true가 반환되면 list에 추가되는 방식으로 추가를 하면 튜플이 완성된다.

#### 3. 실행

#### 4. 반성
- includes로 이미 포함된 값인지 확인을 할 수 있다!
