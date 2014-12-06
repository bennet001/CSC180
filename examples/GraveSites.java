package examples;

public class GraveSites {
	private final Integer id;
	private final Integer x;
	private final Integer y;
	private final String TombstoneType;
	public GraveSites(Integer id, Integer x, Integer y, String tombstonetype){
		this.id = id;
		this.x = x;
		this.y = y;
		TombstoneType = tombstonetype;
	}
	public Integer getId() {
		return id;
	}
	public Integer getX() {
		return x;
	}
	public Integer getY() {
		return y;
	}
	public String getTombstoneType() {
		return TombstoneType;
	}
}
