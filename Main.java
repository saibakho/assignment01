
import java.io.File;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

public class Main
{
	// global variables ===============================
	public static ArrayList<PokemonData> pokeList = new ArrayList();
	//HashMap<String, String> typeMap = new HashMap();
	// ================================================
	public static void main(String[] args) throws Exception
	{
		readFile("testData");
		mainGame();
	}
	public static void readFile(String filename) throws Exception
	{
		File file = new File(filename);
		Scanner fstream = new Scanner(file);
	//==================================================
		System.out.println("\nloading data ...\n");
		int pokeNum = fstream.nextInt();
		System.out.println(pokeNum);
		for (int i = 0; i < pokeNum; i++)
		{
			PokemonData pokeTemp = new PokemonData("", "", "");
		
			System.out.println("-----------");
			pokeTemp.name = fstream.next();
			System.out.println(pokeTemp.name);
			pokeTemp.type = fstream.next();
			System.out.println(pokeTemp.type);
			fstream.nextLine();		// buffer eating
			pokeTemp.move = fstream.nextLine();
			System.out.println(pokeTemp.move);

			pokeList.add(pokeTemp);
			//typeMap.put(pokeTemp.type, pokeTemp.name);
		}
		System.out.println("-----------");
		System.out.println(".\n.\n.\n.\n.");
	}
	public static void mainGame()
	{
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		int score = 0;
	//==================================================
		System.out.println("====================");
		System.out.println("    Game Start!!");
		System.out.println("====================\n");
		String op = "";
		//ArrayList<PokemonData> pokeCatched = new ArrayList();
		HashMap<String, ArrayList<String>> catchedMap = new HashMap();
		ArrayList<String> grassInitialList = new ArrayList();
		catchedMap.put("grass", grassInitialList);
		// dummy stuff : hashmap is one-to-one ...

		while (!op.toLowerCase().equals("quit"))
		{
			PokemonData curPokemon = pokeList.get(random.nextInt(pokeList.size()));
			System.out.println("Pokemon encountered!!");
			System.out.println("--------------------");
			System.out.println("name : " + curPokemon.name);
			System.out.println("type : " + curPokemon.type);
			System.out.println("move : " + curPokemon.move);
			System.out.print("\nEnter your reaction :\n==> ");
			op = input.next();
		//======================================================
			if (op.toLowerCase().equals("catch"))
			{
				// add to list
				//pokeCatched.add(curPokemon);
				// add to hashmap
				if ( !catchedMap.containsKey(curPokemon.type.toLowerCase()) ) {	// if typeList not exists
					ArrayList<String> tempList = new ArrayList();
					catchedMap.put(curPokemon.type.toLowerCase(), tempList);
				}
				catchedMap.get(curPokemon.type.toLowerCase()).add(curPokemon.name);
				// score stuff
				score += curPokemon.type.equals("grass") ? 1 : -1 ;
				// print
				System.out.println("You've caught a " + curPokemon.name + " !!\n");
			}
			else if (op.toLowerCase().equals("run"))
			{
				// score stuff
				score += curPokemon.type.equals("grass") ? -1 : 1 ;
				// print
				System.out.println("Run away successfully!!\n");
			}
			else if (op.toLowerCase().equals("quit"))
			{
				System.out.println("\n====================");
				System.out.println("    GAME OVER\n");
				System.out.println("score : " + score);
				System.out.println("grass : " + catchedMap.get("grass").size());
				System.out.println("====================\n");
			}
			else if (op.toLowerCase().equals("map"))
			{
				System.out.println("\n================");
				for ( String key : catchedMap.keySet() ) {
					System.out.println(key + " :");
					for ( String value : catchedMap.get(key) ) {
						System.out.println("    [" + value + "]");
					}
				}
				System.out.println("================\n");
			}
			else
			{
				System.out.println("Command not found!! The pokemon ran away!!\n");
			}
		}
	}
}