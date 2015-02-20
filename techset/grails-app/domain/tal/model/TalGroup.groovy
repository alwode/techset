package tal.model

class TalGroup {
	String talGroupName
	String talGroupDescription

	static belongsTo = [talDomain: TalDomain]
	static hasMany = [talAreas: TalArea]
		
    static constraints = {
		talGroupName()
		talGroupDescription()
    }
	
	String toString() {
		return talGroupName
	}

}
