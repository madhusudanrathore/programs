''' diffie hellman key exchange '''
def public_a(num1, num2, secret_a):
	pub_a = num2**secret_a % num1
	return pub_a

def public_b(num1, num2, secret_b):
	pub_b = num2**secret_b % num1
	return pub_b

def key_by_a(num1, secret_a, pub_b):
	key_a = pub_b**secret_a % num1
	return key_a

def key_by_b(num1, pub_a, secret_b):
	key_b = pub_a**secret_b % num1
	return key_b

def main():
	num1 = 353 # 1st prime number
	num2 = 7 # primitive prime with 1st prime number and num2 < num1
	secret_a = 10 # only known to a and secret_a < num1
	secret_b = 20 # only known to b and secret_b < num1

	pub_a = public_a(num1, num2, secret_a)
	pub_b = public_b(num1, num2, secret_b)
	print("PUBLIC A\t{}\nPUBLIC B\t{}".format(pub_a, pub_b))

	key_a = key_by_a(num1, secret_a, pub_b)
	key_b = key_by_b(num1, pub_a, secret_b)
	print("KEY A\t{}\nKEY B\t{}".format(key_a, key_b))

if __name__ == '__main__':
	main()