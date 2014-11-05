package exercises.four.auction;

import java.util.Map;

public class Auction {
	private final int _Id;
	private int _CurrentBid;
	private String _Owner;
	private String _Name;
	private Map<String,Object> _Propertieslist;

	public Auction(int id, String name, int currentBid) {
		_Id = id;
		_Name = name;
		_CurrentBid = currentBid;
	}
	public Auction(int id, String name, int currentBid, Map<String,Object> properties){
		_Id = id;
		_Name = name;
		_CurrentBid = currentBid;
		_Propertieslist = properties;
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
		if(obj.getClass() == Integer.class && Integer.parseInt(obj.toString()) == getId()){
			return true;
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

	public Map<String,Object> getProperties(){
		Map<String, Object> map = (Map<String, Object>) _Propertieslist.values();
		return map;
	}
	
	public Object getProperty(String propertyName){
		Object accuired = _Propertieslist.get(propertyName);
		return accuired;
	}
	public <T> T getProperty(String propertyName, Class<T> propertyType){
		return (T) _Propertieslist.get(propertyName);
	}
	
	public void setProperty(String propertyName, Object propertyValue){
		_Propertieslist.put(propertyName, propertyValue);
	}
}
