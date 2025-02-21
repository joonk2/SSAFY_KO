from collections import deque

"""
V = 7
E = 8

7 8
1 2
1 3 
2 4
2 5
4 6
5 6
6 7
3 7
"""


# v : 탐색 시작 정점 번호
def bfs(v):
    # 초기 상태
    # 중복 방문 체크를 위한 배열
    visited = [0] * (V+1)

    # 내가 다음에 방문할 정점을 기억할 큐
    q = deque()

    # 큐에 시작 정점을 넣은 상태로 탐색 시작
    # 시작 정점에서 처리해야 할 작업이 있다면 미리 하고 반복 진입
    q.append(v)
    visited[v] = 1

    # 큐가 빌때까지 계속 탐색
    # --> 아직 방문할 정점이 남았으면 계속 탐색
    while q:
        # 큐에서 방문할 곳 하나 꺼내오기
        now = q.popleft()

        # if not visited[now]:
        #     visited[now] = 1
        print(now, end = " ")


        # now 정점에서 할일을 처리
        # now 정점이 이전에 방문한 곳이 아니라면

        # now 정점과 연결되어 있는 정점을 탐색
        for next in G_lst[now]:
            # next 정점을 이전에 방문한 적이 없나 체크
            # 방문한 적이 없으면 큐를 통해서 나중에 방문하겠다고 예약
            if not visited[next]:

                # 다음에 next 방문 예정
                q.append(next)

                # 중복 방문처리 + 거리 계산까지 한번에
                # 시작 정점에서 next 까지의 거리 =
                # 시작정점에서 now 까지의 거리 + 1
                visited[next] = visited[now] + 1







V, E = map(int, input().split())
G_matrix = [[0]* (V+1) for _ in range(V+1)]
G_lst = [ [] for _ in range(V+1) ]

for i in range(E):
    # 간선의 개수만큼 반복
    s, e = map(int, input().split())
    # s 정점에서 e 정점으로 가는 길이 존재
    # s와 e는 연결되어 있다라는 사실을 나타냄
    # 인접 행렬

    G_matrix[s][e] = 1
    G_matrix[e][s] = 1

    # 인접 리스트
    G_lst[s].append(e)
    G_lst[e].append(s)



bfs(1)