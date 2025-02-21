T = int(input())
for tc in range(1, T+1):
    monster = int(input())
    N = 10

    # 동 남 서 북
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]

    matrix = [list(map(int, input().strip())) for _ in range(N)]

    for y in range(N):
        for x in range(N):
            target = matrix[y][x]

            if 1 <= target <= 3:
                for d in range(4):
                    for k in range(1, target+1):
                        nx = (dx[d] * k) + x
                        ny = (dy[d] * k) + y

                        # 조건 1
                        if not (0 <= ny < N and 0 <= nx < N):
                            break

                        # 조건 2
                        # 다른 몬스터나 벽을 만나면 중단
                        if (1 <= matrix[ny][nx] <= 3) or (matrix[ny][nx] == 4):
                            break;

                        # 조건 3
                        # 구분용
                        if (matrix[ny][nx] == 0):
                            matrix[ny][nx] = 99


    cnt = 0
    for y in range(N):
        for x in range(N):
            if (matrix[y][x] == 0):
                cnt += 1

    print(f'#{tc} {cnt}')


"""
2
3
0000000000
0000001000
0000000000
0002000000
0000000000
0000000000
0000003000
0000000000
0000000000
0000000000
8
0000000000
0020000000
0000030000
0000000200
0010000000
0000000000
0000200000
0304000030
0400000010
0000000000
"""