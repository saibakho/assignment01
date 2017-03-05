Software Studio 2017 Spring Assignment01

104020002 Ming-Yeh Chou

1. Program Running Method : makefile (with Path of "java" and "javac" in Environment Variables)

2. Program Structure :
	Two parts.
	The first one is to read the "testData " file to load Pokenmon datas.
	And the second one is comoposed of a while loop :
		a Random class for having a random Pokemon, an "op" string to fetch the commands,
		and after it, we have a group of if-else for the reactions the program shoud have.

3. The Storing DataTypes :
	An ArrayList<PokemonData> to store the Pokemon datas we load from the "testData" file,
	that is , the pokedex library.

		ArrayList<PokemonData>
				  /			\
				name, type, move

	A HashMap<String, ArrayList<String>> to store the Pokemons we caught.

		HashMap<String, ArrayList<String>>
				/	 \		/	 \
				 type	Array of pokemon names

		HashMap : 

			type 1		name 1
						name 2
						name 3
						  :
						  :
						name n

			type 2		name 1
						name 2
						name 3
						  :
						  :
						name n

			type 3
			  :
			  :
			type n

4. Problems Encountered :
	There are the two main problems I met in this assignment.

	First, I found it hard to read a file in Java because I'm not familiar with the exception throw stuff.
	It's more complicated in Java than in C/C++, I thought. QQ

	Then, ...
	I used to regard HashMap/Map is a one-to-many mapping datatype, but I was wrong.
	(we can't even call it a mapping)
	Thus, to get to this "tree" kind of structure, I mapped every "type" string to an ArrayList.
	By doing so, we can easily get the value size of every key.