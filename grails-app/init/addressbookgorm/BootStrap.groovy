package addressbookgorm

class BootStrap {

    def init = { servletContext ->
        def scranton = new Hometown(city: "Scranton").save()
        def newYork = new Hometown(city: "New York").save()
        new Hometown(city: "Pittsburgh").save()
        new Person(name: "Jim", city: "New York", salary: 5000L, hometown: newYork).save()
        new Person(name: "Pam", city: "Scranton", salary: 3000L, hometown: scranton).save()
        new Person(name: "Mike", city: "Scranton", salary: 7000L, hometown: scranton).save()

    }
    def destroy = {
    }
}
