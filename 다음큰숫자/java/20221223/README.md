## 다음 큰 숫자
n보다 큰 숫자 중 2진수로 변환했을 때 1의 개수가 같은 가장 작은 수 구하는 문제
https://school.programmers.co.kr/learn/courses/30/lessons/12911?language=java

#### 1. 이해
- n보다 큰 숫자 중 2진수로 변환했을 때 1의 개수가 동일한 숫자를 찾아야 한다.

#### 2. 계획
- while문을 돌면서 1씩 더해가면서 Integer.toBinaryString을 이용해서 이진수로 변환해서 1의 숫자를 세어 동일한 개수인 숫자를 찾는다.
- 이 방식은 효율성 테스트에서 실패하기 때문에 1 개수를 세어서 동일한 1개수를 가지고 있는 숫자 중 n보다 크면서 가장 작은 숫자를 찾아야 할 것 같다.
- toCharArray()를 활용하면 split("")을 이용하는 것보다 훨씬 속도가 빠르다.

#### 3. 실행

#### 4. 반성
- Integer.bitCount()로 2진수로 변환했을 때 1의 개수를 셀 수 있다.
