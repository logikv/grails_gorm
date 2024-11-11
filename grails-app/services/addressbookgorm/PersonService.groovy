package addressbookgorm

import grails.gorm.services.Service
import org.grails.datastore.mapping.query.api.BuildableCriteria

@Service(Person)
interface PersonService {



    Person get(Serializable id)

    List<Person> list(Map args)

    List<Person> findByHometown(Hometown hometown)

    Long count()

    void delete(Serializable id)

    Person save(Person person)

}