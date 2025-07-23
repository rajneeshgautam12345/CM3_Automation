@Full_Scenario
Feature: Service Now DIA E2E Scenarios
#
  #@DIA_Simple_Onnet 
  #@TEST_EDPSF-52271
  #Scenario Outline: TC-01-DIA Onnet Order submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #And User submit the TDF and SDF form "<floorAndRoom>" "<scenario>"
#
    #When User submitted the order to DOP "<floorAndRoom>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    #Examples: 
      #| sAccount                | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | scenario         | contact     |
      #| Lumentum Operations LLC |     2 | DNVFCOQE | Floor 5 Room WLAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | DIA_Simple_Onnet | Andrew Chan |
#
 #
  #@DIA_Colorless 
  #@TEST_EDPSF-52274
  #Scenario Outline: TC-03-DIA Onnet colourless address order submit to snow.
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #And User submit the TDF and SDF form "<floorAndRoom>" "<scenario>"
#
    #When User submitted the order to DOP "<floorAndRoom>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName           | cpeProvider      | futureday | scenario      | contact       |
      #| Lumentum Operations LLC      |     2 | WLMSAZAF | Floor 1 Room MPOE      | COLORADO | SL0003313633 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router     | CISCO C4431-ET-01 | Level 3 Provided |         3 | DIA_Colorless | Andrew Chan |
#
  #| Costco Wholesale Corporation |     2 | DNVFCOQES04 | Floor DN     | COLORADO | SL0003313633 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router     | CISCO C4431-ET-01 | Level 3 Provided |         3 | DIA_Colorless | Andrew Parada |
 #
  #@DIA_Onnet_ASRI_Manual 
  #@TEST_EDPSF-52277
  #Scenario Outline: TC-06-DIA Onnet ASRI manual submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #And User submit the TDF and SDF form "<floorAndRoom>" "<scenario>"
#
    #When User submitted the order to DOP "<floorAndRoom>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | scenario              | contact       |
      #| Lumentum Operations LLC      |     2 | ATLA134O | Floor 1 Room LL10 | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | DIA_Onnet_ASRI_Manual | Andrew Chan   |
#
  #@DIA_Onnet_Wave 
  #@TEST_EDPSF-52278
  #Scenario Outline: TC-07-DIA Onnet Wave order submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #And User submit the TDF and SDF form "<floorAndRoom>" "<scenario>"
#
    #When User submitted the order to DOP "<floorAndRoom>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom      | fstate  | fplcode      | smyproduct                | bandwidth                                 | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | tasknum        | contact       |
      #| Lumentum Operations LLC      |     2 | NWYK36G2 | Floor 43 Room MDF | NEWYORK | PL0027228028 | Dedicated Internet Access | 10 Gig LanWave - Wave Access (500-10,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | DIA_Onnet_Wave | Andrew Chan   |
#
  #@DIA_Onnet_With_BE 
  #@TEST_EDPSF-52279
  #Scenario Outline: TC-08-DIA Onnet with BE Order submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #And User submit the TDF and SDF form "<floorAndRoom>" "<scenario>"
#
    #When User submitted the order to DOP "<floorAndRoom>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                                | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName | cpeProvider | futureday | scenario          | contact       |
      #| Lumentum Operations LLC      |     2 | DNVFCOQE | Floor 5 Room WLAB | COLORADO | PL0031189037 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Extended Delivery - To the Customer Suite (Lumen Provided) | No               | 1000 | 1000 |   36 | No             |                    |         |             |         3 | DIA_Onnet_With_BE | Andrew Chan   |
#
   #@DIA_Affiliate 
  #@TEST_EDPSF-52285
  #Scenario Outline: TC-13-DIA Colorless Simply Onnet order submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<scenario>"
    #And User submit the TDF and SDF form "<floorAndRoom>" "<scenario>"
#
    #When User submitted the order to DOP "<floorAndRoom>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName           | cpeProvider      | futureday | scenario      | contact       |
      #| Lumentum Operations LLC      |     2 | SLKCUTSC | Floor 1 Room 9999 | COLORADO | SL0003313633 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router     | CISCO C4431-ET-01 | Level 3 Provided |         3 | DIA_Affiliate | Andrew Chan   |
#
  #@DIA_Headless 
  #@TEST_EDPSF-62125
  #Scenario Outline: TC-15-DIA Onnet headless Order submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #And User submit the TDF and SDF form "<floorAndRoom>" "<scenario>"
#
    #When User submitted the order to DOP "<floorAndRoom>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | scenario     | contact       |
      #| Lumentum Operations LLC      |     2 | DNVFCOQE | Floor 5 Room WLAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | DIA_Headless | Andrew Chan   |
#
  #
  #
  #@DIA_Simple_Onnet 
  #@TEST_EDPSF-52271
  #Scenario Outline: TC-01-DIA Onnet Order submit to snow
    #Given User is in EASE url
    #When User logs in as a "Valid" user
    #And User search the PON
    #And User fillup order details
    #
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #And User submit the TDF and SDF form "<floorAndRoom>" "<scenario>"
     #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | scenario     | contact       |
      #| Lumentum Operations LLC      |     2 | DNVFCOQE | Floor 5 Room WLAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | DIA_Headless | Andrew Chan   |
#
  #@TEST
   #Scenario Outline: TC-01-DIA Onnet Order submit to snow
     #Given User logs in as valid user in flight deck
    #When User navigate to Advance Search Page
    #Then User successfully navigated to advance search page
    #When User enters the Order Id and hit on search
    #Then Order records successfully dispalyed
    #Then User validates the "<taskName2>" task is in "<status2>" status
    #When User refresh the page
   #Then User validates Dispatch flow task is in "<status1>" status
    #|CM-Test and Tag|
    
   #When User logs in as a "Valid" user
   #And User open the install "UNI" order
   #Then User validates Create_Ovc flow task successfully completed
    #|Create Colorless Xvc Service|
   #And User fillup order details ES as "S" and spec as "SVCMUX" for UNI
   #And User search the install "EVC" PON
   #And User submit the Supp1 on order
   #Then User validate Supp1 successfully submitted
    #Examples: 
      #| managedESP  | pdays |ES |SpecCode | taskName1     | taskName2       | taskName3           |taskName4       |taskName5       |taskName6           |taskName7       | status1    | status2 | status3  | status4 |
      #| MCI         |     2 |S  |SVCMUX   |Get Mesh Path | Select Location | Activate UNI in ACT |CM-Test and Tag |Send Manual PTA |Ease Completion sent|MOB Notification| Created    | Ready   | Assigned |Completed|

   #@TEST55
   #Scenario Outline: Port Acailability
     #Given User open the mesh url
     #Then User validates the mesh response
     #
      #@UNI_SUPP3
  #Scenario Outline: TC-09-UNI Supp1 Validation
    #Given User is in EASE url
    #When User logs in as a "Valid" user
    #And User search the install "UNI" PON
    #And User submit the Supp3 on order
    #Then User validate Supp3 successfully submitted
#
    #Examples: 
      #| managedESP | pdays | taskName6            | taskName7        | status1 | status2 | status3  | status4   |
      #| MCI        |     2 | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed |
       
    #When User enters the install "EVCCombo" order Id and hit on search   
    #And user retrieve the service Id from task "<taskName4>"
    #Given User is in EASE url
    #Given User logs in as valid user in flight deck
    #When User navigate to Advance Search Page
    #Then User successfully navigated to advance search page
    #When User enters the Order Id and hit on search
    #Then Order records successfully dispalyed
    #Then User validates the "<taskName4>" task is in "<status4>" status
    #When User self assign and complete the "<taskName4>" task
   #
    #Examples: 
      #| managedESP | pdays | ES | SpecCode | taskName1     | taskName2       | taskName3           | taskName4       | taskName5       | taskName6            | taskName7        | status1 | status2 | status3  | status4   |
      #| MCI        |     2 | S  | SVCMUX   | Get Mesh Path | Select Location | Activate UNI in ACT | CM-Test and Tag | Send Manual PTA | Ease Completion sent | MOB Notification | Created | Ready   | Assigned | Completed |

    