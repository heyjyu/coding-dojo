## 압축
LZW압축 후 사전 색인 번호를 배열로 출력하는 문제이다.
https://school.programmers.co.kr/learn/courses/30/lessons/17684?language=java

#### 1. 이해
- LZW압축은 먼저 A~Z까지의 단어를 포함한 사전을 만들고,
- 현재 입력과 일치하는 가장 긴 문자열 w를 찾고,
- w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
- 입력에서 남은 글자가 있다면(c) w+c에 해당하는 단어를 사전에 등록한다.
- 2로 돌아간다.

#### 2. 계획
- Map으로 사전을 등록해서 w를 찾고(첫글자, 첫 두글자, 첫 세글자... 순으로 찾아서 못찾기 직전까지 찾는다), w에 해당하는 색인 번호를 출력하고 입력에서 w를 제거한다.
- 만약 남은 글자가 있다면 w+c에 해당하는 단어를 사전에 등록하고, w를 찾고, w에 해당하는 색인번호를 출력하고, 입력에서 w를 제거한다

#### 3. 실행

#### 4. 반성
- startsWith를 사용하면 앞에서 일치하는 문자가 있는지 확인할 수 있다.
