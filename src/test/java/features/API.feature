Feature: Test Automation API https://dummyapi.io/

  @api
  Scenario: test get all user
    Given prepare url for "GET_USER"
    When hit api get request
    Then response code will be 200
    And response body match with JSONSchema "get_list_users_normal.json"

  @api
  Scenario: Test get a specific user
    Given prepare url for "GET_USER"
    When hit api get request for a specific id "60d0fe4f5311236168a10a06"
    Then response code will be 200
    And response body match with JSONSchema "get_user_by_id.json"

  @api
  Scenario: test get list of tags
    Given prepare url for "GET_TAGS"
    When hit api get request
    Then response code will be 200

  @api
  Scenario: test post user
    Given prepare url for "POST_USER"
    When hit api post request
    Then response code will be 200
    And validate create response body
    And response body match with JSONSchema "post_create_new_user.json"

  @api
  Scenario: test update user (user input incorrect email)
    Given prepare url for "POST_USER"
    When hit api post request
    Then response code will be 200
    And validate create response body
    Then hit api put request to update the email
    And response code will be 200
    And response body match with JSONSchema "post_create_new_user.json"

  @api
  Scenario: test delete user
    Given prepare url for "POST_USER"
    When hit api post request
    Then response code will be 200
    And validate create response body
    Then hit api delete request
    And response code will be 200