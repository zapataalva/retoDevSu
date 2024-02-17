Feature: Add a new pet on Petstore

  Background:
    * url "https://petstore.swagger.io/v2/"
    * configure headers = { Accept : '*/*' , Content-Type : 'application/json'}

  @Create
  Scenario: Add a new pet OK
    Given path 'pet'
    And request
        """
        {
          "id": 0,
          "category": {
            "id": 0,
            "name": "Canino"
          },
          "name": "doggie",
          "photoUrls": [
            "urlPhoto.com"
          ],
          "tags": [
            {
              "id": 0,
              "name": "Curo"
            }
          ],
          "status": "available"
        }
        """
    When method POST
    Then status 200
    And def petId = $.id
    And print petId
