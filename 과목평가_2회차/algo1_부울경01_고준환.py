T = int(input())
for tc in range(1, T+1):
    N, M = map(int, input().split())
    lst = list(map(int, input().split()))


    for _ in range(M):
        a, b, c = list(map(int, input().split()))
        for i in range(b-1, b-1+c):
            lst[i] = a - lst[i];

    print(f'#{tc} {lst}')


"""
3
5 1
1 1 0 0 1
1 3 2
5 3
1 1 0 0 1
1 3 2
1 4 1
1 2 4
5 1
1 1 0 1 0
1 4 1
"""