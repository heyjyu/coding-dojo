## N개의 최소공배수
N개 숫자의 최소공배수를 구하는 문제이다.
https://school.programmers.co.kr/learn/courses/30/lessons/12953?language=javascript

#### 1. 이해
- 두 수의 곱을 최대공약수로 나누면 최소공배수가 된다.

#### 2. 계획
- 두 수의 최소공배수를 구해서 누적해서 모든 수에 대한 최소공배수를 구한다.

#### 3. 실행

#### 4. 반성
- x, y의 최대공약수는 x % y ? gcd(y, x%y) : y 로 재귀적으로 구할 수 있다.
