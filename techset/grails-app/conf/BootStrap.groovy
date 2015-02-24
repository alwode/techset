class BootStrap {

    def init = { servletContext ->
		
/*	def master = new tal.model.TalMaster(talMasterName: "ICT Software",
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
*/

		def String talModelXMLString =	new File("c:\\temp\\tal.xml").getText('UTF-8')
		
		def map = new XmlParser().parseText(talModelXMLString)
		
		def master = new tal.model.TalMaster(talMasterName: "ICT Software",
			talMasterDescription: "ICT Software" )
		map.node.node.node.each {
			def currDomain = it
			def tal.model.TalDomain talDomain = new tal.model.TalDomain(talDomainName: currDomain.attribute("TEXT"),
		  									   talDomainDescription: currDomain.attribute("TEXT"))
			master.addToTalDomains(talDomain)
			System.out.println(currDomain.attribute("TEXT"))
			
			it.node.each {
				def currGroup = it
				def tal.model.TalGroup talGroup = new tal.model.TalGroup(talGroupName: currGroup.attribute("TEXT"),
											   talGroupDescription: currGroup.attribute("TEXT"))
				talDomain.addToTalGroups(talGroup)
				System.out.println("    " + currGroup.attribute("TEXT"))
				it.node.each {
					def currArea = it
					def tal.model.TalArea talArea = new tal.model.TalArea(talAreaName: currArea.attribute("TEXT"), 
			  								   talAreaDescription: currArea.attribute("TEXT"))
					talGroup.addToTalAreas(talArea)
					System.out.println("        " + currArea.attribute("TEXT"))
					
				}
			}
		}
		master.save()
	}
    def destroy = {
    }
}
