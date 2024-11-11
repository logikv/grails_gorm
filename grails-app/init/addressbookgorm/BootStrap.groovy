package addressbookgorm

class BootStrap {

    def init = { servletContext ->
        def scranton = new Hometown(city: "Scranton").save()
        def newYork = new Hometown(city: "New York").save()
        def pittsburgh = new Hometown(city: "Pittsburgh").save()


        new Person(name: "Jim", salary: 5000L, hometown: newYork).save()
        new Person(name: "Pam", salary: 3000L, hometown: scranton).save()
        new Person(name: "Mike", salary: 7000L, hometown: scranton).save()

        Person.list().each {
            print it
            println it.hometown
        }

        println("####")
        def person = Person.executeQuery("select p from Person p where p.name like '%i%'")
        person.each { println it }


        println("####")
        def pam = Person.findByName("Pam")
        println pam

        println("####")
        def persons = Person.findAllBySalaryLessThanAndHometown(5000+1, Hometown.get(1))
        persons.each { println(it.name)}


        println("####")
        def result = Person.withCriteria {
            if(false) order("salary", "desc")
            if(true) like("name", "%i%")
        }

        result.each { println("${it.name}: ${it.salary}")}


    }
    def destroy = {
    }
}
