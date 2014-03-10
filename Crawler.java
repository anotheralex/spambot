import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.new.MalformedURLException;

public class Crawler implements Runnable {

	private static final int MAX_LINKS_FOLLOWED = 10;
	private SpamBot spamBot;
	private AtomicInteger linksFollowed = new AtomicInteger();

	public Crawler(SpamBot spamBot) {
		this.spamBot = spamBot;
	}

	public void run() {
		if(linksFollowed.get() > MAX_LINKS_FOLLOWED) return;
		String url = spamBot.getAndRemoveLink();
		try {
			WebPage wp = new WebPageImpl(url);
			Set<String> fetchedLinks = wp.getLinks();
			spamBot.addLinks(fetchedLinks);
			Set<String> fetchedEmails = wp.getEmails();
			spamBot.addEmails(fetchedEmails);		
			spamBot.addSuccesses(url);
			linksFollowed.incrementAndGet();
		} catch (MalformedURLException e) {
			System.out.println("Malformed Url: " + url);
		}
		run();
	}

}