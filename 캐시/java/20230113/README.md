## 캐시
캐시 크기에 따른 실행시간을 계산하는 문제이다.
https://school.programmers.co.kr/learn/courses/30/lessons/17680?language=java

#### 1. 이해
- 현재 처리한 값이 캐시에 가장 마지막에 저장된다.
- 캐시에 있는 값을 처리하는 경우 실행 시간이 1이고, 아니라면 5이다.

#### 2. 계획
- 캐시 arraylist를 만들어두고, 만약 캐시 가장 마지막 값이 현재 처리 값이 아니라면 캐시 첫 값을 없애고 마지막 값에 현재 처리한 값을 넣는다.
- 캐시에 있는 값을 처리하면 1초를 더하고 아니라면 5초를 더한다.
- 캐시 배열에는 소문자로 저장한다.
- 캐시 hit인데 마지막 저장값이 아니면 찾아서 없애야 한다.

#### 3. 실행

#### 4. 반성
- 내가 모든 경우를 고려했는지 꼭 확인하자.
- toLowerCase를 해주는 경우 중복되는 값들은 하나의 변수로 묶는 것이 실수를 줄일 수 있다.
