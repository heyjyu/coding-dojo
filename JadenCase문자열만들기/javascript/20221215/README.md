## JadenCase 문자열 만들기
모든 단어의 첫 문자가 알파벳인 경우만 대문자고 나머지는 소문자인 문자열로 만드는 문제
https://school.programmers.co.kr/learn/courses/30/lessons/12951?language=javascript

#### 1. 이해
- 공백 문자가 연속해서 나올 수 있다.
- 단어의 첫 문자가 숫자일 수 있다.

#### 2. 계획
- 모두 소문자로 바꾸고,
- split('')를 통해 한문자씩으로 이뤄진 배열을 만들고,
- 문자열의 첫 문자가 알파벳인 경우 대문자로 바꾸고,
- 앞 문자가 스페이스이고, 현문자가 알파벳인 경우 대문자로 바꾸기

#### 3. 실행

#### 4. 반성
- ''.charAt(아무 정수)는 ''이다.
- ''.substring(아무 정수)도 ''이다.
- ''[아무 정수]는 undefined이다.
- 따라서 문자열.split(' ').map(word => word.charAt(0).toUpperCase() + word.substring(1).toLowerCase()).join(' ');을 이용해서 풀 수 있다.
- 공백이 여러개인 경우 ' '으로 split하고, charAt과 substring을 적절히 활용하면 좋을 것 같다.
