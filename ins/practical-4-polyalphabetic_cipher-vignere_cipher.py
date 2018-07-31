def padding(plain_text, key): # padding for remaining values
	temp_str = ""
	temp_str += plain_text
	plain_text_len = len(plain_text)
	key_len = len(key)
	
	if plain_text_len%key_len != 0:
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
			if char == " ":
				enc_str += char
			elif char.islower():
				enc_str += chr((ord(char)+shift-97)%26+97)
			elif char.isupper():
				dec_str += chr((ord(char)+shift-65)%26+65)
			elif char == "~":
				enc_str += '~'
		x += key_len
	
	return enc_str

def decryption(final_plain_text, key):
	dec_str=""
	final_plain_text_len = len(final_plain_text)
	key_len = len(key)

	x=0
	while x < final_plain_text_len:
		for y in range(key_len):
			shift=26-ord(key[y])
			char=final_plain_text[x+y]
			if char==" ":
				dec_str += char
			elif char.islower():
				dec_str += chr((ord(char)+shift-97)%26+97)
			elif char.isupper():
				dec_str += chr((ord(char)+shift-65)%26+65)
			elif char=="~":
				dec_str += '~'
		x += key_len
	
	return dec_str

def main():
	key = "M@d#U"
	plain_text = "hellomadhusudan"
	cipher_text = None
	decipher_text = None

	final_plain_text=padding(plain_text, key)
	cipher_text = encryption(final_plain_text, key)
	decipher_text = decryption(cipher_text, key)

	print("PLAIN TEXT:\t" + plain_text)
	print ("FINAL PLAIN TEXT:\t" + final_plain_text)
	print("CIPHER TEXT:\t" + cipher_text)
	print("DECIPHER TEXT:\t" + decipher_text)

if __name__ == '__main__':
	main()
