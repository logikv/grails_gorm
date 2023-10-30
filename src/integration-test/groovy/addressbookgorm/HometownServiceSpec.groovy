package addressbookgorm

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class HometownServiceSpec extends Specification {

    HometownService hometownService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Hometown(...).save(flush: true, failOnError: true)
        //new Hometown(...).save(flush: true, failOnError: true)
        //Hometown hometown = new Hometown(...).save(flush: true, failOnError: true)
        //new Hometown(...).save(flush: true, failOnError: true)
        //new Hometown(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //hometown.id
    }

    void "test get"() {
        setupData()

        expect:
        hometownService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Hometown> hometownList = hometownService.list(max: 2, offset: 2)

        then:
        hometownList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        hometownService.count() == 5
    }

    void "test delete"() {
        Long hometownId = setupData()

        expect:
        hometownService.count() == 5

        when:
        hometownService.delete(hometownId)
        sessionFactory.currentSession.flush()

        then:
        hometownService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Hometown hometown = new Hometown()
        hometownService.save(hometown)

        then:
        hometown.id != null
    }
}
