package mx.blogspot.decibelelektrobeat

class ApplicationRole {

    String name
    String description

    static constraints = {
        name 		nullable:false, blank:false
        description nullable:true, blank:true
    }

}
