/**
* A spambot
*/
public interface SpamBot {
	/**
	* Sets the seed.
	*
	* The seed is the very first URL that has to be given to the
	* system. The associated web page is the starting point for
	* the whole process of fetching web pages, extracting their
	* links and email addresses, and fetching more web pages.
	*
	* @param seedUrl the first URL to fetch and analyse
	*/
	void setSeed(String seedUrl) throws MalformedURLException;

	/**
	* Returns the seed URL.
	* @return the seed URL.
	*/
	String getSeed();
	
	/**
	* Sets the number of threads.
	*
	* The user should be able to set the number of threads to be
	* used for running the crawlers.
	*
	* @param count the number of threads (i.e. crawlers) to start in parallel
	*/
	void setThreads(int count);

	/**
	* Initiates the scanning process.
	*/
	void scanSite();
	
	/**
	* Returns all the emails gathered.
	*
	* This method should be executed only after the last crawlers
	* have stopped. If it is called before that point, its
	* behaviour is not defined.
	*/
	Set<String> getEmails();

	/**
	* Adds set of emails to existing set of emails
	* 
	* @param set of emails to add
	*/
	void addEmails(Set<String> emails);

	/**
	* Retrieves a link and removes it from the list of links to visit.
	*
	* @return link
	*/
	String getAndRemoveLink();

	/**
	* Adds set of links to existing set of links
	* 
	* @param set of links to add 
	*/
	void addLinks(Set<String> links);

	/**
	* Returns all the links successfully followed
	*/
	Set<String> getSuccessfulLinks();

	/**
	* Adds set of links successfully followed to existing set of links successfully followed
	* 
	* @param set of links to add 
	*/
	void addSuccessfulLinks(Set<String> link);


}
