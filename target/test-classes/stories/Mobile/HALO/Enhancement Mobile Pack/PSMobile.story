Story: PS Mobile
Meta:@PSMobile
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account


Scenario: PSMobile01 HALO R1.0_Mobile_Product and services_TS02_New Connection Order on an Existing Account 
Meta:@PSMobile01
@FolderName PSMobile01
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
And Retrieve Promotion 'PostpaidPromotionSIMOfroEnhData'
Then Select Action from Product&Services Overview for 'PromotionActive'


Scenario: PSMobile02 HALO R1.0_Mobile_Product and services_TS05_Service S4 (Owner A Payer B User C)
Meta:@PSMobile02
@FolderName PSMobile02
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'NewPayer'
And Create Service Hierarchy Account for 'NewUser'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: PSMobile03 HALO R1.0_Mobile_Product and services_TS07_Display of Line Items under the Product & services line items across all the tabs (Owned, Billed, Used). 
Meta:@PSMobile03
@FolderName PSMobile03
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'ShowLineItems'
And Select Action from Billed Product and Services (Account Overview)'ShowLineItems'
And Select Action from Used Product and Services (Account Overview) 'ShowLineItems'
And Select Action from Used Product and Services (Account Overview) 'DrilldownMSISDN'
Then Perform Product Services line items validation for Owned product Services 'AllActive'
Then Perform Product Services line items validation for Owned product Services 'AllActiveinBilledView'
Then Perform Product Services line items validation for Owned product Services 'AllActiveinUsedView'


Scenario: PSMobile06 HALO R1.0_Mobile_Product and services_TS11_Perform additional actions through the available actions in dropdown for Owned Service. 
Meta:@PSMobile06
@FolderName PSMobile06
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'PerformAdditionalAction'


Scenario: PSMobile07 HALO R1.0_Mobile_Product and services_TS12_Check credit limit through the available actions in dropdown for Owned 
Meta:@PSMobile07
@FolderName PSMobile07
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'ChangeCreditLimit200'
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'CheckCreditLimit'
Then Select Action from Product&Services Overview for 'ChangeCreditLimit300'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CheckCreditLimitfor300'

Scenario: PSMobile08 HALO R1.0_Mobile_Product and services_TS13_Agent search through option Service type by providing a value to search on click of the binocular under Product & services details section 
Meta:@PSMobile08
@FolderName PSMobile08
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Billed Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'SearchByServiceType'

Scenario: PSMobile11 HALO R1.0_Mobile_Product and services_TS18_Display of Account Level Products 
Meta:@PSMobile11
@FolderName PSMobile11
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Billed Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'SearchForRootProductinOwnedView'
Then Select Action from Product&Services Overview for 'SearchForRootProductinBilledView'
Then Select Action from Product&Services Overview for 'SearchForRootProductinUsedView'

Scenario: PSMobile12 HALO R1.0_Mobile_Product and services_TS19_Agent to be shown with Include inactive button once they clicks on exclude inactive button 
Meta:@PSMobile12
@FolderName PSMobile12
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Billed Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'IncludeInactive'
Then Select Action from Product&Services Overview for 'ExcludeInactive'


Scenario: PSMobile13 HALO R1.0_Mobile_Product and services_TS21_Product and Service Overview_Actions for Owned Products & Services 
Meta:@PSMobile13
@FolderName PSMobile13
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'SIMActivities'
Then Select Action from Product&Services Overview for 'Topup'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'PerformAdditionalAction'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'Upgrade'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'CustomiseforValidation'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'SIMActivities'
Then Select Action from Product&Services Overview for 'CheckCreditLimit'
Then Select Action from Product&Services Overview for 'PerformAdditionalAction'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'CustomiseforValidation'
Given Retrieve Account 'PrepaidVOXIConsumer'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'SIMActivities'
Then Select Action from Product&Services Overview for 'CustomiseforValidation'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'PerformAdditionalAction'


Scenario: PSMobile14 HALO R1.0_Mobile_Product and services_TS22_Modify Order_ADD Product
Meta:@PSMobile14
@FolderName PSMobile14
@Tarun
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerExcludingDataBar'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'Customise'
And Econfig Item 'DataBarOn'
And Compare Line Items 'DataBarAdd'
And Order Details Capture in Order Summary page
And Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete



Scenario: PSMobile15 HALO R1.0_Mobile_Product and services_TS23_Modify Order_Remove Product
Meta:@PSMobile15
@FolderName PSMobile15
@Tarun
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerIncludingDataBar'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'Customise'
And Econfig Item 'DataBarOff'
And Compare Line Items 'DataBarDelete'
And Order Details Capture in Order Summary page
And Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete

Scenario: PSMobile22 [1]HALO R1.0_Mobile_Product and services_TS14_Agent search through option Name by providing a value to search on click of the binocular under Product & services details section 
Meta:@PSMobile22
@FolderName PSMobile22
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Billed Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'SearchByName'


Scenario: PSMobile23 [1]HALO R1.0_Mobile_Product and services_TS15_Agent search through option Installed ID by providing a value to search on click of the binocular under Product & services details section 
Meta:@PSMobile23
@FolderName PSMobile23
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'ConsFLADSL'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Billed Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'SearchByInstalledID'


Scenario: PSMobile24 HALO R1.0_Mobile_Product and services_TS20_Account Overview_Actions for Owned Products & Services 
Meta:@PSMobile24
@FolderName PSMobile24
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'SIMActivities'
And Select Action from Owned Product and Services (Account Overview)'Topup'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'PerformAdditionalAction'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'Upgrade'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CustomiseforValidation'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CheckCreditLimitforValidation'
And Select Action from Owned Product and Services (Account Overview)'SIMActivities'
And Select Action from Owned Product and Services (Account Overview)'PerformAdditionalAction'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CustomiseforValidation'
Given Retrieve Account 'PrepaidVOXIConsumer'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'SIMActivities'
And Select Action from Owned Product and Services (Account Overview)'CustomiseforValidation'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'PerformAdditionalAction'




