Story: Epic_8331
Meta:@Epic_8331
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account


Scenario: BarclaysRecurringFlag003 CCS 17.0_VFUKE-1314_TC07_Validation of Authorise request structure for Secure Voice authorisation when a new Postpaid Billing profile is created with Credit/Debit Card-Enhanced.
Meta:@BarclaysRecurringFlag003
@FolderName BarclaysRecurringFlag003
@Rakesh
Given Place screenshots in Folder 'FolderName'
Given Login with 'LSG' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidCreditDebitCardAuthoriseAndSettleWithCVV' and click on Save Button


Scenario: BarclaysRecurringFlag004 CCS 17.0_VFUKE-1314_TC09_Validation of Authorise request structure for Secure Voice authorisation when a new Prepaid Billing profile is created with Credit/Debit Card-Enhanced.
Meta:@BarclaysRecurringFlag004
@FolderName BarclaysRecurringFlag004
@Rakesh
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
When Create Prepaid Billing Profile with 'Debit/Credit Card'
Then Billing Profiles validation for 'PrepayCredit/DebitCardThroughAuthoriseAndSettle'

Scenario: BarclaysRecurringFlag007 CCS 17.0_VFUKE-1314_TC18_Validation of Authorise request structure for Secure Voice authorisation when Credit or Debit Card is taken as ID proof under Identification check-Enhanced.
Meta:@BarclaysRecurringFlag007
@FolderName BarclaysRecurringFlag007
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'LSG' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Identification Type as 'CreditCard'


Scenario: CCS 17.0_VFUKE-1314_TC21_Validation of Authorise request structure for Secure Voice authorisation when the existing billing profile is changed-Enhanced.
Meta:@BarclaysRecurringFlag008
@Rakesh
@FolderName BarclaysRecurringFlag008
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerCreditCard'
Given Login with 'LSG' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
Then Billing Profiles validation for 'ChangeCredit/DebitCardThroughAuthoriseAndSettle'



Scenario: BarclaysRecurringFlag011 CCS 17.0_VFUKE-1314_TC27_Validation of Authorise request structure for Secure Voice authorisation in Service hierarchy flow -Enhanced.
Meta:@BarclaysRecurringFlag011
@FolderName BarclaysRecurringFlag011
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'LSG' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NoNextNewPostpaidCreditDebitCardAuthoriseAndSettleWithCVV' and click on Save Button
And Create Service Hierarchy Account for 'NewPayerWithCreditDebitAuthorise'


Scenario: BarclaysRecurringFlag020 CCS 17.0_VFUKE-1314_TC48_Validation of Authorise request structure for Secure Voice authorisation when a new Payment Line is created with Credit/Debit Card-Enhanced.
Meta:@BarclaysRecurringFlag020
@FolderName BarclaysRecurringFlag020
@Rakesh
Given Place screenshots in Folder 'FolderName'
Given Login with 'LSG' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVetAcceptHALO'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'OneOffPaymentCreditDebitCardAuthoriseAndSettle' and Confirm Order




