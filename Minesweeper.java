import java.util.*;

public class Minesweeper {


	static int board[][];
<<<<<<< HEAD
	static int height = 10;
	static int width = 10;
	// static int[][] board = {{0,0,0,0},{0,0,-1,0},{0,0,-1,0},{0,-1,0,0}};
	static int number_of_mines = 15;
=======
	static int height = 16;
	static int width = 16;
	// static int[][] board = {{0,0,0,0},{0,0,-1,0},{0,0,-1,0},{0,-1,0,0}};
	static int number_of_mines = 40;
>>>>>>> Added Rules 4 and 5

	static Map<String, ArrayList<String>> unsureNodes = new HashMap<String, ArrayList<String>>();
	static Map<String, ArrayList<String>> mineNodes = new HashMap<String, ArrayList<String>>();
	static List<String> clearNodes = new ArrayList<String>();
	static Map<String, Integer> clueNodes = new HashMap<String, Integer>();
	static Set<String> mineSet = new HashSet<String>();
	static Map<String, Double> unvisited = new HashMap<String, Double>(); 
	
	public static void Rule5(){
<<<<<<< HEAD
		
=======
		Iterator it = unvisited.entrySet().iterator();
		int clue, number_of_unsure_neighbours;
		double probability;
		while(it.hasNext())
		{
			Map.Entry key_value_pair = (Map.Entry) it.next();
			String parent_node = (String) key_value_pair.getKey();
			if(clueNodes.containsKey(parent_node))
			{	
			clue = clueNodes.get(parent_node);
			number_of_unsure_neighbours = unsureNodes.get(parent_node).size();
			probability = (double)clue/ (double) number_of_unsure_neighbours;
			}
			else
			{
				probability = (double)(number_of_mines - mineSet.size())/(double)unvisited.size();
			}			
			if(unsureNodes.containsKey(parent_node))
			{
				List<String> child_nodes = unsureNodes.get(parent_node);
				for(int i = 0; i<child_nodes.size();i++)
				{
					unvisited.put(child_nodes.get(i), probability);
				}
			}
			else
			{
				unvisited.put(parent_node, probability);	
			}
		}
>>>>>>> Added Rules 4 and 5
	}

	public static void Rule4()
	{
<<<<<<< HEAD
		// Iterator it = unsureNodes.entrySet().iterator();
		// int clue_count = 0;
		// while (it.hasNext())
		// {	
		// Map.Entry key_value_pair = (Map.Entry) it.next();
		// String parent_node = (String) key_value_pair.getKey();
		// clue_count += clueNodes.get(parent_node);
		// }
		// if((number_of_mines - mineSet.size()) == clue_count)
		// {
		// 	System.out.println("Remaining mines are just "+(number_of_mines - mineSet.size()) +" and clue count is "+clue_count);
		// 	Iterator it_v = unvisited.entrySet().iterator();
		// 	while (it_v.hasNext())
		// 	{
		// 		Map.Entry key_value_pair_v = (Map.Entry) it_v.next();
		// 		String node = (String)key_value_pair_v.getKey();
		// 		clearNodes.add(node); 
		// 	}
		// }
=======
		 /*Iterator it = unsureNodes.entrySet().iterator();
		 int clue_count = 0;
		 while (it.hasNext())
		 {	
		 Map.Entry key_value_pair = (Map.Entry) it.next();
		 String parent_node = (String) key_value_pair.getKey();
		 clue_count += clueNodes.get(parent_node);
		 }
		 if((number_of_mines - mineSet.size()) == clue_count)
		 {
		 	System.out.println("Remaining mines are just "+(number_of_mines - mineSet.size()) +" and clue count is "+clue_count);
		 	Iterator it_v = unvisited.entrySet().iterator();
		 	while (it_v.hasNext())
		 	{
		 		Map.Entry key_value_pair_v = (Map.Entry) it_v.next();
		 		String node = (String)key_value_pair_v.getKey();
		 		unvisited.put(node, 0.0); 
		 	}
		 }*/
>>>>>>> Added Rules 4 and 5
	}

	public static void Rule3()
	{
		if(unsureNodes.size() <= 1)
		{
			return;
		}
		Iterator it = unsureNodes.entrySet().iterator();
		int count = 0;
		while (it.hasNext()) {
			Map.Entry key_value_pair = (Map.Entry) it.next();
			String parent_node = (String) key_value_pair.getKey();
			ArrayList<String> child_nodes = (ArrayList<String>) key_value_pair.getValue();
			Iterator it_2 = unsureNodes.entrySet().iterator();
			count++;
			for (int i=0;i<count;i++)
			{
				it_2.next();
			}
		//	System.out.println("Comparing for "+parent_node);
			while(it_2.hasNext())
			{
				Map.Entry key_value_pair_2 = (Map.Entry) it_2.next();
				String parent_node_2 = (String) key_value_pair_2.getKey();
				ArrayList<String> child_nodes_2 = (ArrayList<String>) key_value_pair_2.getValue();
<<<<<<< HEAD
				System.out.println(" with "+parent_node_2);
				System.out.println("Comparing "+child_nodes+"with "+child_nodes_2);
=======
			//	System.out.println(" with "+parent_node_2);
			//	System.out.println("Comparing "+child_nodes+"with "+child_nodes_2);
>>>>>>> Added Rules 4 and 5
				if(child_nodes.size() >= child_nodes_2.size())
				{
					if(child_nodes.containsAll(child_nodes_2))
					{
						
						for (int k =0; k < child_nodes.size();k++)
						{
							if(child_nodes_2.contains(child_nodes.get(k)))
									{
										System.out.println("Deleting "+child_nodes.get(k));
										child_nodes.remove(k);
										k--;
									}
						}
						unsureNodes.put(parent_node, child_nodes);
						int new_clue = Math.abs(clueNodes.get(parent_node)-clueNodes.get(parent_node_2));
						System.out.println("Parent node clue: "+clueNodes.get(parent_node)+" Parent Node 2 clue: "+clueNodes.get(parent_node_2)+" New Clue: "+new_clue);
						clueNodes.put(parent_node,new_clue);
						// markAsMine();
						// makeUnsureSure();
						// Rule2();
						
					}
				}
				else
				{
					if(child_nodes_2.containsAll(child_nodes))
					{
						
						for (int k =0; k < child_nodes_2.size();k++)
						{
							if(child_nodes.contains(child_nodes_2.get(k)))
									{
										System.out.println("Deleting "+child_nodes_2.get(k));
										child_nodes_2.remove(k);
										k--;
									}
						}
						unsureNodes.put(parent_node_2, child_nodes_2);
						int new_clue = Math.abs(clueNodes.get(parent_node_2)-clueNodes.get(parent_node));
						System.out.println("Parent node clue: "+clueNodes.get(parent_node)+" Parent Node 2 clue: "+clueNodes.get(parent_node_2)+" New Clue: "+new_clue);
						clueNodes.put(parent_node_2,new_clue);
						// markAsMine();
						// makeUnsureSure();
						// Rule2();
						
					}
				}
				
			}
			// markAsMine();
			// makeUnsureSure();
			// Rule2();
		}
	}

	public static int getMineNumber(int i, int j){
		int count = 0;
		if (i - 1 > -1 && j - 1 > -1) {
			if (board[i - 1][j - 1] == -1)
				count++;
		}

		if (i - 1 > -1){
			if (board[i - 1][j] == -1)
				count++;
		}
		if (i - 1 > -1 && j + 1 < width){
			if (board[i - 1][j + 1] == -1)
				count++;
		}
		if (j - 1 > -1){
			if (board[i][j - 1] == -1)
				count++;
		}

		if (j + 1 < width){
			if (board[i][j + 1] == -1)
				count++;
		}

		if (i + 1 < height && j - 1 > -1) {
			if (board[i + 1][j - 1] == -1)
				count++;
		}

		if (i + 1 < height){
			if (board[i + 1][j] == -1)
				count++;
		}

		if (i + 1 < height && j + 1 < width){
			if (board[i + 1][j + 1] == -1)
				count++;
		}
		return count;
	}

	static void markAsMine(){
		Iterator it = unsureNodes.entrySet().iterator();
		List<String> list_of_parents = new ArrayList<String>();
		while (it.hasNext()) {
			Map.Entry key_value_pair = (Map.Entry) it.next();
			String parent_node = (String) key_value_pair.getKey();
			ArrayList<String> child_nodes = (ArrayList<String>) key_value_pair.getValue();
			if (clueNodes.get(parent_node) == child_nodes.size()) {
				if(child_nodes.size()>0) 
				{	
				mineNodes.put(parent_node, child_nodes);
				for(int i = 0; i < child_nodes.size();i++)
				{
					mineSet.add(child_nodes.get(i));
				}
				list_of_parents.add(parent_node);
				}
			}
		}
		for (int i = 0; i < list_of_parents.size(); i++) {
			unsureNodes.remove(list_of_parents.get(i));
		}
		
	}

	static void makeUnsureSure(){
		Iterator it = unsureNodes.entrySet().iterator();
		List<String> parent_node_list = new ArrayList<String>(); 
		while (it.hasNext()) {
			Map.Entry key_value_pair = (Map.Entry) it.next();
			String parent_node = (String) key_value_pair.getKey();
			ArrayList<String> child_nodes = (ArrayList<String>) key_value_pair.getValue();
			for (int i = 0; i < child_nodes.size(); i++) {
				if (clearNodes.contains(child_nodes.get(i)) || clueNodes.containsKey(child_nodes.get(i))) {
					child_nodes.remove(i);
					i--;
				}				
			}
			if (child_nodes.size() > 0) {
				unsureNodes.put(parent_node, child_nodes);
			}
			else
			{
				parent_node_list.add(parent_node);
			}
		}
		for(int i = 0; i<parent_node_list.size();i++)
		{
			unsureNodes.remove(parent_node_list.get(i));
		}
	}

	static void populateClue(int i, int j){
		String node = i + "," + j;
		clueNodes.put(node, getMineNumber(i, j));
	}

	public static void populateClearNodes(int i, int j){
		String neighbour_node = "";
		if (i - 1 > -1 && j - 1 > -1) {
			neighbour_node = (i - 1) + "," + (j - 1);
			if (!clearNodes.contains(neighbour_node))
				clearNodes.add(neighbour_node);
		}

		if (i - 1 > -1){
			neighbour_node = (i - 1) + "," + (j);
			if (!clearNodes.contains(neighbour_node))
				clearNodes.add(neighbour_node);
		}
		if (i - 1 > -1 && j + 1 < width){
			neighbour_node = (i - 1) + "," + (j + 1);
			if (!clearNodes.contains(neighbour_node))
				clearNodes.add(neighbour_node);
		}
		if (j - 1 > -1){
			neighbour_node = (i) + "," + (j - 1);
			if (!clearNodes.contains(neighbour_node))
				clearNodes.add(neighbour_node);
		}

		if (j + 1 < width){
			neighbour_node = (i) + "," + (j + 1);
			if (!clearNodes.contains(neighbour_node))
				clearNodes.add(neighbour_node);
		}

		if (i + 1 < height && j - 1 > -1){
			neighbour_node = (i + 1) + "," + (j - 1);
			if (!clearNodes.contains(neighbour_node))
				clearNodes.add(neighbour_node);
		}

		if (i + 1 < height){
			neighbour_node = (i + 1) + "," + (j);
			if (!clearNodes.contains(neighbour_node))
				clearNodes.add(neighbour_node);
		}

		if (i + 1 < height && j + 1 < width){
			neighbour_node = (i + 1) + "," + (j + 1);
			if (!clearNodes.contains(neighbour_node))
				clearNodes.add(neighbour_node);
		}
	}

	public static void populateUnsureNodes(int i, int j){
		String node = i + "," + j;
		String neighbour_node = "";
		int flag = 0;
		if (i - 1 > -1 && j - 1 > -1){
			neighbour_node = (i - 1) + "," + (j - 1);
			if (unsureNodes.containsKey(node)){
				unsureNodes.get(node).add(neighbour_node);
			} 
			else{
				ArrayList<String> new_node_list = new ArrayList<String>();
				new_node_list.add(neighbour_node);
				unsureNodes.put(node, new_node_list);
			}	
<<<<<<< HEAD
			unvisited.remove(neighbour_node);
=======
			//unvisited.remove(neighbour_node);
>>>>>>> Added Rules 4 and 5
		}

		if (i - 1 > -1){			
			neighbour_node = (i - 1) + "," + (j);
			if (unsureNodes.containsKey(node)) {
				unsureNodes.get(node).add(neighbour_node);
			} 
			else{
				ArrayList<String> new_node_list = new ArrayList<String>();
				new_node_list.add(neighbour_node);
				unsureNodes.put(node, new_node_list);
			}
<<<<<<< HEAD
			unvisited.remove(neighbour_node);
=======
//			unvisited.remove(neighbour_node);
>>>>>>> Added Rules 4 and 5
		}
		if (i - 1 > -1 && j + 1 < width){
			neighbour_node = (i - 1) + "," + (j + 1);
			if (unsureNodes.containsKey(node)) {
				unsureNodes.get(node).add(neighbour_node);
			}
			else{
				ArrayList<String> new_node_list = new ArrayList<String>();
				new_node_list.add(neighbour_node);
				unsureNodes.put(node, new_node_list);
			}
<<<<<<< HEAD
			unvisited.remove(neighbour_node);
=======
//			unvisited.remove(neighbour_node);
>>>>>>> Added Rules 4 and 5
		}
		if (j - 1 > -1){
			neighbour_node = (i) + "," + (j - 1);
			if (unsureNodes.containsKey(node)){
				unsureNodes.get(node).add(neighbour_node);
			}
			else{
				ArrayList<String> new_node_list = new ArrayList<String>();
				new_node_list.add(neighbour_node);
				unsureNodes.put(node, new_node_list);
			}
<<<<<<< HEAD
			unvisited.remove(neighbour_node);
=======
//			unvisited.remove(neighbour_node);
>>>>>>> Added Rules 4 and 5
		}

		if (j + 1 < width){
			neighbour_node = (i) + "," + (j + 1);
			if (unsureNodes.containsKey(node)) {
				unsureNodes.get(node).add(neighbour_node);
			}
			else{
				ArrayList<String> new_node_list = new ArrayList<String>();
				new_node_list.add(neighbour_node);
				unsureNodes.put(node, new_node_list);
			}
<<<<<<< HEAD
			unvisited.remove(neighbour_node);
=======
//			unvisited.remove(neighbour_node);
>>>>>>> Added Rules 4 and 5
		}

		if (i + 1 < height && j - 1 > -1) {
			neighbour_node = (i + 1) + "," + (j - 1);
			if (unsureNodes.containsKey(node)) {
				unsureNodes.get(node).add(neighbour_node);
			} else {
				ArrayList<String> new_node_list = new ArrayList<String>();
				new_node_list.add(neighbour_node);
				unsureNodes.put(node, new_node_list);
			}
<<<<<<< HEAD
			unvisited.remove(neighbour_node);
=======
//			unvisited.remove(neighbour_node);
>>>>>>> Added Rules 4 and 5
		}

		if (i + 1 < height) {
			neighbour_node = (i + 1) + "," + (j);
			if (unsureNodes.containsKey(node)) {
				unsureNodes.get(node).add(neighbour_node);
			} else {
				ArrayList<String> new_node_list = new ArrayList<String>();
				new_node_list.add(neighbour_node);
				unsureNodes.put(node, new_node_list);
			}
<<<<<<< HEAD
			unvisited.remove(neighbour_node);
=======
//			unvisited.remove(neighbour_node);
>>>>>>> Added Rules 4 and 5
		}

		if (i + 1 < height && j + 1 < width) {
			neighbour_node = (i + 1) + "," + (j+1);
			if (unsureNodes.containsKey(node)) {
				unsureNodes.get(node).add(neighbour_node);
			} else {
				ArrayList<String> new_node_list = new ArrayList<String>();
				new_node_list.add(neighbour_node);
				unsureNodes.put(node, new_node_list);
			}
<<<<<<< HEAD
			unvisited.remove(neighbour_node);
=======
//			unvisited.remove(neighbour_node);
>>>>>>> Added Rules 4 and 5
		}
	}

	public static void Rule2() {
		Iterator it = clueNodes.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry key_value_pair = (Map.Entry) it.next();
			String node = (String) key_value_pair.getKey();
			int clue = (Integer) key_value_pair.getValue();
			int i = Integer.parseInt(node.split(",")[0]);
			int j = Integer.parseInt(node.split(",")[1]);
			String neighbour_node = "";
			int mine_count = 0;
			if (i - 1 > -1 && j - 1 > -1) {
				neighbour_node = (i - 1) + "," + (j - 1);
				if (mineSet.contains(neighbour_node))
					mine_count++;
			}

			if (i - 1 > -1) {
				neighbour_node = (i - 1) + "," + (j);
				if (mineSet.contains(neighbour_node))
					mine_count++;
			}
			if (i - 1 > -1 && j + 1 < width) {
				neighbour_node = (i - 1) + "," + (j + 1);
				if (mineSet.contains(neighbour_node))
					mine_count++;
			}
			if (j - 1 > -1) {
				neighbour_node = (i) + "," + (j - 1);
				if (mineSet.contains(neighbour_node))
					mine_count++;
			}

			if (j + 1 < width) {
				neighbour_node = (i) + "," + (j + 1);
				if (mineSet.contains(neighbour_node))
					mine_count++;
			}

			if (i + 1 < height && j - 1 > -1) {
				neighbour_node = (i + 1) + "," + (j - 1);
				if (mineSet.contains(neighbour_node))
					mine_count++;
			}

			if (i + 1 < height) {
				neighbour_node = (i + 1) + "," + (j);
				if (mineSet.contains(neighbour_node))
					mine_count++;
			}

			if (i + 1 < height && j + 1 < width) {
				neighbour_node = (i + 1) + "," + (j + 1);
				if (mineSet.contains(neighbour_node))
					mine_count++;
			}
			if(mine_count == clue){
				List<String> clear_nodes = unsureNodes.get(node);
				if(clear_nodes!=null){
					for(int k=0;k<clear_nodes.size();k++){
						if(!mineSet.contains(clear_nodes.get(k))){
							clearNodes.add(clear_nodes.get(k));
						}
					}
					unsureNodes.remove(node);
				}
			}
		}
	}

	static int[][] generateBoard(int height, int width, int number_of_mines) {
		board = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				board[i][j] = 0;
			}
		}
		Random rand = new Random();
		while (number_of_mines > 0) {
			int h_index = rand.nextInt(height);
			int w_index = rand.nextInt(width);
			if (board[h_index][w_index] != -1 && !(h_index < 2 && w_index < 2)) {
				board[h_index][w_index] = -1;
				number_of_mines--;
			}
		}
		return board;
	}

	static void displayBoard(int board[][], int height, int width) {

		System.out.print("  ");
		System.out.println("\n");
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print("\t" + board[i][j]);
			}
			System.out.println("\n");
		}
	}

	public static void main(String args[]) {

		board = generateBoard(height, width, number_of_mines);

		for(int i=0;i<height;i++){
			for(int j=0;j<width;j++){
				unvisited.put(i+","+j,0.0);
			}
		}

		displayBoard(board, height, width);

		clueNodes.put("0,0", getMineNumber(0, 0));
		unvisited.remove("0,0");

		if (getMineNumber(0, 0) == 0) {
			populateClearNodes(0, 0);
		} else {
			populateUnsureNodes(0, 0);
		}
		System.out.println(
				"Clear node has: " + clearNodes.size() + "; Unsure node has: " + unsureNodes.size() + " nodes");
		Rule3();
		markAsMine();
		makeUnsureSure();
		Rule2();
		Rule4();
<<<<<<< HEAD
=======
		Rule5();
>>>>>>> Added Rules 4 and 5
		System.out.println(
				"Clear node has - " + clearNodes.size() + "; Unsure node has - " + unsureNodes.size() + " nodes");

		while (mineSet.size() < number_of_mines) {
			if (!clearNodes.isEmpty()) {
				String current_node = clearNodes.get(0);
				if(clueNodes.containsKey(current_node) || mineSet.contains(current_node))
				{
					clearNodes.remove(0);
					System.out.println("Repeat "+current_node);
					continue;
				}
				System.out.println("Clear node - " + current_node);
				int i = Integer.parseInt(current_node.split(",")[0]);
				int j = Integer.parseInt(current_node.split(",")[1]);
				int number_of_nearby_mines = getMineNumber(i, j);
				System.out.println("Next nearby mines - " + number_of_nearby_mines);
				clueNodes.put(current_node, number_of_nearby_mines);
				unvisited.remove(current_node);
				if (number_of_nearby_mines == 0) {
					populateClearNodes(i, j);
				} else {
					populateUnsureNodes(i, j);
				}
				Rule3();
				markAsMine();
				makeUnsureSure();
				Rule2();
				Rule4();
<<<<<<< HEAD
=======
				Rule5();
>>>>>>> Added Rules 4 and 5
				clearNodes.remove(0);
				System.out.println("Clear node has - " + clearNodes.size() + "; Unsure node has - " + unsureNodes.size()
						+ " nodes");
				Iterator it_un = unsureNodes.entrySet().iterator();
				for (int a =0; a< clearNodes.size(); a++)
				{
					System.out.println(" Clear nodes are - "+ clearNodes.get(a));
				}
				while (it_un.hasNext()) {
					Map.Entry key_value_pair_un = (Map.Entry) it_un.next();
					String parent_node_un = (String) key_value_pair_un.getKey();
					List<String> child_nodes_un = (ArrayList<String>) key_value_pair_un.getValue();
					for (int q = 0; q < child_nodes_un.size(); q++) {
						System.out.println(
								"Unsure nodes- " + child_nodes_un.get(q) + " and the parent is " + parent_node_un);
					}
				}
<<<<<<< HEAD
			} else if(!unsureNodes.isEmpty()){
				// Rule3();
				// markAsMine();
				// makeUnsureSure();
				// Rule2();
				System.out.println("Querying unsure nodes");
				Iterator it = unsureNodes.entrySet().iterator();
=======
			} else {
				System.out.println("Querying non clear nodes");
				Iterator it = unvisited.entrySet().iterator();
>>>>>>> Added Rules 4 and 5
				Map.Entry key_value_pair = (Map.Entry) it.next();
				double min_probability = (Double) key_value_pair.getValue();
				double max_probability = (Double) key_value_pair.getValue();
				String current_node = (String) key_value_pair.getKey();
				while(it.hasNext())
				{
					key_value_pair = (Map.Entry) it.next();
					String parent_node = (String) key_value_pair.getKey();
					if( (Double) key_value_pair.getValue() < min_probability)
					{	
						min_probability = (Double) key_value_pair.getValue();
						current_node = parent_node;
					}
<<<<<<< HEAD
					else
					{
						unsureNodes.put(parent_node, child_nodes);
=======
					if( (Double) key_value_pair.getValue() > max_probability)
					{	
						max_probability = (Double) key_value_pair.getValue();
						current_node = parent_node;
>>>>>>> Added Rules 4 and 5
					}
				}		
				System.out.println("Max probability "+max_probability);
				System.out.println("Unsure node - " + current_node + " probability "+min_probability);
				int i = Integer.parseInt(current_node.split(",")[0]);
				int j = Integer.parseInt(current_node.split(",")[1]);
				if (board[i][j] == -1) {
					System.out.println("Number of mines uncovered : "+mineSet.size());
					System.out.println("Game over!!");
					return;
				} else {
					int number_of_nearby_mines = getMineNumber(i, j);
					clueNodes.put(current_node, number_of_nearby_mines);
					unvisited.remove(current_node);
					if (number_of_nearby_mines == 0) {
						populateClearNodes(Integer.parseInt(current_node.split(",")[0]),
								Integer.parseInt(current_node.split(",")[1]));
					} else {
						populateUnsureNodes(Integer.parseInt(current_node.split(",")[0]),
								Integer.parseInt(current_node.split(",")[1]));
					}
					Rule3();
					markAsMine();
					makeUnsureSure();
					Rule2();
					Rule4();
<<<<<<< HEAD
					if(child_nodes.size()!=0){
						child_nodes.remove(0);
					}
					if(child_nodes.isEmpty())
					{
						unsureNodes.remove(parent_node);
					}
					else
					{
						unsureNodes.put(parent_node, child_nodes);
					}
=======
					Rule5();					
>>>>>>> Added Rules 4 and 5
					System.out.println("Clear node has - " + clearNodes.size() + "; Unsure node has - "
							+ unsureNodes.size() + " nodes");
					Iterator it_un = unsureNodes.entrySet().iterator();
					for (int a =0; a< clearNodes.size(); a++)
					{
						System.out.println(" Clear nodes are - "+ clearNodes.get(a));
					}
					while (it_un.hasNext()) {
						Map.Entry key_value_pair_un = (Map.Entry) it_un.next();
						String parent_node_un = (String) key_value_pair_un.getKey();
						List<String> child_nodes_un = (ArrayList<String>) key_value_pair_un.getValue();
						for (int q = 0; q < child_nodes_un.size(); q++) {
							System.out.println(
									"Unsure nodes- " + child_nodes_un.get(q) + " and the parent is " + parent_node_un);
						}
					}
				}
			}
<<<<<<< HEAD
			
			else
			{
				
				// Random rand = new Random();
				// int row = rand.nextInt(height);
			    // int column = rand.nextInt(width);
			    Iterator it = unvisited.entrySet().iterator();
			    if(!it.hasNext())
			    {
			    	System.out.println("I don't know what to do! No more nodes to visit!! Unvisited: "+unvisited.size());
			    	return;
			    }
				Map.Entry key_value_pair = (Map.Entry) it.next();
				String current_node = (String) key_value_pair.getKey();
				// while(clueNodes.containsKey(current_node) || mineSet.contains(current_node))
				// {
				// 	row = rand.nextInt(height);
				//     column = rand.nextInt(width);
				// 	current_node = row+","+column;
				// }
				System.out.println("Clear node - " + current_node);
				int i = Integer.parseInt(current_node.split(",")[0]);
				int j = Integer.parseInt(current_node.split(",")[1]);
				unvisited.remove(current_node);
				int number_of_nearby_mines = getMineNumber(i, j);
				System.out.println("Next nearby mines - " + number_of_nearby_mines);
				clueNodes.put(current_node, number_of_nearby_mines);
				unvisited.remove(current_node);
				if (number_of_nearby_mines == 0) {
					populateClearNodes(i, j);
				} else {
					populateUnsureNodes(i, j);
				}
				Rule3();
				markAsMine();
				makeUnsureSure();
				Rule2();
				Rule4();
				System.out.println("Clear node has - " + clearNodes.size() + "; Unsure node has - " + unsureNodes.size()
						+ " nodes");
				Iterator it_un = unsureNodes.entrySet().iterator();
				for (int a =0; a< clearNodes.size(); a++)
				{
					System.out.println(" Clear nodes are - "+ clearNodes.get(a));
				}
				while (it_un.hasNext()) {
					Map.Entry key_value_pair_un = (Map.Entry) it_un.next();
					String parent_node_un = (String) key_value_pair_un.getKey();
					List<String> child_nodes_un = (ArrayList<String>) key_value_pair_un.getValue();
					for (int q = 0; q < child_nodes_un.size(); q++) {
						System.out.println(
								"Unsure nodes- " + child_nodes_un.get(q) + " and the parent is " + parent_node_un);
					}
				}
			}
=======
>>>>>>> Added Rules 4 and 5
		}
		System.out.println("All mines found!");

		Iterator it = mineNodes.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry key_value_pair = (Map.Entry) it.next();
			String parent_node = (String) key_value_pair.getKey();
			List<String> child_nodes = (ArrayList<String>) key_value_pair.getValue();
			for (int i = 0; i < child_nodes.size(); i++) {
				System.out.println("Mine is in " + child_nodes.get(i) + " and the parent is " + parent_node);
			}
		}
		System.out.println(mineSet.toString());
	}
}