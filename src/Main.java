import java.util.Scanner;

class Main {
	// Structure of Graph
	static class Graph {
		// vertices and edges
		int v, e;
		int[][] dir;

		// Graph Constructor
		Graph(int v, int e) {
			this.v = v;
			this.e = e;
			dir = new int[v][];
			for (int i = 0; i < v; i++)
				dir[i] = new int[v];
		}
	}

	static Graph createGraph(int v, int e) {
		Graph G = new Graph(v, e);

		/*
		 * 0-----1 | \ | | \ | | \ | 2-----3
		 */

		// direction from Lily
		G.dir[0][0] = -1;
		G.dir[0][1] = 1;
		G.dir[0][2] = 0;
		G.dir[0][3] = 0;
		G.dir[0][4] = 0;
		G.dir[0][5] = 1;
		G.dir[0][6] = 0;
		G.dir[0][7] = 1;
		G.dir[0][8] = 0;
		G.dir[0][9] = 0;

		// direction from James
		G.dir[1][1] = -1;
		G.dir[1][0] = 1;
		G.dir[1][2] = 0;
		G.dir[1][3] = 0;
		G.dir[1][4] = 0;
		G.dir[1][5] = 0;
		G.dir[1][6] = 0;
		G.dir[1][7] = 1;
		G.dir[1][8] = 0;
		G.dir[1][9] = 0;

		// direction from Sirius
		G.dir[2][2] = -1;
		G.dir[2][0] = 0;
		G.dir[2][1] = 0;
		G.dir[2][3] = 0;
		G.dir[2][4] = 0;
		G.dir[2][5] = 0;
		G.dir[2][6] = 0;
		G.dir[2][7] = 1;
		G.dir[2][8] = 0;
		G.dir[2][9] = 0;

		// direction from Ginny
		G.dir[3][3] = -1;
		G.dir[3][0] = 0;
		G.dir[3][1] = 0;
		G.dir[3][2] = 0;
		G.dir[3][4] = 1;
		G.dir[3][5] = 1;
		G.dir[3][6] = 0;
		G.dir[3][7] = 1;
		G.dir[3][8] = 1;
		G.dir[3][9] = 1;

		// direction from Malfoy
		G.dir[4][4] = -1;
		G.dir[4][0] = 0;
		G.dir[4][1] = 0;
		G.dir[4][2] = 0;
		G.dir[4][3] = 1;
		G.dir[4][5] = 1;
		G.dir[4][6] = 1;
		G.dir[4][7] = 1;
		G.dir[4][8] = 1;
		G.dir[4][9] = 1;

		// direction from Snape
		G.dir[5][5] = -1;
		G.dir[5][0] = 1;
		G.dir[5][1] = 0;
		G.dir[5][2] = 0;
		G.dir[5][3] = 1;
		G.dir[5][4] = 1;
		G.dir[5][6] = 1;
		G.dir[5][7] = 1;
		G.dir[5][8] = 1;
		G.dir[5][9] = 1;

		// direction from Hermonie
		G.dir[6][6] = -1;
		G.dir[6][0] = 0;
		G.dir[6][1] = 0;
		G.dir[6][2] = 0;
		G.dir[6][3] = 0;
		G.dir[6][4] = 1;
		G.dir[6][5] = 1;
		G.dir[6][7] = 1;
		G.dir[6][8] = 1;
		G.dir[6][9] = 0;

		// direction from Harry
		G.dir[7][7] = -1;
		G.dir[7][0] = 1;
		G.dir[7][1] = 1;
		G.dir[7][2] = 1;
		G.dir[7][3] = 1;
		G.dir[7][4] = 1;
		G.dir[7][5] = 1;
		G.dir[7][6] = 1;
		G.dir[7][8] = 1;
		G.dir[7][9] = 1;

		// direction from Ron
		G.dir[8][8] = -1;
		G.dir[8][0] = 0;
		G.dir[8][1] = 0;
		G.dir[8][2] = 0;
		G.dir[8][3] = 1;
		G.dir[8][4] = 1;
		G.dir[8][5] = 1;
		G.dir[8][6] = 1;
		G.dir[8][7] = 1;
		G.dir[8][9] = 1;

		// direction from Fred
		G.dir[9][9] = -1;
		G.dir[9][0] = 0;
		G.dir[9][1] = 0;
		G.dir[9][2] = 0;
		G.dir[9][3] = 1;
		G.dir[9][4] = 1;
		G.dir[9][5] = 1;
		G.dir[9][6] = 0;
		G.dir[9][7] = 1;
		G.dir[9][8] = 1;

		return G;
	}

	static void findDegree(Graph G) {
		int degree = 0;
		int[] deg = new int[10];
		for (int i = 0; i < G.v; i++) {
			for (int j = 0; j < G.v; j++) {
				if (G.dir[i][j] == 1)
					degree++;
			}
			deg[i] = degree;
			degree = 0;
		}
		System.out.println("Degrees: \n");
		System.out.println("Lily: " + deg[0]);
		System.out.println("James: " + deg[1]);
		System.out.println("Sirius: " + deg[2]);
		System.out.println("Ginny: " + deg[3]);
		System.out.println("Malfoy: " + deg[4]);
		System.out.println("Snape: " + deg[5]);
		System.out.println("Hermione: " + deg[6]);
		System.out.println("Harry: " + deg[7]);
		System.out.println("Ron: " + deg[8]);
		System.out.println("Fred: " + deg[9]);

	}

	static void closeness(Graph G) {
		double temp = 0;
		double[] sums = new double[10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (G.dir[i][j] == 1) {
					temp = temp + 1;
				} else if (G.dir[i][j] == 0) {
					temp = temp + 2;
				}
			}
			sums[i] = 1 / (temp / 9);
			temp = 0;
		}
		System.out.println("Closeness Centrality:\n");
		System.out.println("Lily: " + sums[0]);
		System.out.println("James: " + sums[1]);
		System.out.println("Sirius: " + sums[2]);
		System.out.println("Ginny: " + sums[3]);
		System.out.println("Malfoy: " + sums[4]);
		System.out.println("Snape: " + sums[5]);
		System.out.println("Hermione: " + sums[6]);
		System.out.println("Harry: " + sums[7]);
		System.out.println("Ron: " + sums[8]);
		System.out.println("Fred: " + sums[9]);
		System.out.println();
	}

	static void eccentricity(Graph G) {
		double temp = 1;
		double[] hold = new double[10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (G.dir[i][j] == 0) {
					temp = 2;
				}

			}
			hold[i] = 1 / (temp);
			temp = 1;
		}
		System.out.println("Eccencricity Centrality:\n");

		System.out.println("Lily: " + hold[0]);
		System.out.println("James: " + hold[1]);
		System.out.println("Sirius: " + hold[2]);
		System.out.println("Ginny: " + hold[3]);
		System.out.println("Malfoy: " + hold[4]);
		System.out.println("Snape: " + hold[5]);
		System.out.println("Hermione: " + hold[6]);
		System.out.println("Harry: " + hold[7]);
		System.out.println("Ron: " + hold[8]);
		System.out.println("Fred: " + hold[9]);
		System.out.println();
	}

	static void betweenCentrality(Graph G) {
		
		int center = 7;
		double totalPath = 0;
		double chosenPath = 0;
		double result = 0;
		double finalResult = 0;

		for (int i = 0; i < G.v; i++) {
			for (int j = 0; j < G.v; j++) {
				if (i != j && G.dir[i][j] != 1 && j != center && i != center) {
					for (int j2 = 0; j2 < G.v; j2++) {
						if (G.dir[i][j2] == 1 && G.dir[j2][j] == 1 && j2 == center) {
							chosenPath++;
							totalPath++;
						} else if (G.dir[i][j2] == 1 && G.dir[j2][j] == 1 && j2 != center) {
							totalPath++;
						}

					}
					result = chosenPath / totalPath;
					finalResult = finalResult + result;
					System.out.println(i + " " + j + " " + chosenPath + " / " + totalPath);
					chosenPath = 0;
					totalPath = 0;
				}
			}
		}
		finalResult = finalResult / 2;
		System.out.println("Betweennes Centrality of " + center + " : " + finalResult);
	}

	public static void main(String[] args) {
		while(true) {
		int vertices = 10;
		int edges = 24;
		int choice;
		Graph G = createGraph(vertices, edges);
		Scanner scn = new Scanner(System.in);

		System.out.println(" 1- Closeness Centrality\n 2- Eccentricity Centrality \n 3- Degree \n 4- Betweenness Centrality");
		while (true) {
			try {
				System.out.println("Pick your operation: ");
				choice = scn.nextInt();
				if (choice < 5 && choice > 0)
					break;

			} catch (java.util.InputMismatchException e) {
				System.out.print("Wrong input!\n");
				scn.next();
				continue;
			}
		}

		switch (choice) {
		case 1:
			closeness(G);
			break;
		case 2:
			eccentricity(G);
			break;
		case 3:
			findDegree(G);
			break;
		case 4:
			betweenCentrality(G);
			break;
		}

		// 
		// 
		// 
		
	}
	}
}

/*

*/