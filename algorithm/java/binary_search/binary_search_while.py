def binary_search_while(target):
    left = 0
    right = len(arr)-1

    while left <= right:
        mid = (left + right) // 2


        # mid idx에서 검색 완료
        if arr[mid] == target:
            return mid

        # 왼쪽에 정답이 있다
        if target < arr[mid]:
            right = mid-1
        else:
            left = mid+1


    # 검색 실패패
    return -1




arr = [4,2,9,7,11,23,19]

# 이진 검색은 항상 정렬된 데이터에 적용해야한다
arr.sort()
# arr = [2,4,6,9,11,19,23]

print(binary_search_while(10))