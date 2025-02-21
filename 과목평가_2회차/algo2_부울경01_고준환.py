T = int(input())
for tc in range(1, T+1):

    # 동 남 서 북
    #   + delta direction
    dx = [1, 0, -1, 0]
    dy = [0, 1, 0, -1]


    N = 10
    monster = int(input())
    matrix = [list(map(int, input().strip())) for _ in range(N)]
    # print(matrix)

    for y in range(N):
        for x in range(N):
            target = matrix[y][x]
            # 모든 위치에서 일단 괴물이 있나 없나 보고
            # 괴물이 있으면 괴물의 종류에 따라 광선이 비추는 구역을
            # 안전하지 않은 곳으로 표시를 하자!

            if 1 <= target <= 3:
                for d in range(4):
                    for k in range(1, target + 1):
                        nx = (dx[d] * k) + x
                        ny = (dy[d] * k) + y

                        # 범위 벗어나면 중단
                        if not (0 <= ny < N and 0 <= nx < N):
                            break;

                        # 다른몬스터(1~3) or 벽(4) 만나면 중단
                        if (1 <= matrix[ny][nx] <= 3) or (matrix[ny][nx] == 4):
                            break;

                        # 구분용 (빈 공간일때 99로 변경)
                        if matrix[ny][nx] == 0:
                            matrix[ny][nx] = 99



    cnt = 0
    for y in range(N):
        for x in range(N):
            if matrix[y][x] == 0:
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