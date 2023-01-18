## H-Index
과학자가 발표한 논문 n편 중에 h번 이상 인용된 논문이 h편 이상이고, 나머지 논문이 h번 이하 인용된 h의 최댓값을 구하는 문제이다.
https://school.programmers.co.kr/learn/courses/30/lessons/42747?language=java

#### 1. 이해
- h번 이상 인용된 논문이 h편이상이어야 한다.

#### 2. 계획
- 배열을 내림차순으로 정렬을 하고,
- 큰 수부터 그 수 이상인 수만 filter로 남겨서 그 수 이상이 되는 수를 찾는다.

#### 3. 실행

#### 4. 반성
- 가장 크거나 작은 값을 찾는 문제는 정렬을 먼저한다.
- java에서 내림차순 정렬을 하려면 Arrays.sort(array, Collections.reverseOrder())를 사용하면 된다. 이 때 int는 Integer 래퍼 클래스로 박싱을 해줘야한다.
- Arrays.stream(citations)
  .boxed()
  .toArray(Integer[]::new); 를 통해 박싱을 할 수 있다.
- 꼭 주어진 citation값들 중에 h가 있지 않을 수 있다.
- sort한 후 sort한 번째를 통해 그 이상 인용된 논문 수를 구할 수 있다.
