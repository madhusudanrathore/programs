import random

key_len = 4
key_vector = []
input_str = "hellomadhusudanrathore"
str_len = len(input_str)
plain_text_vector = []
cipher_text_vector=[]


def prepare_key():
	random.seed(1) # same random values generated each time
	for x in range(key_len):
		temp = random.randint(1,10000)
		key_vector.append(temp)
	print(key_vector)


def prepare_input_vector():
	temp_str=""
	temp_str+=input_str

	if str_len % key_len != 0:# apply padding
		temp=key_len-str_len%key_len
		for x in range( temp ):
			temp_str+="~"

	print(temp_str, len(temp_str)) # final input string
	new_str_len = len(temp_str) # final input length

	rows = new_str_len/key_len
	cols = key_len
	pt_vec = [[0 for x in range(cols)] for y in range(rows)]
	print(rows,cols)

	for x in range(rows): # prepare plaintext vector
		for y in range(cols):
			char = temp_str[x+y]
			pt_vec[x][y] = ord(char)

	return pt_vec


def encryption(inp):
	temp=[]

	return temp


prepare_key()
plain_text_vector=prepare_input_vector()
cipher_text = encryption( plain_text_vector )
# decrypted_str = decryption(encrypted_str)


# print ( "input:\t" + input_str )
# print ( "encryption:\t" + encrypted_str )
# print ( "decryption:\t" + decrypted_str )