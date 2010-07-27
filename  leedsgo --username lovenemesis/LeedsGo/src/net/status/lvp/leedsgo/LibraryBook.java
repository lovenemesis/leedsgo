package net.status.lvp.leedsgo;

class LibraryBook {
	/**Class to hold the information of the book*/
	
	private String author = null;
	private String title = null;
	private String year = null;
	private String imprint = null;
	private String note = null;
	private String avail = null;
	
	LibraryBook(String title, String year){
		this.title = title;
		this.year = year;
	}
	
	void setAuthor(String author){
		this.author = author;		
	}
	
	void setTitle(String title){
		this.title = title;		
	}
	
	void setYear(String year){
		this.year = year;		
	}
	
	void setImprint(String imprint){
		this.imprint = imprint;
	}
	
	void setNote(String note){
		this.note = note;
	}
	
	void setAvail(String avail){
		this.avail = avail;
	}
	
	String getAuthor(){
		return this.author;
	}
	
	String getTitle(){
		return this.title;
	}
	
	String getYear(){
		return this.year;
	}
	
	String getImprint(){
		return this.imprint;
	}
	
	String getNote(){
		return this.note;
	}
	
	String getAvail(){
		return this.avail;
	}
}
