Feature: UNI feature

  Background: Port Acailability
  Given User open the mesh url
  Then User validates the mesh response
  
  @UNI_Install_PerPort_SVCMUX 
  @TEST_EDPSF-52271
  Scenario Outline: TC-01-UNI Install per port with Spec Code- SVCMUX Order E2E Validation-Passed
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the existing "UNI" PON
    And User fillup order details ES as "<ES>" and spec as "<SpecCode>" for UNI
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
    When User refresh the page
    Then User validates the "<taskName2>" task is in "<status2>" status
    When User enters the details and retry the task
    Then User validates "<taskName2>" task successfully completed
    When User refresh the page
    Then User validates "<taskName3>" task successfully completed
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
      | managedESP | ES | SpecCode | taskName1     | taskName2       | taskName3           | taskName4       | taskName5       | taskName6            | taskName7        | status1 | status2 | status3  | status4   |
      | MCI        | S  | SVCMUX   | Get Mesh Path | Select Location | Activate UNI in ACT | CM-Test and Tag | Send Manual PTA | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed |

  @UNI_Install_PerService_SVCMUX 
  @TEST_EDPSF-52271
  Scenario Outline: TC-02-UNI Install per service with spec-SVCMUX Order E2E Validation-Passed
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the existing "UNI" PON
    And User fillup order details ES as "<ES>" and spec as "<SpecCode>" for UNI
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
    When User refresh the page
    Then User validates the "<taskName2>" task is in "<status2>" status
    When User enters the details and retry the task
    Then User validates "<taskName2>" task successfully completed
    When User refresh the page
    Then User validates "<taskName3>" task successfully completed
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
      | managedESP | ES | SpecCode | taskName1     | taskName2       | taskName3           | taskName4       | taskName5       | taskName6            | taskName7        | status1 | status2 | status3  | status4   |
      | MCI        | M  | SVCMUX   | Get Mesh Path | Select Location | Activate UNI in ACT | CM-Test and Tag | Send Manual PTA | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed |

  @UNI_Install_PerPort_TLSMOE 
  @TEST_EDPSF-52271
  Scenario Outline: TC-03-UNI Install per port with spec-TLSMOE Order E2E Validation
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the existing "UNI" PON
    And User fillup order details ES as "<ES>" and spec as "<SpecCode>" for UNI
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
    When User refresh the page
    Then User validates the "<taskName2>" task is in "<status2>" status
    When User enters the details and retry the task
    Then User validates "<taskName2>" task successfully completed
    When User refresh the page
    Then User validates "<taskName3>" task successfully completed
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
      | managedESP | ES | SpecCode | taskName1     | taskName2       | taskName3           | taskName4       | taskName5       | taskName6            | taskName7        | status1 | status2 | status3  | status4   |
      | MCI        | S  | TLSMOE   | Get Mesh Path | Select Location | Activate UNI in ACT | CM-Test and Tag | Send Manual PTA | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed |

  @UNI_Install_PerService_TLSMOE 
  @TEST_EDPSF-52271
  Scenario Outline: TC-04-UNI Install per service with spec-TLSMOE Order E2E Validation
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the existing "UNI" PON
    And User fillup order details ES as "M" and spec as "TLSMOE" for UNI
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
    When User refresh the page
    Then User validates the "<taskName2>" task is in "<status2>" status
    When User enters the details and retry the task
    Then User validates "<taskName2>" task successfully completed
    When User refresh the page
    Then User validates "<taskName3>" task successfully completed
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
      | managedESP | ES | SpecCode | taskName1     | taskName2       | taskName3           | taskName4       | taskName5       | taskName6            | taskName7        | status1 | status2 | status3  | status4   | managedServiceType                                  |
      | MCI        | M  | TLSMOE   | Get Mesh Path | Select Location | Activate UNI in ACT | CM-Test and Tag | Send Manual PTA | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed | Managed Router and Managed Integrated Access Device |

  @UNI_SUPP2 
  @TEST_EDPSF-52271
  Scenario Outline: TC-05-UNI Supp2 Order Validation
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the install "UNI" PON
    And User open the install "UNI" order
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
    When User enters the install "UNI" order Id and hit on search
    Then Order records successfully dispalyed
    Then User validates the "<taskName4>" task is in "<status5>" status
    When User refresh the page
    When User enters the supp version Order Id and hit on search
    Then Order records successfully dispalyed
    And User validates "<taskName1>" task successfully completed
    When User refresh the page
    Then User validates "<taskName2>" task successfully completed
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

 @UNI_SUPP3
  Scenario Outline: TC-06-UNI Supp3 or Supp4 Validation-Passed
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the install "UNI" PON
    And User submit the Supp3 on order
    Then User validate Supp3 successfully submitted
    Given User logs in as valid user in orchestrator
    When User search the order
    Then order record should display
    Then User validate and complete the INTERNAL tasks
    And User validate and complete the SWC tasks
    And User validate NONASOG tasks in completed status
    And User validate accept project task is in Completed status
    Examples: 
      | managedESP | pdays | taskName6            | taskName7        | status1 | status2 | status3  | status4   |
      | MCI        |     2 | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed |

  @UNI_CHANGE
  Scenario Outline: TC-07-UNI Change Order by changing ES, SPEC and TSP attributes
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the existing "UNI" PON
    And User submit the UNI Change order by changing "<ES>" , "<TSP>" and "<SPEC>" field
    Given User logs in as valid user in orchestrator
    When User search the order
    Then order record should display
    When User entered the SWC for UNI and Combo Order
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
    Then User validates CO_Qualification_OL flow task successfully completed
      | Retrieve Service Spec |
      | Retrieve PM Spec      |
      | swcCLLI Enrichment    |
      | Order Enrichment      |
      | XREF Order Enrichment |
    When User refresh the page
    Then User validates the "<taskName1>" task is in "<In-Progress>" status
    When User refresh the page
    Then User validates the "<taskName2>" task is in "<status2>" status
    When User enters the details and retry the task
    Then User validates "<taskName2>" task successfully completed
    When User refresh the page
    Then User validates CLC_Management flow task successfully completed
      | CLC Management |
    When User refresh the page
    Then User validates CO_Processor flow task successfully completed
      | Determine Rate Limit Change |
      | Metro-E Change Order        |
    And User open the "Metro-E Change Order" task
    And validates the changes in task
    When User refresh the page
    Then User validates CO_Message_Handler_OL flow task successfully completed
      | CO_Update_Inventory   |
      | Update UNI Attributes |
    When User refresh the page
    Then User validates Order_Acceptance_OL flow task successfully completed
      | Order Closure Milestone |
      | Ease Completion sent    |
      | MOB Notification        |
    Examples: 
      | managedESP | ES |TSP         |SPEC    | taskName1     | taskName2       | status1 | status2 | status3  | status4   |
      | MCI        | M  |TSP0MXTJD02 |TLSMOE  |Change Order   | Select Location | Created | Ready   | Assigned | Completed |

  @UNI_HOTCUT
  Scenario Outline: TC-08-UNI Hot Cut Change Order
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the existing "UNI" PON
    And User submit the UNI Change order by changing "<NCI>" , "<SECNCI>" field
    Given User logs in as valid user in orchestrator
    When User search the order
    Then order record should display
    When User entered the SWC for UNI and Combo Order
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
    Then User validates CO_Qualification_OL flow task successfully completed
      | Retrieve Service Spec |
      | Retrieve PM Spec      |
      | swcCLLI Enrichment    |
      | Order Enrichment      |
      | XREF Order Enrichment |
    When User refresh the page
    Then User validates CO_Qualification_OL flow task successfully completed
      | Retrieve Service Spec] |
      | Retrieve PM Spec       |
      | swcCLLI Enrichment     |
      | Order Enrichment       |
      | XREF Order Enrichment  |
    When User refresh the page
    Then User validates the "<Change Order>" task is in "<In-Progress>" status
    When User refresh the page
    Then User validates the "<taskName2>" task is in "<status2>" status
    When User enters the details and retry the task
    Then User validates "<taskName2>" task successfully completed
    When User refresh the page
    Then User validates CLC_Management flow task successfully completed
      | CLC Management |
    When User refresh the page
    Then User validates CO_Processor flow task successfully completed
      | Determine Rate Limit Change |
      | Metro-E Change Order        |
    When User refresh the page
    Then User validates CO_Message_Handler_OL flow task successfully completed
      | CO_Update_Inventory   |
      | Update UNI Attributes |
    When User refresh the page
    Then User validates Order_Acceptance_OL flow task successfully completed
      | Order Closure Milestone |
      | Ease Completion sent    |
      | MOB Notification        |
    Examples: 
      | managedESP | NCI   |SECNCI     | taskName1     | taskName2       | taskName3           | taskName4       | taskName5       | taskName6            | taskName7        | status1 | status2 | status3  | status4   |
      | MCI        | KSE2  | 02CXF.10G |Get Mesh Path  | Select Location | Activate UNI in ACT | CM-Test and Tag | Send Manual PTA | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed |

  @UNI_DISCO
  Scenario Outline: TC-09-UNI Disconnect Order-Passed
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the existing "UNI_Disconnect" PON
    And User submit the "UNI" disconnect order
    Given User logs in as valid user in orchestrator
    When User search the order
    Then order record should display
    When User entered the SWC for UNI Disco and Combo Order
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
      | Get UNI from ARM               |
      | Order Enrichment               |
      | XREF Order Enrichment          |
    When User refresh the page
    Then User validates the "<taskName1>" task is in "<status5>" status
    When User refresh the page
    Then User validates the "<taskName2>" task is in "<status6>" status
    When User self assign and complete the "<taskName2>" task
    Then User validates "<taskName2>" task successfully completed
    When User refresh the page
    Then User validates service successfully disconected in act
      | Delete Colorless Port SL |
      | Hard Delete UNI          |
      | Deactivate Uni in ACT    |
    When User refresh the page
    Then User validates the "<Disconnect Arm Inventory delay>" task is in "<status7>" status

    #When User refresh the page
    #Then User validates Order_Acceptance_OL flow task successfully completed
    #|Order Closure Milestone|
    #|Ease Completion sent|
    #|MOB Notification|
    Examples: 
      | managedESP | taskName1        | taskName2                    | taskName3           | taskName4       | taskName5       | taskName6            | taskName7        | status1 | status2 | status3  | status4   | status5     | status6 | status7 |
      | MCI        | Disconnect Order | Supervised Disconnect Review | Activate UNI in ACT | CM-Test and Tag | Send Manual PTA | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed | In-Progress | Blocked | Pending |

  @UNI_SUPP1
  Scenario Outline: TC-10-UNI Supp1 Validation
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the install "UNI" PON
    And User submit the Supp1 on order
    Then User validate Supp1 successfully submitted
    Examples: 
      | managedESP | taskName6            | taskName7        | status1 | status2 | status3  | status4   |
      | MCI        | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed |

  @UNI_MOVE
  Scenario Outline: TC-11-UNI Move Order  -Passed
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the existing "MOVE" PON
    And User submit the UNI Move order by changing "<address>" field
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
    Then User validates CO_Qualification_OL flow task successfully completed
      | Retrieve Service Spec |
      | Retrieve PM Spec      |
      | swcCLLI Enrichment    |
      | Order Enrichment      |
      | XREF Order Enrichment |
      
    When User refresh the page
    Then User validates Business_Qualification flow task successfully completed
      | Business Qualification |
      
    When User refresh the page
    Then User validates CLC_Management flow task successfully completed
      #|Manage Location|
      #|Manage Contacts|
      | CLC Management |
   
    #When User refresh the page
    #Then User validates the "<Change Order>" task is in "<In-Progress>" status
  #
    #When User refresh the page
    #Then User validates CO_Processor flow task successfully completed
      #| Determine Rate Limit Change |
      #| Metro-E Change Order        |
    #
    #When User refresh the page
    #Then User validates CO_Message_Handler_OL flow task successfully completed
      #| CO_Update_Inventory   |
      #| Update UNI Attributes |
    #
    #When User refresh the page
    #Then User validates Order_Acceptance_OL flow task successfully completed
      #| Order Closure Milestone |
      #| Ease Completion sent    |
      #| MOB Notification        |
    Examples: 
      | managedESP | taskName6            | taskName7        | status1 | status2 | status3  | status4   |
      | MCI        | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed |

  @UNI_TRANSFER
  Scenario Outline: TC-12-UNI Transfer Order
    Given User is in EASE url
    When User logs in as a "Valid" user
    And User search the existing "TRANSFER" PON
   And User submit the UNI transfer order by changing "<address>" field
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
    Then User validates CO_Qualification_OL flow task successfully completed
      | Retrieve Service Spec |
      | Retrieve PM Spec      |
      | swcCLLI Enrichment    |
      | Order Enrichment      |
      | XREF Order Enrichment |     
    When User refresh the page
    Then User validates Business_Qualification flow task successfully completed
      | Business Qualification |      
    When User refresh the page
    Then User validates CLC_Management flow task successfully completed
      #|Manage Location|
      #|Manage Contacts|
      | CLC Management |     
    Examples: 
      | managedESP | taskName6            | taskName7        | status1 | status2 | status3  | status4   |
      | MCI        | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed |