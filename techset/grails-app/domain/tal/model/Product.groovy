package tal.model

class Product {

	String product
	String vendor
	String productVersion
	
    static constraints = {
    }
	
	String toString() {
		return product + " " + productVersion
	}

}
