shift = 10

def encryption(inp):
	enc_str = ""
	
	for x in range(len(inp)):
		char = inp[x]
		if char == " ":
			enc_str += char
		elif char.isupper():
			enc_str += chr((ord(char)+shift-65)%26+65)
		elif char.islower():
			enc_str += chr((ord(char)+shift-97)%26+97)
		else: # for numbers and special characters
			enc_str += chr((ord(char)+shift*10)%256)
	
	return enc_str


def decryption(inp):
	dec_str = ""
	
	for x in range(len(inp)):
		char = inp[x]
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
	plain_text = "hello STUDENT 0123456789 !$%&*()-+/*.,'`~#}{<>[]}{"
	cipher_text = encryption(plain_text)
	deciphered_text = decryption(cipher_text)

	print ( "input:\t" + plain_text )
	print ( "encryption:\t" + cipher_text )
	print ( "decryption:\t" + deciphered_text )

if __name__ == '__main__':
	main()
