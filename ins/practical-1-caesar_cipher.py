''' caesar cipher '''
def encryption(plain_text, shift):
	enc_str = ""
	length = len(plain_text)
	
	for index in xrange(length):
		char = plain_text[index]
		if char.isupper():
			enc_str += chr((ord(char)+shift-65)%26+65)
		elif char.islower():
			enc_str += chr((ord(char)+shift-97)%26+97)
		elif char.isdigit():
			enc_str += chr((ord(char)+shift-48)%10+48)
		else: # special characters
			enc_str += chr((ord(char)+shift-32)%16+32)
	
	return enc_str

def decryption(cipher_text, shift):
	dec_str = ""
	length = len(cipher_text)
	
	for index in xrange(length):
		char = cipher_text[index]
		if char.isupper():
			dec_str += chr((ord(char)+(26-shift)-65)%26+65) # using cyclic property for decryption
		elif char.islower():
			dec_str += chr((ord(char)+(26-shift)-97)%26+97)
		elif char.isdigit():
			dec_str += chr((ord(char)+(10-shift)-48)%10+48)
		else: # special characters
			dec_str += chr((ord(char)+(16-shift)-32)%16+32)
	
	return dec_str

def main():
	shift = 25
	plain_text = "hello STUDENT 0123456789 !\"#$%&'()+,-./*" # no other special characters than mentioned
	cipher_text = encryption(plain_text, shift)
	decipher_text = decryption(cipher_text, shift)

	print("PLAIN TEXT:\t" + plain_text)
	print("CIPHER TEXT:\t" + cipher_text)
	print("DECIPHER TEXT:\t" + decipher_text)

if __name__ == '__main__':
	main()
