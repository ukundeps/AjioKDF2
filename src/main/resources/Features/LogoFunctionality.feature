Feature: Verify Ajio Page redirection to HomePage after clicking on Logo

Scenario: Verify  Ajio Page redirection to HomePage after clicking on Logo
	Given User launches application url
	Then User Clicks on Sign/Join Ajio Link
	Then A pop-up will open and user enters valid credentials in that pop-up
	Then User clicks My Account to redirect to  My acount page
	When User clicks on Ajio Logo 
	Then Verify the page is redirecting to homepage from My account page
