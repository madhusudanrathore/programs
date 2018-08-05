def modified_euler_totient():
	return None

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
	d = ((p1-1)*(p2-1)+1)/e

	print("P1:{}\tP2:{}\tN:{}\tE:{}\tD:{}".format(p1, p2, n, e, d))

	plain_text = "hellomadhusudanrathore1235~@:13$"
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
