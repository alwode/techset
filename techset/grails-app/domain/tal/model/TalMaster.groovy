package tal.model

class TalMaster {
	String talMasterName
	String talMasterDescription

	static hasMany = [talDomains: TalDomain]
		
    static constraints = {
		talMasterName()
		talMasterDescription()
    }
	
	String toString() {
		return talMasterName
	}
}
