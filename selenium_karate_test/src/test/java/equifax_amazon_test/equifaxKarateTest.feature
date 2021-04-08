Feature: Equifax Karate Test

  Background: Base Url
    * url 'http://dummy.restapiexample.com/'

  Scenario: Get Method
    * def employeeId = '1'
    Given path 'api/v1/employee/' + employeeId
    When method get
    Then status 200
    And match response.status == 'success'
    And match response.data == {"id": 1,"employee_name": "Tiger Nixon","employee_salary": 320800,"employee_age": 61,"profile_image": ""}

    Scenario: Delete method
      * def employeeId = '1'
      Given path 'api/v1/delete/' + employeeId
      When method delete
      Then status 200
      And match response.status == 'success'
      And match response.message == 'Successfully! Record has been deleted'
