Story: GDPR
Meta:@GDPR
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account
  
  
Scenario: GDPR_ContactManagement01 HALO_GDPR_Contact Management - Existing account_DOB Greater Than16
Meta:@GDPR_ContactManagement01
@FolderName GDPR_ContactManagement01
@SumiT
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Perform changes in Contacts scenario for 'AddExistingMajorContact'



Scenario: GDPR_ContactManagement02 HALO_GDPR_Contact Management - Existing account_DOB Less Than 16
Meta:@GDPR_ContactManagement02
@FolderName GDPR_ContactManagement02
@SumiT
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Perform changes in Contacts scenario for 'AddExistingMinorContact'



Scenario: GDPR_ContactManagement03 HALO_GDPR_Contact Management - Existing account_DOB without DOB
Meta:@GDPR_ContactManagement03
@FolderName GDPR_ContactManagement03
@SumiT
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Perform changes in Contacts scenario for 'AddExistingWithoutDOBContact'



Scenario: GDPR_NewAqusition01 HALO_GDPR_New Aqusition -Existing  Customer_ 16yr 12day  - Over 16
Meta:@GDPR_NewAqusition01
@FolderName GDPR_NewAqusition01
@SumiT
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Perform changes in Contacts scenario for 'ChangeDOBforNotificationMajor'
When Search The OUI Account 'GoToAccountLink' ''
When Create New OUI Order
And Update Promotion 'SIMOPromotion111469' for 'AddPrepaidPromoOnly' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Notification check For Major




Scenario: GDPR_NewAqusition02 HALO_GDPR_New Aqusition -Existing  Customer_ 26 Yr
Meta:@GDPR_NewAqusition02
@FolderName GDPR_NewAqusition02
@SumiT
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Perform changes in Contacts scenario for 'ChangeDOBforNotificationMajor'
When Search The OUI Account 'GoToAccountLink' ''
When Create New OUI Order
And Update Promotion 'SIMOPromotion111469' for 'AddPrepaidPromoOnly' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Notification check For Major




Scenario: GDPR_NewAqusition03 HALO_GDPR_New Aqusition -Existing  Customer_Less Than 16 yr
Meta:@GDPR_NewAqusition03
@FolderName GDPR_NewAqusition03
@SumiT
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Perform changes in Contacts scenario for 'ChangeDOBforNotificationMinor'
When Search The OUI Account 'GoToAccountLink' ''
When Create New OUI Order
And Update Promotion 'SIMOPromotion111469' for 'AddPostpaid' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Notification check For Minor




Scenario: GDPR_NewAqusition06 HALO_GDPR_New Aqusition -New Customer_ 15 Yr - Over 16
Meta:@GDPR_NewAqusition06
@FolderName GDPR_NewAqusition06
@SumiT
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'ConsumerBTW'
When Update Promotion 'SIMOPromotion111469' for 'AddPostpaid' in OUI
And Create Personal Detail and Adress for 'ConsumerBTW'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Notification check For Minor


Scenario: GDPR_NewAqusition07 HALO_GDPR_New Aqusition -New Customer_ 16 Yr 12day  - Over 16
Meta:@GDPR_NewAqusition07
@FolderName GDPR_NewAqusition07
@SumiT
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
When Update Promotion 'SIMOPromotion111469' for 'AddPostpaid' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Notification check For Major


Scenario: GDPR_NewAqusition08 HALO_GDPR_New Aqusition -New Customer_ 26 Yr
Meta:@GDPR_NewAqusition08
@FolderName GDPR_NewAqusition08
@SumiT
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
When Update Promotion 'SIMOPromotion111469' for 'AddPostpaid' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Notification check For Major


Scenario: GDPR_NewAqusition09 HALO_GDPR_New Aqusition -New Customer_Less Than 16 yr
Meta:@GDPR_NewAqusition09
@FolderName GDPR_NewAqusition09
@SumiT
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'ConsumerMinor'
When Update Promotion 'SIMOPromotion111469' for 'AddPostpaid' in OUI
And Create Personal Detail and Adress for 'ConsumerMinor'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Notification check For Minor




Scenario: GDPR_NewAqusition10 HALO_GDPR_New Aqusition -New Customer_Without DOB - Over age
Meta:@GDPR_NewAqusition10
@FolderName GDPR_NewAqusition10
@SumiT
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Partnership'
When Update Promotion 'SIMOPromotion111469' for 'AddPostpaid' in OUI
And Create Personal Detail and Adress for 'Partnership'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Notification check For Major



Scenario: GDPR_NewAqusition11 HALO_GDPR_New Aqusition -New Customer_Without DOB -  Under age tick
Meta:@GDPR_NewAqusition11
@FolderName GDPR_NewAqusition11
@SumiT
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Partnership'
When Update Promotion 'SIMOPromotion111469' for 'AddPostpaid' in OUI
And Create Personal Detail and Adress for 'Partnership'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Notification check For Minor


Scenario: GDPR_Service Hirerchy01 HALO_GDPR_Service Hirerchy - Existing contact_DOB Greater Than16
Meta:@GDPR_Service Hirerchy01
@Manvi
@FolderName GDPR_ServiceHirerchy01
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ModifyUserPayer'
When Create Service Hierarchy Account for 'NewUser'
When Create Service Hierarchy Account for 'ValidatePayerSameAsAccountName'
And Click on Confirm Payer/User Button
And Submit the Changes and Capture Order Details
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
When Search The Account ''
And Validate account added in contacts table for 'ValidateUserAdded'



Scenario: GDPR_Service Hirerchy02 HALO_GDPR_Service Hirerchy - Existing contact_DOB Less Than 16
Meta:@GDPR_ServiceHirerchy02
@Payel
@FolderName GDPR_ServiceHirerchy02
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ModifyUserPayer'
When Create Service Hierarchy Account for 'NewUserwithMinorDOB'
When Create Service Hierarchy Account for 'ValidatePayerSameAsAccountName'
And Click on Confirm Payer/User Button
And Submit the Changes and Capture Order Details
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
When Search The Account ''
And Validate account added in contacts table for 'ValidateUserAdded'


Scenario: GDPR_ServiceHirerchy04 HALO_GDPR_Service Hirerchy - New contact_DOB Less Than 16 
Meta:@GDPR_ServiceHirerchy04
@FolderName GDPR_ServiceHirerchy04
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'NewPayer'
When Create Service Hierarchy Account for 'NewUserwithMinorDOB'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
When Search The Account ''
And Validate account added in contacts table for 'ValidateUserAdded'


Scenario: GDPR_ServiceHirerchy05 HALO_GDPR_Service Hirerchy - New contact_DOB Greater Than16
Meta:@GDPR_ServiceHirerchy05
@FolderName GDPR_ServiceHirerchy05
@Manvi
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'NewPayer'
When Create Service Hierarchy Account for 'NewUser'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete
When Search The Account ''
And Validate account added in contacts table for 'ValidateUserAdded'


Scenario: GDPR_ContactManagement04 HALO_GDPR_Contact Management - New_DOB 16
Meta:@GDPR_ContactManagement04
@FolderName GDPR_ContactManagement04
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'AddNewContactforGDPR16years'


Scenario: GDPR_ContactManagement05 HALO_GDPR_Contact Management - New_DOB Greater Than18
Meta:@GDPR_ContactManagement05
@FolderName GDPR_ContactManagement05
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'AddNewContactforGDPRLessThan16yrs'

Scenario: GDPR_ContactManagement06 HALO_GDPR_Contact Management - New_DOB Less Than 16
Meta:@GDPR_ContactManagement06
@FolderName GDPR_ContactManagement06
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'AddNewContactforGDPRLessThan16yrs'