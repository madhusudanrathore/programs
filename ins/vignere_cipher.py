key="M@d#U"
key_len=len(key)

input_str = "hellomadhusudan"
inp_len=len(input_str)

def padding(): # padding for remaining values
	temp_str=""
	temp_str+=input_str
	if inp_len%key_len != 0:
		temp=key_len-inp_len%key_len
		for i in range(temp):
			temp_str+="~"
	return temp_str

modified_input_str=padding()
modified_len=len(modified_input_str)

def encryption():
	enc_str=""
	x=0
	while x < modified_len:
		for y in range(key_len):
			shift=ord(key[y])
			char=modified_input_str[x+y]
			if char==" ":
				enc_str += char
			elif char.islower():
				enc_str += chr((ord(char)+shift-97)%26+97)
			elif char.isupper():
				dec_str += chr((ord(char)+shift-65)%26+65)
			elif char=="~":
				enc_str += '~'
		x += key_len
	return enc_str

def decryption(enc_str):
	dec_str=""
	x=0
	while x < modified_len:
		for y in range(key_len):
			shift=26-ord(key[y])
			char=enc_str[x+y]
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

encrypted_str = encryption()
decrypted_str = decryption(encrypted_str)

print ( "input:\t" + input_str )
print ( "modified input:\t" + modified_input_str )
print ( "encryption:\t" + encrypted_str )
print ( "decryption:\t" + decrypted_str )