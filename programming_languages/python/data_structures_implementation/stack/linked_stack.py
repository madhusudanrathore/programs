class Node( object ):
	def __init__(self):
		self.data = int(input("ENTER DATA:\t"))
		self.Next_node = None
		print( self.data, "\t ENTERED")

class linked_stack( object ):
	def __init__(self):
		new_node = Node()
		self.head = new_node
		print("STACK CREATED")

	def push(self):#fundamentally, it is INSERTION AT BEGINNING
		new_node = Node()
		new_node.Next_node = self.head
		self.head = new_node			

	def display(self):
		# if self.head is None
		# 	print("EMPTY LIST")
		# else:
		self.temp_node = self.head
		while self.temp_node:
			print(self.temp_node.data, " -> ", end='')
			self.temp_node = self.temp_node.Next_node
		print(" NONE")

def controller():
	user_stack = linked_stack()
	choice = None
	again = True

	while( again ):
		print("1). PUSH")
		print("2). POP")
		print("3). DISPLAY")
		print("4). EXIT")
		choice = int(input("ENTER CHOICE\t"))

		if choice == 1:
			user_stack.push()
		elif choice == 2:
			user_stack.pop()
		elif choice == 3:
			user_stack.display()
		elif choice == 4:
			print("GOODBYE")
			again = None
		else:
			print("ERROR CHOICE")

controller()