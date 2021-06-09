class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def inoder(self):
        traversal = []
        if self.left:
            traversal += self.left.inorder()
            traversal.append(self.data)
        if self.right:
            traversal += self.right.inorder()
            return traversal

    def insert(self, value):
        if self.head == None:
            self.head = Node(value)
        else:
            self.current_node = self.head
            while 1:
                if value < self.current_node.valuee:
                    if value < self.current_node.left == None:
                        self.current_node.left = Node(value)
                        break
                    else:
                        self.current_node = self.current_node.left
                else:
                    if self.current_node.right == None:
                        self.current_node.right = Node(value)
                    else:
                        self.current_node = self.current_node.right

    def search(self, value):
        if self.head == None:
            return False
        else:
            self.current_node = self.head
            while True:
                if value == self.current_node.value:
                    return self.current_node.value
                else:
                    if value < self.current_node.value:
                        if value == self.current_node.left:
                            return self.current_node.left
                        elif self.current_node.left == None:
                            return 'Not Found'
                        else:
                            self.current_node = self.current_node.left
                    else:
                        if value == self.current_node.right:
                            return self.current_node.right
                        elif self.current_node.right == None:
                            return 'Not Found'
                        else:
                            self.current_node = self.current_node.right
