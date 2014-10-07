package lab.one.two;

public class Auction {
	private final int _Id;
	private int _CurrentBid;
	private String _Owner;
	private String _Name;

	public Auction(int id, String name, int currentBid) {
		_Id = id;
		_Name = name;
		_CurrentBid = currentBid;

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
			return "\n" + this._Name + "\n" + this._CurrentBid + "\n" + this._Owner + "\n" + this._Id;
		} else {
			return "\n" + this._Name + "\n" + this._CurrentBid + "\n" + this._Id;
		}
	}
	
	

	public int get_CurrentBid() {
		return _CurrentBid;
	}

	public void set_CurrentBid(int _CurrentBid) {
		this._CurrentBid = _CurrentBid;
	}

	public String get_Owner() {
		return _Owner;
	}

	public void set_Owner(String _Owner) {
		this._Owner = _Owner;
	}
	public void set_Name(String _Name) {
		if(_Owner == null){
		this._Name = _Name;
		}
		else{
			System.out.println("Illegal operation.");
		}
	}

	public String get_Name() {
		return _Name;
	}

	public int get_Id() {
		return _Id;
	}	
}
