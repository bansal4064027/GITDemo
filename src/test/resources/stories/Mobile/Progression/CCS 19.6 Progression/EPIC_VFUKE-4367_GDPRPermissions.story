Story: Epic_4367
Meta:@Epic_4367
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account

Scenario: GDPRPermissions01 - CCS 19.6_VFUKE-4367_GDPR Permissions & Preferences_TS01_Enablement_New Contact_Validate that Contact permissions are displayed and editable for Non Minor Contact under Contacts screens.
Meta:@GDPRPermissions01
@Rakesh
@FolderName GDPRPermissions01
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search Username 'POSTRRR4433' on Outer Level Contact
When Update Account Level Marketting Permission 'CheckDoNotUseThirdPartySocialMediaAndAppsData' from contact view


Scenario: GDPRPermissions02 - CCS 19.6_VFUKE-4367_GDPR Permissions & Preferences_TS02_Enablement_New Contact_Validate that Contact permissions are displayed and editable for Non Minor Contact under Contact view of an Account.
Meta:@GDPRPermissions02
@Zeba
@FolderName GDPRPermissions02
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Validate Marketing Permission for 'AccountLevelMarketingPermissionValidationforNotMinor'

Scenario: GDPRPermissions03 - CCS 19.6_VFUKE-4367_GDPR Permissions & Preferences_TS03_Enablement_New Contact_Validate that Contact permissions are not editable for Minor Contact under both Contacts screen and Contact view of an Account.
Meta:@GDPRPermissions03
@Zeba
@FolderName GDPRPermissions03
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumerMinor'
And Validate Marketing Permission for 'AccountLevelMarketingPermissionValidationforMinor'


Scenario: GDPRPermissions04 CCS 19.6_VFUKE-4367_GDPR Permissions & Preferences_TS04_Enhancement_New Contact_Validate that Contact permissions are displayed and editable for Non Minor Contact under Contact Management view.
Meta:@GDPRPermissions04
@Payel
@FolderName GDPRPermissions04
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PrepaidPackage' for 'AddPrepaidPromoOnly' in OUI
And Create Personal Detail and Adress for 'Consumer'
When Search The OUI Account 'GoToAccountLink' ''
Then Check Third Party Social Marketing Permission for '3rdPartyMarketingPermissionEditableforNonMinor'


Scenario: GDPRPermissions05 VFUKE-4367_GDPR Permissions & Preferences_TS05_Enhancement_New Contact_Validate that Contact permissions are displayed and are non editable for Minor Contact under Contact Management view
Meta:@GDPRPermissions05
@Payel
@FolderName GDPRPermissions05
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'MinorConsumer'
And Update Promotion 'PrepaidPackage' for 'AddPrepaidPromoOnly' in OUI
And Create Personal Detail and Adress for 'Consumer'
When Search The OUI Account 'GoToAccountLink' ''
Then Check Third Party Social Marketing Permission for '3rdPartyMarketingPermissionNotEditableforMinorwithDOBchange'

Scenario: GDPRPermissions06 CCS 19.6_VFUKE-4367_GDPR Permissions & Preferences_TS06_Enhancement_New Contact_Validate that Contact permissions are displayed and editable for Non Minor Contact under Service hierarchy  view for Payer / User account. 
Meta:@GDPRPermissions06
@FolderName GDPRPermissions06
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'NonMinor3rdPartyMarketingPermissionForNewPayer'

Scenario: GDPRPermissions07 CCS 19.6_VFUKE-4367_GDPR Permissions & Preferences_TS07_Enhancement_New Contact_Validate that Contact permissions are displayed and non editable for Minor Contact under Service hierarchy  view for Payer / User account. 
Meta:@GDPRPermissions07
@FolderName GDPRPermissions07
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'Minor3rdPartyMarketingPermissionForNewPayer'

Scenario: GDPRPermissions08 CCS 19.6_VFUKE-4367_GDPR Permissions & Preferences_TS08_Enhancement_New Contact_Validate that Contact / Service permissions are displayed and editable for Non Minor Contact under Order Summary view for new acquisition journey. 
Meta:@GDPRPermissions08
@FolderName GDPRPermissions08
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT01' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Perform Validations in Order Summary page for 'Validate3rdPartyForNonMinor'

Scenario: GDPRPermissions09 CCS 19.6_VFUKE-4367_GDPR Permissions & Preferences_TS09_Enhancement_New Contact_Validate that Contact / Service permissions are displayed and non editable for Minor Contact under under Order Summary view for new acquisition journey. 
Meta:@GDPRPermissions09
@FolderName GDPRPermissions09
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT01' in 'Env'
When Create OUI account type 'MinorConsumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'MinorConsumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Perform Validations in Order Summary page for 'Validate3rdPartyForMinor'

Scenario: GDPRPermissions10 - CCS 19.6_VFUKE-4367_GDPR Permissions & Preferences_TS12_Enablement_New Contact_Validate that Contact permissions non editable for Contacts having D.O.B. exaclty 14 under Contacts screens.
Meta:@GDPRPermissions10
@Rakesh
@FolderName GDPRPermissions10
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumerOnlineExact14YearsMinor'
And Validate Marketing Permission for 'AccountLevelMarketingPermissionValidationforMinor'



Scenario: GDPRPermissions11 - CCS 19.6_VFUKE-4367_GDPR Permissions & Preferences_TS01_Enablement_Existing Contact_Validate that Contact permissions are displayed and editable for Non Minor Contact under Contacts screens.
Meta:@GDPRPermissions11
@Zeba
@FolderName GDPRPermissions11
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
And Validate Marketing Permission for 'AccountLevelMarketingPermissionValidationforMinorExisting'


Scenario: GDPRPermissions12 - CCS 19.6_VFUKE-4367_GDPR Permissions & Preferences_TS02_Enablement_Existing Contact_Validate that Contact permissions are displayed and editable for Non Minor Contact under Contact view of an Account.
Meta:@GDPRPermissions12
@Zeba
@FolderName GDPRPermissions12
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The Account ''
When Validate Marketing Permission for 'AccountLevelMarketingPermissionValidationforNotMinor'


Scenario: GDPRPermissions14 CCS VFUKE-4367_GDPR Permissions & Preferences_TS07_Enhancement_Existing Contact_Validate that Contact permissions are displayed and editable for Non Minor Contact under Contact Management view
Meta:@GDPRPermissions14
@Payel
@FolderName GDPRPermissions14
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The OUI Account 'GoToAccountLink' ''
Then Check Third Party Social Marketing Permission for '3rdPartyMarketingPermissionEditableforNonMinor'


Scenario: GDPRPermissions15 VFUKE-4367_GDPR Permissions & Preferences_TS08_Enhancement_Existing Contact_Validate that Contact permissions are displayed and are non editable for Minor Contact under Contact Management view.
Meta:@GDPRPermissions15
@Payel
@FolderName GDPRPermissions15
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'AdvanceSearch' ''
Then Check Third Party Social Marketing Permission for '3rdPartyMarketingPermissionNotEditableforMinorwithDOBchange'




Scenario: GDPRPermissions16 CCS 19.6_VFUKE-4367_GDPR Permissions & Preferences_TS11_Enhancement_Existing Contact_Validate that Contact permissions are displayed and editable for Non Minor Contact under Service hierarchy  view for Payer / User account.
Meta:@GDPRPermissions16
@FolderName GDPRPermissions16
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ModifyUserPayer'
When Create Service Hierarchy Account for 'NonMinor3rdPartyMarketingPermissionForNewPayer'

Scenario: GDPRPermissions017 CCS 19.6_VFUKE-4367_GDPR Permissions & Preferences_TS12_Enhancement_Existing Contact_Validate that Contact permissions are displayed and non editable for Minor Contact under Service hierarchy  view for Payer / User account.
Meta:@GDPRPermissions017
@FolderName GDPRPermissions017
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Check Third Party Social Marketing Permission for 'ChangeDOBMinorForAccHolder'
When Search The OUI Account 'GoToAccountLink' ''
When Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ModifyUserPayer'
When Create Service Hierarchy Account for 'Minor3rdPartyMarketingPermissionForNewPayer'

