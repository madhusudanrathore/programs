class Node( object ):
	def __init__(self, d):
		self.data = d
		self.Next_node = None
		print( self.data, "\t ENTERED")

class singly( object ):
	def __init__(self):
		self.head = None
		print("LINKED LIST CREATED")

	def insert(self, d):
		new_node = Node(d)
		new_node.Next_node = self.head
		self.head = new_node			

	def display(self):
		curr = self.head

		if curr is None:
			print("EMPTY LIST")
			return
		else:
			while curr:
				print(curr.data, " -> ", end='')
				curr = curr.Next_node
			print(" NONE")
			return

def controller():
	linked_list = singly()
	linked_list.insert(20)
	linked_list.insert(15)
	linked_list.insert(10)
	linked_list.display()

controller()