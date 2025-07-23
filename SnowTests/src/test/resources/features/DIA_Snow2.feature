#@all
#Feature: Service Now DIA E2E Scenarios2
#
  #@DIA_Onnet_With_MR_&_MIAD 
  #@TEST_EDPSF-52275
  #Scenario Outline: TC-04-DIA Onnet with MIAD and Managed Router Order submit to snow
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
    #When User submitted the order to DOP "<floorAndRoom>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    #Examples: 
      #| sAccount                | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | tasknum                          | contact     |
      #| Lumentum Operations LLC |     2 | DNVFCOQE | Floor 5 Room WLAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | Yes            | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Chan |
#
  #@DIA_Offnet_With_BE_&_MR 
  #@TEST_EDPSF-52276
  #Scenario Outline: TC-05-DIA Offnet with Building extension and Managed Router Order submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #When User submitted the order to DOP "<floorAndRoom>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
#
    #Examples: 
      #| sAccount                | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                                | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName            | cpeProvider      | futureday | tasknum                          | contact     |
      #| Lumentum Operations LLC |     2 | BNNTCOAP | Floor 1 Room TELC | COLORADO | PL0031189037 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Extended Delivery - To the Customer Suite (Lumen Provided) | No               | 1000 | 1000 |   36 | Yes            | Managed Router     | CISCO C4451X-ET-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Chan |
#
  #@DIA_SNOW2_TC_1
  #Scenario Outline: TC-05-DIA Onnet Order submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
#
    #Examples: 
      #| sAccount                | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName                                   | cpeProvider      | futureday | tasknum                          | contact       |
      #| Lumentum Operations LLC |     2 | LABBRMCO | Floor 1 Room LAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             |                    | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |
#
  #@DIA_Onnet_With_MR 
  #@TEST_EDPSF-52281
  #Scenario Outline: TC-09-DIA Onnet with Managed Router Order submit to snow
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
      #| sAccount                | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName      | cpeProvider      | futureday | scenario          | contact     |
      #| Lumentum Operations LLC |     2 | DNVFCOQE | Floor 5 Room WLAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | Yes            | Managed Router     | C4451X-ET-01 | Level 3 Provided |         3 | DIA_Onnet_With_MR | Andrew Chan |
#
  #CISCO C4451X-ET-01    (Test4)
  #@DIA_Onnet_With_BE_&_MR 
  #@TEST_EDPSF-52288
  #Scenario Outline: TC-14-DIA Onnet with Building extension and Managed Router Order submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
#
    #And User submit the TDF and SDF form "<floorAndRoom>" "<scenario>"
    #When User submitted the order to DOP "<floorAndRoom>"
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    #Examples: 
      #| sAccount                | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                                | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName            | cpeProvider      | futureday | scenario               | contact     |
      #| Lumentum Operations LLC |     2 | DNVFCOQE | Floor 5 Room WLAB | COLORADO | PL0031189037 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Extended Delivery - To the Customer Suite (Lumen Provided) | No               | 1000 | 1000 |   36 | Yes            | Managed Router     | CISCO C4451X-ET-01 | Level 3 Provided |         3 | DIA_Onnet_With_BE_&_MR | Andrew Chan |
#
  #| Bloomberg                   |     2 | 1092 CEDAR ST BENNETT CO 80102 USA     | Floor 1       | North Carolina | PL0000005093 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps        |Flat Rate     | Extended Delivery - To the Customer Suite (Lumen Provided) |        No       |1000 | 1000 |  36   |         Yes   | Managed Router    |CISCO C4451X-ET-01  |Level 3 Provided|  3        | Dedicated_Internet_Access_On_Net | Beth McCarthy  |
  #2-LK2D1Y
  #@Affiliate_Prod
  #Scenario Outline: TC-14-DIA Colorless Simply Onnet order submit to snow.
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
#
    #Examples: 
      #| sAccount     | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName           | cpeProvider      | futureday | tasknum                          | contact       |
      #| SUNDAY UAT 1 |     2 | CLSUCOND | Floor 2 Room MPOE | COLORADO | SL0003313633 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router     | CISCO C4431-ET-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |
#
  #@DIA_SNOW_Sanity 
  #@TEST_EDPSF-11932
  #Scenario Outline: DIA Onnet Order submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #When User submitted the order to DOP
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    #When User logs in Snow application
    #Then User successfully logged in snow application
    #When User navigate to customer orders submodule
    #Then User succesfully landed to customer orders submodule
    #When User search the order in customer orders submodule
    #Then successfully displayed the searched order records
    #When User clicks on Customer order
    #Then User successfully landed to order deatils
    #When User clicks on approve button
    #Then order successfully gets approved
    #When User clicks on show related items link
    #When User clicks on related order entities
    #Then User successfully validates the SM id, Opportunity Id
    #When User navigates to the order line "<Component1>" Item
    #Then User successfully navigated to order line "<Component1>" Item
    #When User navigates to product order section of DIA
    #Then User validates the "<DIAWorkflow>" kicked off for "<Component1>" under flow context
    #When User navigates to the customer order page
    #And User navigates to the order line "<Component2>" Item
    #Then User successfully navigated to order line "<Component2>" Item
    #When User navigates to product order section of Access Service
    #Then User validates the "<AccessWorkflow>" kicked off for "<Component2>" under flow context
    #When User navigates to the customer order page
    #And User navigates to the order line "<Component3>" Item
    #Then User successfully navigated to order line "<Component3>" Item
    #When User navigates to product order section of Internet Service
    #Then User validates the "<InternetWorkflow>" kicked off for "<Component3>" under flow context
#
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | tasknum                          | contact       | Component1                | DIAWorkflow                   | Component2     | AccessWorkflow             | Component3       | InternetWorkflow           |
      #| Costco Wholesale Corporation |     2 | LTTNCOML | Floor 1 Room LAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada | Dedicated Internet Access | LMN-ORCH-DIA-Order Validation | Access Service | LMN-ORCH-SOM-Discover Path | Internet Service | LMN-ORCH-DIA-IP Assignment |
#
  #@DIA_SNOW_E2E
  #Scenario Outline: DIA Onnet Order submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #When User submitted the order to DOP
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    #When User logs in Snow application
    #Then User successfully logged in snow application
    #When User navigate to customer orders submodule
    #Then User succesfully landed to customer orders submodule
    #When User search the order in customer orders submodule
    #Then successfully displayed the searched order records
    #When User clicks on Customer order
    #Then User successfully landed to order deatils
    #When User clicks on approve button
    #Then order successfully gets approved
    #When User clicks on show related items link
    #When User clicks on related order entities
    #Then User successfully validates the SM id, Opportunity Id
    #When User navigates to the order line "<Component1>" Item
    #Then User successfully navigated to order line "<Component1>" Item
    #When User navigates to product order section of DIA
    #Then User validates the "<DIAWorkflow>" kicked off for "<Component1>" under flow context
    #When User clicks on the "<DIAWorkflow>" and clicks on open in operation view
    #Then User successfully navigates to the workflow in flow designer
    #Then User validates the workflow "<DIAWorkflow>" is waiting for TDG task
    #When User navigates to order tasks section of "<Component1>"
    #When User navigates to the customer order page
    #And User navigates to gather_order_details tab
    #And fillup the access type and access subtype details under tdg form
    #And enters the details for IP subnets and save it
    #And enters the details for transport access and save it
    #And user navigates back to customer order page
    #When User navigates to the order line "<Component1>" Item
    #Then User successfully navigated to order line "<Component1>" Item
    #When User navigates to order tasks section of "<Component1>"
    #Then User validates "<diaTasksName3>" task is open state
    #And User completes the "<diaTasksName3>" task
    #Then User validates "<diaTasksName3>" task is completed state
    #Then User validates "<diaTasksName4>" task is open state
    #And User completes the "<diaTasksName4>" task
    #Then User validates "<diaTasksName4>" task is completed state
    #Then User validates "<diaTasksName5>" task is open state
    #And User completes the "<diaTasksName5>" task
    #Then User validates "<diaTasksName5>" task is completed state
    #When User navigates to the workflow window tab
    #Then User validates the workflow "<DIAWorkflow>" is waiting for CCM Task
    #When User navigates to order tasks section of "<Component1>"
    #And User reload the order line item
    #Then User validates "<diaTasksName2>" task is open state
    #And User completes the "<diaTasksName2>" task
    #Then User validates "<diaTasksName2>" task is completed state
    #And User validates the order validation wait workflow status
    #When User navigates to order tasks section of "<Component1>"
    #Then User validates "<diaTasksName1>" task is open state
    #When User completes the "<diaTasksName1>" task
    #Then User validates "<diaTasksName1>" task is completed state
    #When User navigates to the workflow window tab
    #Then User validates the workflow "<DIAWorkflow>" is waiting for CCM Task
    #When User navigates to order tasks section of "<Component1>"
    #And User reload the order line item
    #Then User validates "<diaTasksName2>" task is open state
    #And User completes the "<diaTasksName2>" task
    #Then User validates "<diaTasksName2>" task is completed state
    #Then User validates "<diaTasksName2SLA>" task is open state
    #And User completes the "<diaTasksName2SLA>" task
    #Then User validates "<diaTasksName2SLA>" task is completed state
    #When User navigates to the workflow window tab
    #Then User validates the workflow "<DIAWorkflow>" is waiting for TDG task
    #When User navigates to order tasks section of "<Component1>"
    #Then User validates "<diaTasksName3>" task is open state
    #And User completes the "<diaTasksName3>" task
    #Then User validates "<diaTasksName3>" task is completed state
    #When User navigates to the workflow window tab
    #Then User validates the workflow "<DIAWorkflow>" is waiting for credit check status
    #When User navigates to order tasks section of "<Component1>"
    #And User navigates to the customer order page
    #And User approve the credit check status
    #Then User validates the workflow "<DIAWorkflow>" is waiting for IIQ task
    #Then User validates the workflow "<DIAWorkflow>" completed successfully
    #When User navigates to order tasks section of "<Component1>"
    #When User navigates to the customer order page
    #And User navigates to the order line "<Component2>" Item
    #Then User successfully navigated to order line "<Component2>" Item
    #When User navigates to product order section of Access Service
    #When User navigates to order tasks section of "<Component2>"
    #Then User validates the "<AccessWorkflow>" kicked off for "<Component2>" under flow context
    #When User clicks on the "<AccessWorkflow>" and clicks on open in operation view
    #Then User successfully navigates to the workflow in flow designer
    #And User validates the Path Comp workflow kicked off
    #When User open the "< path comp workflow>" in flow designer
    #And User navigates to the path comp mesh action
    #Then User validates the device and port details of mesh response
    #And User validates the workflow "<path comp workflow>" completed successfully
    #When User navigates to the customer order page
    #When User navigates to order tasks section of "<Component2>"
    #Then User validates the layer 1 task kicked off time
    #When User navigates to the flow designer
    #When User open the "< layer1 workflow>" in flow designer
    #Then User validates the Create UNI action completed successfully
    #When User navigates to order tasks section of "<Component2>"
    #When User navigates to the customer order page
    #And User navigates to the service order enrichment tab
    #Then User validates the port service alias updated successfully
    #And User navigates to the order line "<Component3>" Item
    #Then User successfully navigated to order line "<Component3>" Item
    #When User navigates to product order section of Internet Service
    #Then User validates the "<InternetWorkflow>" kicked off for "<Component3>" under flow context
#
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | tasknum                          | contact       | Component1                | DIAWorkflow                   | Component2     | AccessWorkflow             | Component3       | InternetWorkflow           | diaTasksName1    | diaTasksName2         | diaTasksName3            | diaTasksName4           | diaTasksName5 |
      #| Costco Wholesale Corporation |     2 | LTTNCOML | Floor 1 Room LAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada | Dedicated Internet Access | LMN-ORCH-DIA-Order Validation | Access Service | LMN-ORCH-SOM-Discover Path | Internet Service | LMN-ORCH-DIA-IP Assignment | Order Validation | Customer Coordination | Gather Order Details TDE | LMN-SOM-Initiate TDG-MS | TDG SLA Timer |
#
  #@DIA_SNOW_E2E_Off
  #Scenario Outline: DIA Offnet Order submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #When User submitted the order to DOP
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User successfully get the order records
    #When User logs in Snow application
    #Then User successfully logged in snow application
    #When User navigate to customer orders submodule
    #Then User succesfully landed to customer orders submodule
    #When User search the order in customer orders submodule
    #Then successfully displayed the searched order records
    #When User clicks on Customer order
    #Then User successfully landed to order deatils
    #When User clicks on show related items link
    #When User clicks on related order entities
    #Then User successfully validates the SM id, Opportunity Id
    #When User navigates to the order line "<Component1>" Item
    #Then User successfully navigated to order line "<Component1>" Item
    #When User navigates to product order section of DIA
    #Then User validates the "<DIAWorkflow>" kicked off for "<Component1>" under flow context
    #When User clicks on the "<DIAWorkflow>" and clicks on open in operation view
    #Then User successfully navigates to the workflow in flow designer
    #Then User validates the workflow "<DIAWorkflow>" is waiting for TDG task
    #When User navigates to order tasks section of "<Component1>"
    #When User navigates to the customer order page
    #And User fillup the tdg records for "<Offnet>" order
    #And User navigates to gather_order_details tab
    #And fillup the access type and access subtype details under tdg form
    #And enters the details for IP subnets and save it]
    #And enters the details for transport access and save it
    #And user navigates back to customer order page
    #When User navigates to the order line "<Component1>" Item
    #Then User successfully navigated to order line "<Component1>" Item
    #When User enters characteristic values for order line "<Component1>" Item
    #When User navigates to order tasks section of "<Component1>"
    #Then User validates "<Gather Order Details TDE>" task is open state
    #And User completes the "<Gather Order Details TDE>" task
    #Then User validates "<Gather Order Details TDE>" task is completed state
    #And User validates the order validation wait workflow status
    #When User navigates to order tasks section of "<Component1>"
    #Then User validates "<Order Validation>" task is open state
    #When User completes the "<Order Validation>" task
    #Then User validates "<Order Validation>" task is completed state
    #When User successfully navigates to the workflow in flow designer
    #Then User validates the workflow "<DIAWorkflow>" is waiting for credit check status
    #When User navigates to order tasks section of "<Component1>"
    #And user navigates back to customer order page
    #And User approve the credit check status
    #And User navigates to the order line "<Component1>" Item
    #And User successfully navigates to the workflow in flow designer
    #Then User validates the workflow "<DIAWorkflow>" is waiting for CCM Task
    #When User navigates to order tasks section of "<Component1>"
    #And User reload the order line item
    #Then User validates "<Customer Coordination>" task is open state
    #When User completes the "<Customer Coordination>" task
    #Then User validates "<Customer Coordination>" task is completed state
    #When User successfully navigates to the workflow in flow designer
    #Then User validates the workflow "<DIAWorkflow>" is waiting for IIQ task
    #And User validates the workflow "<DIAWorkflow>" completed successfully
    #When User navigates to order tasks section of "<Component1>"
    #And User navigates to the customer order page
    #And User navigates to the order line "<Component2>" Item
    #Then User successfully navigated to order line "<Component2>" Item
    #When User navigates to product order section of Access Service
    #Then User validates the "<AccessWorkflow>" kicked off for "<Component2>" under flow context
    #When User clicks on the "<AccessWorkflow>" and clicks on open in operation view
    #And User successfully navigates to the workflow in flow designer
    #Then User validates the workflow "<AccessWorkflow>" completed successfully
    #When User navigates to order tasks section of "<Component2>"
    #And User reload the order line item
    #Then User validates "<LMN-WFO-MVP-OffNet-MS>" task is open state
    #When User successfully navigates to the workflow in flow designer
    #And User open the flow "<*LMN WFO MVP OffNet>" in flow designer
    #Then User validates "<LMN WFO MVP OffNet>" flow waiting for "<Offnet Manual Design Template>" task
    #When User logs in flightdeck application
    #Then User validates the "<Offnet Manual Design Template>" task kicked off for order
    #When User enters the mandatory field and completes the task
    #And User successfully navigates to the workflow in flow designer
    #Then User validates "<Create Offnet Port>" subflow completed under "<LMN WFO MVP OffNet>" flow
    #And User validates the "<FOC Recieved>" task kicked off for order
    #When User successfully navigates to the workflow in flow designer
    #Then User successfully validates the "<LMN-WFO-MVP-OffNet>" is waiting for "<FOC Recieved>"
    #When User logs in EASE application
    #And User completes the asr tasks
    #Then User validates the workflow "<Offnet>" completed successfully
    #When User navigates to the customer order page
    #And User navigates to the service order enrichment tab
    #Then User validates the port service alias updated successfully
    #And User navigates to the order line "<Component3>" Item
    #Then User successfully navigated to order line "<Component3>" Item
    #When User navigates to product order section of Internet Service
    #Then User validates the "<InternetWorkflow>" kicked off for "<Component3>" under flow context
#
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | tasknum                          | contact       | Component1                | DIAWorkflow                   | Component2       | AccessWorkflow             | Component3       | InternetWorkflow           | diaTasksName1    | diaTasksName2         | diaTasksName3            | diaTasksName4           |
      #| Costco Wholesale Corporation |     2 | LTTNCOML | Floor 1 Room LAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada | Dedicated Internet Access | LMN-ORCH-DIA-Order Validation | Access - Off Net | LMN-ORCH-SOM-Discover Path | Internet Service | LMN-ORCH-DIA-IP Assignment | Order Validation | Customer Coordination | Gather Order Details TDE | LMN-SOM-Initiate TDG-MS |
#
  #@Simply45
  #Scenario Outline: TC-033-DIA Colorless Simply Onnet2 order submit to snow.
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
#
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom   | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName           | cpeProvider      | futureday | tasknum                          | contact       |
      #| Costco Wholesale Corporation |     2 | LFYTCOET | Floor 1 Room 3 | COLORADO | SL0003313633 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router     | CISCO C4431-ET-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |
#
  #@Prod
  #Scenario Outline: TC-033-DIA Colorless Simply Onnet order submit to snow.
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
#
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom       | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName           | cpeProvider      | futureday | tasknum                          | contact       |
      #| Costco Wholesale Corporation |     2 | FTCMCOQJ | Floor 1 Room TELCO | COLORADO | SL0003313633 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router     | CISCO C4431-ET-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |
#
  #@Simply1 
  #@TEST_EDPSF-4029
  #Scenario Outline: TC-033-DIA Colorless Simply Onnet order submit to snow.
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
#
    #Examples: 
      #| sAccount                     | pdays | faddress    | floorAndRoom | fstate   | fplcode      | smyproduct                | bandwidth                                 | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName           | cpeProvider      | futureday | tasknum                          | contact       |
      #| Costco Wholesale Corporation |     2 | BXELSDAES02 | Floor 1      | COLORADO | SL0003313633 | Dedicated Internet Access | Fast E - Ethernet Switched Access (1-100) | 100 Mbps           | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router     | CISCO C4431-ET-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |
#
  #@DIA_SNOW_TC_9 
  #@TEST_EDPSF-4139
  #Scenario Outline: TC-09-DIA Onnet Order with FastE bandwidth submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
#
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                 | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName | cpeProvider | futureday | tasknum                          | contact       |
      #| Costco Wholesale Corporation |     2 | LABBRMCO | Floor 1 Room LAB | COLORADO | PL0027228028 | Dedicated Internet Access | Fast E - Ethernet Switched Access (1-100) | 100 Mbps           | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             |                    |         |             |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |
#
  #|WHOLE FOODS MARKET SERVICES, INC.|     2 | 1092 CEDAR ST BENNETT CO 80102 USA       | Floor 1       |                | PL0000714932 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000)|1000 Mbps         |Flat Rate      | Standard Delivery - To the MPoE (Customer Provided) |        No       |1000 | 1000 |  36   |  No         |                                                     |                                          |                |  3        | Dedicated_Internet_Access_On_Net |Alex Yuen   |
  # --#2-WWGLDX
  #@DIA_SNOW_TC_8 
  #@TEST_EDPSF-4138
  #Scenario Outline: TC-08-DIA Onnet Order with 10GIGE bandwidth submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
#
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                      | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName | cpeProvider | futureday | tasknum                          | contact       |
      #| Costco Wholesale Corporation |     2 | LTTNCOML | Floor 1 Room LAB | COLORADO | PL0027228028 | Dedicated Internet Access | 10 GigE - Ethernet Switched Access (500-6,000) | 2000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             |                    |         |             |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |
#
  #|WHOLE FOODS MARKET SERVICES, INC.|     2 | 1092 CEDAR ST BENNETT CO 80102 USA       | Floor 1       |                | PL0000714932 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000)|1000 Mbps         |Flat Rate      | Standard Delivery - To the MPoE (Customer Provided) |        No       |1000 | 1000 |  36   |  No         |                                                     |                                          |                |  3        | Dedicated_Internet_Access_On_Net |Alex Yuen   |
  # --#2-WWGLDX
  #@DIA_SNOW_TC_7 
  #@TEST_EDPSF-4032
  #Scenario Outline: TC-07-SDWAN-Validate SDWAN with DIA order move to swift
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds sdwan product "<smyproduct>" "<accesstype>" "<access1>" "<bandwidth>" "<bill_method>" "<buildingExt>"
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
    #When User submitted the order to DOP
    #And User logs in DOP application
    #Then User successfully logged in DOP application
    #When User search the quotes in DOP
    #Then User validates the order move to swift
#
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom     | fstate   | smyproduct | accesstype               | access1      | bandwidth                                  | bill_method | buildingExt | futureday | tasknum    | contact       |
      #| Costco Wholesale Corporation |     2 | LABBRMCO | Floor 1 Room LAB | COLORADO | SD-WAN     | Dedicated Inernet Access | New or Swift | GigE - Ethernet Switched Access (50-1,000) | Flat Rate   | Standard    |         3 | SD-WAN-DIA | Andrew Parada |
#
  #@DIA_SNOW_TC_4 
  #@TEST_EDPSF-4134
  #Scenario Outline: TC-04-DIA Onnet with Building extension and Multiple logical Order submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
#
    #Examples: 
      #| sAccount                | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod   | buildingExt                                                | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName           | cpeProvider      | futureday | tasknum                          | contact     |
      #| Lumentum Operations LLC |     2 | LTTNCOML | Floor 1 Room LAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | See IP Logicals | Extended Delivery - To the Customer Suite (Lumen Provided) | Yes              | 1000 | 1000 |   36 | No             | Managed Router     | CISCO C4431-ET-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Chan |
#
  #| 2-QFRP5B |     2 |  700 W MINERAL AVE LITTLETON CO 80120 USA| Floor 1 Room 1| North Carolina | PL0000005093 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000)| 1000 Mbps        | Flat Rate     | Extended Delivery - To the Customer Suite (Lumen Provided)  |        Yes       |1000 | 1000 |  36   |         No   | Managed Router    |CISCO C4431-ET-01 |Level 3 Provided|  3        | Dedicated_Internet_Access_On_Net | Eric Brown   | Customer Order Id | 552003812 | Monarch  |
  #@Simply
  #Scenario Outline: TC-17-DIA Colorless Simply Onnet order submit to snow.
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
#
    #Examples: 
      #| sAccount                     | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName           | cpeProvider      | futureday | tasknum                          | contact       |
      #| Costco Wholesale Corporation |     2 | WVCYUTWX | Floor 1 Room MPOE | COLORADO | SL0003313633 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router     | CISCO C4431-ET-01 | Level 3 Provided |         3 | Dedicated_Internet_Access_On_Net | Andrew Parada |
#
  #@DIA_SNOW_TC_12
  #Scenario Outline: TC-12-DIA Offnet with ROC Order submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
    #And User adds managed service component to DIA order "<managedService>" "<managedServiceType>" "<kitName>" "<cpeProvider>"
    #And User submit the product configured
    #And User adds secenario data "<contact>" "<pdays>" "<floorAndRoom>"
#
    #Examples: 
      #| sAccount                | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | accessSolution  | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName | cpeProvider | futureday | tasknum                          | contact     |
      #| Lumentum Operations LLC |     2 | CLMBGABA | Floor 1 Room TELC | COLORADO | PL0031189037 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Firm Vendor Bid | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             |                    |         |             |         3 | Dedicated_Internet_Access_On_Net | Andrew Chan |
#
  #@DIA_Simple_Offnet 
  #@TEST_EDPSF-52272
  #Scenario Outline: TC-02-DIA Offnet Order submit to snow
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
      #| sAccount                | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName | cpeProvider | futureday | scenario          | contact     |
      #| Lumentum Operations LLC |     2 | BNNTCOAP | Floor 1 Room TELC | COLORADO | PL0031189037 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             |                    |         |             |         3 | DIA_Simple_Offnet | Andrew Chan |
#
  #|WHOLE FOODS MARKET SERVICES, INC.|     2 | 1092 CEDAR ST BENNETT CO 80102 USA       | Floor 1       |                | PL0000714932 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000)|1000 Mbps         |Flat Rate      | Standard Delivery - To the MPoE (Customer Provided) |        No       |1000 | 1000 |  36   |  No         |                                                     |                                          |                |  3        | Dedicated_Internet_Access_On_Net |Alex Yuen   |
  # --#2-WWGLDX
  #@DIA_Offnet_Wave 
  #@TEST_EDPSF-52282
  #Scenario Outline: TC-10-DIA Offnet wave bandwidth Order submit to snow
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
      #| sAccount                | pdays | faddress | floorAndRoom     | fstate   | fplcode      | smyproduct                | bandwidth                                 | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | scenario        | contact     |
      #| Lumentum Operations LLC |     2 | LSAHCAXP | Floor 4 Room MMR | COLORADO | PL0027228028 | Dedicated Internet Access | 10 Gig LanWave - Wave Access (500-10,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | DIA_Offnet_Wave | Andrew Chan |
#
  #@DIA_Offnet_GPOM 
  #@TEST_EDPSF-52283
  #Scenario Outline: TC-11-DIA Offnet GPOM Order submit to snow
    #Given User is in SFA url
    #When User logs in as a "Valid" user
    #And User creates an Opportunity "<sAccount>" <pdays> "<scenario>"
    #And User creates a Secenario
    #And User adds one valid locations with floor "<faddress>" "<floorAndRoom>" "<fstate>" "<fplcode>"
    #And User adds dia product "<smyproduct>" "<bandwidth>" "<accessSubbandwidth>" "<accessSolution>" "<billingMethod>" "<buildingExt>" "<multipleLogicals>" "<pdr>" "<cdr>" "<term>"
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
      #| sAccount                | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | accessSolution                                                                                                     | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName | cpeProvider | futureday | scenario        | contact     |
      #| Lumentum Operations LLC |     2 | CLMBGABA | Floor 1 Room TELC | COLORADO | PL0031189037 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Level 3 - BELLSOUTH TELECOMM INC - GA -> Level3 - 1000 - 1000 - Best Effort - Pt-Pt - ILEC - USD - $656.25 - $0.00 | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             |                    |         |             |         3 | DIA_Offnet_GPOM | Andrew Chan |
#
  #@DIA_Affiliate_Wave 
  #@TEST_EDPSF-75752
  #Scenario Outline: TC-16-DIA Affiliate Wave Order submit to snow
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
      #| sAccount                | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                 | accessSubbandwidth | billingMethod | buildingExt                                         | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType | kitName           | cpeProvider      | futureday | scenario      | contact     |
      #| Lumentum Operations LLC |     2 | SLKCUTSC | Floor 1 Room 9999 | COLORADO | SL0003313633 | Dedicated Internet Access | 10 Gig LanWave - Wave Access (500-10,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router     | CISCO C4431-ET-01 | Level 3 Provided |         3 | DIA_Affiliate | Andrew Chan |
#
  #@DIA_ALL
  #Scenario Outline: DIA Order submit to snow
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
      #| sAccount         | pdays | faddress | floorAndRoom      | fstate   | fplcode      | smyproduct                | bandwidth                                  | accessSubbandwidth | billingMethod | buildingExt                                                | multipleLogicals | pdr  | cdr  | term | managedService | managedServiceType                                  | kitName                                   | cpeProvider      | futureday | scenario              | contact   |
      #| Boyd Gaming Corp |     2 | DNVFCOQE | Floor 5 Room WLAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided)        | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | DIA_Simple_Onnet      | Andy Cruz |
      #| Lumentum Operations LLC     |     2 | BNNTCOAP | Floor 1 Room TELC | COLORADO | PL0031189037 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             |                                                     |                                           |                  |         3 | DIA_Simple_Offnet    | Andrew Chan   |
      #| Boyd Gaming Corp |     2 | ATLA134O | Floor 1 Room LL10 | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided)        | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | DIA_Onnet_ASRI_Manual | Andy Cruz |
      #| Boyd Gaming Corp |     2 | NWYK36G2 | Floor 43 Room MDF | NEWYORK  | PL0027228028 | Dedicated Internet Access | 10 Gig LanWave - Wave Access (500-10,000)  | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided)        | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | DIA_Onnet_Wave        | Andy Cruz |
      #| Boyd Gaming Corp |     2 | DNVFCOQE | Floor 5 Room WLAB | COLORADO | PL0031189037 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Extended Delivery - To the Customer Suite (Lumen Provided) | No               | 1000 | 1000 |   36 | No             |                                                     |                                           |                  |         3 | DIA_Onnet_With_BE     | Andy Cruz |
      #| Lumentum Operations LLC      |     2 | LSAHCAXP | Floor 4 Room MMR  | COLORADO | PL0027228028 | Dedicated Internet Access | 10 Gig LanWave - Wave Access (500-10,000)  | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided) | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | DIA_Offnet_Wave      | Andrew Chan   |
      #| Boyd Gaming Corp |     2 | SLKCUTSC | Floor 1 Room 9999 | COLORADO | SL0003313633 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided)        | No               | 1000 | 1000 |   36 | No             | Managed Router                                      | CISCO C4431-ET-01                         | Level 3 Provided |         3 | DIA_Affiliate         | Andy Cruz |
      #| Boyd Gaming Corp |     2 | DNVFCOQE | Floor 5 Room WLAB | COLORADO | PL0027228028 | Dedicated Internet Access | GigE - Ethernet Switched Access (50-1,000) | 1000 Mbps          | Flat Rate     | Standard Delivery - To the MPoE (Customer Provided)        | No               | 1000 | 1000 |   36 | No             | Managed Router and Managed Integrated Access Device | CISCO C4451X-ET-01 and CISCO C4451X-T1-01 | Level 3 Provided |         3 | DIA_Headless          | Andy Cruz |
