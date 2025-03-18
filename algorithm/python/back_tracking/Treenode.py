class TreeNode:
    def __init__(self, key):
        self.left = None
        self.right = None
        self.value = key


# 1. 탐색
# root : 찾기 시작하는 트리의 루트 노드
# key : 우리가 트리 안에서 찾으려고 하는 값
def search(root, key)