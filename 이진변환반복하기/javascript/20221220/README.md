## 이진 변환 반복하기
이진 변환을 하면서 몇 번 이진 변환을 해야 1이 되고, 0이 몇 개 사라졌는지 확인하는 문제
https://school.programmers.co.kr/learn/courses/30/lessons/70129?language=javascript

#### 1. 이해
- 이진 변환은 0을 없애고, 문자열 길이를 2진수로 변환하는 과정을 의미한다.

#### 2. 계획
- while문을 돌면서 문자열이 1이 될 때까지 반복한다.
- s의 길이가 150,000이하이므로 문자열 자체를 숫자로 변환하면 안된다.

#### 3. 실행

#### 4. 반성
- javascript에서는 배열의 길이인 length가 메서드가 아니고, .length처럼 필드처럼 사용한다.
- 숫자를 담은 변수 number가 있을 때 number.toString(2)를 하면 2진수로 변환된다.
