package exercises.two;

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
	public boolean equals(Object obj) {
		if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        } else if(obj.getClass() == Integer.class && Integer.parseInt(obj.toString()) >= 0) {
        	return this.get_Id() == Integer.parseInt(obj.toString());
        }

        Auction guest = (Auction) obj;
        return _Id == guest._Id;
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
