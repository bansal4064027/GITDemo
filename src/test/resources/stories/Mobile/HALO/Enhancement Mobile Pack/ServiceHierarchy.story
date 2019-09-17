Story: Service Hierarchy
Meta:@ServiceHierarchy
@tag tag:admin,tag:application,version:Release-02,version:Sprint-01.02

Narrative:
  As a user
  I should be able to create the Service Hierarchy account


Scenario: ServiceHierarchyEnh001 HALO R2_service hierarchy_TC01_New Payer_Validate agent is able to add new Payer from SearchExisting Contact 
Meta:@ServiceHierarchyEnh001
@FolderName ServiceHierarchyEnh001
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'AddExistingPayer'


Scenario: ServiceHierarchyEnh002 HALO R2_service hierarchy_TC02_New Payer_Validate agent is able to add new Payer from Create a New Contact 
Meta:@ServiceHierarchyEnh002
@FolderName ServiceHierarchyEnh002
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'NewPayer'

Scenario: ServiceHierarchyEnh003  HALO R2_service hierarchy_TC03_New User_Validate agent is able to add new user from Search existing contact 
Meta:@ServiceHierarchyEnh003
@FolderName ServiceHierarchyEnh003
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'AddExistingUser'

Scenario: ServiceHierarchyEnh004  HALO R2_service hierarchy_TC04_New User_Validate agent is able to add a new user from Create New Contact 
Meta:@ServiceHierarchyEnh004
@FolderName ServiceHierarchyEnh004
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'NewUser'

Scenario: ServiceHierarchyEnh005 HALO R2_service hierarchy_TC05_Validate agent is able to do Service Hierarchy for Owner Account_A Payer Account_A and User Account_C 
Meta:@ServiceHierarchyEnh005
@FolderName ServiceHierarchyEnh005
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'NewUser'
And Create Service Hierarchy Account for 'ValidatePayerSameAsOwner'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: ServiceHierarchyEnh006 HALO R2_service hierarchy_TC06_Validate agent is able to do Service Hierarchy for Owner Account_A and same  Payer Account and User Account_B 
Meta:@ServiceHierarchyEnh006
@FolderName ServiceHierarchyEnh006
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'NewPayer'
And Create Service Hierarchy Account for 'ValidateUserSameAsPayer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: ServiceHierarchyEnh007 HALO R2_service hierarchy_TC07_Validate agent is able to do Service Hierarchy for Owner Account_A , Payer Account_B and User Account_C 
Meta:@ServiceHierarchyEnh007
@FolderName ServiceHierarchyEnh007
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'NewPayer'
And Create Service Hierarchy Account for 'NewUser'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: ServiceHierarchyEnh008 HALO R2_service hierarchy_TC08_Validate agent is able to do Service Hierarchy for Same owner and payer_different user (Service I need_Postpaid , Service Own_Postpaid) 
Meta:@ServiceHierarchyEnh008
@FolderName ServiceHierarchyEnh008
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'NewUser'
And Create Service Hierarchy Account for 'ValidatePayerSameAsOwner'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order


Scenario: ServiceHierarchyEnh010 HALO R2_service hierarchy_TC10_Validate agent is able to do Service Hierarchy for Same owner and payer, different user (Service I need -Prepaid , Service Own - Prepaid) 
Meta:@ServiceHierarchyEnh010
@FolderName ServiceHierarchyEnh010
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'PrepaidPackage' for 'AddPrepaidPromoOnly' in OUI
And Create Service Hierarchy Account for 'NewUser'
And Create Service Hierarchy Account for 'ValidatePayerSameAsAccountName'
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order

Scenario: ServiceHierarchyEnh012 HALO R2_service hierarchy_TC12_Validate agent is able to do Service Hierarchy for _Payer and user is same, different owner (Service I need -Postpaid , Service Own - Prepaid)
Meta:@ServiceHierarchyEnh012
@FolderName ServiceHierarchyEnh012
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Service Hierarchy Account for 'NewPayer'
And Create Service Hierarchy Account for 'ValidateUserSameAsPayer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Click on Next Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order
When Search The Account ''
And Validate account added in contacts table for 'ValidatePayerAdded'

Scenario: ServiceHierarchyEnh013 HALO R2_service hierarchy_TC13_Validate agent is able to do Service Hierarchy for Payer and user is same, different owner(Service I need -Prepaid , Service Own - Postpaid) 
Meta:@ServiceHierarchyEnh013
@FolderName ServiceHierarchyEnh013
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'PrepaidPackage' for 'AddPrepaidPromoOnly' in OUI
And Select Billing Profile 'NewPrepaidCash' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order


Scenario: ServiceHierarchyEnh014 HALO R2_service hierarchy_TC14_Validate agent is able to do Service Hierarchy for Payer and user is same, different owner (Service I need -Postpaid , Service Own - Postpaid) 
Meta:@ServiceHierarchyEnh014
@FolderName ServiceHierarchyEnh014
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'NewPayer'
And Create Service Hierarchy Account for 'ValidateUserSameAsPayer'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'NoShipping'
And Update ICCID and MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order

Scenario: ServiceHierarchyEnh015 HALO R2_service hierarchy_TC15_Validate agent is able to do Service Hierarchy for Owner, payer and user are all different (Service I need -Postpaid , Service Own - Prepaid)
Meta:@ServiceHierarchyEnh015
@FolderName ServiceHierarchyEnh015
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PrepaidConsumer'
Given Login with 'AGENT04' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Service Hierarchy Account for 'NewPayer'
And Create Service Hierarchy Account for 'NewUser'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Click on Next Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order
When Search The Account ''
And Validate account added in contacts table for 'ValidatePayerAdded'
And Validate account added in contacts table for 'ValidateUserAdded'


Scenario: ServiceHierarchyEnh016 HALO R2_service hierarchy_TC16_Validate agent is able to do Service Hierarchy for Owner, payer and user are all different(Service I need -Prepaid , Service Own - Postpaid) 
Meta:@ServiceHierarchyEnh016
@FolderName ServiceHierarchyEnh016
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Retrieve Account 'PostpaidConsumerBillMe'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Search The OUI Account 'GoToAccountLink' ''
And Create New OUI Order
And Update Promotion 'PrepaidPackage' for 'AddPrepaidPromoOnly' in OUI
And Create Service Hierarchy Account for 'AddExistingUser'
And Click on Next Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order

Scenario: ServiceHierarchyEnh017 HALO R2_service hierarchy_TC17_Validate agent is able to do Service Hierarchy for Owner, payer and user are all different (Service I need -Postpaid , Service Own - Postpaid) 
Meta:@ServiceHierarchyEnh017
@FolderName ServiceHierarchyEnh017
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'NewPayer'
And Create Service Hierarchy Account for 'NewUser'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: ServiceHierarchyEnh018 HALO R2_service hierarchy_TC18_Validate agent is able to do Service Hierarchy for Owner Account_A , Select one Payer from Multi Payer Account and  Select one User from Multi User 
Meta:@ServiceHierarchyEnh018
@FolderName ServiceHierarchyEnh018
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'TEST_RETAIL_1' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'AddMultiPayer'
And Create Service Hierarchy Account for 'AddMultiUser'
And Create Service Hierarchy Account for 'Select1PayerfromMultiPayer'
And Create Service Hierarchy Account for 'Select1UserfromMultiUser'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'Cash' and Confirm Order

Scenario: ServiceHierarchyEnh019 HALO R2_service hierarchy_TC19_Validate agent is able to do Service Hierarchy for Owner Account - A , Payer Account -B(from existing account) and User Account -C(From existing account)
Meta:@ServiceHierarchyEnh019
@FolderName ServiceHierarchyEnh019
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'AddExistingPayer'
And Create Service Hierarchy Account for 'AddExistingUser'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: ServiceHierarchyEnh020 HALO R2_service hierarchy_TC20_Validate agent is able to do Service Hierarchy for Owner Account - A , Payer Account -B(by creating new account) and User Account -C(by creating new account account)
Meta:@ServiceHierarchyEnh020
@FolderName ServiceHierarchyEnh020
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'NewPayer'
And Create Service Hierarchy Account for 'NewUser'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: ServiceHierarchyEnh021 HALO R2_service hierarchy_TC21_Validate agent is able to do Service Hierarchy for Owner Account - A , Payer Account -B(by searching existing account) and User Account -C(by creating new account account)
Meta:@ServiceHierarchyEnh021
@FolderName ServiceHierarchyEnh021
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'AddExistingPayer'
And Create Service Hierarchy Account for 'NewUser'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: ServiceHierarchyEnh023 HALO R2_service hierarchy_TC23_Validate agent is not able to do Service Hierarchy for Owner Account - A , Select one Payer from Multi Payer Account(B) and User(C, which is already active and associated to an service.)
Meta:@ServiceHierarchyEnh023
@FolderName ServiceHierarchyEnh023
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'AddExistingPayer'
And Create Service Hierarchy Account for 'AddExistingUser'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMe' and click on Save Button
When Perform Fulfilment Status With 'DeliveryToCustomer'
And Update MSISDN in OUI by performing 'UpdateMSISDN' and Click Next
And Order Details Capture in Order Summary page
When Perform payment with 'ONAccountNon-CardPopNO' and Confirm Order

Scenario: ServiceHierarchyEnh024 HALO R2_service hierarchy_TC24_Validate agent is not able to do Service Hierarchy for Owner and user is same, different Payer.(A,B,A)
Meta:@ServiceHierarchyEnh024
@FolderName ServiceHierarchyEnh024
@Sayali
Given Place screenshots in Folder 'FolderName'
Given Login with 'AGENT04' in 'Env'
When Create OUI account type 'Consumer'
And Update Promotion 'PostpaidPromotionSIMOfroEnhData' for 'AddSIMOwithVOICEandDATA' in OUI
And Create Personal Detail and Adress for 'Consumer'
And Create Service Hierarchy Account for 'NewPayer'
And Create Service Hierarchy Account for 'SelectOwnerAsUser'
And Create Service Hierarchy Account for 'ValidateUserSameAsOwner'
And Perform Credit Vet OUI for 'CreditVettingNotRequired'
And Select Billing Profile 'NewPostpaidBillMePopupYesOnNextButton' and click on Save Button

