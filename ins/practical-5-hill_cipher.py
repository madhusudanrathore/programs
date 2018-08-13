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

def prepare_entities(plain_text, key_len):
	final_plain_text = ""
	final_plain_text += plain_text.lower().replace(' ','') # convert to lowercase and remove space
	final_plain_text_len = len(final_plain_text) # final input length

	if final_plain_text_len%key_len != 0: # apply padding
		temp = key_len-final_plain_text_len%key_len
		for x in range( temp ):
			final_plain_text += "x"

	final_plain_text_len = len(final_plain_text) # new final length after padding
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
	
	for index1 in xrange( final_plain_text_vector_len/key_len ):
		# get temp plain text
		temp = numpy.zeros(shape=(key_len,1))
		for index2 in xrange(key_len):
			temp[index2][0] = final_plain_text_vector[index1*key_len+index2][0]
		# multiplication of KEY VECTOR with TEMP PLAIN TEXT, C = K*P
		temp_result = key_vector*temp
		# append temporary results
		for index3 in xrange(key_len):
			val = temp_result[index3][0]%26
			cipher_text_vector[index1*key_len+index3][0] = val
			cipher_text += chr(int(val)+97)

	return cipher_text_vector, cipher_text

def decryption(cipher_text_vector, key_vector):
	decipher_text = ''
	cipher_text_vector_len = len(cipher_text_vector)
	key_len = len(key_vector)
	decipher_text_vector = numpy.zeros(shape=(cipher_text_vector_len,1))

	for index1 in xrange( cipher_text_vector_len/key_len ):
		# get temp cipher text
		temp = numpy.zeros(shape=(key_len,1))
		for index2 in xrange(key_len):
			temp[index2][0] = cipher_text_vector[index1*key_len+index2][0]
		# multiplication of INVERSE KEY VECTOR with TEMP PLAIN TEXT, D = K^-1*C
		temp_result = numpy.linalg.inv(key_vector)*temp
		# append temporary results
		for index3 in xrange(key_len):
			val = temp_result[index3][0]%26
			decipher_text_vector[index1*key_len+index3][0] = val
			decipher_text += chr(int(val)+97)

	return decipher_text_vector, decipher_text

def main():
	key_len = 5 # will produce keyword of length (key_len*key_len)
	plain_text = 'madhu sudan' # no special characters
	cipher_text = ''
	decipher_text = ''

	key_vector = None
	final_plain_text_vector = None
	cipher_text_vector = None
	decipher_text_vector = None
	
	key_vector = prepare_key(key_len)

	final_plain_text_vector, final_plain_text = prepare_entities(plain_text, key_len)	
	cipher_text_vector, cipher_text = encryption(final_plain_text_vector, key_vector)
	decipher_text_vector, decipher_text = decryption(cipher_text_vector, key_vector)

	print("KEY VECTOR\n{}".format(key_vector))
	print("PLAIN TEXT:\t{}\nFINAL PLAIN TEXT:\t{}\nFINAL PLAIN TEXT VECTOR:\n{}".format(plain_text, final_plain_text, final_plain_text_vector))
	print("CIPHER TEXT VECTOR\n{}\nCIPHER TEXT:\t{}".format(cipher_text_vector, cipher_text))
	print("DECIPHER TEXT VECTOR\n{}\nDECIPHER TEXT:\t{}".format(decipher_text_vector, decipher_text))

if __name__ == '__main__':
	main()
