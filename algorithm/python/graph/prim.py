"""
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

# prim
# - 특정 정점 기준으로 시작
# - 갈 수 있는 노드들 중 가중치가 가장 작은 노드부터 고르자
# -> 그냥 큐가아닌, 우선순위 큐를 활용하면 좋다.



import heapq

def prim(start_node):
    pq = [(0, start_node)]  # (가중치, 노드) 형태로 초기화
    MST = [0] * V  # 방문 여부 체크
    min_weight = 0  # 최소 비용 저장

    while pq:
        weight, node = heapq.heappop(pq)

        if MST[node]:  # 이미 방문한 노드는 스킵
            continue

        MST[node] = 1  # 방문 처리
        min_weight += weight  # MST 비용 추가

        # 현재 노드에서 갈 수 있는 모든 노드 확인
        for next_node in range(V):
            if graph[node][next_node] > 0 and not MST[next_node]:  # 유효한 간선인지 확인
                heapq.heappush(pq, (graph[node][next_node], next_node))

    return min_weight


# 입력 받기
V, E = map(int, input().split())
graph = [[0] * V for _ in range(V)]

for _ in range(E):
    start, end, weight = map(int, input().split())
    graph[start][end] = weight
    graph[end][start] = weight

result = prim(4)  # 시작 노드를 4로 설정
print(f'최소 비용 = {result}')
