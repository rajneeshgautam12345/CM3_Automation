Feature: EVC Combo feature

  @EVC_COMBO_INSTALL
  Scenario Outline: TC-17-EVC Combo Install Order E2E Validation -Passed
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the existing "EVCCOMBO" PON
    And User fillup order details for EVC_Combo
    
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
    And User validates Order_Persistence flow task successfully completed
      | Colorless Metro Order Fulfillment |
      | CM3 Mongo Access Request          |
      | EASE Notify                       |
    When User refresh the page
    Then User validates Master_Qualification flow task successfully completed
      | Qualification Milestone          |
      | swcCLLI Enrichment               |
      | Valid Spec Code Mapping XREF     |
      | NCI Spec Code XREF               |
      | Valid Spec Code Combination XREF |
    When User refresh the page
    Then User validates Business_Qualification flow task successfully completed
      | Business Qualification |
    When User refresh the page
    Then User validates "<taskName1>" task successfully completed
    When User refresh the page
    Then User validates CLC_Management flow task successfully completed
      | CLC Management |
    When User refresh the page
    Then User validates VLAN_Processing flow task successfully completed
      | VLAN Pool Processing |
    When User refresh the page
    Then User validates Create_UNI flow task successfully completed
      | Activate UNI in ACT |
      | Update Uni in ARM   |
    When User refresh the page
    Then User validates FOC_Processing flow task successfully completed
      | FOC Sent |
    When User refresh the page
    Then User validates Dispatch flow task is in "<status1>" status
      | CM-Test and Tag |
    When User refresh the page
    Then User validates RUID_Validation flow task successfully completed
      | RUID Check Milestone |
    When User refresh the page
    Then User validates Create_xVC flow task successfully completed
      | Create Colorless Xvc Service           |
      | Create Colourless Evpl Evc Service ARM |
      
    When User refresh the page
    Then User validates Mesa_Test_OL flow task successfully completed
    | MESA Test generator or reflector not supported - CM |
      
    Then User validates the "<taskName4>" task is in "<status1>" status
    When User self assign and complete the "<taskName4>" task
    Then User validates "<taskName4>" task successfully completed
    When User refresh the page
    Then User validates the "<taskName5>" task is in "<status2>" status
    When User self assign and enter the "<taskName5>" task details
    And User complete the task
    Then User validates "<taskName5>" task successfully completed
    
    When User refresh the page
    Then User validates the "<taskName6>" task is in "<status4>" status
    And User validates the "<taskName7>" task is in "<status4>" status

    Examples: 
      | managedESP | taskName1     | taskName3           | taskName4       | taskName5       | taskName6            | taskName7        | status1 | status2 | status3  | status4   |
      | MCI        | Get Mesh Path | Activate UNI in ACT | CM-Test and Tag | Send Manual PTA | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed |

  @EVC_COMBO_SUPP2 
  Scenario Outline: TC-18-EVC COMBO Supp2 Order Validation
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the install "EVCCombo" PON
    And User open the install "EVCCombo" order
    And User submit supp2 on order
    Given User logs in as valid user in orchestrator
    When User search the order
    Then order record should display
    And User validate and complete the SWC tasks
    And User validate NONASOG tasks in completed status
    And User validate accept project task is in Completed status
    Given User logs in as valid user in flight deck
    When User navigate to Advance Search Page
    Then User successfully navigated to advance search page
    When User enters the install "EVCCombo" order Id and hit on search
    Then Order records successfully dispalyed
    Then User validates the "<taskName4>" task is in "<status5>" status
    When User refresh the page
    When User enters the supp version Order Id and hit on search
    Then Order records successfully dispalyed
    And User validates "<taskName1>" task successfully completed
    When User refresh the page
    Then User validates the "<taskName4>" task is in "<status1>" status
    When User self assign and complete the "<taskName4>" task
    Then User validates "<taskName4>" task successfully completed
    When User refresh the page
    Then User validates the "<taskName5>" task is in "<status2>" status
    When User self assign and enter the "<taskName5>" task details
    And User complete the task
    Then User validates "<taskName5>" task successfully completed
    When User refresh the page
    Then User validates the "<taskName6>" task is in "<status4>" status
    And User validates the "<taskName7>" task is in "<status4>" status

    Examples: 
      | managedESP | taskName1     | taskName2       | taskName3           | taskName4       | taskName5       | taskName6            | taskName7        | status1 | status2 | status3  | status4   | status5   |
      | MCI        | Get Mesh Path | Select Location | Activate UNI in ACT | CM-Test and Tag | Send Manual PTA | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed | Cancelled |

  #When User enters the supp version "EVC Combo" Order Id and hit on search
  @EVC_COMBO_SUPP1
  Scenario Outline: TC-19-EVC Combo Supp1 Validation
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the install "EVCCombo" PON
    And User submit the Supp1 on order
    Then User validate Supp1 successfully submitted

    Examples: 
      | managedESP | taskName6            | taskName7        | status1 | status2 | status3  | status4   |
      | MCI        | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed |
