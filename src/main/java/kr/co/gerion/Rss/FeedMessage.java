package kr.co.gerion.Rss;

public class FeedMessage {


     String title;
     String description;
     String link;
     String author;
     String guid;
     String pubdate;
     String thumbnailUrl;
     String category;
     
     
     public String getTitle() {
             return title;
     }
 
     public void setTitle(String title) {
             this.title = title;
     }
 
     public String getDescription() {
             return description;
     }
 
     public void setDescription(String description) {
             this.description = description;
     }
 
     public String getLink() {
             return link;
     }
 
     public void setLink(String link) {
             this.link = link;
     }
 
     public String getAuthor() {
             return author;
     }
 
     public void setAuthor(String author) {
             this.author = author;
     }
 
     public String getGuid() {
             return guid;
     }
 
     public void setGuid(String guid) {
             this.guid = guid;
     }
 
     public String getPubdate() {
          return pubdate;
     }
 
     public void setPubdate(String pubdate) {
         this.pubdate = pubdate;
     }
 
    public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
    public String toString() {
        return "FeedMessage [title=" + title + ", description=" + description + ", link=" + link + ", author=" + author
                + ", guid=" + guid + ", pubdate=" + pubdate + ", thumbnailUrl=" + thumbnailUrl + ", category=" + category + "]";
    }


	
	
	
	
	
	
	
	
	
	
	
	
	
}
