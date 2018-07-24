key="keyword"
input_string="hello student"
mat=[[0 for x in range(5)] for y in range(5)] # define 5*5 matrix

def make_key_unique():
	alphabet_string="abcdefghiklmnopqrstuvwxyz" # j is excluded
	temp_key=""
	temp_alphabet=""
	for i in xrange(len(key)):
		temp=key[0:i+1]			
		if key[i] not in temp_key and key[i] is not 'j': # j is excluded
			temp_key+=key[i]
			temp_alphabet=alphabet_string.replace(key[i],'')
			alphabet_string=temp_alphabet
	return temp_key, alphabet_string

def make_matrix():
	new_key_count=len(new_key)
	new_alphabet_count=len(new_alphabet)
	for i in range(5):
		for j in range(5):
			if new_key_count>0:
				temp=len(new_key)-new_key_count
				mat[i][j]=new_key[temp]
				new_key_count=new_key_count-1
			else:
				temp=len(new_alphabet)-new_alphabet_count
				mat[i][j]=new_alphabet[temp]
				new_alphabet_count=new_alphabet_count-1
	print "matrix is as below:\n", mat

def find_row_col(ch):
	for i in xrange(5):
		for j in xrange(5):
			if mat[i][j] is ch:
				return i, j

def encryption():
	temp_input_string=input_string.replace(' ','') # remove spaces

	for i in xrange(len(temp_input_string)): # append 'x' for same consecutive characters
		if (i!=len(temp_input_string)-1) and (temp_input_string[i] == temp_input_string[i+1]):
			temp=temp_input_string[:i+1]+'x'+temp_input_string[i+1:]
			temp_input_string=temp

	if len(temp_input_string)%2 != 0: # append 'x' if input length is odd
		temp_input_string+='x'

	enc_str=""
	i=0
	while i < len(temp_input_string): # encryption logic
		temp_row_1, temp_col_1 = find_row_col(temp_input_string[i])
		temp_row_2, temp_col_2 = find_row_col(temp_input_string[i+1])
		enc_1=None
		enc_2=None

		if temp_row_1 == temp_row_2: # same row, shift column
			enc_1=mat[temp_row_1][(temp_col_1+1)%5]
			enc_2=mat[temp_row_2][(temp_col_2+1)%5]
		elif temp_col_1 == temp_col_2: # same column, shift row
			enc_1=mat[(temp_row_1+1)%5][temp_col_1]
			enc_2=mat[(temp_row_2+1)%5][temp_col_2]
		else:
			enc_1=mat[temp_row_1][temp_col_2]
			enc_2=mat[temp_row_2][temp_col_1]

		enc_str += enc_1 + enc_2
		i=i+2

	return enc_str

def decryption(enc_str):
	dec_str=""
	i=0
	while i < len(enc_str): # encryption logic
		temp_row_1, temp_col_1 = find_row_col(enc_str[i])
		temp_row_2, temp_col_2 = find_row_col(enc_str[i+1])
		dec_1=None
		dec_2=None

		if temp_row_1 == temp_row_2: # same row, shift column
			dec_1=mat[temp_row_1][(temp_col_1-1)%5]
			dec_2=mat[temp_row_2][(temp_col_2-1)%5]
		elif temp_col_1 == temp_col_2: # same column, shift row
			dec_1=mat[(temp_row_1-1)%5][temp_col_1]
			dec_2=mat[(temp_row_2-1)%5][temp_col_2]
		else:
			dec_1=mat[temp_row_1][temp_col_2]
			dec_2=mat[temp_row_2][temp_col_1]

		dec_str += dec_1 + dec_2
		i=i+2

	return dec_str

new_key, new_alphabet=make_key_unique()
make_matrix()
encrypted_string=encryption()
decrypted_string=decryption(encrypted_string)

print ( "input:\t" + input_string )
print ( "encryption:\t" + encrypted_string )
print ( "decryption:\t" + decrypted_string )