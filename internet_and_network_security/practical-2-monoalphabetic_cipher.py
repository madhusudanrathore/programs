''' monoalphabetic substitution cipher '''
def prepare_final_plain_text(plain_text): # convert to lowercase and remove space
	final_plain_text = ''
	final_plain_text += plain_text.lower().replace(' ','')
	return final_plain_text

def encryption(plain_text, alphabet, substituted_alphabet):
	cipher_text = ''

	for index1 in range( len(plain_text) ):
		for index2 in range( len( alphabet) ):
			if plain_text[index1] == alphabet[index2]:
				cipher_text += substituted_alphabet[index2]
	
	return cipher_text

def decryption(cipher_text, alphabet, substituted_alphabet):
	decipher_text = ''

	for index1 in range( len(cipher_text) ):
		for index2 in range( len( alphabet) ):
			if cipher_text[index1] == substituted_alphabet[index2]:
				decipher_text += alphabet[index2]

	return decipher_text

def main():
	alphabet = ['a', 'b', 'c', 'd','e', 'f', 'g', 'h', 'i',
				'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
	substituted_alphabet = ['q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o','p',
							'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
							'z', 'x', 'c', 'v', 'b', 'n', 'm']

	plain_text = "hello STUDENT" # no characters other than specified in alphabet list
	final_plain_text = prepare_final_plain_text(plain_text)
	cipher_text = encryption(final_plain_text, alphabet, substituted_alphabet)
	decipher_text = decryption(cipher_text, alphabet, substituted_alphabet)

	print("PLAIN TEXT:\t" + plain_text)
	print("FINAL PLAIN TEXT\t{}".format(final_plain_text))
	print("CIPHER TEXT:\t" + cipher_text)
	print("DECIPHER TEXT:\t" + decipher_text)

if __name__ == '__main__':
	main()