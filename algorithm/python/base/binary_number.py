# ------------ 10진수 --> 2진수로 변환 -------------------
# 10진수를 지속적으로 2로 나누어 구현한다
# 마지막으로 List를 거꾸로 뒤집는다

decimal = 149
res = []

while decimal != 0:
    res.append(decimal %  2)
    decimal //= 2

res.reverse()
print(res)