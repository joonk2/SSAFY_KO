size = 10

cq = [0] * size
front = rear = 0
# 원형큐는 front를 위한 자리 1개를 비워둔다.

def is_full():
  # rear는 마지막 원소의 위치
  # rear + 1 은 다음에 삽입될 원소의 위치
  # rear + 1 이 front와 같으면 큐가 가득 찼다고 판단
  # front를 위한 자리는 비워둔 상태
  return (rear + 1) % size == front

# 원형 큐에 원소를 10개 삽입
for i in range(1, 11):
  if not is_full():

    # 인덱스 9를 벗어나면 안되기 때문에
    rear = (rear + 1) % size
    cq[rear] = i


# front를 위한 자리는 비어있어야 하기 때문에 10은 삽입되지 않았다
print(cq)
print(front, rear)

for i in range(9):
  front = (front + 1) % size
  print(cq[front], end = " ")
print()

print(cq)
print(front, rear)

# front --> 9 됨
# rear --> 9 에서 멈춤