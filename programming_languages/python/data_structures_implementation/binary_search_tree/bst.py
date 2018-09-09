import random

class Node(object):
	def __init__(self, implicit_data=None):
		self.data = implicit_data
		self.left = None
		self.right = None
		print( self.data, "\t ENTERED")

class bst(object):
	def __init__(self):
		self.root = None

	def insert_node(self):
		if self.root is None:#EMPTY TREE
			new_node = Node(10)#ROOT = 10
			self.root = new_node
			print("BST Created")
		else:#NON-EMPTY TREE
			val = random.randint(1,101)
			new_node = Node(val)#ELSE RANDOM VALUES
			temp = self.root
			while temp.left or temp.right:
				if temp.data >= val and temp.left:
					temp = temp.left
				elif temp.data < val and temp.right:
					temp = temp.right
				else:
					break

			if temp.data >= val:
				temp.left = new_node
			else:
				temp.right = new_node

			print(val," NODE INSERTED")

	def preorder_traversal(self, obj):
		if obj:
			print(obj.data, " " ,end="")
			self.preorder_traversal(obj.left)
			self.preorder_traversal(obj.right)

	def inorder_traversal(self, obj):
		if obj:
			self.inorder_traversal(obj.left)
			print(obj.data, " " ,end="")
			self.inorder_traversal(obj.right)

	def postorder_traversal(self, obj):
		if obj:
			self.postorder_traversal(obj.left)
			self.postorder_traversal(obj.right)
			print(obj.data, " " ,end="")

	def search_node(self):
		

def controller():
	tree = bst()
	repeat = True

	while( repeat )
        print("1). EXIT")
        print("2). INSERT")
        print("3). PREORDER TRAVERSAL")
        print("4). INORDER TRAVERSAL")
        print("5). POSTORDER TRAVERSAL")
        print("6). SEARCH")
        print("7). HEIGHT")
        print("8). SMALLEST")
        print("9). LARGEST")
        print("10). TOTAL NODES")
        print("11). TOTAL EXTERNAL NODES")
        print("12). TOTAL INTERNAL NODES")
        print("13). DELETE SPECIFIC NODE")
        print("14). DELETE TREE")
        choice = int(input("ENTER YOUR CHOICE\t"))

		if choice == 1:
		    repeat = False
		elif choice == 2:
		    tree.insert_node()
		elif choice == 3:
		    tree.preorder( tree.root )
		    print()
		elif choice == 4:
		    tree.inorder( tree.root )
		    print()
		elif choice == 5:
		    tree.postorder( tree.root )
		    print()
		elif choice == 6:
		    tree.search_node()
		else:
		    print("INVALID OPTION")

controller()