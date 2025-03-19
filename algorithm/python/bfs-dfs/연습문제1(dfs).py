"""
[input]
7 8
1 2
1 3
2 4
2 5
4 6
5 6
6 7
3 7

[output]
1 2 4 6 5 7 3
"""




def dfs(node):
    # 보통 그래프 문제들에서
    # ex) K개의 노드 방문했다면 종료
    # ex) N개를 모두 방문했다면 경로 출력
    # if 종료시 해야할 것들 or 가지치기
    # return


    print(node, end = " ")

    # 현재 노드에서 인접한 노드들을 모두 확인하면서, 한 군데로 진행
    for next_node in graph[node]:
        # 이미 방문했다면 가지마라
        if visited[next_node]:
            continue
        # 만약 다음 노드를 방문 안했다면 방문처리하고 dfs로 탐색하라
        elif visited[next_node] == False:
            visited[next_node] = True
            dfs(next_node)



# import sys
# sys.stdin = open("연습문제1.txt", "r")

N, M = map(int, input().split())

# 1. 그래프를 저장하기
# - 비어있는 그래프를 생성한다
# - 그래프 정보를 입력받아 넣는다

# adjaceny-list
graph = [ [] for _ in range(N+1) ]

for _ in range(M):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

# 방문 여부 기록
visited = [0] * (N+1)

# 출발점 초기화
visited[1] = 1

# dfs 실행
dfs(1)

# for row in graph:
#     print(*row)