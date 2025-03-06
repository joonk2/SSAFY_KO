"""
3
4 47FE
5 79E12
8 41DA16CD


[코드 개요]
문제는 16진수에서 2진수로 바꾸는 것이다.
이를 위해 각 숫자에 매칭되는 dict를 만들어 주었고,
shift 연산자를 활용하였다
"""


hexadecimal_to_binary = {
    '0' : 0,
    '1' : 1,
    '2' : 2,
    '3' : 3,
    '4' : 4,
    '5' : 5,
    '6' : 6,
    '7' : 7,
    '8' : 8,
    '9' : 9,
    'A' : 10,
    'B' : 11,
    'C' : 12,
    'D' : 13,
    'E' : 14,
    'F' : 15
}

T = int(input())
for tc in range(1, T+1):
    N, hexadecimal = input().split()

    # 결과값을 저장할 빈 문자열 res 선언
    res = ""

    # decimal에 값 할당
    for i in hexadecimal:
        decimal = hexadecimal_to_binary[i]

        # 임시 저장을 위한 빈 문자열 binary 선언
        binary = ""

        # 문제를 보면 4자리 만큼 값 할당인데
        # index를 bit로 생각하자 [][][][] --> 1 << 3
        for j in range(3, -1, -1):
            if decimal & (1 << j):
                binary += '1'
            else:
                binary += '0'

        res += binary

    print(f'#{tc} {res}')