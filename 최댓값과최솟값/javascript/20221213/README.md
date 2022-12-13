## 최댓값과 최솟값
문자열에 있는 숫자 중 최솟값과 최댓값을 구해서 출력하는 문제
https://school.programmers.co.kr/learn/courses/30/lessons/12939?language=javascript

#### 1. 이해
- 각 숫자가 띄어쓰기로 구분되어 있다.
- 최솟값과 최대값을 띄어쓰기로 구분해서 결과값을 도출해야 한다.

#### 2. 계획
- split으로 배열로 만들고 최솟값과 최댓값을 찾아서 연결하여 반환한다.

#### 3. 실행

#### 4. 반성
- Math.min을 쓰려면 배열을 그냥쓰면 안되고 spread연산자를 이용해 줘야 한다.
- Math.min과 Math.max는 문자열 array도 취급하기 때문에
- Math.min(...s.split(' '))과 Math.max(...s.split(' '))모두 이용할 수 있다.
- 또한 sort도 이용해서 최솟값과 최댓값을 찾아낼 수 있다.
