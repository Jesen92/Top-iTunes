package org.example.Top10ItunesDownloads;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

public class ParseApplication {
	private String data;
	private ArrayList<Application> applications;
	
	private int ranking;
	
	public ParseApplication(String xmlData) 
	{
		data = xmlData;
		applications = new ArrayList<Application>();
	}
	
	public ArrayList<Application> getApplication()
	{
		return applications;
	}
	
	public boolean process()
	{
		boolean operationStatus = true;
		Application currentRecord = null;
		boolean inEntry = false;
		String textValue = "";		
		
		
		
		try
		{
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser();
			
			xpp.setInput(new StringReader(this.data));
			int eventType = xpp.getEventType();
			
			if(eventType==XmlPullParser.END_DOCUMENT)
				ranking=0;
			
			while(eventType!=XmlPullParser.END_DOCUMENT)
			{
				String tagName = xpp.getName();
				
				if(eventType == XmlPullParser.START_TAG)
				{
					if(tagName.equalsIgnoreCase("entry"))
					{
						inEntry=true;
						currentRecord = new Application();
						currentRecord.setRank(++ranking);
					}
					
					
				}else if(eventType == XmlPullParser.TEXT)
				{
					textValue = xpp.getText();
					
					
					
				}else if(eventType == XmlPullParser.END_TAG)
				{
					if(inEntry)
					{
						if(tagName.equalsIgnoreCase("entry"))
						{
							applications.add(currentRecord);
						}else if(tagName.equalsIgnoreCase("name"))
						{
							currentRecord.setName(textValue);
						}else if(tagName.equalsIgnoreCase("artist"))
						{
							currentRecord.setArtist(textValue);
						}else if(tagName.equalsIgnoreCase("releaseDate"))
						{
							currentRecord.setReleaseDate(textValue);
						}
				}
			}	
				eventType = xpp.next();
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
			operationStatus=false;
		}
		
		/*for(Application app : applications )
		{
			Log.d("LOG", "*************");
			Log.d("LOG",app.getName());
			Log.d("LOG",app.getArtist());
			Log.d("LOG",app.getReleaseDate());
		}*/
		
		return operationStatus;
	}
}
