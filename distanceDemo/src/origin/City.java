package origin;

/**   
* @Title: City.java 
* @Package origin 
* @Description:  
* @author Pengbin Li   
* @date 2019年1月4日 下午6:23:21 
* @version V1.0   
*/

public class City {
	private int x;
	
	private int y;
	
	private int[] neighbor;
	
	private String name;
	
	public City() {
		
	}
	
	public City(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int[] getNeighbor() {
		return neighbor;
	}

	public void setNeighbor(int[] neighbor) {
		this.neighbor = neighbor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
