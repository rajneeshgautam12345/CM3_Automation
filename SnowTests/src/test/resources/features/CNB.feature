Feature: UNI feature

  @CNB 
  @TEST_EDPSF-107553
  Scenario Outline: TC-27-CNB Install per port with Spec Code- SVCMUX Order E2E Validation
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the existing "UNI" PON
    And User fillup order details ES as "<ES>" and spec as "<SpecCode>" for CNB
    Given User logs in as valid user in orchestrator
    When User search the order
    Then order record should display
    When User entered the SWC for UNI and Combo Order
    Then User validate and complete the INTERNAL tasks
    And User validate and complete the SWC tasks
    And User validate NONASOG tasks in completed status
    And User validate accept project task is in Completed status
    Given User logs in as valid user in flight deck
    When User navigate to Advance Search Page
    Then User successfully navigated to advance search page
    When User enters the Order Id and hit on search
    Then Order records successfully dispalyed
    And User validates "<taskName1>" task successfully completed
    #And user retrieve the service Id from task "<taskName1>"
    When User refresh the page
    Then User validates the "<taskName2>" task is in "<status2>" status
    When User enters the details and retry the task
    Then User validates "<taskName2>" task successfully completed
    When User refresh the page
    Then User validates the "<taskName3>" task is in "<status5>" status
    Then User validates the "<taskName4>" task is in "<status5>" status

    Examples: 
      | managedESP | ES | SpecCode | taskName1     | taskName2       | taskName3            | taskName4               | taskName5       | taskName6            | taskName7        | status1 | status2 | status3  | status4   |status5    |
      | MCI        | S  | SVCMUX   | Get Mesh Path | Select Location | CNB Determine Action | Colorless Network Build | Send Manual PTA | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed |In-Progress|

  #@EVC_OVC_EndPoint_Cleanup
  #Scenario Outline: TC-28-EVC or OVC or UNI Endpoint Cleanup
  #Given User is in Autopilot url
  #When User navigate to LNAAS_DELETE_TRANSACTION_ACT_TL_V1 flow in automatio Studio
  #And User enters the details "<actIdentifierId>" and "<CorreleationId>"
  #And User click on start to trigger the flow
  #Then User validates workflow status
  #
  #Examples:
  #| actIdentifierId | CorreleationId |
  #| MCI             |     2          |
  #
  #@UNI_Cleanup
  #Scenario Outline: TC-29-UNI service Cleanup
    #Given User is in Autopilot url
    #When User navigate to LNAAS_DELETE_COLORLESS_PORT_SL_V1 flow in automatio Studio
    #And User enters UNI details for cleanup "<CustomerName>" and "<serviceId>"
    #And User click on start to trigger the flow
    #Then User validates workflow status
#
    #Examples: 
      #| CustomerName        | serviceId          |
      #| AT&T COMMUNICATIONS | 29/KXGS/595317//MS |
