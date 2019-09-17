Story: HALO DVT
Meta:@EnhancementMBB
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account
  
  
Scenario: EnhancementMBB_01 Validate that applet to display blocking pop up message about missing contact info is as per confluence for MBB/Gigacube new connection.
Meta:@EnhancementMBB_01
@FolderName EnhancementMBB_01
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'ConsumerWithoutContactNo'
And Update Promotion 'PostpaidPromotionMBB4G' for 'AddHandsetPostpayMBBPayG4GGigaCube' in OUI
And Create Personal Detail and Adress for 'ConsumerWithoutContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredYesPopUp'
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNextButtonOnlyYesPopUp'
And Create Personal Detail and Adress for 'ConsumerWithValidContactNo'
And Perform Credit Vet OUI for 'CreditVettingNextButtonOnlyNoPopUp'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order



Scenario: EnhancementMBB_02 Validate that when phone number of primary contact is updated then it can not be left blank and it starts from 07 or 447.
Meta:@EnhancementMBB_02
@FolderName EnhancementMBB_02
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumerWithValidContactNo'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionMBB4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'PostpaidPromotionMBB4G' for 'AddHandsetPostpayMBBPayG4GGigaCube' in OUI
And Create Personal Detail and Adress for 'ConsumerWithoutContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredYesPopUp'
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredYesPopUp'


Scenario: EnhancementMBB_03 Validate the new connection order of 30day GigaCube data plan 100GB(111317) on Consumer account from FUT division.
Meta:@EnhancementMBB_03
@FolderName EnhancementMBB_03
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'ConsumerWithValidContactNo'
And Update Promotion 'PostpaidPromotionGigaCubeMBB111317' for 'AddHandsetPostpayMBBPayG4GGigaCube' in OUI
And Create Personal Detail and Adress for 'ConsumerWithValidContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order



Scenario: EnhancementMBB_04 Validate the new connection order of 18mth GigaCube data plan 300GB(111353) on Consumer account from non FUT divisions.
Meta:@EnhancementMBB_04
@FolderName EnhancementMBB_04
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT01' in 'Env'
When Create OUI account type 'ConsumerWithValidContactNo'
And Update Promotion 'PostpaidPromotionGigaCube300GBMBB111353' for 'AddHandsetPostpayMBBPayG4GGigaCube' in OUI
And Create Personal Detail and Adress for 'ConsumerWithValidContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order



Scenario: EnhancementMBB_05 Validate the new connection order of SIMO dongle plan on Consumer account.
Meta:@EnhancementMBB_05
@FolderName EnhancementMBB_05
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'ConsumerWithValidContactNo'
And Update Promotion 'PostpaidPromotionMBB4G' for 'AddHandsetPostpayMBBPayGSearchByDevice' in OUI
And Create Personal Detail and Adress for 'ConsumerWithValidContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order



Scenario: EnhancementMBB_06 Validate the new connection order of tablet(111516 to 111547) plan on Consumer account.
Meta:@EnhancementMBB_06
@FolderName EnhancementMBB_06
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'ConsumerWithValidContactNo'
And Update Promotion 'PostpaidPromotionMBBforTablet' for 'AddTabletMBBviaSearchByDevice' in OUI
And Create Personal Detail and Adress for 'ConsumerWithValidContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'NoShipping'
And Update IMEI for 'EnterIMEIInApple' in OUI
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order



Scenario: EnhancementMBB_07 Validate the new connection order of dongle/mobile Wi-Fi(111548 to 111557) plan on Consumer account.
Meta:@EnhancementMBB_07
@FolderName EnhancementMBB_07
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'ConsumerWithValidContactNo'
And Update Promotion 'PostpaidBusinessPromo111553' for 'AddHandsetPostpayMBBPayG4GGigaCube' in OUI
And Create Personal Detail and Adress for 'ConsumerWithValidContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order




Scenario: EnhancementMBB_08 Validate the new connection order of mobile(PAYM/SIMO) plan on Consumer account
Meta:@EnhancementMBB_08
@FolderName EnhancementMBB_08
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'ConsumerWithoutContactNo'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'ConsumerWithoutContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order



Scenario: EnhancementMBB_09 Validate the new connection order of Fixed Line plan on Consumer account.
Meta:@EnhancementMBB_09
@FolderName EnhancementMBB_09
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'QP' in 'Env'
When Create OUI account type 'PostpaidConsumerFixLineNoContactNum'
And Get Address 'BlankStandardFTTH'
And Click on Fixed Line Check Avilibility for 'BlankStandardFTTH'
And Filter Promotion for Enhancement 'BlankStdFTTHGigafast100unlmtdBroad'
And Create Personal Detail and Adress for 'ConsumerWithoutContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Click on Generate New Number
And Click on Book Appointment
And Click on Terms and Condition
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order


Scenario: EnhancementMBB_010 Validate that the 50GB Data Extras product can be added to the Tactical Gigacube plans.
Meta:@EnhancementMBB_010
@FolderName EnhancementMBB_010
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'ConsumerWithValidContactNo'
And Update Promotion 'PostpaidPromotionGigaCubeMBB111317' for 'AddHandsetPostpayMBBPayG4GGigaCube' in OUI
And Create Personal Detail and Adress for 'ConsumerWithValidContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CustomiseNewMSISDN'
When Econfig Item 'Extra50GBDataWithOneOffCostON'
And Compare Line Items '50GBDataWithOneOffCostAdd'
And Order Details Capture in Order Summary page
And Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete


Scenario: EnhancementMBB_011 Validate the new connection order of 30day 4G GigaCube data plan 100 GB on Sole-Trader account.
Meta:@EnhancementMBB_011
@FolderName EnhancementMBB_011
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'SoleTraderOUIWithValidContactNo'
And Update Promotion 'GigaCube30Day4G100GB112004' for 'AddHandsetPostpayMBBPayG4GGigaCube' in OUI
And Create Personal Detail and Adress for 'ConsumerWithValidContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order


Scenario: EnhancementMBB_012 Validate the new connection order of 30day 4G GigaCube data plan 200 GB on Consumer account.
Meta:@EnhancementMBB_012
@FolderName EnhancementMBB_012
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'ConsumerWithValidContactNo'
And Update Promotion 'GigaCube30Day4G200GB112005' for 'AddHandsetPostpayMBBPayG4GGigaCube' in OUI
And Create Personal Detail and Adress for 'ConsumerWithValidContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order


Scenario: EnhancementMBB_013 Validate the new connection order of 30day 4G GigaCube data plan Unlimited on Small-Business account.
Meta:@EnhancementMBB_013
@FolderName EnhancementMBB_013
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'LtdCompanyWithValidContactNo'
And Update Promotion 'GigaCube30Day4GUnlimited112006' for 'AddHandsetPostpayMBBPayG4GGigaCube' in OUI
And Create Personal Detail and Adress for 'ConsumerWithValidContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order


Scenario: EnhancementMBB_014 Validate the new connection order of 18mth 4G GigaCube data plan 100 GB on Consumer account.
Meta:@EnhancementMBB_014
@FolderName EnhancementMBB_014
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'ConsumerWithValidContactNo'
And Update Promotion 'GigaCube18mth4G100GB112007' for 'AddHandsetPostpayMBBPayG4GGigaCube' in OUI
And Create Personal Detail and Adress for 'ConsumerWithValidContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order


Scenario: EnhancementMBB_015 Validate the new connection order of 18mth 4G GigaCube data plan 200 GB on Consumer account.
Meta:@EnhancementMBB_015
@FolderName EnhancementMBB_015
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'ConsumerWithValidContactNo'
And Update Promotion 'GigaCube18mth4G200GB112008' for 'AddHandsetPostpayMBBPayG4GGigaCube' in OUI
And Create Personal Detail and Adress for 'ConsumerWithValidContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order


Scenario: EnhancementMBB_016 Validate the new connection order of 18mth 4G GigaCube data plan Unlimited on Consumer account.
Meta:@EnhancementMBB_016
@FolderName EnhancementMBB_016
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'ConsumerWithValidContactNo'
And Update Promotion 'GigaCube18mth4GUnlimited112009' for 'AddHandsetPostpayMBBPayG4GGigaCube' in OUI
And Create Personal Detail and Adress for 'ConsumerWithValidContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order



Scenario: EnhancementMBB_017 Validate the new connection order of 30day 5G GigaCube data plan 100 GB on Consumer account.
Meta:@EnhancementMBB_017
@FolderName EnhancementMBB_017
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'ConsumerWithValidContactNo'
And Update Promotion 'GigaCube30Day5G100GB112010' for 'AddHandsetPostpayMBBPayG5GGigaCube' in OUI
And Create Personal Detail and Adress for 'ConsumerWithValidContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order


Scenario: EnhancementMBB_018 Validate the new connection order of 30day 5G GigaCube data plan 200 GB on Consumer account.
Meta:@EnhancementMBB_018
@FolderName EnhancementMBB_018
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'ConsumerWithValidContactNo'
And Update Promotion 'GigaCube30Day5G200GB112011' for 'AddHandsetPostpayMBBPayG5GGigaCube' in OUI
And Create Personal Detail and Adress for 'ConsumerWithValidContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order


Scenario: EnhancementMBB_019 Validate the new connection order of 30day 5G GigaCube data plan Unlimited on Consumer account.
Meta:@EnhancementMBB_019
@FolderName EnhancementMBB_019
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'ConsumerWithValidContactNo'
And Update Promotion 'GigaCube30Day5GUnlimited112012' for 'AddHandsetPostpayMBBPayG5GGigaCube' in OUI
And Create Personal Detail and Adress for 'ConsumerWithValidContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order



Scenario: EnhancementMBB_020 Validate the new connection order of 18mth 5G GigaCube data plan 200 GB on Consumer account.
Meta:@EnhancementMBB_020
@FolderName EnhancementMBB_020
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'ConsumerWithValidContactNo'
And Update Promotion 'GigaCube18mth5G200GB112014' for 'AddHandsetPostpayMBBPayG5GGigaCube' in OUI
And Create Personal Detail and Adress for 'ConsumerWithValidContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order


Scenario: EnhancementMBB_021 Validate the new connection order of 18mth 5G GigaCube data plan Unlimited on Small-SME account.
Meta:@EnhancementMBB_021
@FolderName EnhancementMBB_021
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'LtdCompanyWithValidContactNo'
And Update Promotion 'GigaCube18mth5GUnlimited112015' for 'AddHandsetPostpayMBBPayG5GGigaCube' in OUI
And Create Personal Detail and Adress for 'ConsumerWithValidContactNo'
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardAuthorisepaymentAndSettlewithCVV' and Confirm Order


Scenario: EnhancementMBB_022 Validate that the 10GB Data Extras product can be added to the Strategic Gigacube plans.
Meta:@EnhancementMBB_022
@FolderName EnhancementMBB_022
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CustomiseNewMSISDN'
When Econfig Item '10GBAdditionalDataOn'
And Compare Line Items '10GBAdditionalDataAdd'
And Order Details Capture in Order Summary page
And Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete


Scenario: EnhancementMBB_023 Validate that the optional products can be deleted from the Strategic Gigacube plans.
Meta:@EnhancementMBB_023
@FolderName EnhancementMBB_023
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CustomiseNewMSISDN'
When Econfig Item '10GBAdditionalDataOff'
And Compare Line Items '10GBAdditionalDataDelete'
And Order Details Capture in Order Summary page
And Confirm Order
When Search The Account ''
And Create new order 'NoNewNoPopUp'
Then Check Order Status till Complete


Scenario: EnhancementMBB_024 Validate that the excluded products cannot be added to the Strategic Gigacube plans.
Meta:@EnhancementMBB_024
@FolderName EnhancementMBB_024
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CustomiseNewMSISDN'
When Econfig Item 'RedSharerExcludedProduct'


Scenario: EnhancementMBB_025 Validate that the mandatory products can not be deleted from the Strategic Gigacube plans.
Meta:@EnhancementMBB_025
@FolderName EnhancementMBB_025
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'CustomiseNewMSISDN'
When Econfig Item '4GOff'

Scenario: EnhancementMBB_026 Validate the new connection order of 30day GigaCube data plan 100GB(111317) on Consumer account from FUT division.
Meta:@EnhancementMBB_026
@FolderName EnhancementMBB_026
@Bushra
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT01' in 'Env'
When Create OUI account type 'ConsumerWithValidContactNo'
And Update Promotion 'PostpaidPromotionGigaCubeMBB111317' for 'AddHandsetPostpayMBBPayG4GGigaCube' in OUI
