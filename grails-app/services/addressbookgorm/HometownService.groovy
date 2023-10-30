package addressbookgorm

import grails.gorm.services.Service

@Service(Hometown)
interface HometownService {

    Hometown get(Serializable id)

    List<Hometown> list(Map args)

    Long count()

    void delete(Serializable id)

    Hometown save(Hometown hometown)

}