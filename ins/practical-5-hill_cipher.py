''' hill cipher '''
import random, numpy

def prepare_key(length):
	random.seed(1) # same random values generated each time
	temp_vec = numpy.zeros(shape=(length,length)) # n*n vector
	
	for x in xrange(length):
		for y in xrange(length):
			temp = random.randint(0,26) # random numbers between 0 and 25
			temp_vec[x][y] = temp
	
	return temp_vec # return numpy matrix

def prepare_all_plain_text_entities(plain_text, key_len):
	final_plain_text = ""
	final_plain_text += plain_text.lower().replace(' ','') # convert to lowercase and remove space
	final_plain_text_len = len(final_plain_text) # final input length

	if final_plain_text_len%key_len != 0: # apply padding
		temp = key_len-final_plain_text_len%key_len
		for x in range( temp ):
			final_plain_text += "x"

	final_plain_text_vector = numpy.zeros(shape=(final_plain_text_len,1))

	for x in xrange(final_plain_text_len): # prepare plaintext vector
		char = final_plain_text[x]
		final_plain_text_vector[x][0] = (ord(char)-97)%26

	return final_plain_text_vector, final_plain_text

def encryption(final_plain_text_vector, key_vector):
	cipher_text = ""
	final_plain_text_vector_len = len(final_plain_text_vector)
	cipher_text_vector = numpy.zeros(shape=(final_plain_text_vector_len,1))
	key_len = len(key_vector)

	x = 0
	while x < final_plain_text_vector_len:
		temp_final_plain_text_vector = numpy.zeros(shape=(key_len,1))
		temp_cipher_text_vector = numpy.zeros(shape=(key_len,1))

		for y in xrange(key_len): # get part of plain text to be encrypted
			temp_final_plain_text_vector[y][0] = final_plain_text_vector[x+y][0]

		# multiplication of KEY VECTOR with temporary PLAIN TEXT, C = K*P
		temp_cipher_text_vector = key_vector*temp_final_plain_text_vector

		# append to final cipher vector
		for i in xrange(key_len):
			cipher_text_vector[x+i][0] = temp_cipher_text_vector[i][0]%26
			cipher_text += chr(int(cipher_text_vector[x+i][0]%26)+97)

		x = x+key_len

	return cipher_text_vector, cipher_text

def decryption(cipher_text_vector, key_vector):
	decipher_text = ''
	cipher_text_vector_len = len(cipher_text_vector)
	key_len = len(key_vector)
	decipher_text_vector = numpy.zeros(shape=(cipher_text_vector_len,1))

	x = 0
	while x < cipher_text_vector_len:
		temp_cipher_text_vector = numpy.zeros(shape=(key_len,1))
		temp_decipher_text_vector = numpy.zeros(shape=(key_len,1))

		for y in xrange(key_len): # get part of plain text to be encrypted
			temp_cipher_text_vector[y][0] = cipher_text_vector[x+y][0]

		# multiplication of INVERSE KEY VECTOR with temporary CIPHER TEXT, D = K^-1*C
		temp_decipher_text_vector = numpy.linalg.inv(key_vector)*temp_cipher_text_vector

		# append to final decipher vector
		for i in xrange(key_len):
			decipher_text_vector[x+i][0] = temp_decipher_text_vector[i][0]%26
			decipher_text += chr(int(decipher_text_vector[x+i][0])+97)

		x = x+key_len

	return decipher_text_vector, decipher_text

def main():
	key_len = 2 # will produce keyword of length keylen*key_len
	plain_text = 'madhusudan' # no special characters
	cipher_text = ''
	decipher_text = ''

	key_vector = None
	final_plain_text_vector = None
	cipher_text_vector = None
	decipher_text_vector = None
	
	key_vector = prepare_key(key_len)
	# print(numpy.linalg.inv(key_vector))

	final_plain_text_vector, final_plain_text = prepare_all_plain_text_entities(plain_text, key_len)	
	cipher_text_vector, cipher_text = encryption(final_plain_text_vector, key_vector)
	decipher_text_vector, decipher_text = decryption(cipher_text_vector, key_vector)

	print("KEY VECTOR\n{}".format(key_vector))
	print("PLAIN TEXT:\t{}\nFINAL PLAIN TEXT:\t{}\nFINAL PLAIN TEXT VECTOR:\n{}".format(plain_text, final_plain_text, final_plain_text_vector))
	print("CIPHER TEXT VECTOR\n{}\nCIPHER TEXT:\t{}".format(cipher_text_vector, cipher_text))
	print("DECIPHER TEXT VECTOR\n{}\nDECIPHER TEXT:\t{}".format(decipher_text_vector, decipher_text))

if __name__ == '__main__':
	main()
