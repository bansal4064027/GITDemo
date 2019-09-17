Story: FUT Changes Mobile
Meta:@FUTChangesMobile
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the account

Scenario: FUTMobile02 HALO R1.0_FUT Issue_SOU5161_Override Price_TS02_If a product is not eligible for any discount at all_Error Message should be thrown
Meta:@FUTMobile02
@FolderName FUTMobile02
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Override price discount for 'Discount5PopupforNonDicountProduct'


Scenario: FUTMobile05 HALO R1.0_FUT Issue_SOU5170_Fulfilment_Delivery Details Update_TS01_Fulfilment_Delivery Details Update_ Mobile_New Customer_Collect from store stock
Meta:@FUTMobile05
@FolderName FUTMobile05
@Payel	
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'CollectFromStoreStock'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: FUTMobile06 HALO R1.0_FUT Issue_SOU5170_Fulfilment_Delivery Details Update_TS02_Fulfilment_Delivery Details Update _ Mobile_Existing customer_Deliver to store
Meta:@FUTMobile06
@FolderName FUTMobile06
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToStore'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order



Scenario: FUTMobile08 HALO R1.0_FUT Issue_SOU5170_Fulfilment_Delivery Details Update_TS05_Fulfilment_Delivery Details Update _ Mobile_Existing customer_Deliver to customer
Meta:@FUTMobile08
@FolderName FUTMobile08
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI
And Perform Credit Vet OUI for 'CreditVettingNotRequiredandClickNext'
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order




Scenario: FUTMobile09 HALO R1.0_FUT Issue_SOU5171_Add Promotions_Products to Basket _TS01_P&S view agent can search for PAYM device or promotion based on Search by device option 
Meta:@FUTMobile09
@FolderName FUTMobile09
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI

Scenario: FUTMobile10 HALO R1.0_FUT Issue_SOU5171_Add Promotions_Products to Basket _TS02_P&S view_agent can search for PAYM device or promotion based on Search by price plan option 
Meta:@FUTMobile10
@FolderName FUTMobile10
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotion4G' for 'AddPostpaidPromotionviaSearchByPlan' in OUI

Scenario: FUTMobile11 HALO R1.0_FUT Issue_SOU5264_Cost in Basket_TS01_Cost in Basket _ Consumer Accounts 
Meta:@FUTMobile11
@FolderName FUTMobile11
@Tarun
Given Place screenshots in Folder 'FolderName'
Given Login with 'RETAIL1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'ConsumerValidation'

Scenario: FUTMobile12 HALO R1.0_FUT Issue_SOU5264_Cost in Basket_TS02_Cost in Basket _ Business Accounts 
Meta:@FUTMobile12
@FolderName FUTMobile12
@Tarun
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'SoleTraderOUI'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'SoleTraderOUI'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'BusinessValidation'

Scenario: FUTMobile17 HALO R1.0_FUT Issue_SOU5273_Automatically Open CTI Toolbar_TS01_Agents profiles who have the CTI functionality enabled
Meta:@FUTMobile17
@FolderName FUTMobile17
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'CTI' in 'Env'
When Search for CTI Toolbar for 'SearchForCTIToolbar' ''

Scenario: FUTMobile18 HALO R1.0_FUT Issue_SOU5273_Automatically Open CTI Toolbar_TS02_Agents profiles who have the CTI functionality disabled
Meta:@FUTMobile18
@FolderName FUTMobile18
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Search for CTI Toolbar for 'DONotSearchForCTIToolbar' ''
Given Login with 'VFREDUSR' in 'Env'
When Search for CTI Toolbar for 'DONotSearchForCTIToolbar' ''


Scenario: FUTMobile19 HALO R1.0_FUT Issue_SOU5539_Navigation to Account Overview_TS01_Contact management_Navigation
Meta:@FUTMobile19
@FolderName FUTMobile19
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
Given Retrieve Account 'PostpaidConsumer'
When Search The OUI Account 'GoToAccountLink' ''
Then Navigate To Contact Tab and Check for Account Overview


Scenario: FUTMobile21 HALO R1.0_FUT Issue_SOU5542_Time at Address_TS01_Search the Current Address 
Meta:@FUTMobile21
@FolderName FUTMobile21
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'CurrentAddressPopupValidation'


Scenario: FUTMobile22 HALO R1.0_FUT Issue_SOU5542_Time at Address_TS02_Search the Previous Address 
Meta:@FUTMobile22
@FolderName FUTMobile22
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Adress for 'PreviousAddressPopupValidation'


Scenario: FUTMobile23 HALO R1.0_FUT Issue_SOU5542_Time at Address_TS03_Create New Address Manually 
Meta:@FUTMobile23
@FolderName FUTMobile23
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'ConsumerManualAddressPopupValidation'


Scenario: FUTMobile24 HALO R1.0_FUT Issue_SOU5543_Scroll bar in LOV_TS01_Scroll bar in LOV
Meta:@FUTMobile24
@FolderName FUTMobile24
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Check LOV for dropdowns in About Customer Page

Scenario: FUTMobile25 HALO R1.0_FUT Issue_SOU5544_Contract Period for PAYM _TS01_Contract Period for PAYM SIM Only
Meta:@FUTMobile25
@FolderName FUTMobile25
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Check Promotion Contract Period  for 'ValidateContractPeriodfordifferentPromo' in OUI





Scenario: FUTMobile26 HALO R1.0_FUT Issue_SOU5549_Retail Digital Signature_TS01_Retail Digital Signature Applet should not be visible to Call Centre Agents 
Meta:@FUTMobile26
@FolderName FUTMobile26
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Validate Digital Signature Applet not present for Call Centre Agents


Scenario: FUTMobile30  HALO R1.0_FUT Issue_SOU5549_Retail Digital Signature_TS05_Skip signature capture 
Meta:@FUTMobile30
@FolderName FUTMobile30
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page



Scenario: FUTMobile31 HALO R1.0_FUT Issue_SOU5757_FLBB Add to Basket _TS01_FL_BB _Add to basket button in Service point details 
Meta:@FUTMobile31
@FolderName FUTMobile31
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'QP' in 'Env'
When Create OUI account type 'PostpaidConsumerFixLine'
And Get Address 'SPAREPAIRCBU'
And Click on Fixed Line Check Avilibility for 'SPAREPAIRCBU'
And Filter Promotion for Enhancement 'PickFirstPromotion'


Scenario: FUTMobile32 HALO R1.0_FUT Issue_SOU5759_Address Validation message_TS01_Blocking message will pop_up if search is done with entering post code. 
Meta:@FUTMobile32
@FolderName FUTMobile32
@Payel
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'NoPostcodeValidation'

Scenario: FUTMobile33 HALO R1.0_FUT Issue_SOU5847_Navigation to Enabled from Billed Used Products & Services _TS01_Perform additional actions through Billed Product & services Applet (Account Overview)
Meta:@FUTMobile33
@FolderName FUTMobile33
@Tarun
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Billed Product and Services (Account Overview)'PerformAdditionalAction'


Scenario: FUTMobile34 HALO R1.0_FUT Issue_SOU5847_Navigation to Enabled from Billed Used Products & Services _TS02_Perform additional actions through Used Product & services Applet (Account Overview)
Meta:@FUTMobile34
@FolderName FUTMobile34
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Used Product and Services (Account Overview) 'PerformAdditionalAction'


Scenario: FUTMobile35 HALO R1.0_FUT Issue_SOU5847_Navigation to Enabled from Billed Used Products & Services _TS03_Perform additional actions through Billed Product & services Applet (Product & Services overview)
Meta:@FUTMobile35
@FolderName FUTMobile35
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Billed Product and Services (Account Overview)'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'PerformAdditionalActiononPromotionfromBilledView'


Scenario: FUTMobile36 HALO R1.0_FUT Issue_SOU5847_Navigation to Enabled from Billed Used Products & Services _TS04_Perform additional actions through Used Product & services Applet (Product & Services overview)
Meta:@FUTMobile36
@FolderName FUTMobile36
@Payel
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Select Action from Used Product and Services (Account Overview) 'DrilldownMSISDN'
Then Select Action from Product&Services Overview for 'PerformAdditionalActiononPromotionfromUsedView'

Scenario: FUTMobile40 FUT Issue_42_QC15266 - P2 Secondary DPA Email Address Missing
Meta:@FUTMobile40
@FolderName FUTMobile40
@Zeba
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'RETAIL' in 'Env'
When Search The Account ''
When Validate Contacts tab for 'EnterEmailandUpdateToBillingProfile'
When Search The OUI Account 'AdvanceSearch' ''
Then Perform DPA validation for 'SecurityQuestionPAYMPassCheckEmail'


Scenario: FUTMobile44 FUT Issue_62_P3 Incorrect PAYG Pricing 
Meta:@FUTMobile44
@FolderName FUTMobile44
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Validate Cost To Correct Decimal


Scenario: FUTMobile47 FUT Issue_93_P2 Save Signiture BIP report error
Meta:@FUTMobile47
@FolderName FUTMobile47
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Enter Digital Signature and Click on Next
When Perform payment with 'Cash' and Confirm Order





