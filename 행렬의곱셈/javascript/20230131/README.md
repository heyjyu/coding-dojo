## 행렬의 곱셈
두 행렬의 곱의 결과를 도출하는 문제이다.
https://school.programmers.co.kr/learn/courses/30/lessons/12949?language=javascript

#### 1. 이해
- 결과 행렬의 행 수는 첫 행렬의 행 수와 같고, 열 수는 두번째 행렬의 열 수와 같다.
- i,j의 값은 첫 행렬의 i행 값들과 두번째 행렬의 j열 값들의 곱의 합이다.

#### 2. 계획
- 결과 행렬의 각 행을 구하고,
- 행 수만큼 반복해서 전체 결과를 구하기

#### 3. 실행

#### 4. 반성
- arr1.map((row) => arr2[0].map((x,y) => row.reduce((a,b,c) => a + b * arr2[c][y], 0))) 로도 풀 수 있다.
