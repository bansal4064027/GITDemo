Story: Service Hierarchy In Life Mobile
Meta:@ServiceHierarchyInLifeStoryMobile
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account
  
Scenario: ServiceHierarchyLifeMob01 HALO R1.1_Change Service Hierarchy_TS01_Change Service Hierarchy S1_Owner A Payer A User A 
Meta:@ServiceHierarchyLifeMob01
@FolderName ServiceHierarchyLifeMob01
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ModifyUserPayer'
When Create Service Hierarchy Account for 'ValidateUserSameAsAccountName'
When Create Service Hierarchy Account for 'ValidatePayerSameAsAccountName'

Scenario: ServiceHierarchyLifeMob02 HALO R1.1_Change Service Hierarchy_TS02_Change Service Hierarchy S2_Owner A Payer A User C
Meta:@ServiceHierarchyLifeMob02
@FolderName ServiceHierarchyLifeMob02
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ModifyUserPayer'
When Create Service Hierarchy Account for 'AddExistingUser'
When Create Service Hierarchy Account for 'ValidatePayerSameAsAccountName'
And Click on Confirm Payer/User Button
And Submit the Changes and Capture Order Details

Scenario: ServiceHierarchyLifeMob03 HALO R1.1_Change Service Hierarchy_TS03_Change Service Hierarchy S3_Owner A Payer B User B
Meta:@ServiceHierarchyLifeMob03
@FolderName ServiceHierarchyLifeMob03
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ModifyUserPayer'
When Create Service Hierarchy Account for 'AddExistingPayer'
When Create Service Hierarchy Account for 'ValidateUserSameAsPayer'
And Click on Confirm Payer/User Button
And Submit the Changes and Capture Order Details

Scenario: ServiceHierarchyLifeMob04 HALO R1.1_Change Service Hierarchy_TS04_Change Service Hierarchy S5_Owner A Payer B User C
Meta:@ServiceHierarchyLifeMob04
@FolderName ServiceHierarchyLifeMob04
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ModifyUserPayer'
When Create Service Hierarchy Account for 'AddExistingPayer'
When Create Service Hierarchy Account for 'AddExistingUser'
And Click on Confirm Payer/User Button
And Submit the Changes and Capture Order Details

Scenario: ServiceHierarchyLifeMob05 HALO R1.1_Change Service Hierarchy_TS05_Modify payer and or user account option_Available 
Meta:@ServiceHierarchyLifeMob05
@FolderName ServiceHierarchyLifeMob05
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ValidateModifyUserPayerOptionPresentForViews'

Scenario: ServiceHierarchyLifeMob06 HALO R1.1_Change Service Hierarchy_TS06_Modify payer and or user account option_Insufficient permission level 
Meta:@ServiceHierarchyLifeMob06
@FolderName ServiceHierarchyLifeMob06
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'AddNewContactforLevel1'
When Search The OUI Account 'GoToAccountLinkforPermissionLevel1' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ModifyUserPayer'
When Click on Discard Changes Button
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'AddNewContactforLevel2'
When Search The OUI Account 'GoToAccountLinkforPermissionLevel2' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ModifyUserPayerforInsufficientFund'

Scenario: ServiceHierarchyLifeMob07 HALO R1.1_Change Service Hierarchy_TS07_Modify payer and or user account should be blocked for the service which already has pending orders_Continue with the Journey
Meta:@ServiceHierarchyLifeMob07
@FolderName ServiceHierarchyLifeMob07
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerPending'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ModifyUserPayerPending'
When Create Service Hierarchy Account for 'AddExistingPayer'
And Click on Confirm Payer/User Button
And Submit the Changes and Capture Order Details


Scenario: ServiceHierarchyLifeMob08 HALO R1.1_Change Service Hierarchy_TS08_Modify payer and or user account should be blocked for the service which already has pending orders_Discard the Journey
Meta:@ServiceHierarchyLifeMob08
@FolderName ServiceHierarchyLifeMob08
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerPending'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ModifyUserPayerPending'


Scenario: HALO R1.1_Change Service Hierarchy_TS10_Blocking error message should be displayed if the account selected from the payer pick applet has no billing profile or a prepaid billing profile 
Meta:@ServiceHierarchyLifeMob10
@FolderName ServiceHierarchyLifeMob10
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerMBB'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ModifyUserPayer'
When Create Service Hierarchy Account for 'AddExistingUser'
And Create Service Hierarchy Account for 'NoBillingProfileError'


Scenario: ServiceHierarchyLifeMob11 HALO R1.1_Change Service Hierarchy_TS11_Auto update user if payer is different and owner is same as user
Meta:@ServiceHierarchyLifeMob11
@FolderName ServiceHierarchyLifeMob11
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ModifyUserPayer'
When Create Service Hierarchy Account for 'AddExistingPayer'
When Create Service Hierarchy Account for 'ValidateUserSameAsPayer'
And Click on Confirm Payer/User Button
And Submit the Changes and Capture Order Details

Scenario: ServiceHierarchyLifeMob17 HALO R1.1_Change Current Service_Part1_TS16_User click e-configurator menu item ifor the selected service which already has one or more pending orders from 
Product & services overview – Owned Product & services applet 
Meta:@ServiceHierarchyLifeMob17
@FolderName ServiceHierarchyLifeMob17
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ServiceHierarchyChange'


Scenario: HALO R1.1_Change Service Hierarchy_TS12_Change Service Hierarchy S4_Owner A Payer B User A_INVALID_Blocking message should be displayed if user set invalid account hierarchy
Meta:@ServiceHierarchyLifeMob12
@FolderName ServiceHierarchyLifeMob12
@SumIT
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ModifyUserPayer'
When Create Service Hierarchy Account for 'AddExistingPayer'
When Create Service Hierarchy Account for 'SelectOwnerAsUserBlocked'


Scenario: HALO R1.1_Change Service Hierarchy_TS12_Change Service Hierarchy S5_Owner A Payer B User c_Payer and User Accounts address creation_Agent associate existing contact and adds another address in it
Meta:@ServiceHierarchyLifeMob16
@FolderName ServiceHierarchyLifeMob16
@SumIT
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'QP' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ModifyUserPayer'
When Create Service Hierarchy Account for 'AddExistingPayer'
And Create Service Hierarchy Account for 'AddExistingUser'
And Click on Confirm Payer/User Button
And Submit the Changes and Capture Order Details


Scenario: ServiceHierarchyLifeMob13 HALO R1.1_Change Service Hierarchy_TS13_Discard changes for modify service hierarchy journey
Meta:@ServiceHierarchyLifeMob13
@FolderName ServiceHierarchyLifeMob13
@Vaishnavi
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ModifyUserPayer'
When Click on Discard Changes Button


Scenario: ServiceHierarchyLifeMob14 HALO R1.1_Change Service Hierarchy_TS14_Progress bar for modify service hierarchy journey
Meta:@ServiceHierarchyLifeMob14
@FolderName ServiceHierarchyLifeMob14
@Vaishnavi
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ValidateModifyUserPayerOptionPresentForViews'


Scenario: ServiceHierarchyLifeMob15 HALO R1.1_Change Service Hierarchy_TS15_Change Service Hierarchy 
		  S5_Owner A Payer B User C_Payer and User accounts address creation_Agent creates new contact and
		  adds address in it
Meta:@ServiceHierarchyLifeMob15
@FolderName ServiceHierarchyLifeMob15
@Vaishnavi
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'ConsumerManualAddress'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMeNextButtonNO' and click on Save Button
When Create Service Hierarchy Account for 'NewPayer'
And Create Service Hierarchy Account for 'NewUser'
And Click on Next Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: HALO R1.1_Change Service Hierarchy_TS20_Agent is able to select one payer from Multi Payer Account and one user from Multi User account and proceed with the order 
Meta:@ServiceHierarchyLifeMob20
@FolderName ServiceHierarchyLifeMob20
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'AddMultiPayer'
And Create Service Hierarchy Account for 'AddMultiUser'
And Create Service Hierarchy Account for 'Select1PayerfromMultiPayer'
And Create Service Hierarchy Account for 'Select1UserfromMultiUser'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order