## 올바른 괄호
(에 해당하는) 짝이 있는지 확인하는 문제
https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java

#### 1. 이해
- (())도 올바른 괄호이다.

#### 2. 계획
- 스택을 이용해서 풀면 된다.
- 만약 (라면 stack에 쌓고, )라면 stack에서 pop을 하는 방식으로 stack과 짝이 맞는지 확인한다.

#### 3. 실행

#### 4. 반성
- 짝을 맞춰서 없애는 문제는 stack을 활용하면 좋을 것 같다.
- 먼저 stack에 넣고, 짝이 맞았을 때 pop을 하면 된다.
