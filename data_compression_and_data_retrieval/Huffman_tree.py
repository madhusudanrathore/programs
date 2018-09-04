class Node(object):
	def __init__(self, implicit_probability=None, implicit_word=None):
		self.probability = implicit_probability
		self.word = implicit_word
		self.left = None
		self.right = None

class HuffmanTree(object):
	def __init__(self):
		self.parent=None

	def build_tree(self):
		self.insert_node(input_data[0][0],input_data[0][1], input_data[1][0], input_data[1][1])#INITIAL 2 ENTRIES
		itr_len=len(input_data)
		for x in range(0,itr_len):#REMAINING ENTRIES
			self.insert_node(input_data[0][0], input_data[0][1])

	def update_dictionary(self, entry=None):
		input_data.pop(0)#POP ONE ELEMENT
		if entry is 1: input_data.pop(0)#POP ANOTHER ELEMENT IF IT'S FIRST ENTRY

	def insert_node(self, w1, p1,  w2=None, p2=None):
		if p2:#FIRST ENTRY
			p=Node(p1+p2)
			new_left=Node(p1, w1)
			new_right=Node(p2, w2)
			p.left=new_left
			p.right=new_right
			self.parent=p
			self.update_dictionary(1)
		else:#REMAINING ENTRIES
			p=self.parent
			q=Node(p.probability+p1)
			new_node=Node(p1,w1)
			if p.probability<p1:
				q.left=p
				q.right=new_node
			else:
				q.left=new_node
				q.right=p
			self.parent=q
			self.update_dictionary()

	def preorder_traversal(self, obj, path=""):
		if obj:
			self.preorder_traversal(obj.left,path+"0")
			if obj.word:print (str(obj.word) + ' '+path)
			self.preorder_traversal(obj.right,path+"1")

def getData():#RETURNS SORTED LIST
	inp=[['a',0.2],['b',0.4],['c',0.2],['d',0.1],['e',0.1]]
	n=len(inp)
	#APPLYING BUBBLE SORT
	for i in range(n):
		for j in range(0, n-1):
			if inp[j][1]>inp[j+1][1]:
				inp[j][0], inp[j+1][0]=inp[j+1][0], inp[j][0]#CODEWORD SWAP
				inp[j][1], inp[j+1][1]=inp[j+1][1], inp[j][1]#PROBABILITY SWAP
	return inp

input_data = getData()
ht = HuffmanTree()

#BUILDING TREE
ht.build_tree()
#PRINT TREE
ht.preorder_traversal(ht.parent)