Story: AccManagementPayment
Meta:@AccManagementPayment
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account

Scenario: AccManagementPayment03 Siebel_Upgrade_Phase_2_TS07_TC01_Direct Debit billing profile creation
Meta:@AccManagementPayment03
@FolderName AccManagementPayment03
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidDirectDebit' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CashPopNO' and Confirm Order


Scenario: AccManagementPayment01 Siebel Upgrade Phase 2_Enhancement_TC120_Validate that agent performs authorize payment
Meta:@AccManagementPayment01
@FolderName
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order


Scenario: AccManagementPayment02 Siebel Upgrade Phase 2_Enhancement_TC120_Validate that agent performs authorize settle payment
Meta:@AccManagementPayment02
@FolderName
@Sumit
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order

