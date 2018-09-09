class Node(object):
	def __init__(self):
		self.data = int(input("ENTER DATA:\t"))
		self.Next_node = None
		print( self.data, "\t ENTERED")

class singly(object):
	def __init__(self):
		self.head = None
		print("LINKED LIST CREATED")

	def insert_beg(self):#fundamentally, it is INSERTION AT BEGINNING
		new_node = Node()
		new_node.Next_node = self.head
		self.head = new_node			

	def insert_end(self):
		curr = self.head
		if not curr:
			self.insert_beg()
		else:
			while curr.Next_node:
				curr = curr.Next_node
			new_node = Node()
			curr.Next_node = new_node
			new_node.Next_node = None

	def delete_beg(self):
		curr = self.head
		if curr is None:
			print("EMPTY LIST")
			return
		else:
			print(curr.data, " DELETED")
			self.head = curr.Next_node

	def delete_end(self):
		curr = self.head
		if not curr:
			print("EMPTY LIST")
			return
		elif not curr.Next_node:
			self.delete_beg()
			return
		else:
			prev = curr
			curr = curr.Next_node
			while curr.Next_node:
				prev = curr
				curr = curr.Next_node
			print(curr.data, " DELETED")
			prev.Next_node = None

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

def controller():
	linked_list = singly()
	choice = None
	again = True

	while( again ):
		print("1). INSERT BEGINNING")
		print("2). INSERT END")
		print("3). DELETE BEGINNING")
		print("4). DELETE END")
		print("11). DISPLAY")
		print("12). EXIT")
		choice = int(input("ENTER CHOICE\t"))

		if choice == 1:
			linked_list.insert_beg()
		elif choice == 2:
			linked_list.insert_end()
		elif choice == 3:
			linked_list.delete_beg()
		elif choice == 4:
			linked_list.delete_end()
		elif choice == 11:
			linked_list.display()
		elif choice == 12:
			print("GOODBYE")
			again = None
		else:
			print("ERROR CHOICE")

controller()