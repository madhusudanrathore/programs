import random
import sys
import os
# LISTS -------------
# A list allows you to create a list of values and manipulate them
# Each value has an index with the first one starting at 0
 
grocery_list = ['Juice', 'Tomatoes', 'Potatoes', 'Bananas']
print('The first item is', grocery_list[1])
 
# You can change the value stored in a list box
grocery_list[0] = "Green Juice"
print(grocery_list)
 
# You can get a subset of the list with [min:up to but not including max]
 
print(grocery_list[1:3])
 
# You can put any data type in a a list including a list
other_events = ['Wash Car', 'Pick up Kids', 'Cash Check']
to_do_list = [other_events, grocery_list]
 
print(to_do_list)
 
# Get the second item in the second list (Boxes inside of boxes)
print(to_do_list[1][1])
 
# You add values using append
grocery_list.append('onions')
print(to_do_list)
 
# Insert item at given index
grocery_list.insert(1, "Pickle")
 
# Remove item from list
grocery_list.remove("Pickle")
 
# Sorts items in list
grocery_list.sort()
 
# Reverse sort items in list
grocery_list.reverse()
 
# del deletes an item at specified index
del grocery_list[4]
print(to_do_list)
 
# We can combine lists with a +
to_do_list = other_events + grocery_list
print(to_do_list)
 
# Get length of list
print(len(to_do_list))
 
# Get the max item in list
print(max(to_do_list))
 
# Get the minimum item in list
print(min(to_do_list))

# TUPLES -------------
# Values in a tuple can't change like lists
 
pi_tuple = (3, 1, 4, 1, 5, 9)
 
# Convert tuple into a list
new_tuple = list(pi_tuple)
print(new_tuple)

# Convert a list into a tuple
new_list = tuple(grocery_list)
print(new_list)

# tuples also have len(tuple), min(tuple) and max(tuple)