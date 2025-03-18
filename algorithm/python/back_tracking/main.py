def check(row, col):
    # 1. 같은 열에 놓은 적이 있는가
    for i in range(row):
        if visited[i][col]:
            return False

    # 2. 왼쪽 대각선(\) 검사
    i, j = row - 1, col - 1
    while i >= 0 and j >= 0:
        if visited[i][j]:
            return False
        i -= 1
        j -= 1

    # 3. 오른쪽 대각선(/) 검사
    i, j = row - 1, col + 1  # 오른쪽 대각선 방향 수정
    while i >= 0 and j < N:
        if visited[i][j]:
            return False
        i -= 1
        j += 1

    return True  # 모든 검사를 통과하면 놓을 수 있음


def dfs(row):
    global res

    # 모든 퀸을 놓으면 성공한 케이스
    if row == N:
        res += 1
        return

    # 후보군: N개의 열
    for col in range(N):
        if not check(row, col):  # 놓을 수 없는 경우 스킵
            continue

        visited[row][col] = 1  # 퀸 놓기
        dfs(row + 1)           # 다음 행으로 진행
        visited[row][col] = 0  # 백트래킹 (원래대로 복구)


N = 4
visited = [[0] * N for _ in range(N)]
res = 0
dfs(0)

print(res)  # 정답 출력