Story: SOU
Meta:@SOU
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account


Scenario: SOU02 15.0_SOU_6576_Contact Numbers hinting name field. 
Meta:@SOU02
@FolderName SOU02
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'HintCheck'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'HintCheck'
And Create Service Hierarchy Account for 'HintCheck'


Scenario: SOU03 15.0_SOU_7093_Customise Button is grayed out on the Guided sales process on products and services 
Meta:@SOU03
@FolderName SOU03
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Perform action for 'CustomiseButtonValidation' in OUI Product and Services page
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlanandDonotNavigate' in OUI
And Perform action for 'CustomiseButtonValidation' in OUI Product and Services page


Scenario: SOU04 15.0_SOU_6898_When an account has been manually created in Enabled unable to Modify via the Products & services tab. 
Meta:@SOU04
@FolderName SOU04
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerIncludingAdultContentBar'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'PerformAdditionalAction'
And Modify 'ModifyWithInstalledID' with Econfig Item 'AdtContCallsAndSMSOutgngOnlyBarOff'

Scenario: SOU05 15.0_SOU_6683_Postcode is case sensitive 
Meta:@SOU05
@FolderName SOU05
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'ValidateLowerCasePostCodeManually'
And Validate PostCode Case Sensitive for 'ValidateLowerCasePostCodeManually'
When ReLogin with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'ValidateLowerCasePostCodeBySearch'
And Validate PostCode Case Sensitive for 'ValidateLowerCasePostCodeBySearch'
Given Retrieve Account 'PrepaidConsumer'
When ReLogin with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Service Hierarchy Account for 'NewPayerCaseSensitivePostcodeValidation'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Click on Next Button
When Perform Fulfilment Status With 'ValidatePostCodeCaseSensitiveCollectFromStoreStock'



Scenario: SOU06 15.0_SOU_6684_Unable to amend years and months at an address onces saved 
Meta:@SOU06
@FolderName SOU06
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'AmmendTimeinAddress'


Scenario: SOU11 15.0_SOU_7091_Enhanced billing profile defaults to postpaid 
Meta:@SOU11
@FolderName SOU11
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ValidateBillingProfileForPrepay'
Given Retrieve Account 'PrepaidVOXIConsumer'
When ReLogin with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'ValidateBillingProfileForVoxi'

Scenario: SOU12 15.0_SOU_6795_When clicking on Mobile phone service hyperlink, agent is directed to Enabled customer summary view
Meta:@SOU12
@FolderName SOU12
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'ValidateHyperlinkNotPresentForRootProduct'

Scenario: SOU14 15.0_SOU_7089_Email SMS sent is incorrect
Meta:@SOU14
@FolderName SOU14
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Discard Order
When Search The Account ''
Then Validate Cust Comms Message 'UpFrontCostAndMonthlyCostEmailValidation'


Scenario: SOU15 15.0_SOU_7208_DTA_First line of customer address is editable 
Meta:@SOU15
@FolderName SOU15
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomerforAddressLineValidation'


Scenario: SOU16 15.0_SOU_7081_PAYG SIMO Promotions are not visible on searching by SKU ID in E7 environment
Meta:@SOU16
@FolderName SOU16
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PrepaidPackage' for 'AddSIMOPrepayandDonotNavigate' in OUI
And Update Promotion 'PrepaidPromotionMBB' for 'AddSIMOPrepay' in OUI

Scenario: SOU17 15.0_SOU_7176_Issue on Account payment line 
Meta:@SOU17
@FolderName SOU17
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'ConsumerManualAddress'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order