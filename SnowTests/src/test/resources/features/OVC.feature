Feature: OVC Feature

  @OVC_INSTALL
  Scenario Outline: TC-20-Standalone OVC Instal Order E2E Validation
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the existing "OVC" PON
    And User fillup order details for OVC
    Given User logs in as valid user in orchestrator
    When User search the order
    Then order record should display
    Then User validate and complete the INTERNAL tasks
    And User validate NONASOG tasks in completed status
    And User validate accept project task is in Completed status for EVC
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
    Then User validates CLC_Management flow task successfully completed
      | CLC Management |
    When User refresh the page
    Then User validates VLAN_Processing flow task successfully completed
      | VLAN Pool Processing |
    When User refresh the page
    Then User validates FOC_Processing flow task successfully completed
      | FOC Sent |
    When User refresh the page
    Then User validates RUID_Validation flow task successfully completed
      | RUID Check Milestone |
    When User refresh the page
    Then User validates Create_Ovc flow task successfully completed
      | Create Colorless Xvc Service           |
      | Create Colourless Evpl Ovc Service ARM |
    When User refresh the page
    Then User validates Mesa_Test_OL flow task successfully completed
      | MESA Test generator or reflector not supported - CM |
    Then User validates the "<taskName6>" task is in "<status4>" status
    And User validates the "<taskName7>" task is in "<status4>" status

    Examples: 
      | managedESP  | taskName6            | taskName7        | status1 | status2 | status3  | status4   |
      | MCI         | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed |

 @OVC_SUPP2
  Scenario Outline: TC-21-Standalone OVC Supp2 Validation
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the install "OVC" PON
    And User open the install "OVC" order
    And User submit supp2 on order
    Examples: 
      | managedESP  | taskName6            | taskName7        | status1 | status2 | status3  | status4   |
      | MCI         | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed |
 
 
  @OVC_SUPP1
  Scenario Outline: TC-22-Standalone OVC Supp1 Validation
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the install "OVC" PON
    And User submit the Supp1 on order
    Then User validate Supp1 successfully submitted

    Examples: 
      | managedESP | taskName6            | taskName7        | status1 | status2 | status3  | status4   |
      | MCI        | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed |
      
      
       @OVC_DISCO
  Scenario Outline: TC-23-Standalone OVC Disconnect Order Validation
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the existing "OVC_Disconnect" PON    
    And User submit the "OVC" disconnect order
    Given User logs in as valid user in orchestrator
    When User search the order
    Then order record should display
    Then User validate and complete the INTERNAL tasks
    And User validate NONASOG tasks in completed status
    And User validate accept project task is in Completed status for EVC
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
    Then User validates Disconnect_Qualification_OL flow task successfully completed
      | Disconnect Order Qualification |
      | Get Xvc from ARM              |
      | Order Enrichment               |
      | XREF Order Enrichment          |
    
     Then User validates Business_Qualification flow task successfully completed
      | Business Qualification |
        
    When User refresh the page
    Then User validates the "<taskName1>" task is in "<status5>" status
    When User refresh the page
    #Then User validates the "<taskName2>" task is in "<status6>" status
    #When User self assign and complete the "<taskName2>" task
    #Then User validates "<taskName2>" task successfully completed
    #When User refresh the page
    #Then User validates service successfully disconected in act
      #| Delete Colorless Port SL |
      #| Hard Delete UNI          |
      #| Deactivate Uni in ACT    |
    #When User refresh the page
    #Then User validates the "<Disconnect Arm Inventory delay>" task is in "<status7>" status
    
    Examples: 
      | managedESP  | taskName1            | taskName2                    | status1 | status2 | status3  | status4   |status5    |
      | MCI         | Disconnect Order     | Supervised Disconnect Review | Created | Ready   | Assigned | Completed |In-Progress|
    
