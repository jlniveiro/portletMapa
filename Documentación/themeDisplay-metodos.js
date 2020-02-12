AUI().ready(

	/*
	This function gets loaded when all the HTML, not including the portlets, is
	loaded.
	*/

	function() {
	}
);

Liferay.Portlet.ready(

	/*
	This function gets loaded after each and every portlet on the page.

	portletId: the current portlet's id
	node: the Alloy Node object of the current portlet
	*/

	function(portletId, node) {
		$(document).ready(function() {
			if(Liferay.ThemeDisplay.isSignedIn()){
				console.log('Hola ' + Liferay.ThemeDisplay.getUserName() + '. bienvenido.');
				console.log('Liferay.ThemeDisplay.getLayoutId()==> '+ Liferay.ThemeDisplay.getLayoutId());
				console.log('Liferay.ThemeDisplay.getLayoutRelativeURL()==> '+ Liferay.ThemeDisplay.getLayoutRelativeURL());
				console.log('Liferay.ThemeDisplay.getLayoutURL()==> '+ Liferay.ThemeDisplay.getLayoutURL());
				console.log('Liferay.ThemeDisplay.getParentLayoutId()==> '+ Liferay.ThemeDisplay.getParentLayoutId());
				console.log('Liferay.ThemeDisplay.isControlPanel()==> '+ Liferay.ThemeDisplay.isControlPanel());
				console.log('Liferay.ThemeDisplay.isPrivateLayout()==> '+ Liferay.ThemeDisplay.isPrivateLayout());
				console.log('Liferay.ThemeDisplay.isVirtualLayout()==> '+ Liferay.ThemeDisplay.isVirtualLayout());
				console.log('Liferay.ThemeDisplay.getBCP47LanguageId()==> '+ Liferay.ThemeDisplay.getBCP47LanguageId());
				console.log('Liferay.ThemeDisplay.getCDNBaseURL()==> '+ Liferay.ThemeDisplay.getCDNBaseURL());
				console.log('Liferay.ThemeDisplay.getCDNDynamicResourcesHost()==> '+ Liferay.ThemeDisplay.getCDNDynamicResourcesHost());
				console.log('Liferay.ThemeDisplay.getCDNHost()==> '+ Liferay.ThemeDisplay.getCDNHost());
				console.log('Liferay.ThemeDisplay.getCompanyGroupId()==> '+ Liferay.ThemeDisplay.getCompanyGroupId());
				console.log('Liferay.ThemeDisplay.getCompanyId()==> '+ Liferay.ThemeDisplay.getCompanyId());
				console.log('Liferay.ThemeDisplay.getDefaultLanguageId()==> '+ Liferay.ThemeDisplay.getDefaultLanguageId());
				console.log('Liferay.ThemeDisplay.getDoAsUserIdEncoded()==> '+ Liferay.ThemeDisplay.getDoAsUserIdEncoded());
				console.log('Liferay.ThemeDisplay.getLanguageId()==> '+ Liferay.ThemeDisplay.getLanguageId());
				console.log('Liferay.ThemeDisplay.getParentGroupId()==> '+ Liferay.ThemeDisplay.getParentGroupId());
				console.log('Liferay.ThemeDisplay.getPathContext()==> '+ Liferay.ThemeDisplay.getPathContext());
				console.log('Liferay.ThemeDisplay.getPathImage()==> '+ Liferay.ThemeDisplay.getPathImage());
				console.log('Liferay.ThemeDisplay.getPathJavaScript()==> '+ Liferay.ThemeDisplay.getPathJavaScript());
				console.log('Liferay.ThemeDisplay.getPathMain()==> '+ Liferay.ThemeDisplay.getPathMain());
				console.log('Liferay.ThemeDisplay.getPathThemeImages()==> '+ Liferay.ThemeDisplay.getPathThemeImages());
				console.log('Liferay.ThemeDisplay.getPathThemeRoot()==> '+ Liferay.ThemeDisplay.getPathThemeRoot());
				console.log('Liferay.ThemeDisplay.getPlid()==> '+ Liferay.TºhemeDisplay.getPlid());
				console.log('Liferay.ThemeDisplay.getPortalURL()==> '+ Liferay.ThemeDisplay.getPortalURL());
				console.log('Liferay.ThemeDisplay.getScopeGroupId()==> '+ Liferay.ThemeDisplay.getScopeGroupId());
				console.log('Liferay.ThemeDisplay.getSessionId()==> '+ Liferay.ThemeDisplay.getSessionId());
				console.log('Liferay.ThemeDisplay.getSiteGroupId()==> '+ Liferay.ThemeDisplay.getSiteGroupId());
				console.log('Liferay.ThemeDisplay.getURLControlPanel()==> '+ Liferay.ThemeDisplay.getURLControlPanel());
				console.log('Liferay.ThemeDisplay.getURLHome()==> '+ Liferay.ThemeDisplay.getURLHome());
				console.log('Liferay.ThemeDisplay.getUserId()==> '+ Liferay.ThemeDisplay.getUserId());
				console.log('Liferay.ThemeDisplay.getUserName()==> '+ Liferay.ThemeDisplay.getUserName());
				console.log('Liferay.ThemeDisplay.isAddSessionIdToURL()==> '+ Liferay.ThemeDisplay.isAddSessionIdToURL());
				// este metodo no lo reconoce
				// console.log('Liferay.ThemeDisplay.isFreeformLayout()==> '+ Liferay.ThemeDisplay.isFreeformLayout());
				console.log('Liferay.ThemeDisplay.isImpersonated()==> '+ Liferay.ThemeDisplay.isImpersonated());
				console.log('Liferay.ThemeDisplay.isSignedIn()==> '+ Liferay.ThemeDisplay.isSignedIn());
				console.log('Liferay.ThemeDisplay.isStateExclusive()==> '+ Liferay.ThemeDisplay.isStateExclusive());
				console.log('Liferay.ThemeDisplay.isStateMaximized()==> '+ Liferay.ThemeDisplay.isStateMaximized());
				console.log('Liferay.ThemeDisplay.isStatePopUp()==> '+ Liferay.ThemeDisplay.isStatePopUp());
			}
			else {
				console.log('Hola Guest.')
			}
		
		});
	}
);

Liferay.on(
	'allPortletsReady',

	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/

	function() {
	}
);