# python의 리스트 메서드를 사용해서 구현

# 공백 상태의 큐
q = []

# 원소 10개 주기
for i in range(1, 11):
  q.append(i)

print(q)

# 원소 10개 삭제
for i in range(10):
  print(q.pop(), end = " ")
print()

print(q)


"""
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
10 9 8 7 6 5 4 3 2 1 
[]
"""