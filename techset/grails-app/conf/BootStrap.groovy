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
		def String talModelXMLString =""
		def String line = ""
		new File("c:\\temp\\tal.xml").withReader { reader ->
		  while (line = reader.readLine() != null) {
		  	talModelXMLString.concat(line)
		  }
		}
		
		def nodes = new XmlParser().parseText()
		def allRecords = records.car.size()
		assert allRecords == 3
		def allNodes = records.depthFirst().size()
		assert allNodes == 10
		def firstRecord = records.car[0]
		assert 'car' == firstRecord.name()
		assert 'Holden' == firstRecord.'@make'
		assert 'Australia' == firstRecord.country.text()
		// 2 cars have an 'e' in the make
		assert 2 == records.car.findAll{ it.'@make'.contains('e') }.size()
		// makes of cars that have an 's' followed by an 'a' in the country
		assert ['Holden', 'Peel'] == records.car.findAll{ it.country.text() =~ '.*s.*a.*' }.'@make'
		
		}
    def destroy = {
    }
}
