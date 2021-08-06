package resources;

import java.util.ArrayList;
import java.util.List;
import pojo.Location_Pojo;
import pojo.Place_Pojo;

public class TestDataBuild {

	public Place_Pojo addPlacePayload() // setting sample data
	{
		Place_Pojo place_Pojo = new Place_Pojo();
		place_Pojo.setAccuracy(50);
		place_Pojo.setName("Frontline house");
		place_Pojo.setPhone_number("(+91) 983 893 3937");
		place_Pojo.setAddress("29, side layout, cohen 09");
		place_Pojo.setWebsite("http://google.com");
		place_Pojo.setLanguage("French-IN");
		Location_Pojo location_Pojo = new Location_Pojo();
		location_Pojo.setLat(-38.383494);
		location_Pojo.setLng(33.427362);
		place_Pojo.setLocation(location_Pojo);
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		place_Pojo.setTypes(myList);
		return place_Pojo;

	}

	public Place_Pojo addPlacePayload(String name, String language, String address, String phone) // setting sample data
	{
		Place_Pojo place_Pojo = new Place_Pojo();
		place_Pojo.setAccuracy(50);
		place_Pojo.setName(name);
		place_Pojo.setPhone_number(phone);
		place_Pojo.setAddress(address);
		place_Pojo.setWebsite("http://google.com");
		place_Pojo.setLanguage(language);
		Location_Pojo location_Pojo = new Location_Pojo();
		location_Pojo.setLat(-38.383494);
		location_Pojo.setLng(33.427362);
		place_Pojo.setLocation(location_Pojo);
		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		place_Pojo.setTypes(myList);
		return place_Pojo;

	}

	public String deletePlaceLoad(String place_id) {
	
		return "{\r\n    \"place_id\": \""+place_id+"\"\r\n}";
	}
}
