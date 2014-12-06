package labs.three;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RAMAuctionService implements AuctionService {
	FileInputStream filein;
	private static final Pattern AUCTION_PATTERN = Pattern
			.compile(
					"<h3 class=\"lvtitle\"><a .*?>(?:<span class=\"newly\">New listing</span>.*?)?(.*?)</a>.*?\\$([0-9,]+\\.\\d{2}).*?((\\d+) bid.*?)?(timeMs=\"(\\d+)\".*?)?Item: (\\d+)",
					Pattern.DOTALL);

	private Matcher m;

	public RAMAuctionService(String FileName) {
		try {
			Path p = Paths.get(FileName);
			byte[] b = Files.readAllBytes(p);
			String text = new String(b);
			m = AUCTION_PATTERN.matcher(text);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean hasNext() {
		return m.find();
	}

	public Auction next() {
		String title = m.group(1).trim();
		double price = Double.parseDouble(m.group(2).replace(",", ""));
		int numberOfBids = parseInto(m.group(4), 0, Integer.class);
		long endTimeMillis = parseInto(m.group(6), System.currentTimeMillis()
				+ 7 * 24 * 60 * 60 * 1000, Long.class);
		long id = Long.parseLong(m.group(7));
		return new Auction(id, title, "", price, "System", numberOfBids,
				endTimeMillis);
	}

	private <T> T parseInto(String toBeParsed, T defaultValue, Class<T> clazz) {
		try {
			return clazz.getConstructor(String.class).newInstance(toBeParsed);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Collection<Auction> search(String criteria) {
		Stack<Predicate> predicateContainer = new Stack<Predicate>();
		Stack<String> OperatorContainer = new Stack<String>();
		String[] lookfor = criteria.split(" ");
		for (int i = 0; i < (lookfor.length); i++) {
			if (lookfor[i].equalsIgnoreCase("AND")) {
				OperatorContainer.push("AND");
			} else if (lookfor[i].equalsIgnoreCase("OR")
					&& !OperatorContainer.contains(new AndPredicate())) {
				OperatorContainer.push("OR");
			} else if ((lookfor[i].equalsIgnoreCase("OR") && OperatorContainer
					.contains(new AndPredicate())) || i == lookfor.length) {
				Predicate<Auction> pop1 = predicateContainer.pop();
				Predicate<Auction> pop2 = predicateContainer.pop();
				Predicate pop3 = DecidePredicate(OperatorContainer.pop());
				pop3.setFirstNeed(pop1);
				pop3.setSecondNeed(pop2);
				predicateContainer.push(pop3);
				OperatorContainer.push("OR");
			} else {
				predicateContainer.push(new ContainsPredicate<String>(
						lookfor[i]));
			}
		}
		Collection<Auction> set;
		if(predicateContainer.isEmpty()){
			set = Filter(auctionmodel.values(), predicateContainer.pop());
		}else{
			set = Filter(auctionmodel.values(), null);
		}
		return set;
	}

	@SuppressWarnings("rawtypes")
	private Predicate DecidePredicate(String pop) {
		Predicate action = null;
		switch (pop) {
		case "AND":
			action = new AndPredicate();
			break;
		case "OR":
			action = new OrPredicate();
			break;
		default:
			break;
		}
		return action;
	}

	public Collection<Auction> Filter(Collection<Auction> providedCollection,
			Predicate<Auction> providedPredicate) {
		ArrayList<Auction> searchResult = new ArrayList<Auction>();
		if (providedPredicate != null) {
			for (Auction CurrentAuctionItem : providedCollection) {
				Auction check = providedPredicate.evaluate(CurrentAuctionItem) ? CurrentAuctionItem
						: null;
				if (check != null) {
					Long time = (check.getEndTimeMillis().getTimeInMillis() - System
							.currentTimeMillis());
					if (time >= 0) {
						searchResult.add(check);
					}
				}
			}
		} else {
			for (Auction auction : providedCollection) {
				if (auction != null) {
					Long time = (auction.getEndTimeMillis().getTimeInMillis() - System
							.currentTimeMillis());
					if (time >= 0) {
						searchResult.add(auction);
					}
				}
			}
		}
		return searchResult;
	}

	@Override
	public void bid(String username, Long itemId, Collection<Auction> list) {
		Auction tempItem = null;
		for (Auction currentAucItem : list) {
			if (currentAucItem.equals(itemId)) {
				tempItem = currentAucItem;
			}
		}
		if (tempItem != null
				&& tempItem.getEndTimeMillis().compareTo(
						new GregorianCalendar()) >= 0) {
			auctionmodel.remove(itemId);
			tempItem.setCurrentBid((tempItem.getCurrentBid() + 1));
			tempItem.setOwner(username);
			tempItem.setNumberOfBids((tempItem.getNumberOfBids() + 1));
			auctionmodel.put(tempItem.getId(), tempItem);
		} else {

		}
	}

	@Override
	@Deprecated
	public void bid(String username, Long itemId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Auction create(Auction auction) {
		auctionmodel.put(auction.getId(), auction);
		return auction;
	}

	@Override
	public Auction update(Auction auction, Long id) {
		// TODO Auto-generated method stub
		auctionmodel.replace(id, auction);
		return auction;
	}

	@Override
	public Auction retreive(Long id) {
		return auctionmodel.get(id);
	}

	@Override
	public void delete(Long id) {
		auctionmodel.remove(id);
	}
}
