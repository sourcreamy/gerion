package kr.co.gerion.Rss;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

public class RSSFeedParser {

	static final String TITLE = "title";
    static final String DESCRIPTION = "description";
    static final String CHANNEL = "channel";
    static final String LANGUAGE = "language";
    static final String COPYRIGHT = "copyright";
    static final String LINK = "link";
    static final String AUTHOR = "author";
    static final String ITEM = "item";
    static final String PUB_DATE = "pubDate";
    static final String GUID = "guid";
    static final String PUBDATE ="pubdate";
    static final String THUMBNAILURL= "thumbnail";
    static final String CATEGORY= "category";
    
    
    
    final URL url;

    public RSSFeedParser(String feedUrl) {
            try {
                    this.url = new URL(feedUrl);
            } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
            }
    }

    public Feed readFeed() {
            Feed feed = null;
            try {
                    boolean isFeedHeader = true;
                    // Set header values intial to the empty string
                    String description = "";
                    String title = "";
                    String link = "";
                    String language = "";
                    String copyright = "";
                    String author = "";
                    String pubdate = "";
                    String guid = "";
                    String thumbnailUrl = "";
                    String category = "";
                    boolean thumbnailIsExist = false;
                    // First create a new XMLInputFactory
                    XMLInputFactory inputFactory = XMLInputFactory.newInstance();
                    // Setup a new eventReader
                    InputStream in = read();
                    XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
                    // read the XML document
                    while (eventReader.hasNext()) {
                            XMLEvent event = eventReader.nextEvent();
                            if (event.isStartElement()) {
                                    String localPart = event.asStartElement().getName()
                                                    .getLocalPart();
                                    switch (localPart) {
                                    case ITEM:
                                            if (isFeedHeader) {
                                                    isFeedHeader = false;
                                                    feed = new Feed(title, link, description, language,
                                                                    copyright, pubdate);
                                            }
                                            event = eventReader.nextEvent();
                                            break;
                                    case TITLE:
                                            title = getCharacterData(event, eventReader);
                                            break;
                                    case DESCRIPTION:
                                            description = getCharacterData(event, eventReader);
                                            break;
                                    case LINK:
                                            link = getCharacterData(event, eventReader);
                                            break;
                                    case GUID:
                                            guid = getCharacterData(event, eventReader);
                                            break;
                                    case LANGUAGE:
                                            language = getCharacterData(event, eventReader);
                                            break;
                                    case AUTHOR:
                                            author = getCharacterData(event, eventReader);
                                            break;
                                    case PUB_DATE:
                                            pubdate = getCharacterData(event, eventReader);
                                            break;
                                    case COPYRIGHT:
                                            copyright = getCharacterData(event, eventReader);
                                            break;
                                    case PUBDATE:
                                        	pubdate = getCharacterData(event, eventReader);
                                        	break;
                                    case THUMBNAILURL:
                                    		thumbnailIsExist = true;
                                    		thumbnailUrl = getCharacterData(localPart,event,eventReader);
                                    		break;
                                    case CATEGORY:
                                    		category = getCharacterData(event,eventReader);
                                    		break;
                                            
                                    }
                            } else if (event.isEndElement()) {
                                    if (event.asEndElement().getName().getLocalPart() == (ITEM)) {
                                            FeedMessage message = new FeedMessage();
                                            message.setAuthor(author);
                                            message.setDescription(description);
                                            message.setGuid(guid);
                                            message.setLink(link);
                                            message.setTitle(title);
                                            message.setPubdate(pubdate);
                                            if(thumbnailIsExist){
                                            	message.setThumbnailUrl(thumbnailUrl);	
                                            }else{
                                            	message.setThumbnailUrl("");
                                            }
                                            thumbnailIsExist = false;
                                            message.setCategory(category);
                                            feed.getMessages().add(message);
                                            event = eventReader.nextEvent();
                                            continue;
                                    }
                            }
                    }
            } catch (XMLStreamException e) {
                    throw new RuntimeException(e);
            }
            return feed;
    }

    private String getCharacterData(XMLEvent event, XMLEventReader eventReader)
                    throws XMLStreamException {
            String result = "";
            event = eventReader.nextEvent();
            if (event instanceof Characters) {
                    result = event.asCharacters().getData();
            }
            return result;
    }
    
    private String getCharacterData(String localPart ,XMLEvent event, XMLEventReader eventReader)
    			throws XMLStreamException {
		    String result = "";
		   
		    if (event.isStartElement()) {
                @SuppressWarnings("unchecked")
				Iterator<Attribute> itr = event.asStartElement().getAttributes();
                while(itr.hasNext()){
                    Attribute attribute = itr.next();
                    result = attribute.getValue();
                }
            }		    
		    return result;
}

    private InputStream read() {
            try {
                    return url.openStream();
            } catch (IOException e) {
                    throw new RuntimeException(e);
            }
    }


	
}
