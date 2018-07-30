def make_key_unique(key):
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

def make_matrix(new_key, new_alphabet, matrix):
	new_key_count=len(new_key)
	new_alphabet_count=len(new_alphabet)
	
	for i in range(5):
		for j in range(5):
			if new_key_count>0:
				temp=len(new_key)-new_key_count
				matrix[i][j]=new_key[temp]
				new_key_count=new_key_count-1
			else:
				temp=len(new_alphabet)-new_alphabet_count
				matrix[i][j]=new_alphabet[temp]
				new_alphabet_count=new_alphabet_count-1
	
	print("MATRIX AS BELOW:\n{}\n".format(matrix))
	return matrix

def find_row_col(ch, matrix):
	for i in xrange(5):
		for j in xrange(5):
			if matrix[i][j] is ch:
				return i, j

def encryption(plain_text, matrix):
	temp_plain_text=plain_text.replace(' ','') # remove spaces

	for i in xrange(len(temp_plain_text)): # append 'x' for same consecutive characters
		if (i!=len(temp_plain_text)-1) and (temp_plain_text[i] == temp_plain_text[i+1]):
			temp=temp_plain_text[:i+1]+'x'+temp_plain_text[i+1:]
			temp_plain_text=temp

	if len(temp_plain_text)%2 != 0: # append 'x' if input length is odd
		temp_plain_text+='x'

	enc_str=""
	i=0
	while i < len(temp_plain_text): # encryption logic
		temp_row_1, temp_col_1 = find_row_col(temp_plain_text[i], matrix)
		temp_row_2, temp_col_2 = find_row_col(temp_plain_text[i+1], matrix)
		enc_1=None
		enc_2=None

		if temp_row_1 == temp_row_2: # same row, shift column
			enc_1=matrix[temp_row_1][(temp_col_1+1)%5]
			enc_2=matrix[temp_row_2][(temp_col_2+1)%5]
		elif temp_col_1 == temp_col_2: # same column, shift row
			enc_1=matrix[(temp_row_1+1)%5][temp_col_1]
			enc_2=matrix[(temp_row_2+1)%5][temp_col_2]
		else:
			enc_1=matrix[temp_row_1][temp_col_2]
			enc_2=matrix[temp_row_2][temp_col_1]

		enc_str += enc_1 + enc_2
		i=i+2

	return enc_str, temp_plain_text

def decryption(enc_str, matrix):
	dec_str=""
	
	i=0
	while i < len(enc_str): # encryption logic
		temp_row_1, temp_col_1 = find_row_col(enc_str[i], matrix)
		temp_row_2, temp_col_2 = find_row_col(enc_str[i+1], matrix)
		dec_1=None
		dec_2=None

		if temp_row_1 == temp_row_2: # same row, shift column
			dec_1=matrix[temp_row_1][(temp_col_1-1)%5]
			dec_2=matrix[temp_row_2][(temp_col_2-1)%5]
		elif temp_col_1 == temp_col_2: # same column, shift row
			dec_1=matrix[(temp_row_1-1)%5][temp_col_1]
			dec_2=matrix[(temp_row_2-1)%5][temp_col_2]
		else:
			dec_1=matrix[temp_row_1][temp_col_2]
			dec_2=matrix[temp_row_2][temp_col_1]

		dec_str += dec_1 + dec_2
		i=i+2

	return dec_str

def main():
	key = "keyword"
	plain_text = "hellostudent" # should be lower case and without spaces
	matrix = [[0 for x in range(5)] for y in range(5)] # define 5*5 matrix

	new_key, new_alphabet = make_key_unique(key)
	matrix = make_matrix(new_key, new_alphabet, matrix)
	cipher_text, final_plain_text = encryption(plain_text, matrix)
	decipher_text = decryption(cipher_text, matrix)

	print("PLAIN TEXT:\t" + plain_text)
	print("FINAL PLAIN TEXT:\t{}".format(final_plain_text))
	print("CIPHER TEXT:\t" + cipher_text)
	print("DECIPHER TEXT:\t" + decipher_text)

if __name__ == '__main__':
	main()
