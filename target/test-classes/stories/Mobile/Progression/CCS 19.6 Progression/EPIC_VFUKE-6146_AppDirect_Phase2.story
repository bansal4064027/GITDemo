Story: Epic_6146
Meta:@Epic_6146
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account

Scenario: AppDirectPhase2_01 VFUKE-6146 AppDirect Integration- Phase 2A_TS01_New acquisition journey by adding standalone App Direct plan (111902)
Meta:@AppDirectPhase2_01
@FolderName AppDirectPhase2_01
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'LtdCompany'
And Update Promotion 'VCSMProduct111902' for 'AddAppDirectPromofromSoftware' in OUI
And Create Personal Detail and Adress for 'LtdCompany'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Check for Columns in 'CheckforAppDirectPromo'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order

Scenario: AppDirectPhase2_02 VFUKE-6146 AppDirect Integration- Phase 2A_TS02_New acquisition journey by adding  App Direct plan (111902) along with other postpay service
Meta:@AppDirectPhase2_02
@FolderName AppDirectPhase2_02
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'LtdCompany'
And Update Promotion 'VCSMProduct111902' for 'AddAppDirectPromofromSoftwareAndDonotNavigate' in OUI
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'LtdCompany'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
When Check for Columns in 'CheckforAppDirectPromo'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete


Scenario: AppDirectPhase2_03 VFUKE-6146 AppDirect Integration- Phase 2A_TS03_Validate that agent should not able to add App Direct service in order if 1 App Direct service already added into basket of same order
Meta:@AppDirectPhase2_03
@FolderName AppDirectPhase2_03
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidSmallBusiness'
When Search The OUI Account 'GoToAccountLinkforPermissionLevel0' ''
And Create New OUI Order
And Update Promotion 'VCSMProduct111902' for 'AddAppDirectPromofromSoftwareAndDonotNavigate' in OUI
And Update Promotion 'VCSMProduct111902' for 'AddSecondAppDirectPromValidatePopUpClickNext' in OUI
When Check for Columns in 'CheckforAppDirectPromo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete

Scenario: AppDirectPhase2_04 VFUKE-6146 AppDirect Integration- Phase 2A_TS04_Validate that agent should not able to add App Direct service in order if Owner Account already has an Active AppDirect service
Meta:@AppDirectPhase2_04
@FolderName AppDirectPhase2_04
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'VCSMProduct111902'
And Update ICCID against 'ValidateSequenceIDagainstVCSM'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The OUI Account 'GoToAccountLinkforPermissionLevel0' ''
And Create New OUI Order
And Update Promotion 'VCSMProduct111902' for 'AddSecondAppDirectPromValidatePopUp' in OUI

Scenario: AppDirectPhase2_05 VFUKE-6146 AppDirect Integration- Phase 2A_TS05_Validate that agent should not able to add App Direct service in order if an open order is already available with AppDirect product in the basket
Meta:@AppDirectPhase2_05
@FolderName AppDirectPhase2_05
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'SmallBusiness'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'VCSMProduct111902'
And Update ICCID against 'ValidateSequenceIDagainstVCSM'
And Reserve Order
And Perform Credit Vet
And Perform the Action 'PerformAboutRecord'
And Perform the AboutRecord
And Execute query 'AutoAssetforOpen1'
And Execute query 'AutoAssetforOpen2'
And Execute query 'AutoAssetforOpen3'
When Search The OUI Account 'GoToAccountLinkforPermissionLevel0' ''
And Create New OUI Order
And Update Promotion 'VCSMProduct111902' for 'AddSecondAppDirectPromValidatePopUp' in OUI

Scenario: AppDirectPhase2_06 VFUKE-6146 AppDirect Integration- Phase 2A_TS06_New acquisition journey by adding standalone App Direct plan (111902) on existing account
Meta:@AppDirectPhase2_06
@FolderName AppDirectPhase2_06
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidSmallBusiness'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'VCSMProduct111902' for 'AddAppDirectPromofromSoftware' in OUI
When Check for Columns in 'CheckforAppDirectPromo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: AppDirectPhase2_07 VFUKE-6146 AppDirect Integration- Phase 2A_TS07_New acquisition journey by adding  App Direct plan (111902) along with other postpay service on existing account
Meta:@AppDirectPhase2_07
@FolderName AppDirectPhase2_07
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidSoleTrader'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'VCSMProduct111902' for 'AddAppDirectPromofromSoftwareandDonotNavigate' in OUI
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
!-- And Create Personal Detail and Adress for 'LtdCompany'
When Check for Columns in 'CheckforAppDirectPromo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order

