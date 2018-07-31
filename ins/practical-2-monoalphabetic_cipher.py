def encryption(plain_text, shift):
	enc_str = ""
	length = len(plain_text)
	
	for x in xrange(length):
		char = plain_text[x]
		if char == " ":
			enc_str += char
		elif char.isupper():
			enc_str += chr((ord(char)+shift-65)%26+65)
		elif char.islower():
			enc_str += chr((ord(char)+shift-97)%26+97)
		else: # for numbers and special characters
			enc_str += chr((ord(char)+shift*10)%256)
	
	return enc_str

def decryption(cipher_text, shift):
	dec_str = ""
	length = len(cipher_text)
	
	for x in xrange(length):
		char = cipher_text[x]
		if char == " ":
			dec_str += char
		elif char.isupper():
			dec_str += chr((ord(char)+(26-shift)-65)%26+65) # using cyclic property for decryption
		elif char.islower():
			dec_str += chr((ord(char)+(26-shift)-97)%26+97)
		else:
			dec_str += chr((ord(char)+(256-shift*10))%256)
	
	return dec_str

def main():
	shift = 1
	plain_text = "hellostudent"
	cipher_text = encryption(plain_text, shift)
	decipher_text = decryption(cipher_text, shift)

	print("PLAIN TEXT:\t" + plain_text)
	print("CIPHER TEXT:\t" + cipher_text)
	print("DECIPHER TEXT:\t" + decipher_text)

if __name__ == '__main__':
	main()