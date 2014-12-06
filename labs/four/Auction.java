package labs.four;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Auction {
	private final Long id;
	private String name;
	private String description;
	private Double currentBid = 1.0;
	private final String creator;
	private String owner;
	private Integer numberOfBids = 0;
	private Calendar endTimeMillis;
	
	private SimpleDateFormat param2 = new SimpleDateFormat("M.dd.yyyy");
	private AuctionDateFormat firstFormat = new AuctionDateFormat(param2);

	public Auction(Long id, String name, Double currentBid, String userName) {
		this.id = new Long(id);
		this.name = name;
		this.currentBid = currentBid;
		this.description = "";
		this.creator = userName;
		this.owner = userName;
		this.endTimeMillis = new GregorianCalendar();
		this.endTimeMillis.setTimeInMillis(System.currentTimeMillis() + 7 * 24
				* 60 * 60 * 1000);
	}

	public Auction(Long id, String productName, Double productPrice,
			String productDescription, String userName) {
		// TODO Auto-generated constructor stub
		this.id = new Long(id);
		this.name = productName;
		this.currentBid = productPrice;
		this.description = productDescription;
		this.creator = userName;
		this.owner = userName;
		this.endTimeMillis = new GregorianCalendar();
		this.endTimeMillis.setTimeInMillis(System.currentTimeMillis() + 7 * 24
				* 60 * 60 * 1000);
	}

	public Auction(Long id, String productName, String description,
			Double currentBid, String currentOwner, Integer numberOfBids,
			Long endTimeMillis) {
		this.id = id;
		this.name = productName;
		this.currentBid = currentBid;
		this.description = description;
		this.creator = currentOwner;
		this.owner = currentOwner;
		this.numberOfBids = numberOfBids;
		this.endTimeMillis = new GregorianCalendar();
		this.endTimeMillis.setTimeInMillis(endTimeMillis);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + id);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (Long.class == obj.getClass()) {
			return id.equals(obj);
		}
		if (getClass() != obj.getClass())
			return false;
		Auction other = (Auction) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%-12s, %-85s, %-11s, %-10s, %-10s, %-10s",
				this.id, this.name + " " + this.description, this.currentBid,
				this.numberOfBids, this.owner, firstFormat.format(endTimeMillis.getTime()));
	}

	public Double getCurrentBid() {
		return currentBid;
	}

	public void setCurrentBid(Double _CurrentBid) {
		this.currentBid = _CurrentBid;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String _Owner) {
		this.owner = _Owner;
	}

	public void setName(String _Name) {
		if (getNumberOfBids() == 0) {
			this.name = _Name;
		} else {
			System.out
					.println("Adjusting the product name is an iIllegal operation.");
		}
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public Integer getNumberOfBids() {
		return numberOfBids;
	}

	public void setNumberOfBids(Integer numberOfBids) {
		this.numberOfBids = numberOfBids;
	}

	public Calendar getEndTimeMillis() {
		return endTimeMillis;
	}

	public void setEndTimeMillis(Calendar endTimeMillis) {
		if (getNumberOfBids() == 0) {
			this.endTimeMillis = endTimeMillis;
		}
	}

	public String getCreator() {
		return creator;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
