package origin;

/**   
* @Title: Test.java 
* @Package origin 
* @Description:  
* @author Pengbin Li   
* @date 2019年1月4日 下午6:24:20 
* @version V1.0   
*/

public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		City[] cities = t.generateMap(20);
		int[][] map = t.generateMap(cities);
		int N = map.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("--------------------------\n--------------------------");
		int[] distance = t.getClosest(map);
		for (int i : distance) {
			System.out.print(i + "\t");
		}
	}
	
	private City[] generateMap(int num) {
		City[] res = new City[num];
		
		for (int i = 0; i < num; i++) {
			res[i] = new City("City" + String.valueOf(i)
					, (int)(Math.random() * 100), (int)(Math.random() * 100));
		}
		
		for (int i = 0; i < num; i++) {
			int j = (int) (Math.random() * 17);
			int[] neighbor;
			if (i == j) {
				neighbor = new int[]{j, j + 1};
			} else {
				neighbor = new int[]{j, j + 1, j + 2};
			}
			res[i].setNeighbor(neighbor);
		}
		
		return res;
	}
	
	private int[][] generateMap(City[] cities) {
		int N = cities.length;
		int[][] res = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			int[] neighbor = cities[i].getNeighbor();
			boolean b = neighbor.length == 3;
			for (int j = 0; j < N; j++) {
				if (i == j) {
					res[i][j] = 10000;  //longest range which means not reachable or same point
				}else if (j == neighbor[0] || j == neighbor[1]) {
					res[i][j] =  (int)(Math.sqrt(Math.pow(cities[i].getX() - cities[j].getX(), 2)
							+ Math.pow(cities[i].getY() - cities[j].getY(), 2)));
				} else if (b && j == neighbor[2]) {
					res[i][j] = (int)(Math.sqrt(Math.pow(cities[i].getX() - cities[j].getX(), 2)
							+ Math.pow(cities[i].getY() - cities[j].getY(), 2)));
				} else {
					res[i][j] = 10000;
				}
			}
		}
		
		return res;
	}
	
	private int[] getClosest(int[][] map) {
		int N = map.length;
		int[] res = new int[N];
		
		int[] used = new int[N];
		int[] parent = new int[N]; //last node to the index point
				
		used[0] = 1;
		
		for (int i = 0; i < N; i++) {
			res[i] = map[0][i];
		}
		
		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int j = 0;
			for (int k = 0; k < N; k++) {
				if (used[k] == 0 && res[k] < min) {
					min = res[k];
					j = k;
				}
			}
			used[j] = 1;
			for (int k = 0; k < N; k++) {
				if (used[k] == 0 && res[k] > res[j] + map[j][k]) {
					res[k] = res[j] + map[j][k];
					parent[k] = j;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(parent[i] + "\t");
		}
		System.out.println();
		
		return res;
	}
}
