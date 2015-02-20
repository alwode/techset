package tal.model

class TalDomain {
	String talDomainName
	String talDomainDescription

	static belongsTo = [talMaster: TalMaster]
	static hasMany = [talGroups: TalGroup]
		
    static constraints = {
		talDomainName()
		talDomainDescription()
    }

		String toString() {
		return talDomainName
	}

}
