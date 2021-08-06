Feature: Validating Place API's

@AddPlace
Scenario: Verify add place is being succesfully added using AddPlaceAPI
Given Add place Payload
When user calls "AddPlaceAPI" with "POST" http request
Then the API call is success with status code is 200
And "status" in response body is "OK"
And "scope" in response body is "APP"


# #When we are passing data from feature file then use Scenario Outline 
@Addplace2
Scenario Outline: Verify add place is being succesfully added using AddPlaceAPI
Given Add place Payload with "<name>" , "<language>" , "<address>" and "<phone>"
When user calls "AddPlaceAPI" with "POST" http request
Then the API call is success with status code is 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_Id created maps to "<name>" using "GetPlaceAPI"

Examples:
      |name|language|address|phone|
      |Raghu|Kannada|Mysore city|8019356528|
      |Amar|Hindi|Delhi city|7795090732|
  
@DeletePlace      
Scenario: Verify if Delete Place functionality is working 

Given Delete place Payload
When user calls "DeletePlaceAPI" with "POST" http request
Then the API call is success with status code is 200
And "status" in response body is "OK"
       