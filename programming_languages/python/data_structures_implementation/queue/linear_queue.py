class queue( object ):
	def __init__(self):
		self.front = -1
		self.rear = -1
		self.size = int(input("Enter size of Queue:\t"))
		self.arr = [None]*self.size

	def enqueue(self):
		if self.rear == self.size-1:
			print("OVERFLOW")
		else:
			val = int(input("Enter value to be inserted\t"))

			if self.rear == -1 and self.front == -1 :
				self.front = 0
				self.rear = 0
			else:
				self.rear += 1

			self.arr[self.rear] = val
			print(val , "INSERTED")

	def dequeue(self):
		if self.front == -1 or self.front > self.rear:
			print("UNDERFLOW")
		else:
			print( self.arr[self.front] , "deleted")
			self.front+=1

	def display(self):
		if self.front <= self.rear:
			high = self.front
			low = self.rear + 1
			for x in range(high,low):
				print(self.arr[x])
		else:
			print ("EMPTY")

def controller():
	user_queue = queue()
	choice = None
	again = True

	while( again ):
		print("1). ENQUEUE")
		print("2). DEQUEUE")
		print("3). DISPLAY")
		print("4). EXIT")
		choice = int(input("ENTER CHOICE\t"))

		if choice == 1:
			user_queue.enqueue()
		elif choice == 2:
			user_queue.dequeue()
		elif choice == 3:
			user_queue.display()
		elif choice == 4:
			print("GOODBYE")
			again = None
		else:
			print("ERROR CHOICE")

controller()