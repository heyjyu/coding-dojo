## 영어 끝말잇기
영어 끝말잇기를 처음 탈락한 사람의 번호와 몇번째 차례에 탈락했는지 구하는 문제이다.
https://school.programmers.co.kr/learn/courses/30/lessons/12981?language=javascript

#### 1. 이해
- 이전에 등장한 단어는 사용할 수 없다.
- 기존 단어의 마지막 문자로 시작하는 단어를 말해야한다.
- 한 글자 단어는 인정되지 않는다.

#### 2. 계획
- 몇번째에 탈락했는지 확인해서 n으로 나눈 나머지 + 1이 탈락한 사람의 번호이고,
- 몇번째에 탈락했는지 확인해서 n으로 나눈 몫 + 1이 자신의 차례에 해당한다.
- 탈락자가 없다면 [0,0]을 반환한다.

#### 3. 실행

#### 4. 반성
- 자바스크립트에서 slice로 sublist를 만들 수 있다.
- list가 가지고 있는지 includes로 확인이 가능하고,
- set은 has로 값이 있는지 확인할 수 있다.
