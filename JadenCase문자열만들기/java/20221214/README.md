## JadenCase 문자열 만들기
단어의 첫 문자가 영문자인 경우 대문자로 만들고 나머지는 다 소문자로 만드는 문제
https://school.programmers.co.kr/learn/courses/30/lessons/12951?language=java

#### 1. 이해
- 단어의 첫 문자가 영어인 경우 대문자로 만들고 나머지는 소문자로 만든다.
- toLowerCase toUpperCase를 이용할 수 있다.

#### 2. 계획
- 먼저 모두 lowerCase를 하고서 첫 문자만 따로 판단을 해주고 ' [a-z]'를 upper case로 만든다.

#### 3. 실행

#### 4. 반성
- string.toLowerCase().split("");으로 각 문자로 이뤄진 배열을 얻을 수 있고,
- flag = true;를 해두고, 문자 배열을 돌면서 isFirstLetter이면 toUpperCase를 해주고,
- 현재 문자가 .equals(" ")이라면 flag = true;를 해주는 반복 연산을 해주는 방법도 이용할 수 있을 것 같다.
- split("")를 하면 각 문자로 이뤄진 배열을 만들 수 있다는 점을 기억해두자.
