all: Main.java PokemonData.java
	javac Main.java PokemonData.java
	java Main
	del Main.class PokemonData.class