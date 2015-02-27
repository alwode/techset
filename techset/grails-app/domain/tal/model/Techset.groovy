package tal.model

class Techset {

	String techsetName
	Date validFrom
	Date validUntil
	
	static hasMany = [techsetProducts: TechsetProduct]
	
    static constraints = {
    }
	String toString() {
		return techsetName
	}
}
