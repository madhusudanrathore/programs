''' vigenere cipher '''
def prepare_input(plain_text, key):
	temp_str = ""
	temp_str += plain_text
	plain_text_len = len(plain_text)
	key_len = len(key)
	
	if plain_text_len%key_len != 0: # padding for remaining values
		temp = key_len-plain_text_len%key_len
		for i in range(temp):
			temp_str += "~"
	
	return temp_str

def encryption(final_plain_text, key):
	enc_str = ""
	final_plain_text_len = len(final_plain_text)
	key_len = len(key)

	x = 0
	while x < final_plain_text_len:
		for y in range(key_len):
			shift = ord(key[y])
			char = final_plain_text[x+y]
			if char.isupper():
				enc_str += chr((ord(char)+shift-65)%26+65)
			elif char.islower():
				enc_str += chr((ord(char)+shift-97)%26+97)
			elif char.isdigit():
				enc_str += chr((ord(char)+shift-48)%10+48)
			elif char == "~":
				enc_str += "~"
			else: # special characters
				enc_str += chr((ord(char)+shift-32)%16+32)
		
		x += key_len
	
	return enc_str

def decryption(final_plain_text, key):
	dec_str=""
	final_plain_text_len = len(final_plain_text)
	key_len = len(key)

	x=0
	while x < final_plain_text_len:
		for y in range(key_len):
			shift=ord(key[y])
			char=final_plain_text[x+y]
			if char.isupper():
				dec_str += chr((ord(char)+(26-shift)-65)%26+65) # using cyclic property for decryption
			elif char.islower():
				dec_str += chr((ord(char)+(26-shift)-97)%26+97)
			elif char.isdigit():
				dec_str += chr((ord(char)+(10-shift)-48)%10+48)
			elif char=="~":
				dec_str += ""
			else: # special characters
				dec_str += chr((ord(char)+(16-shift)-32)%16+32)

		x += key_len
	
	return dec_str

def main():
	key = "keyword"
	plain_text = "hello STUDENT 0123456789 !\"#$%&'()+,-./*" # no other special characters
	final_plain_text=prepare_input(plain_text, key)
	cipher_text = encryption(final_plain_text, key)
	decipher_text = decryption(cipher_text, key)

	print("PLAIN TEXT:\t" + plain_text)
	print("CIPHER TEXT:\t" + cipher_text)
	print("DECIPHER TEXT:\t" + decipher_text)

if __name__ == '__main__':
	main()