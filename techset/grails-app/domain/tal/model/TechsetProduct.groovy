package tal.model

class TechsetProduct {

	Product product
	
	static belongsTo = [techset: Techset] 
    static constraints = {
    }
}
