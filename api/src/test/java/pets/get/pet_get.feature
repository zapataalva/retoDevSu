Feature: Get pets of Petstore

  Background:
    * url "https://petstore.swagger.io/v2/"
    * configure headers = { Accept : '*/*' , Content-Type : 'application/json'}


  @GetById
  Scenario: Get pet by id OK
    * call read('../post/pet_post.feature@Create')
    Given path 'pet'
    And path petId
    When method GET
    Then status 200
    And def jsonResponse = $

  @GetByStatusAvailable
  Scenario: Get pet by status available
    * call read('../put/pet_put.feature@updateSatusAvailable')
    Given path 'pet/findByStatus'
    And param status = newStatus
    When method GET
    Then status 200
    And def jsonResponse = $

  @GetByStatusPending
  Scenario: Get pet by status pending
    * call read('../put/pet_put.feature@updateSatusPending')
    Given path 'pet/findByStatus'
    And param status = newStatus
    When method GET
    Then status 200
    And def jsonResponse = $

  @GetByStatusSold
  Scenario: Get pet by status sold
    * call read('../put/pet_put.feature@updateSatusSold')
    Given path 'pet/findByStatus'
    And param status = newStatus
    When method GET
    Then status 200
    And def jsonResponse = $


  Scenario: Get pet by wrong id
    Given path 'pet'
    And path 999478465654
    When method GET
    Then status 404