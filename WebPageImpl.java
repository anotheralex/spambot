import java.net.*;
import java.io.*;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
* A possible interface representing a web page.
* This is only a suggestion.
*/
public class WebPageImpl implements WebPage {

	private static final Pattern linkPattern = new Pattern.compile('\<a href\="()".*');
	private static final Pattern emailPattern = new Pattern.compile('([\w\.\-_]+@[\w\.\-_]\.[A-Za-z])[ "]');
	private String urlstr;
	private URL url;
	private Set<String> links = new HashSet<String>();
	private Set<String> emails = new HashSet<String>();

	/**
	*
	*
	* throws MalformedURLException
	*/
	public WebPageImpl(String urlstr) throws MalformedURLException{
		this.urlstr = urlstr;
		parseUrlSource();
	}

	/**
	* Returns the URL that identifies this web page.
	* @return the URL that identifies this web page.
	*/
	@Override
	public String getUrl() {
		return this.urlstr;
	}

	/**
	* Returns all the links on this webpage.
	*
	* Implementing classes should return a read-only view of this
	* set, using Collections.unmodifiableSet().
	*
	* @return all the links on this webpage.
	*/
	@Override
	Set<String> getLinks() {
		return Collections.unmodifiableSet(links);
	}
	
	/**
	* Returns all the emails on this webpage.
	*
	* Implementing classes should return a read-only view of this
	* set, using Collections.unmodifiableSet().
	*
	* @return all the emails on this webpage.
	*/
	@Override
	Set<String> getEmails() {
		return Collections.unmodifiableSet(emails);
	}

	// Also, implementing classes should override equals() to
	// ensure that p1.equals(p2) returns true if and only if
	// p1.getUrl().equals(p2.getUrl()) returns true

	@Override
	public boolean equals(Object obj) {
		if (!(p2 instanceOf WebPageImpl)) {
			return false
		}
		WebPage p2 = (WebPage) obj;
		return this.getUrl().equals(p2.getUrl());
	}

	private void parseUrlSource() throws MalformedURLException {
		
		URL website = new URL(urlstr);
		BufferedReader in = null;
		try { 
			in = new BufferedReader(
				new InputStreamReader(
					website.openStream()));

			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				Matcher linkMatcher = linkPattern.matcher(inputLine);
				while (linkMatcher.find()) {
					links.add(linkMatcher.group());
				}
				Matcher emailMatcher = emailPattern.matcher(inputLine);
				while (emailMatcher.find()) {
					emails.add(emailMatcher.group());
				}
			}

			in.close;
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
