"""
크루스칼

모든 간선들을 보면서
가중치가 가장 작은 간선부터 고르자(정렬)
이때, 사이클이 발생하면 pass


7 11
0 1 32
0 2 31
0 5 60
0 6 51
1 2 21
2 4 46
2 6 25
3 4 34
3 5 18
4 5 40
4 6 51
"""

# 대장 검색
def find_set(x):
    if x == parents[x]:
        return x

    # 기본 코드
    # return find_set(parents[x])

    # 경로 압축
    parents[x] = find_set(parents[x])
    return parents[x]


# 인수합병
def union(x, y):
    ref_x  = find_set(x)
    ref_y = find_set(y)

    # 대장이 같다면 넘겨뿌리
    if ref_x == ref_y:
        return

    # 일정한 규칙으로 연결
    if ref_x < ref_y:
        parents[ref_y] = ref_x
    else:
        parents[ref_x] = ref_y





V, E = map(int, input().split())
edges = []
for _ in range(E):
    start, end, weight = map(int, input().split())
    # 간선에 대한 정보들을 저장함
    edges.append( (start, end, weight) )

# 가중치 기준으로 오름차순
edges.sort(key = lambda x: x[2])

# make_set (정점을 기준으로 만들어진다)
parents = [i for i in range(V)]

# 작은 것부터 고르면서 나아가자
# 언제까지? N-1개를 선택할 때까지

# 현재까지 선택한 간선의 수
E_cnt = 0
# MST 가중치의 합
cumSum_weight = 0

for u, v, w in edges:
    # u와 v가 연결이 안되어있으면 선택
    # == 다른 집합이라면
    if find_set(u) != find_set(v):
        union(u, v)
        E_cnt += 1
        cumSum_weight += w

        # MST 구성이 끝났다.
        if E_cnt == V-1:
            break


# print(edges)
print(f'최소 비용 --> {cumSum_weight}')