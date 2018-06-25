shift=10

def encryption(inp):
	e=""
	for x in range(len(inp)):
		char=inp[x]
		if char==" ":
			e += char
		elif char.isupper():
			e += chr((ord(char) + shift - 65)%26 + 65)
		else:
			e += chr((ord(char) + shift - 97)%26 + 97)
	return e

def decryption(inp):
	d=""
	for x in range(len(inp)):
		char=inp[x]
		if char==" ":
			d += char
		elif char.isupper():
			d += chr((ord(char) + (26-shift) - 65)%26 + 65)
		else:
			d += chr((ord(char) + (26-shift) - 97)%26 + 97)
	return d


input_str = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"
encrypted_str = encryption(input_str)
decrypted_str = decryption(encrypted_str)


print ( "input:\t" + input_str )
print ( "encryption:\t" + encrypted_str )
print ( "decryption:\t" + decrypted_str )