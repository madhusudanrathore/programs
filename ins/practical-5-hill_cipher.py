''' hill cipher '''
import math, sys, numpy

def prepare_key_and_key_vector(key):
	final_key = ""
	final_key += key.lower().replace(' ','') # convert to lowercase and remove space

	sqrt_key = math.sqrt(len(final_key))	
	int_sqrt_key = int(sqrt_key)
	
	if sqrt_key - int_sqrt_key != 0: # not perfect square
		print("KEY LENGTH IS NOT PERFECT SQUARE\nEXITING...")
		sys.exit(0)

	key_vec = numpy.zeros(shape=(int_sqrt_key,int_sqrt_key))
	for x in xrange(int_sqrt_key):
		for y in xrange(int_sqrt_key):
			key_vec[x][y] = ord(final_key[ x*int_sqrt_key + y ])-97

	if numpy.linalg.det(key_vec)==0: # inverse not possible
		print("KEY INVERSE NOT POSSIBLE\nEXITING...")
		sys.exit(0)

	return key_vec, final_key

def prepare_entities(plain_text, key_cols):
	final_plain_text = ""
	final_plain_text += plain_text.lower().replace(' ','') # convert to lowercase and remove space

	if len(final_plain_text)%key_cols != 0: # apply padding
		temp = key_cols-len(final_plain_text)%key_cols
		for x in range( temp ):
			final_plain_text += "x"

	final_plain_text_len = len(final_plain_text) # final length after padding
	
	final_plain_text_vector = numpy.zeros(shape=(final_plain_text_len,1)) # prepare plaintext vector
	for x in xrange(final_plain_text_len):
		char = final_plain_text[x]
		final_plain_text_vector[x][0] = (ord(char)-97)%26

	return final_plain_text_vector, final_plain_text

def encryption(final_plain_text_vector, key_vector, key_cols):
	cipher_text = ''
	final_plain_text_vector_len = len(final_plain_text_vector)
	cipher_text_vector = numpy.zeros(shape=(final_plain_text_vector_len,1))
	
	for index1 in xrange( final_plain_text_vector_len/key_cols ):
		# get temp plain text
		temp = numpy.zeros(shape=(key_cols,1))
		for index2 in xrange(key_cols):
			temp[index2][0] = final_plain_text_vector[index1*key_cols+index2][0]
		
		# multiplication of KEY VECTOR with TEMP PLAIN TEXT, C = K*P
		temp_result = numpy.matmul(key_vector,temp)
		
		# append temporary results
		for index3 in xrange(key_cols):
			val = temp_result[index3][0]%26
			cipher_text_vector[index1*key_cols+index3][0] = val
			cipher_text += chr(int(val)+97)

	return cipher_text_vector, cipher_text

def decryption(cipher_text_vector, key_vector, key_cols):
	decipher_text = ''
	cipher_text_vector_len = len(cipher_text_vector)
	decipher_text_vector = numpy.zeros(shape=(cipher_text_vector_len,1))
	inverse_key_vector = [  [4,9,15], [15, 17, 6], [24, 0, 17]]

	for index1 in xrange( cipher_text_vector_len/key_cols ):
		# get temp cipher text
		temp = numpy.zeros(shape=(key_cols,1))
		for index2 in xrange(key_cols):
			temp[index2][0] = cipher_text_vector[index1*key_cols+index2][0]
		
		# multiplication of INVERSE KEY VECTOR with TEMP CIPHER TEXT, D = K^-1*C
		temp_result = numpy.matmul(inverse_key_vector, temp)
		
		# append temporary results
		for index3 in xrange(key_cols):
			val = temp_result[index3][0]%26
			decipher_text_vector[index1*key_cols+index3][0] = val
			decipher_text += chr(int(val)+97)

	return decipher_text_vector, decipher_text

def main():
	key = 'rrfvs vc ct' # length must be such that all characters sum to perfect square
	plain_text = 'madhu sudan' # no special characters
	key_vector, final_key = prepare_key_and_key_vector(key)
	key_cols = len(key_vector)

	final_plain_text_vector, final_plain_text = prepare_entities(plain_text, key_cols)
	cipher_text_vector, cipher_text = encryption(final_plain_text_vector, key_vector, key_cols)
	decipher_text_vector, decipher_text = decryption(cipher_text_vector, key_vector, key_cols)

	print("KEY:{}\nFINAL KEY:{}\nKEY VECTOR\n{}\n".format(key, final_key, key_vector.tolist()))
	print("PLAIN TEXT:\t{}\nFINAL PLAIN TEXT:\t{}\nFINAL PLAIN TEXT VECTOR:\n{}\n".format(plain_text, final_plain_text, final_plain_text_vector.tolist()))
	print("CIPHER TEXT VECTOR\n{}\nCIPHER TEXT:\t{}\n".format(cipher_text_vector.tolist(), cipher_text))
	print("DECIPHER TEXT VECTOR\n{}\nDECIPHER TEXT:\t{}".format(decipher_text_vector.tolist(), decipher_text))

if __name__ == '__main__':
	main()
