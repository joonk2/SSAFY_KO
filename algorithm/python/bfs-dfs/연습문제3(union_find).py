N = int(input())
p = [0] * N

def make_set(x):
    p[x] = x


p = [i for i in range(1, N+1)]
print(p)

# x가 속한 집합의 대표가?
def find_set(x):
    if x == p[x]:
        return x
    return find_set(p[x])

# 경로 압축 방식
def find_set2(x):
    if p[x] != x:
        p[x] = find_set(p[x])

    return p[x]


def union(x, y):
    # x가 속한 집합의 대표
    king_x = find_set(x)
    # y가 속한 집합의 대표
    king_y = find_set(y)

    # 두 집합의 대표가 같으면 합칠 필요X
    if king_x == king_y:
        return

    # 더 작은 쪽으로 합치자
    if x < y:
        p[y] = x
    else:
        p[x] = y


rank = [0] * (N+1)

def union2(x, y):
    king_x = find_set2(x)
    king_y = find_set2(y)

    # 합칠 때 두 집합의 랭크(높이)를 비교해서 더 큰걸 대표로
    if rank[king_x] > rank[king_y]:
        # x집합의 랭크가 더 크니까 x를 대표로
        p[king_y] = king_x
    else:
        # y집합의 랭크가 더 크니까 y를 대표로
        p[king_x] = king_y
        # 랭크가 같은 경우
        if rank[king_x] == rank[king_y]:
            rank[king_y] += 1


# 1 ~ 10
# make set
p = [i for i in range(1, N+1)]
print(p)

union(1,6)
union(2,6)
union(3,6)
union(4,6)
union(5,6)
union(7,6)
print(p)