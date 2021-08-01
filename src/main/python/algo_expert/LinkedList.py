class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self, data):
        self.head = Node(data)

    def add(self, data):
        if self.head == '':
            self.head = Node(data)
        else:
            node = self.head
            while node.next:
                node = node.next
            node.next = Node(data)

    def desc(self):
        node = self.head
        while node:
            print(node.data)
            node = node.next

    def delete(self, data):
        if self.head == '':
            print("해당 값을 가진 노드가 없습니다.")
            return

        if self.head.data == data:
            temp = self.head
            self.head = self.head.next
            del temp

        else:
            node = self.head
            while node.next:
                if node.next.data == data:
                    temp = node.next
                    node.next = node.next.next
                    del temp
                else:
                    node = node.next


linkedList = LinkedList(2)
for data in range(1, 10):
    linkedList.add(data)
    linkedList.desc()
    print("======================")
linkedList.delete(3)
linkedList.desc()

# https://doorbw.tistory.com/117