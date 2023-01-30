## 행렬의 곱셈
행렬의 곱셈 결과를 반환하는 문제이다.
https://school.programmers.co.kr/learn/courses/30/lessons/12949?language=java

#### 1. 이해
- 행렬의 곱셈 결과의 (i,j)번째 값은 첫 행렬의 i번째 행과 두번째 행렬의 j번째 열의 값들을 곱해서 더한 값에 해당한다.
- 행렬 곱셈 결과 크기는 첫 행렬의 행 수에 해당하는 행과 두번째 행렬의 열 수에 해당하는 열에 해당한다.

#### 2. 계획
- 행을 돌면서 각 행의 열을 돌면서 각 값을 채워준다.

#### 3. 실행

#### 4. 반성
- Collectors.toList()는 java.util.stream.Collectors이기 때문에 java.util.*만 import하면 쓸 수 없다.
