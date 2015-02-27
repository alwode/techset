package tal.model

class TechsetProduct {

	Product product
	TalArea talArea
	static belongsTo = [techset: Techset] 
    static constraints = {
    }
	String toString() {
		return product
	}
}
