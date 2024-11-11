package addressbookgorm

import grails.rest.Resource
import groovy.transform.ToString

@ToString
@Resource(uri='/person')
class Person {

    String name
    Long salary
    Hometown hometown

    static constraints = {
        name blank: false
        salary range: 1..1000000
    }
}
