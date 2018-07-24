shift=10

def encryption(inp):
	e=""
	for x in range(len(inp)):
		char=inp[x]
		if char==" ":
			e += char
		elif char.isupper():
			e += chr((ord(char)+shift-65)%26+65)
		elif char.islower():
			e += chr((ord(char)+shift-97)%26+97)
		else: # for numbers and special characters
			e += chr((ord(char)+shift*10)%256)
	return e

def decryption(inp):
	d=""
	for x in range(len(inp)):
		char=inp[x]
		if char==" ":
			d += char
		elif char.isupper():
			d += chr((ord(char)+(26-shift)-65)%26+65) # using cyclic property for decryption
		elif char.islower():
			d += chr((ord(char)+(26-shift)-97)%26+97)
		else:
			d += chr((ord(char)+(256-shift*10))%256)
	return d

input_str = "hello STUDENT 0123456789 !$%&*()-+/*.,'`~#}{<>[]}{"
encrypted_str = encryption(input_str)
decrypted_str = decryption(encrypted_str)

print ( "input:\t" + input_str )
print ( "encryption:\t" + encrypted_str )
print ( "decryption:\t" + decrypted_str )
