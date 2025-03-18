# A : 정렬 대상 lst
# l : 왼쪽
# r : 오른쪽


def quicksort(A, l, r):
    if l < r:
        # 기준을 정해서
        # 그 기준 원소(피벗)의 위치를 고정하고
        p = partition(A, l, r)


        # 기준원소(p) 왼쪽을 다시 정렬
        quicksort(A, l, p-1)

        # 기준원소(p) 오른쪽을 다시 정렬
        quicksort(A, p+1, r)



def partition(A, l, r):
    # 기준 원소(피벗) 정하기
    # 제일 왼쪽 원소를 기준 원소(피벗)으로 한다
    p = A[l]

    # 피벗보다 작은 원소들은 왼쪽에
    # 피벗보다 큰 원소들은 오른쪽에 오도록

    # 왼쪽에 있으면 안되는 원소 (p보다 큰 원소)
    # 오른쪽에 있으면 안되는 원소를 찾아서 자리 교환 (p보다 작은 원소)
    # 를 찾아서 교환

    # i : 왼쪽에 있으면 안되는 원소를 l에서부터 찾기 시작
    # j : 오른쪽에 있으면 안되는 원소를 r에서부터 찾기 시작
    i = l
    j = r

    # 자리가 잘못된 원소를 찾으면 자리를 바꾸고
    # i,j가 교차하면 더 볼 필요 없다
    while i <= j:
        # p보다 큰거를 왼쪽에서 찾기 시작
        while i <= j and A[i] <= p:
            # i번째 있는 원소는 p이하면 제자리 맞음
            i += 1
        # p보다 큰 ㅜ언소를 왼쪽에서 찾으면 반복 중단

        # p보다 작은거를 오른쪽에서 찾기 ㅣ시작
        while i <= j and A[j] >= p:
            # j번째 있는 원소는 p 이상이므로 제자리 맞음
            j -= 1


        # p보다 작은 원소를 찾으면 반복 중단

        # i에 있는 원소와 j의 원소를 비교해서 자리 교환
        # 반복이 종료되고 여전히 i가 j보다 작다면
        # p보다 작은 원소가 오른쪽(j)에 있다
        # p보다 큰 원소가 왼쪽(i)에 있다
        # 위치가 잘못된 두 원소를 찾았으므로 서로 교환
        if i < j:
            # 잘못된 위치 원소끼리 교환
            A[i], A[j] = A[j], A[i];

    # 위의 while문이 다 돌았다면
    # 기준 원소보다 큰 거슨 오른쪽에, 작은 것은 왼쪽에 다 몰았다.
    # 기준 원소의 위치를 정해줘야 한다.
    A[l], A[j] = A[j], A[l]

    # i와 j가 교차하면 i는 큰원소, j가 작은 원소
    # 맨 앞에 기준 원소의 위치이므로
    # 이 기준원소와 자리를 바꾸려면 작은 원소와 자리를 바꿔야 함.

    # 자리를 바꾼 후 기준 원소의 위치는 j
    # j자리에는 누가 올지 정해졌다. 즉 고정되었다
    return j




li = [11, 45, 23, 81, 28, 34]
N = len(li)
quicksort(li, 0, N-1)
print(li)