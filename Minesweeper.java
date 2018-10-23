import java.util.*;

public class Minesweeper {

	static int[][] board;
	static int height = 5;
	static int width = 5;
	static int number_of_mines = 1;

	static Map<String, ArrayList<String>> unsureNodes = new HashMap<String, ArrayList<String>>();
	static Map<String, ArrayList<String>> mineNodes = new HashMap<String, ArrayList<String>>();
	static List<String> clearNodes = new ArrayList<String>();
	static Map<String, Integer> clueNodes = new HashMap<String, Integer>();
	static Set<String> mineSet = new HashSet<String>();

	public static int getMineNumber(int i, int j) {
		int count = 0;
		if (i - 1 > -1 && j - 1 > -1) {
			if (board[i - 1][j - 1] == -1)
				count++;
		}

		if (i - 1 > -1) {
			if (board[i - 1][j] == -1)
				count++;
		}
		if (i - 1 > -1 && j + 1 < width) {
			if (board[i - 1][j + 1] == -1)
				count++;
		}
		if (j - 1 > -1) {
			if (board[i][j - 1] == -1)
				count++;
		}

		if (j + 1 < width) {
			if (board[i][j + 1] == -1)
				count++;
		}

		if (i + 1 < height && j - 1 > -1) {
			if (board[i + 1][j - 1] == -1)
				count++;
		}

		if (i + 1 < height) {
			if (board[i + 1][j] == -1)
				count++;
		}

		if (i + 1 < height && j + 1 < width) {
			if (board[i + 1][j + 1] == -1)
				count++;
		}
		return count;
	}

	static void markAsMine() {
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

	static void makeUnsureSure() {
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

	static void populateClue(int i, int j) {
		String node = i + "," + j;
		clueNodes.put(node, getMineNumber(i, j));
	}

	public static void populateClearNodes(int i, int j) {
		String neighbour_node = "";
		if (i - 1 > -1 && j - 1 > -1) {
			neighbour_node = (i - 1) + "," + (j - 1);
			if (!clearNodes.contains(neighbour_node))
				clearNodes.add(neighbour_node);
		}

		if (i - 1 > -1) {
			neighbour_node = (i - 1) + "," + (j);
			if (!clearNodes.contains(neighbour_node))
				clearNodes.add(neighbour_node);
		}
		if (i - 1 > -1 && j + 1 < width) {
			neighbour_node = (i - 1) + "," + (j + 1);
			if (!clearNodes.contains(neighbour_node))
				clearNodes.add(neighbour_node);
		}
		if (j - 1 > -1) {
			neighbour_node = (i) + "," + (j - 1);
			if (!clearNodes.contains(neighbour_node))
				clearNodes.add(neighbour_node);
		}

		if (j + 1 < width) {
			neighbour_node = (i) + "," + (j + 1);
			if (!clearNodes.contains(neighbour_node))
				clearNodes.add(neighbour_node);
		}

		if (i + 1 < height && j - 1 > -1) {
			neighbour_node = (i + 1) + "," + (j - 1);
			if (!clearNodes.contains(neighbour_node))
				clearNodes.add(neighbour_node);
		}

		if (i + 1 < height) {
			neighbour_node = (i + 1) + "," + (j);
			if (!clearNodes.contains(neighbour_node))
				clearNodes.add(neighbour_node);
		}

		if (i + 1 < height && j + 1 < width) {
			neighbour_node = (i + 1) + "," + (j + 1);
			if (!clearNodes.contains(neighbour_node))
				clearNodes.add(neighbour_node);
		}
	}

	public static void populateUnsureNodes(int i, int j) {
		String node = i + "," + j;
		String neighbour_node = "";
		int flag = 0;
		if (i - 1 > -1 && j - 1 > -1) {
			neighbour_node = (i - 1) + "," + (j - 1);
			if (unsureNodes.containsKey(node)) {
				unsureNodes.get(node).add(neighbour_node);
			} else {
				ArrayList<String> new_node_list = new ArrayList<String>();
				new_node_list.add(neighbour_node);
				unsureNodes.put(node, new_node_list);
			}
			
		}

		if (i - 1 > -1) {			
			neighbour_node = (i - 1) + "," + (j);
			if (unsureNodes.containsKey(node)) {
				unsureNodes.get(node).add(neighbour_node);
			} else {
				ArrayList<String> new_node_list = new ArrayList<String>();
				new_node_list.add(neighbour_node);
				unsureNodes.put(node, new_node_list);
			}
		}
		if (i - 1 > -1 && j + 1 < width) {
			neighbour_node = (i - 1) + "," + (j + 1);
			if (unsureNodes.containsKey(node)) {
				unsureNodes.get(node).add(neighbour_node);
			} else {
				ArrayList<String> new_node_list = new ArrayList<String>();
				new_node_list.add(neighbour_node);
				unsureNodes.put(node, new_node_list);
			}
		}
		if (j - 1 > -1) {
			neighbour_node = (i) + "," + (j - 1);
			if (unsureNodes.containsKey(node)) {
				unsureNodes.get(node).add(neighbour_node);
			} else {
				ArrayList<String> new_node_list = new ArrayList<String>();
				new_node_list.add(neighbour_node);
				unsureNodes.put(node, new_node_list);
			}
		}

		if (j + 1 < width) {
			neighbour_node = (i) + "," + (j + 1);
			if (unsureNodes.containsKey(node)) {
				unsureNodes.get(node).add(neighbour_node);
			} else {
				ArrayList<String> new_node_list = new ArrayList<String>();
				new_node_list.add(neighbour_node);
				unsureNodes.put(node, new_node_list);
			}
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
			if (board[h_index][w_index] != -1) {
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

		int[][] board = generateBoard(height, width, number_of_mines);
		displayBoard(board, height, width);

		clueNodes.put("0,0", getMineNumber(0, 0));

		if (getMineNumber(0, 0) == 0) {
			populateClearNodes(0, 0);
		} else {
			populateUnsureNodes(0, 0);
		}
		System.out.println(
				"Clear node has - " + clearNodes.size() + "; Unsure node has - " + unsureNodes.size() + " nodes");
		markAsMine();
		makeUnsureSure();
		Rule2();
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
				if (number_of_nearby_mines == 0) {
					populateClearNodes(i, j);
				} else {
					populateUnsureNodes(i, j);
				}
				markAsMine();
				makeUnsureSure();
				Rule2();
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
			} else if(!unsureNodes.isEmpty()){
				System.out.println("Querying unsure nodes");
				Iterator it = unsureNodes.entrySet().iterator();
				Map.Entry key_value_pair = (Map.Entry) it.next();
				String parent_node = (String) key_value_pair.getKey();
				ArrayList<String> child_nodes = (ArrayList<String>) key_value_pair.getValue();
				String current_node = child_nodes.get(0);
				if(clueNodes.containsKey(current_node) || mineSet.contains(current_node))
				{
					System.out.println("Repeat "+current_node);
					child_nodes.remove(0);
					if(child_nodes.isEmpty())
					{
						unsureNodes.remove(parent_node);
					}
					else
					{
					unsureNodes.put(parent_node, child_nodes);
					}
					continue;
				}
				System.out.println("Unsure node - " + current_node);
				int i = Integer.parseInt(current_node.split(",")[0]);
				int j = Integer.parseInt(current_node.split(",")[1]);
				if (board[i][j] == -1) {
					System.out.println("Number of mines uncovered : "+mineSet.size());
					System.out.println("Game over!!");
					return;
				} else {
					int number_of_nearby_mines = getMineNumber(i, j);
					clueNodes.put(current_node, number_of_nearby_mines);
					if (number_of_nearby_mines == 0) {
						populateClearNodes(Integer.parseInt(current_node.split(",")[0]),
								Integer.parseInt(current_node.split(",")[1]));
					} else {
						populateUnsureNodes(Integer.parseInt(current_node.split(",")[0]),
								Integer.parseInt(current_node.split(",")[1]));
					}
					markAsMine();
					makeUnsureSure();
					Rule2();
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
			else
			{
				Random rand = new Random();
				int row = rand.nextInt(height);
			    int column = rand.nextInt(width);
				String current_node = row+","+column;
				while(clueNodes.containsKey(current_node) || mineSet.contains(current_node))
				{
					row = rand.nextInt(height);
				    column = rand.nextInt(width);
					current_node = row+","+column;
				}
				System.out.println("Clear node - " + current_node);
				int i = row;
				int j = column;
				int number_of_nearby_mines = getMineNumber(i, j);
				System.out.println("Next nearby mines - " + number_of_nearby_mines);
				clueNodes.put(current_node, number_of_nearby_mines);
				if (number_of_nearby_mines == 0) {
					populateClearNodes(i, j);
				} else {
					populateUnsureNodes(i, j);
				}
				markAsMine();
				makeUnsureSure();
				Rule2();
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

	}

}