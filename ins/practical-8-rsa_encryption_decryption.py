''' rsa encryption decryption using extended euclidean algorithm '''
def extended_euclidean(phi_n, e):
	col1 = []
	col2 = []
	col3 = []
	col4 = []

	col1.append(1)
	col2.append(0)
	col3.append(phi_n)
	col4.append(None)

	col1.append(0)	
	col2.append(1)
	col3.append(e)
	col4.append(col3[0]/col3[1])

	not_found = True
	i = 2
	while not_found:
		col1.append(col1[i-2]-(col1[i-1]*col4[i-1]))
		col2.append(col2[i-2]-(col2[i-1]*col4[i-1]))
		col3.append(col3[i-2]-(col3[i-1]*col4[i-1]))
		col4.append(col3[i-1]/col3[i])
		
		if col3[i] == 1:
			not_found=False

		i = i+1

	d = col2[i-1]

	return d

def prepare_plain_text_vector(plain_text):
	temp_vec = []
	length = len(plain_text)

	for x in xrange(length):
		temp_vec.append(ord(plain_text[x]))

	return temp_vec

def encryption(plain_text_vector, e, n):
	temp_vec = []
	enc_str = ""
	length = len(plain_text_vector)

	for x in xrange(length):
		temp_cipher_text = (plain_text_vector[x]**e)%n
		temp_vec.append(temp_cipher_text)
		enc_str += chr(temp_cipher_text)

	return temp_vec, enc_str

def decryption(cipher_text_vector, d, n):
	dec_str = ""
	length = len(cipher_text_vector)

	for x in xrange(length):
		temp_decipher_text = (cipher_text_vector[x]**d)%n
		dec_str += chr(temp_decipher_text)
	
	return dec_str

def main():
	p1 = 17
	p2 = 11
	n = p1*p2
	e = 7
	phi_n = (p1-1)*(p2-1)
	d = extended_euclidean(phi_n, e)

	plain_text = "hello STUDENT 0123456789 !\"#$%&'()+,-./* `$^*|\\?@" # all characters supported
	plain_text_vector = []
	cipher_text = []
	decipher_text = []

	plain_text_vector = prepare_plain_text_vector(plain_text)
	cipher_text_vector, cipher_text = encryption(plain_text_vector, e, n)
	decipher_text = decryption(cipher_text_vector, d, n)

	print("PLAIN TEXT:\t" + plain_text)
	print("CIPHER TEXT:\t" + cipher_text)
	print("DECIPHER TEXT:\t" + decipher_text)

if __name__ == '__main__':
	main()
