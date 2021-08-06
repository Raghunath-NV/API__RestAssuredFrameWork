package resources;

//enum is special class in java which has collection of constants or methods

public enum APIResources {

	 AddPlaceAPI("/maps/api/place/add/json"),
	 GetPlaceAPI("/maps/api/place/get/json"),
	 DeletePlaceAPI("/maps/api/place/delete/json");
	
	private String resource;

	// we have written methods which had url which is string so we need to have a
	// constructor which accepts 1 string
	APIResources(String resource) {
		// TODO Auto-generated constructor stub
		this.resource = resource;
	}

	
	public String getResouce() {
		return resource;
	}
}
