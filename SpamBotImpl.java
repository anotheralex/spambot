import java.util.Set;


public class SpamBotImpl implements SpamBot {
	
	Set<String> successfulLinks;
	Set<String> links;
	Set<String> emails;
	String seed;
	int numberOfThreads;
	int threadSemaphore;


	public SpamBotImpl() {}


	void setSeed(String seedUrl) throws MalformedURLException;


	String getSeed();
	

	void setThreads(int count);


	void scanSite();
	

	Set<String> getEmails();


	void addEmails(Set<String> emails);


	String getAndRemoveLink();


	void addLinks(Set<String> links);


	Set<String> getSuccessfulLinks();


	void addSuccessfulLinks(Set<String> link);
}
