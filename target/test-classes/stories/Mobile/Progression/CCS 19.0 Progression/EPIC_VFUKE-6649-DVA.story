Story: Epic_7346
Meta:@Epic_7346
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account

Scenario: CCS 19.0_VFUKE-6649_VFUS-1265_CRM-1168_CRM-842_Multi device_TS05_TC02_Enablement_Negative_Validate that Blocking message is displayed If the Used Location value is null for DVA subscription order associated with OPEN PAYM
Meta:@DVA007
@Rakesh
@FolderName DVA007
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The Account '7000430107'
And Create new order 'NewOrderNoPopUp'
And Promotion is added with 'AmazonDVAPackage'
And Update ICCID against 'OpenPopUpPrimaryInstalledID'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'SubmitSecondaryWithOpenPAYMPopUp'



Scenario: DVA014 CCS 19.0_VFUKE-6649_VFUS-1265_CRM-1168_CRM-842_Multi device_TS12_TC02_Enablement_Validate that billing or service account is changed for  Multi device Secondary DVA  and Multi device secondary mobile subscription  when 1 primary, 1 DVA and 1 Multi devi 
Meta:@DVA014
@Vishwa
@FolderName DVA014
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The Account ''
And Goto Sub Account
And Click New Billing Account
And Create only account type 'BillingAccountConsumer'
And Create New SubAccount Billing Profile 'NewPostpaid'
And Click New Service Account
And Create only account type 'ServiceAccount'
And Goto Account Summary
When Create new order 'NewOrderNoPopUp'
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Promotion is added with 'AmazonDVAPackage'
And Update ICCID against 'OpenPopUpPrimaryID'
And Update ICCID against 'OpenPopUpAddAddress'
And Promotion is added with 'SecondaryPromotion111279'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecordIndex1'
And Update ICCID against 'OpenPopUpPrimaryIDwithIndex'
And Select Menu 'PromotionEditPackage'
And Add Product 'OneNumberBandAppleWatch'
And Update ICCID against 'EnterEIDInAppleWatch'
And Update ICCID against 'EnterIMEIInAppleWatch'
And Retrieve Promotion 'AmazonDVAPackage'
And Update ICCID against 'OpenPopServiceAccount'
And Select Billing Serviceaccount 'ServiceAccount'
And Update ICCID against 'OpenPopBillingAccount'
And Select Billing Serviceaccount 'BillingAccount'
And Retrieve Promotion 'SecondaryPromotion111279'
And Update ICCID against 'OpenPopServiceAccountIndex'
And Select Billing Serviceaccount 'ServiceAccount'
And Update ICCID against 'OpenPopBillingAccountIndex'
And Select Billing Serviceaccount 'BillingAccount'
And Reserve Order
And Submit the Order 'SubmitForSecondarySubscriptionVerifyPopUp'
Then verify the Order line Items 'ServiceAccountCheck'
When Submit the Order 'Normal Submit'


Scenario: DVA024 Multi device_TS22_TC02_Enablement_Validate that agent should not be able to add same DVA product to an Primary subcription
Meta:@DVA024
@Payel
@FolderName DVA024
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionVolte'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Promotion is added with 'AmazonDVAPackage'
And Update ICCID against 'OpenPopUpPrimaryID'
And Update ICCID against 'OpenPopUpAddAddress'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'OneNumberPrimaryProductAdd'
When Retrieve Promotion 'AmazonDVAPackage'
Then verify the Order line Items 'PromotionAdd'
Then verify the Order line Items 'RootProduct0Add'
When Perform the CustomerAccount
When Create new order 'NewOrderNoPopUp'
And Promotion is added with 'AmazonDVAPackage'
And Update ICCID against 'OpenPopUpPrimaryInstalledID'
And Update ICCID against 'OpenPopUpAddAddress'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'ValidateDoubleDVANotAllowed'


Scenario: DVA028 CCS 19.0_VFUKE-6649_VFUS-1265_CRM-1168_CRM-842_Multi device_TS26_TC02_Enablement_Validate that error message is popped up if more than 2 DVA products and 2 primary subscription are added in a same order 
Meta:@DVA028
@Vishwa
@FolderName DVA028
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Promotion is added with 'AmazonDVAPackage'
And Update ICCID against 'OpenPopUpPrimaryID'
And Update ICCID against 'OpenPopUpAddAddress'
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecordIndex1'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSimIndex'
And Promotion is added with 'AmazonDVAPackage'
And Update ICCID against 'OpenPopUpPrimaryIDLoacteColwithIndex'
And Update ICCID against 'OpenPopUpAddAddressIndex'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'SubmitForMultiPrimarySubscriptionVerifyPopUp'






