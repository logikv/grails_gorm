package addressbookgorm

import grails.rest.Resource
import groovy.transform.ToString

@ToString
@Resource(uri='/hometown')
class Hometown {

    static belongsTo = Person
    static hasMany = [persons: Person]


    static mapping = {
        persons joinTable: [name: "person_hometown"]
        persons lazy: false
    }

    String city

}
