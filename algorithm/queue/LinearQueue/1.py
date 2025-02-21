# front와 rear를 큐로 사용하는 방법

# 큐의 크기
size = 10

# 공백 상태의 큐를 생성
q = [0] * size

# front와 rear의 초기화
front = rear = -1

# front : 삭제된 원소의 위치 (첫 원소의 위치)
# rear : 마지막 원소의 위치

for i in range(1, 11):
  # 삽입하기 전에 rear + 1
  rear += 1
  # +1한 위치에 원소를 넣어야 한다
  q[rear] = i


# 원소 10개 삭제해보기
for i in range(1, 11):
  front += 1

  # +1한 위치에 있는 원소를 삭제
  print(q[front], end = " ")
print()

print(q)
print(front, rear)


# 9 9  --> `front와 rear가 비어있네`



# ------------------- 출력 값 ----------------------------
1 2 3 4 5 6 7 8 9 10
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
9 9