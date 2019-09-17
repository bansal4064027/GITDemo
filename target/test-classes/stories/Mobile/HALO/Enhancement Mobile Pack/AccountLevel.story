Story: Account Creation
Meta:@AccountLevelStoy
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account


Scenario: AccCreation-001 consumer account creation-lead capture view 
Meta:@AccCreation-001
@FolderName AccCreation-001
@Pushkar
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'

Scenario: AccCreation-002 Sole trader account creation-lead capture view 
Meta:@AccCreation-002
@FolderName AccCreation-002
@Pushkar
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'SoleTraderOUI'

Scenario: AccCreation-003 Small Business account creation-lead capture view 
Meta:@AccCreation-003
@FolderName AccCreation-003
@Pushkar
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'LtdCompany'

Scenario: AccCreation-004 Anonymous account creation 
Meta:@AccCreation-004
@FolderName AccCreation-004
@Pushkar
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Charity'

Scenario: AccCreation-005 Consumer account-adding personal details 
Meta:@AccCreation-005
@FolderName AccCreation-005
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
When Fill the About the customer detail 'Consumer'


Scenario: AccCreation-006 Anonymous account creation 
Meta:@AccCreation-006
@FolderName AccCreation-006
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'AnonymousOUI'

Scenario: AccCreation-007 Sole Trader account-adding personal details 
Meta:@AccCreation-007
@FolderName AccCreation-007
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'SoleTraderOUI'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
When Fill the About the customer detail 'SoleTraderOUI'

Scenario: AccCreation-008 Small Business account-adding personal details 
Meta:@AccCreation-008
@FolderName AccCreation-008
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Partnership'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
When Fill the About the customer detail 'Partnership'

Scenario: AccCreation-009 Onilne Account creation via SIEBEL 
Meta:@AccCreation-009
@FolderName AccCreation-009
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI online account type 'PostpaidConsumerOnlineOUI'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
When Fill the About the customer detail 'PostpaidConsumerOnlineOUI'

Scenario: AccSearch-002 Account search via advanced search option
Meta:@AccSearch-002
@FolderName AccSearch-002
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'AdvanceSearch' ''

Scenario: AccSearch-001 Account search
Meta:@AccSearch-001
@FolderName AccSearch-001
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'SearchByTelNum' ''
When Search The OUI Account 'SearchBySIM' ''
When Search The OUI Account 'SearchByIMEI' ''


Scenario: AccManagementAdress-003 Change/Edit Address - Manually 
Meta:@AccManagementAdress-003
@FolderName AccManagementAdress-003
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'ConsumerManualAddress'




Scenario: AccManagementAdress-002 Change/Edit Address - Postcode 
Meta:@AccManagementAdress-002
@FolderName AccManagementAdress-002
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'

Scenario: AccManagementAdress-005 Change billing profile 
Meta:@AccManagementAdress-005
@FolderName AccManagementAdress-005
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
When Fill the About the customer detail 'Consumer'
When Change Payment method for 'BillMeToDirectDebit'

Scenario: AccLogin02 Login check for Call Center Agent 
Meta:@AccLogin02
@FolderName AccLogin02
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'

Scenario: AccLogin03 Login Check for SMB. 
Meta:@AccLogin03
@FolderName AccLogin03
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'VFREDUSR' in 'Env'

Scenario: AccLogin04 Login check for FUT 
Meta:@AccLogin04
@FolderName AccLogin04
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'



Scenario: AccManagementAdress-001 Add Address 
Meta:@AccManagementAdress-001
@FolderName AccManagementAdress-001
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'AnonymousOUI'
And Update Promotion 'PrepaidPackage' for 'AddHandsetPrepay' in OUI
And Fill the About the customer detail 'AnonymousOUI'
When ReLogin with 'TEST_RETAIL_1' in 'Env'
And Create OUI account type 'Consumer'
And Update Promotion 'PrepaidPackage' for 'AddHandsetPrepay' in OUI
And Create Personal Detail and Adress for 'Consumer'


Scenario: AccManagementDPA-006 CCheck DPA - PIN & Memorable word
Meta:@AccManagementDPA-006
@FolderName AccManagementDPA-006
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'ConsumerOnlinewithMemorableWord'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform DPA validation for 'DPAPIN'
When ReLogin with 'TEST_RETAIL_1' in 'Env'
And Search The OUI Account 'AdvanceSearch' ''
Then Perform DPA validation for 'DPAMemorableWord'




Scenario: AccManagementDPA-007 Check DPA - OTAC
Meta:@AccManagementDPA-007
@FolderName AccManagementDPA-007
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerOnlineAccount'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform DPA validation for 'OTACValidationPassed'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform DPA validation for 'OTACValidationFailed'


Scenario: AccManagementDPA-008 Check DPA- Security questions - PAYG
Meta:@AccManagementDPA-008
@FolderName AccManagementDPA-008
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform DPA validation for 'SecurityQuestionPAYGPass'
When ReLogin with 'TEST_RETAIL_1' in 'Env'
And Search The OUI Account 'AdvanceSearch' ''
Then Perform DPA validation for 'SecurityQuestionPAYGFail'


Scenario: AccManagementDPA-009 Check DPA- Security questions - PAYM
Meta:@AccManagementDPA-009
@FolderName AccManagementDPA-009
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform DPA validation for 'SecurityQuestionPAYMPass'
When ReLogin with 'TEST_RETAIL_1' in 'Env'
And Search The OUI Account 'AdvanceSearch' ''
Then Perform DPA validation for 'SecurityQuestionPAYMFail'


Scenario: ContactManagementDPA05 Account Permissions 
Meta:@ContactManagementDPA05
@FolderName ContactManagementDPA05
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'AddNewContact'


Scenario: ContactManagementDPA04 Remove Contact
Meta:@ContactManagementDPA04
@FolderName ContactManagementDPA04
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'AddNewContact'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'DeleteContact'


Scenario: ContactManagementDPA06 Change contact
Meta:@ContactManagementDPA06
@FolderName ContactManagementDPA06
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'ChangeConatct'


Scenario: ContactManagementDPA01 Change PIN
Meta:@ContactManagementDPA01
@FolderName ContactManagementDPA01
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'ConsumerOnline'
And Create New Billing Profile 'NewPostpaid'
And Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'SetResetPIN'


Scenario: ContactManagementDPA02 Add contact by searching existing
Meta:@ContactManagementDPA02
@FolderName ContactManagementDPA02
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'ExistingContact'


Scenario: ContactManagementDPA03 Add new contact by creating new
Meta:@ContactManagementDPA03
@FolderName ContactManagementDPA03
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'AddNewContact'


Scenario: ContactManagementDPA09 Change memorable hint or word
Meta:@ContactManagementDPA09
@FolderName ContactManagementDPA09
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'ConsumerOnline'
And Create New Billing Profile 'NewPostpaid'
And Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'SetResetMemorableword'



Scenario: ContactManagementDPA08 Update Email
Meta:@ContactManagementDPA08
@FolderName ContactManagementDPA08
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'ConsumerOnline'
And Create New Billing Profile 'NewPostpaid'
And Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'UpdateEmail'


Scenario: AccManagementAdress-004 Change memorable hint or word
Meta:@AccManagementAdress-004
@FolderName AccManagementAdress-004
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'ConsumerOnline'
And Create New Billing Profile 'NewPostpaid'
And Search The OUI Account 'AdvanceSearch' ''
Then Perform changes in Contacts scenario for 'SetResetPassword'


Scenario: BillCopy04 Email bill copy for account holder  email
Meta:@BillCopy04
@FolderName BillCopy04
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL1' in 'Env'
When Create the account type 'PostpaidConsumerOnline'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform Bill Copy for Scenario 'AccountHolderBillCopy'


Scenario: BillCopy03 Email bill copy for billling account email
Meta:@BillCopy03
@FolderName BillCopy03
@Vishwa
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL1' in 'Env'
When Create the account type 'PostpaidConsumerOnline'
And Create 'NewOrderNoPopUp' 'NewPostpaidWithEmail' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform Bill Copy for Scenario 'BillingProfileBillCopy'

Scenario: ContactManagementDPA07 Remove Email
Meta:@ContactManagementDPA07
@FolderName ContactManagementDPA07
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
When Fill the About the customer detail 'ConsumerCheckRemoveMail'

Scenario: ChangeCurrentServicePart2_04 HALO R1.1_Change Current Service_Part2_TS17_Change plan option_Blocking error will be displayed if the contact who has passed the DPA but has no permission of Account Owner or Level 0 or Level 1. 
Meta:@ChangeCurrentServicePart2_04
@FolderName ChangeCurrentServicePart2_04
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
Then Perform changes in Contacts scenario for 'AddNewContactforLevel2'
When Search The OUI Account 'GoToAccountLinkforPermissionLevel2' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ChangePlan'


Scenario: ChangeCurrentServicePart2_03 HALO R1.1_FL_Change Current Service_Part2_TS03_Change plan option_Blocking error will be displayed if the contact who has passed the DPA has no permission of Account Owner or Level 0 or Level 1. 
Meta:@FLChangeCurrentServicePart2_03
@FolderName FLChangeCurrentServicePart2_03
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'ConsFLADSL'
When Search The OUI Account 'GoToAccountLink' ''
Then Perform changes in Contacts scenario for 'AddNewContactforLevel2'
When Search The OUI Account 'GoToAccountLinkforPermissionLevel2' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ChangePlan'

Scenario: ChangeCurrentServicePart2_10 HALO R1.1_Change Current Service_Part2_TS26_Get blacklist history button_Condition for Enable Disable
Meta:@ChangeCurrentServicePart2_10
@FolderName ChangeCurrentServicePart2_10
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'CheckBlickListHistory'
Then Select Action from Product&Services Overview for 'CheckBlickListHistoryRoles'

Scenario: ChangeCurrentServicePart2_16 HALO R1.1_Change Current Service_Part2_TS33_‘LSG’ Unblacklist are only allowed by LSG agents_All other agents are blocked and cannot proceed with the order.
Meta:@ChangeCurrentServicePart2_16
@FolderName ChangeCurrentServicePart2_16
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'CheckBlickListHistory'
Then Select Action from Product&Services Overview for 'UnblackListLSG'


Scenario: ChangeCurrentServicePart2_15 HALO R1.1_Change Current Service_Part2_TS32_‘FRS‘  Unblacklist are only allowed by the FRS agents_Everyone else raises an SR.
Meta:@ChangeCurrentServicePart2_15
@FolderName ChangeCurrentServicePart2_15
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'CheckBlickListHistory'
Then Select Action from Product&Services Overview for 'UnblackListFRS'

Scenario: ChangeCurrentServicePart2_12 HALO R1.1_Change Current Service_Part2_TS29_Agent is Blocked from unblacklisting a device which has been blacklisted by Insurance team.
Meta:@ChangeCurrentServicePart2_12
@FolderName ChangeCurrentServicePart2_12
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'CheckBlickListHistory'
Then Select Action from Product&Services Overview for 'UnblackListLSG'


Scenario: BillingProfile&Details13 HALO R2.0_Billing Profile & Details_TS13_Check payment date modal
Meta:@BillingProfile&Details13
@FolderName BillingProfile&Details13
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'CheckBillPaymentDate'
