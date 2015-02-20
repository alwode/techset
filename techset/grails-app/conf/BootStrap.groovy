class BootStrap {

    def init = { servletContext ->
		
	def master = new tal.model.TalMaster(talMasterName: "ICT Software",
										 talMasterDescription: "ICT Software" )
	  .addToTalDomains(new tal.model.TalDomain(talDomainName: "Application Development",
		  									   talDomainDescription: "Application Development")
	    .addToTalGroups(new tal.model.TalGroup(talGroupName: "Release and Deployment Management",
											   talGroupDescription: "Release and Deployment Management")
		  .addToTalAreas(new tal.model.TalArea(talAreaName: "Application Deployment for Legacy and Client/Server", 
			  								   talAreaDescription: "Application Deployment for Legacy and Client/Server"))
		  .addToTalAreas(new tal.model.TalArea(talAreaName: "Application Deployment for Legacy and Client/Server", 
			  								   talAreaDescription: "Application Deployment for Legacy and Client/Server"))))
	  .addToTalDomains(new tal.model.TalDomain(talDomainName: "Application Integration and Middleware",
		  									   talDomainDescription: "Application Integration and Middleware"))
	  .save()
    }
    def destroy = {
    }
}
