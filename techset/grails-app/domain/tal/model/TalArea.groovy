package tal.model

class TalArea {
	String talAreaName
	String talAreaDescription

	static belongsTo = [talGroup: TalGroup]
	
    static constraints = {
		talAreaName()
		talAreaDescription()
    }

	String toString() {
		return talAreaName
	}

}
