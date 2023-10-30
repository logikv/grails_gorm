package addressbookgorm

class Person {

    String name
    String city
    Long salary
    Hometown hometown

    static constraints = {
        name blank: false
        city blank: false
        salary range: 1..1000000
    }
}
