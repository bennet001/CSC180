package lab.two.two;

public class Auction {
	private final int _Id;
	private int _CurrentBid;
	private String _Owner;
	private String _Name;
	private String _Description;

	public Auction(int id, String name, int currentBid) {
		_Id = id;
		_Name = name;
		_CurrentBid = currentBid;
		_Description = "";
	}

	public Auction(int size, String productName, int productPrice,
			String productDescription) {
		// TODO Auto-generated constructor stub
		_Id = size;
		_Name = productName;
		_CurrentBid = productPrice;
		_Description = productDescription + " ";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _Id;
		result = prime * result + ((_Name == null) ? 0 : _Name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if(Integer.class == obj.getClass()){
			return _Id == (Integer)obj;
		}
		if (getClass() != obj.getClass())
			return false;
		Auction other = (Auction) obj;
		if (_Id != other._Id)
			return false;
		if (_Name == null) {
			if (other._Name != null)
				return false;
		} else if (!_Name.equals(other._Name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		if (_Owner != null) {
			return this._Name + " " + this._Description + this._CurrentBid + " " + this._Owner + " " + this._Id;
		} else {
			return this._Name + " " + this._Description + this._CurrentBid + " " + this._Id;
		}
	}
	
	

	public int getCurrentBid() {
		return _CurrentBid;
	}

	public void setCurrentBid(int _CurrentBid) {
		this._CurrentBid = _CurrentBid;
	}

	public String getOwner() {
		return _Owner;
	}

	public void setOwner(String _Owner) {
		this._Owner = _Owner;
	}
	public void setName(String _Name) {
		if(_Owner == null){
		this._Name = _Name;
		}
		else{
			System.out.println("Illegal operation.");
		}
	}

	public String getName() {
		return _Name;
	}

	public int getId() {
		return _Id;
	}	
}
