bit = "0000000111100000011000000111100110000110000111100111100111111001100111"
# 출력값
# 0 120 12 7 76 24 60 121 124 103


# 이진수를 7칸씩 쪼개서 십진수로 만듦
N = len(bit)

for i in range(0, N, 7):
    # i번째 비트에서부터 7칸 잘라서 십진수로 만들고 출력
    ith_bin = bit[i : i+7]

    # 결과로 만들 10진수
    decimal = 0

    # 지수
    ex = 0

    # 뒤에서부터 변환 시작
    # j는 idx
    for j in range(6, -1, -1):
        decimal = decimal + 2 ** ex * int(ith_bin[j])
        ex += 1

    print(decimal, end = " ")