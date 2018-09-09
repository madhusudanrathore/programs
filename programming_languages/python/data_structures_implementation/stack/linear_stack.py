class stack( object ):
	def __init__(self):
		self.top = -1
		self.size = int(input("Enter size of stack:\t"))
		self.arr = [None]*self.size

	def push(self):
		if self.top < self.size-1:
			val = int(input("Enter value to be inserted\t"))
			self.top+=1
			self.arr[self.top] = val
			print(self.arr[self.top] , "INSERTED")
		else:
			print("OVERFLOW")

	def pop(self):
		if self.top > -1:
			print( self.arr[self.top] , "deleted")
			self.top-=1
		else:
			print("UNDERFLOW")

	def display(self):
		if self.top > -1:
			high = self.top
			low = -1
			for x in range(high,low,-1):
				print(self.arr[x])
		else:
			print ("EMPTY")

def controller():
	user_stack = stack()
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