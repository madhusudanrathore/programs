input_str = "madhusudan"

window_length = len(input_str)

sbp = -1#SB pointer
lbs = 0#LB START pointer
lbe = -1#LB END pointer

def showOutput( ):
	sbMatchAt = 0
	temp1 = sbp
	temp2 = lbs
	while ( sbMatchAt <= sbp ):
		if ( input_str[temp1] == input_str[temp2] ):
			print sbMatchAt
			break
		--temp1
		++sbMatchAt

def set( pos ):
	if ( pos < window_length/2 ) :
		++lbe
	elif( pos > window_length/2 and pos < window_length ):
		++sbp
		++lbs
		++lbe
		showOutput()
	else:
		++sbp
		++lbs
		showOutput()

for pos in range( 0, ( (window_length-1) + (window_length/2) ) ):
	set( pos )