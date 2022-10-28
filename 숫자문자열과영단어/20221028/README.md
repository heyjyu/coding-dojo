## 숫자 문자열과 영단어
문자열을 숫자로 바꾸기
https://school.programmers.co.kr/learn/courses/30/lessons/81301?language=javascript

#### 1. 이해
- 영어로 된 숫자를 숫자로 바꿔야 한다.

#### 2. 계획
- map에 각 쌍을 넣어두고,
- replace를 이용해 바꾼다.

#### 3. 실행

#### 4. 반성
- JAVA에서는 replace로 충분하지만, JS에서는 모든 값을 바꾸려면 replaceAll을 사용해야 된다는 점을 꼭 기억하자!
- JAVA 에서 map.keySet().stream()으로 키를 순회할 수 있다.
- JS에서 Object.keys(object)로 객체의 키를 순회할 수 있다.
- JAVA에서 reduce의 초기값은 처음에 써주고 JS에서는 끝에 써준다.
- parseInt(,10)대신 Number()로 감싸도 된다.
