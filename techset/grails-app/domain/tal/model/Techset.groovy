package tal.model

class Techset {

	String techsetName
	Date validFrom
	Date validUntil
	
	static hasMany = [techsetProducts: TechSetProduct]
	
    static constraints = {
    }
}
