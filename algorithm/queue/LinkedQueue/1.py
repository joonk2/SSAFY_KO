class Node:
  def __init__(self, data):
    
    # 내 다음이 누구냐
    self.next = None

    # 내 이전이 누구냐 
    self.prev = None

    # 내가 가진 data
    self.data = data


  def __str__(self):
      return str(self.data)
    

class MyQ:
  # 공백 상태 큐
  def __init__(self):
    self.front = None
    self.rear = None

  # 삽입
  def enq(self, node):
    # 큐가 비어있을 때 삽입
    if self.empty():
      self.front = node
      self.rear = node

    # 큐가 오른쪽에 있을 때 삽입
    else:
        # 현재 마지막 원소와 삽입할 원소를 연결 (link)
        self.rear.next = node
        node.prev = self.rear

        # 큐에 삽입 처리, 마지막 원소는 새로 추가한 원소
        self.rear = node


  # 삭제
  def deq(self):
      # 삭제할 노드 기억
      res = self.front


      # 연결 해제
      if res.next:
          # 큐의 새로운 front는 front.next
          self.front = res.next
          
          # front와 이전 front와 연결 해제
          # 이전 front의 다음은 없는 걸로
          res.next = None 

          # 새로운 front의 이전 노드를 없는 걸로
          self.front.prev = None



  # 큐가 비어있는지 확인
  def is_empty(self):
      return not self.front