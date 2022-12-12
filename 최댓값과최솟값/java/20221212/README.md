## 최댓값과 최솟값
문자열을 파싱해서 최댓값과 최소값을 반환하는 문제
https://school.programmers.co.kr/learn/courses/30/lessons/12939?language=java

#### 1. 이해
- split을 통해 숫자로 이뤄진 배열을 만들 수 있다.

#### 2. 계획
- split으로 숫자를 파싱하고, Max와 Min으로 최댓값과 최솟값을 찾아 반환한다.

#### 3. 실행

#### 4. 반성
- split해서 String배열을 만든 뒤 Integer.parseInt로 for문을 돌면서 int배열을 만들고,
- Arrays.sort를 이용해서 0번째와 마지막번째 숫자를 반환하는 방식을 사용하는 것도 좋은 방법인 것 같다.
- Arrays.stream().min().getAsInt()를 통해 최솟값을 얻을 수 있다.
- Arrays.stream(string.split(" ")).map(Integer::parseInt).collect(Collectors.toList());를 통해 string 배열을 Integer list로 변환할 수 있다.
