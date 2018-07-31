import random

def transposeMatrix(m):
    return map(list,zip(*m))

def getMatrixMinor(m,i,j):
    return [row[:j] + row[j+1:] for row in (m[:i]+m[i+1:])]

def getMatrixDeternminant(m):
    #base case for 2x2 matrix
    if len(m) == 2:
        return m[0][0]*m[1][1]-m[0][1]*m[1][0]

    determinant = 0
    for c in range(len(m)):
        determinant += ((-1)**c)*m[0][c]*getMatrixDeternminant(getMatrixMinor(m,0,c))
    return determinant

def getMatrixInverse(m):
    determinant = getMatrixDeternminant(m)
    #special case for 2x2 matrix:
    if len(m) == 2:
        return [[m[1][1]/determinant, -1*m[0][1]/determinant],
                [-1*m[1][0]/determinant, m[0][0]/determinant]]

    #find matrix of cofactors
    cofactors = []
    for r in range(len(m)):
        cofactorRow = []
        for c in range(len(m)):
            minor = getMatrixMinor(m,r,c)
            cofactorRow.append(((-1)**(r+c)) * getMatrixDeternminant(minor))
        cofactors.append(cofactorRow)
    cofactors = transposeMatrix(cofactors)
    for r in range(len(cofactors)):
        for c in range(len(cofactors)):
            cofactors[r][c] = cofactors[r][c]/determinant
    return cofactors

def matrix_multiplication(mat1, mat2):
	result = [[0 for i in range(1)] for j in range(len(mat1))]

	for i in range(len(mat1)):
		for j in range(len(mat2[0])):
			for k in range(len(mat2)):
				result[i][j] += mat1[i][k] * mat2[k][j]

	return result

def inverse_matrix(mat):
	mat_inverse = [[0 for i in range(len(mat))] for j in range(len(mat))]
	
	mat_inverse = getMatrixInverse(mat)
	
	return mat_inverse

def prepare_key(length):
	random.seed(1) # same random values generated each time
	temp_vec = [[0 for x in xrange(length)] for y in xrange(length)] # n*n vector
	
	for x in xrange(length):
		for y in xrange(length):
			temp = random.randint(0,25)
			temp_vec[x][y] = temp
	
	return temp_vec

def prepare_all_plain_text_entities(plain_text, key_len):
	final_plain_text = ""
	final_plain_text += plain_text
	plain_text_len = len(plain_text)

	if plain_text_len%key_len != 0: # apply padding
		temp = key_len-plain_text_len%key_len
		for x in range( temp ):
			final_plain_text += "~"

	final_plain_text_len = len(final_plain_text) # final input length
	plain_text_vector =  [[0 for i in range(1)] for j in range(final_plain_text_len)]

	for x in xrange(final_plain_text_len): # prepare plaintext vector
		char = final_plain_text[x]
		plain_text_vector[x][0] = ord(char)

	return plain_text_vector, final_plain_text

def encryption(plain_text_vector, key_vector):
	cipher_text = ""
	final_plain_text_len = len(plain_text_vector)
	cipher_text_vector = [[0 for i in range(1)] for j in range(final_plain_text_len)]
	key_len = len(key_vector)

	x = 0
	while x < final_plain_text_len:
		temp_plain_text_vector = [[0 for i in range(1)] for j in range(key_len)]
		temp_cipher_text_vector = [[0 for i in range(1)] for j in range(key_len)]

		for y in xrange(key_len): # get part of plain text to be encrypted
			temp_plain_text_vector[y][0] = plain_text_vector[x+y][0]

		# multiplication of KEY VECTOR with temporary PLAIN TEXT, C = K*P
		temp_cipher_text_vector = matrix_multiplication(key_vector, temp_plain_text_vector)

		# append to final cipher vector
		for i in xrange(key_len):
			cipher_text_vector[x+i][0] = temp_cipher_text_vector[i][0]%97
			cipher_text += chr(temp_cipher_text_vector[0][0]%97)

		x = x+key_len

	return cipher_text_vector, cipher_text

def decryption(cipher_text_vector, key_vector):
	decipher_text = ""
	cipher_text_vector_len = len(cipher_text_vector)
	decipher_text_vector = [[0 for i in range(1)] for j in range(cipher_text_vector_len)]
	key_len = len(key_vector)
	inverse_key_vector = [[0 for i in range(key_len)] for j in range(key_len)]
	inverse_key_vector = inverse_matrix(key_vector)

	x = 0
	while x < cipher_text_vector_len:
		temp_cipher_text_vector = [[0 for i in range(1)] for j in range(key_len)]
		temp_cipher_text_vector = [[0 for i in range(1)] for j in range(key_len)]

		for y in xrange(key_len): # get part of plain text to be encrypted
			temp_cipher_text_vector[y][0] = cipher_text_vector[x+y][0]

		# multiplication of INVERSE KEY VECTOR with temporary CIPHER TEXT, D = K^-1*C
		temp_cipher_text_vector = matrix_multiplication(inverse_key_vector, temp_cipher_text_vector)

		# append to final decipher vector
		for i in xrange(key_len):
			decipher_text_vector[x+i][0] = temp_cipher_text_vector[i][0]%97
			decipher_text += chr(temp_cipher_text_vector[0][0]%97)

		x = x+key_len

	return decipher_text_vector, decipher_text

def main():
	key_len = 4
	plain_text = "hellomadhusudanrathore"
	cipher_text = []
	decipher_text = []

	key_vector = []
	plain_text_vector = []
	cipher_text_vector=[]
	decipher_text_vector=[]
	
	key_vector = prepare_key(key_len)
	print(key_vector)
	plain_text_vector, final_plain_text = prepare_all_plain_text_entities(plain_text, key_len)
	cipher_text_vector, cipher_text = encryption(plain_text_vector, key_vector)
	print(cipher_text_vector)
	deciphered_str, decipher_text = decryption(cipher_text_vector, key_vector)


	print("PLAIN TEXT:\t" + plain_text)
	print ("FINAL PLAIN TEXT:\t" + final_plain_text)
	print("CIPHER TEXT:\t" + cipher_text)
	print("DECIPHER TEXT:\t" + decipher_text)

if __name__ == '__main__':
	main()
