Feature: Put pet on Petstore

  Background:
    * url "https://petstore.swagger.io/v2/"
    * configure headers = { Accept : '*/*' , Content-Type : 'application/json'}
    * call read('../get/pet_get.feature@GetById')

  @updateSatusAvailable
  Scenario: Update name and status available
    Given path 'pet'
    And request { id: '#(jsonResponse.id)', category: '#(jsonResponse.category)', name: 'Pigu', photoUrls: '#(jsonResponse.photoUrls)', tags: '#(jsonResponse.tags)', status: 'available' }
    When method PUT
    Then status 200
    And def newStatus = $.status

  @updateSatusPending
  Scenario: Update name and status pending
    Given path 'pet'
    And request { id: '#(jsonResponse.id)', category: '#(jsonResponse.category)', name: 'Carloto', photoUrls: '#(jsonResponse.photoUrls)', tags: '#(jsonResponse.tags)', status: 'pending' }
    When method PUT
    Then status 200
    And def newStatus = $.status

  @updateSatusSold
  Scenario: Update name and status sold
    Given path 'pet'
    And request { id: '#(jsonResponse.id)', category: '#(jsonResponse.category)', name: 'Roster', photoUrls: '#(jsonResponse.photoUrls)', tags: '#(jsonResponse.tags)', status: 'sold' }
    When method PUT
    Then status 200
    And def newStatus = $.status