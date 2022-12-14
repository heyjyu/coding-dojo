## 키패드 누르기

순서대로 누를 번호가 담긴 배열과 무슨 손잡이인지 주어질 때 각 번호를 누른 손이 어떤 손인지 반환한다.
<https://school.programmers.co.kr/learn/courses/30/lessons/67256?language=java>
<https://school.programmers.co.kr/learn/courses/30/lessons/67256?language=javascript>

#### 1. 이해

- 1, 4, 7을 누를 때는 왼손을 사용한다.
- 3, 6, 9를 누를 때는 오른손을 사용한다.
- 2, 5, 8, 0을 누를 때는 오른손과 왼손 엄지 현재 위치에서 더 가까운 엄지를 사용하고, 거리가 같다면 오른손잡이는 오른손, 왼손잡이는 왼손 사용.
- 첫 위치는 왼손은 *, 오른손은 #에 있고,
- 상하 좌우로만 움직이고, 한 칸이 거리 1이다.

#### 2. 계획

- 첫 위치부터 매 번호를 누를 때 마다의 왼손, 오른손의 위치를 찾아야 한다.
- 그리고, 2, 5, 8, 0을 누를 때는 왼손, 오른손으로부터 거리를 계산해서 더 짧거나 같으면 hand를 기반으로 반환
- 만약 1,4,7,3,6,9면 그냥 정해진 손 반환
- 그리고 각 숫자에 해당하는 포지션을 반환하는 함수도 필요

#### 3. 실행

#### 4. 반성

- if 문 내에서 또 if문을 쓰는 경우

```
if () {
  if () {
  }
  ~~
}
```

중첩된 if안에서 continue, break, return등이 없다면 ~~도 실행이 된다는 점을 꼭 기억하자.

- 여러 개가 전체적으로 실패하면 실행되면 안되는 코드가 위와 같은 이유 때문에 실행되고 있는 게 아닌지 살펴보자.
- 어떤 입력에 대한 출력 값이 일정한 경우 Map으로 만들어서 사용하자.
- 움직이지 않는 경우에 대해서도 생각하자.
