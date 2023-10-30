package addressbookgorm

class Hometown {

    static belongsTo = Person
    static hasMany = [persons: Person]

//    static constraints = {
//        id name: 'city'
//    }
    static mapping = {
        persons joinTable: [name: "person_hometown"]
    }

    String city

}
