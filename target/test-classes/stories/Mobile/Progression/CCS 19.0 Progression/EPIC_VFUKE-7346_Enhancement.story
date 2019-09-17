Story: Epic_7346
Meta:@Epic_7346
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account
  
Scenario: MultiDeviceRetrofit001 CCS 19.0_VFUKE-7346_VFUS-1341_CRM-918_Multi device Retrofit_Mobile_TS01_TC01_Validate that new connection Multi device secondary subscription with iWatch is placed on an active PAYM with wi-fi calling &4G
Meta:@MultiDeviceRetrofit001
@FolderName MultiDeviceRetrofit001
@Zeba	
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
When Perform One Number Validation for 'SelectActiveStatusMSISDN' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryOnHold'
When Check order in Account Overview Page for 'CheckModifyComplete'
When Check order in Account Overview Page for 'CheckSecondaryOpen'
When Check if Order has reached Dispatch Shipping Task in OSM
And Dispatch 'ESIM' order via FMW XML
Given Login with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryComplete'



Scenario: MultiDeviceRetrofit002 CCS 19.0_VFUKE-7346_VFUS-1341_CRM-918_Multi device Retrofit_Mobile_TS01_TC01_Validate that new connection Multi device secondary subscription with iWatch is placed on an active PAYM on which wi-fi calling &4G can be added optionally 
Meta:@MultiDeviceRetrofit002
@FolderName MultiDeviceRetrofit002
@Zeba	
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'RETAIL' in 'Env'
When Search The Account ''
And Modify 'ModifyWithInstalledID' with Econfig Item 'WiFiAnd4GCallingOff'
And Submit the Order 'Normal Submit'
Given Login with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
When Perform One Number Validation for 'SelectActiveStatusMSISDN' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryOnHold'
When Check order in Account Overview Page for 'CheckModifyComplete'
When Check order in Account Overview Page for 'CheckSecondaryOpen'
When Check if Order has reached Dispatch Shipping Task in OSM
And Dispatch 'ESIM' order via FMW XML
Given Login with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryComplete'



Scenario: MultiDeviceRetrofit003 CCS 19.0_VFUKE-7346_VFUS-1341_CRM-918_Multi device Retrofit_Mobile_TS01_TC01_Negative_Validate that new connection Multi device secondary subscription with iWatch is placed on an active PAYM without having wi-fi calling&4G
Meta:@MultiDeviceRetrofit003
@FolderName MultiDeviceRetrofit003
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TMTTAR' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion110154'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
Given Login with 'AGENT01' in 'Env'
When Search The Account ''
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
When Perform One Number Validation for 'ValidateNoMSISDNPresent'



Scenario: MultiDeviceRetrofit004 Multi device Retrofit_Mobile_TS01_TC01_Validate that Multi device primary(with wi-fi calling &4G) and secondary subscription are placed in same order
Meta:@MultiDeviceRetrofit004
@FolderName MultiDeviceRetrofit004
@Payel	
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlanandDonotNavigate' in OUI
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Perform 'AboutRecord' on Payment Method and Execute query 'Tokenization' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Retrieve Promotion 'PostpaidPromotion4G'
And Update MSISDN in OUI by performing 'UpdateMSISDN'
And Retrieve Promotion 'SecondaryPromotion111279'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
When Perform One Number Validation for 'SelectPendingStatusMSISDN' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'CreditDebitCardPreAuthorisepaymentwithCVV' and Confirm Order
And Check if Order has reached Dispatch Shipping Task in OSM
And Dispatch 'ESIM' order via FMW XML
When Check order in Account Overview Page for 'CheckPrimaryComplete'


Scenario: MultiDeviceRetrofit006 Multi device Retrofit_Mobile_TS01_TC01_Validate that new connection Multi device secondary subscription with iWatch is placed on an OPEN PAYM having wi-fi calling and 4G present on it
Meta:@MultiDeviceRetrofit006
@FolderName MultiDeviceRetrofit006
@Payel	
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create New 'NewPostpaid' and Perform 'AboutRecordOfMenuItem' with About Record
And Perform 'RunQueryOfMenuItem' and Execute query 'Tokenization' and Create New 'NewOrderNoPopUp' Order
And Promotion is added with 'PostpaidPromotion4G'
And Select Menu 'PromotionEditPackage'
And Add Product 'SpecificHandset080011'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterVodafoneSpendManagerOff'
And Order Fulfilment With 'ReserveYesPopUpYesWarehouse'
And Deliver for 'SelctRoyMl1stClssPostEntrPhNoNoPopUp'
And Make payment with 'CreditDebitCardAuthorisepaymentwithCVV'
When Reserve Order
And Perform Credit Vet
And Submit the Order 'SubmitandNoOrderCheck'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
When Perform One Number Validation for 'SelectOpenStatusMSISDN' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryOnHold'
When Check order in Account Overview Page for 'CaptureNewConnectionOrder'
When Check if Order has reached Dispatch Shipping Task in OSM
And Dispatch 'HandsetAndSIM' order via FMW XML
When Check order in Account Overview Page for 'CaptureNewConnectionOrder'
When Check order in Account Overview Page for 'CheckModifyComplete'
When Check order in Account Overview Page for 'CheckSecondaryOpen'
When Check if Order has reached Dispatch Shipping Task in OSM
And Dispatch 'ESIM' order via FMW XML
When Check order in Account Overview Page for 'CheckSecondaryComplete'


Scenario: MultiDeviceRetrofit010 CCS 19.0_VFUKE-7346_VFUS-1341_CRM-918_Multi device Retrofit_Mobile_TS01_TC01_Negative_Validate that Multi device secondary subscription is not allowed if the Primary has Fraud bar present on it.
Meta:@MultiDeviceRetrofit010
@FolderName MultiDeviceRetrofit010
@Ranju	
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT01' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Customise 'RootProduct' with Econfig Item 'FraudOnE2'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
And Perform One Number Validation for 'ValidateNoMSISDNPresent'


Scenario: MultiDeviceRetrofit013 Multi device Retrofit_Mobile_TS01_TC01_Negative_Validate that Multi device secondary subscription is not allowed on OPEN primary order if the order has CreditAlertABar present on it
Meta:@MultiDeviceRetrofit013
@FolderName MultiDeviceRetrofit013
@Payel	
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Customise 'RootProduct' with Econfig Item 'CreditAlertABarE2'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
When Perform 'PerformAboutRecord' on Order Number
And Execute query 'AutoAssetforOpen1'
And Execute query 'AutoAssetforOpen2'
And Execute query 'AutoAssetforOpen3'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
And Perform One Number Validation for 'ValidateNoMSISDNPresent'



Scenario: MultiDeviceRetrofit014 Multi device Retrofit_Mobile_TS01_TC01_Negative_Validate that Multi device secondary subscription is not allowed on OPEN primary order if the order has Stolen bar present on it
Meta:@MultiDeviceRetrofit014
@FolderName MultiDeviceRetrofit014
@Payel	
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Customise 'RootProduct' with Econfig Item 'StolenOnE2'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
When Perform 'PerformAboutRecord' on Order Number
And Execute query 'AutoAssetforOpen1'
And Execute query 'AutoAssetforOpen2'
And Execute query 'AutoAssetforOpen3'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
And Perform One Number Validation for 'ValidateNoMSISDNPresent'



Scenario: MultiDeviceRetrofit015 Multi device Retrofit_Mobile_TS01_TC01_Negative_Validate that Multi device secondary subscription is not allowed on OPEN primary order if the order has Fraud Bar present on it
Meta:@MultiDeviceRetrofit015
@FolderName MultiDeviceRetrofit015
@Payel	
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Customise 'RootProduct' with Econfig Item 'FraudOnE2'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
When Perform 'PerformAboutRecord' on Order Number
And Execute query 'AutoAssetforOpen1'
And Execute query 'AutoAssetforOpen2'
And Execute query 'AutoAssetforOpen3'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
And Perform One Number Validation for 'ValidateNoMSISDNPresent'



Scenario: MultiDeviceRetrofit016 CCS 19.0_VFUKE-7346_VFUS-1341_CRM-918_Multi device Retrofit_Mobile_TS01_TC01_Negative_Validate that Multi device secondary subscription is not allowed if the for an active  OneNet promotion
Meta:@MultiDeviceRetrofit016
@FolderName MultiDeviceRetrofit016
@Sayali	
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerWithOneNetService'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
And Perform One Number Validation for 'ValidateNoMSISDNPresent'



Scenario: MultiDeviceRetrofit017 CCS 19.0_VFUKE-7346_VFUS-1341_CRM-918_Multi device Retrofit_Mobile_TS01_TC01_Negative_Validate that Multi device secondary subscription is not allowed if the for an active Red+ Lead Sharer promotions.
Meta:@MultiDeviceRetrofit017
@FolderName MultiDeviceRetrofit017
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Customise 'RootProduct' with Econfig Item 'Red\+ LeaderOn'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
And Perform One Number Validation for 'ValidateNoMSISDNPresent'


Scenario: MultiDeviceRetrofit018 CCS 19.0_VFUKE-7346_VFUS-1341_CRM-918_Multi device Retrofit_Mobile_TS01_TC01_Negative_Validate that Multi device secondary subscription is not allowed if the for an active Red+ Sharer promotions
Meta:@MultiDeviceRetrofit018 
@FolderName MultiDeviceRetrofit018 -- need to change for sharer
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Customise 'RootProduct' with Econfig Item 'Red\+ LeaderOn'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
And Perform One Number Validation for 'ValidateNoMSISDNPresent'


Scenario: MultiDeviceRetrofit019 Multi device Retrofit_Mobile_TS01_TC01_Negative_Validate that 2nd secondary is not allowed if the first secondary is already in OPEN status.
Meta:@MultiDeviceRetrofit019
@FolderName MultiDeviceRetrofit019
@Payel	
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
When Perform One Number Validation for 'SelectActiveStatusMSISDN' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryOnHold'
When Check order in Account Overview Page for 'CheckModifyComplete'
When Check order in Account Overview Page for 'CheckSecondaryOpen'
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
When Perform One Number Validation for 'ValidateNoMSISDNPresent'


Scenario: MultiDeviceRetrofit011 CCS 19.0_VFUKE-7346_VFUS-1341_CRM-918_Multi device Retrofit_Mobile_TS01_TC01_Negative_Validate that Multi device secondary subscription is not allowed if the Primary has Stolen bar present on it.
Meta:@MultiDeviceRetrofit011
@FolderName MultiDeviceRetrofit011
@Ranju	
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT01' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Customise 'RootProduct' with Econfig Item 'StolenOnE2'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'SubmitForStolenBarAddJourney'
Then verify the Order line Items 'StolenBarAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveRootPStolenBarExist'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
When Perform One Number Validation for 'ValidateNoMSISDNPresent'




Scenario: MultiDeviceRetrofit012 CCS 19.0_VFUKE-7346_VFUS-1341_CRM-918_Multi device Retrofit_Mobile_TS01_TC01_Negative_Validate that Multi device secondary subscription is not allowed if the Primary has Credit Alert a bar present on it
Meta:@MultiDeviceRetrofit012
@FolderName MultiDeviceRetrofit012
@Ranju	
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotionVolte'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
And Submit the Order 'Normal Submit'
When Search The Account ''
And Modify 'ModifyWithInstalledIDFraudRiskPopUp' with Econfig Item 'CreditAlertABarE2'
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'CreditAlertABarAdd'
When Perform the CustomerAccount
Then Verify the Product and Services for 'AllActiveiveRootProductActive'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
When Perform One Number Validation for 'ValidateNoMSISDNPresent'


Scenario: MultiDeviceRetrofit020 CCS 19.0_VFUKE-7346_VFUS-1341_CRM-918_Multi device Retrofit_Mobile_TS01_TC01_Negative_Validate that 2nd secondary is not allowed if the first secondary is already in ONHOLD status.
Meta:@MultiDeviceRetrofit020
@FolderName MultiDeviceRetrofit020
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create the account type 'PostpaidConsumer'
And Create 'NewOrderNoPopUp' 'NewPostpaid' Order
And Promotion is added with 'PostpaidPromotion4G'
And Update MSISDN by performing 'UpdateMSISDN' on 'RootProductAboutRecord'
And Update ICCID against 'EnterICCIDInBlankWhiteTripleFormatSim'
And Reserve Order
And Perform Credit Vet
When Perform 'PerformAboutRecord' on Order Number
And Execute query 'AutoAssetforOpen1'
And Execute query 'AutoAssetforOpen2'
And Execute query 'AutoAssetforOpen3'
When Search The Account ''
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
When Perform One Number Validation for 'SelectOpenStatusMSISDN' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryOnHold'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
When Perform One Number Validation for 'ValidateNoMSISDNPresent'


Scenario: MultiDeviceRetrofit021 CCS 19.0_VFUKE-7346_VFUS-1341_CRM-918_Multi device Retrofit_Mobile_TS01_TC01_Validate that agent places an immediate disconnection order on Multi device Primary Subscription.
Meta:@MultiDeviceRetrofit021
@FolderName MultiDeviceRetrofit021
@Ranju
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
When Perform One Number Validation for 'SelectActiveStatusMSISDN' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryOnHold'
When Check order in Account Overview Page for 'CheckModifyComplete'
When Check order in Account Overview Page for 'CheckSecondaryOpen'
When Check if Order has reached Dispatch Shipping Task in OSM
When Dispatch 'ESIM' order via FMW XML
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryComplete'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionFeeCalculator'
And Compare Line Items 'ClickNext'
And Enter Disconnection Reason And click Next
And Confirm Order


Scenario: MultiDeviceRetrofit022 CCS 19.0_VFUKE-7346_VFUS-1341_CRM-918_Multi device Retrofit_Mobile_TS01_TC01_Validate that agent places a disconnection order via SR on Multi device Primary Subscription.
Meta:@MultiDeviceRetrofit022
@FolderName MultiDeviceRetrofit022
@Sayali	
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerExcOneNumberSecondaryProd'
Given Login with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
When Perform One Number Validation for 'SelectActiveStatusMSISDN' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryOnHold'
When Check order in Account Overview Page for 'CheckModifyComplete'
When Check order in Account Overview Page for 'CheckSecondaryOpen'
When Check if Order has reached Dispatch Shipping Task in OSM
And Dispatch 'ESIM' order via FMW XML
Given Login with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryComplete'
When ReLogin with 'QPBO' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DisconnectionFeeCalculatorFutureDisconnection'
Then Perform for scenario 'SRRowIdCapture' and perform About Record
Then Perform validation in Service Request screen for scenario 'AddNextDateAsSLA'
When ReLogin with 'ADMIN' in 'Env'
And Navigate To Jobs
And Create New Jobs 'PopVFChangesDisconnect'
And Performs 'SRRowID'
And Perform scenario for 'CaptureJobId' in Jobs
And Perform scenario for 'QueryWithJobIDandCheckforSuccessStatus' in Jobs
When ReLogin with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckModifyComplete'
When Check order in Account Overview Page for 'CheckDisconnectionComplete'


Scenario: MultiDeviceRetrofit023 CCS 19.0_VFUKE-7346_VFUS-1341_CRM-918_Multi device Retrofit_Mobile_TS01_TC01_Validate that agent places a Tariff Migration on Multi device Primary Subscription. 
Meta:@MultiDeviceRetrofit023
@FolderName MultiDeviceRetrofit023
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'SecondaryPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
When Perform One Number Validation for 'SelectActiveStatusMSISDN' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryOnHold'
When Check order in Account Overview Page for 'CheckModifyComplete'
When Check order in Account Overview Page for 'CheckSecondaryOpen'
When Check if Order has reached Dispatch Shipping Task in OSM
And Dispatch 'ESIM' order via FMW XML
Given Login with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryComplete'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'PortInNumberChange'
When Order Details Capture in Order Summary page
When Confirm Order

Scenario: MultiDeviceRetrofit024 CCS 19.0_VFUKE-7346_VFUS-1341_CRM-918_Multi device Retrofit_Mobile_TS01_TC01_Validate that agent places a Tariff Migration on Multi device Primary Subscription having Onenumber primary product in Delete action code. 
Meta:@MultiDeviceRetrofit024
@FolderName MultiDeviceRetrofit024
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'AGENT01' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'PostpaidPromotion111279' for 'AddSpecificHandsetPAYM202052' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
When Perform Validations of Add Serial Number for 'ValidateIMEINumberFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateDeviceEIDFieldDisabled' in OUI
When Perform Validations of Add Serial Number for 'ValidateUseDeviceEIDCheckboxChecked' in OUI
When Perform Validations of Add Serial Number for 'ValidateESIMFieldDisabled' in OUI
When Perform One Number Validation for 'SelectActiveStatusMSISDN' in OUI and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryOnHold'
When Check order in Account Overview Page for 'CheckModifyComplete'
When Check order in Account Overview Page for 'CheckSecondaryOpen'
When Check if Order has reached Dispatch Shipping Task in OSM
And Dispatch 'ESIM' order via FMW XML
When Search The OUI Account 'GoToAccountLink' ''
When Check order in Account Overview Page for 'CheckSecondaryComplete'
When Search The Account ''
And Retrieve Promotion 'PostpaidPromotion4G'
And Modify 'ModifyWithInstalledID' with Econfig Item 'OneNumberPrimaryProductDelete'
And Submit the Order 'Normal Submit'
Then verify the Order line Items 'OneNumberPrimaryProductDelete'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Owned Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'PortInNumberChange'
When Order Details Capture in Order Summary page
When Confirm Order