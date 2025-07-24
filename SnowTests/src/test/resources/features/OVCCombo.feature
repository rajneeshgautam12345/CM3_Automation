Feature: OVC Combo feature

  Background: Port Acailability
  Given User open the mesh url
  Then User validates the mesh response
  
  @OVC_COMBO_INSTALL
  Scenario Outline: TC-24-OVC Combo Install Order E2E Validation
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the existing "OVCCOMBO" PON
    And User fillup order details for OVC_Combo
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
    Then User validates the "<taskName4>" task is in "<status1>" status
    When User refresh the page
    Then User validates RUID_Validation flow task successfully completed
      | RUID Check Milestone |
    When User refresh the page
    Then User validates Create_Ovc flow task successfully completed
      | Activate Ovc in ACT                    |
      | Activate Ovc in ADAM                   |
      | Create Colorless Xvc Service           |
      | Create Colourless Evpl Ovc Service ARM |
           
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
    #Then User validates Mesa_Test_OL flow task successfully completed
      #| MESA Test generator or reflector not supported - CM |
   #When User refresh the page
    Then User validates Ease_Completion flow task successfully completed
    | Ease Completion sent |
      When User refresh the page
    Then User validates Mob_Completion_Notification flow task successfully completed
    | MOB Notification |  

    Examples: 
      | managedESP  | taskName1     | taskName2       | taskName3           | taskName4       | taskName5       | taskName6            | taskName7        | status1 | status2 | status3  | status4   |
      | MCI         | Get Mesh Path | Select Location | Activate UNI in ACT | CM-Test and Tag | Send Manual PTA | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed |
    
    #Then User validates the "<taskName2>" task is in "<status2>" status
    #When User enters the details and retry the task
    #Then User validates "<taskName2>" task successfully completed
    #When User refresh the page

  @OVC_COMBO_SUPP2 
  @TEST_EDPSF-52271
  Scenario Outline: TC-25-OVC COMBO Supp2 Order Validation-Passed
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the install "OVCCombo" PON
    And User open the install "OVCCombo" order
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
    When User enters the install "OVCCombo" order Id and hit on search
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
    Then User validates Ease_Completion flow task successfully completed
    | Ease Completion sent |
      When User refresh the page
    Then User validates Mob_Completion_Notification flow task successfully completed
    | MOB Notification |  
    Examples: 
      | managedESP | taskName1     | taskName2       | taskName3           | taskName4       | taskName5       | taskName6            | taskName7        | status1 | status2 | status3  | status4   | status5   |
      | MCI        | Get Mesh Path | Select Location | Activate UNI in ACT | CM-Test and Tag | Send Manual PTA | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed | Cancelled |

  @OVC_COMBO_SUPP1
  Scenario Outline: TC-26-OVC Combo Supp1 Order Validation
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the install "OVCCombo" PON
    And User submit the Supp1 on order
    Then User validate Supp1 successfully submitted

    Examples: 
      | managedESP                | pdays | taskName6            | taskName7        | status1 | status2 | status3  | status4   |
      | MCI                       |     2 | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed |
