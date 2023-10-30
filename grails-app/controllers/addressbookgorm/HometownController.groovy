package addressbookgorm

import grails.validation.ValidationException
import org.grails.datastore.mapping.query.api.BuildableCriteria

import static org.springframework.http.HttpStatus.*

class HometownController {

    HometownService hometownService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def c = Hometown.createCriteria()
        def response = c.list {

        }
        respond Hometown.findByCity('Scranton')
    }

    def show(Long id) {
        respond hometownService.get(id)
    }

    def create() {
        respond new Hometown(params)
    }

    def save(Hometown hometown) {
        if (hometown == null) {
            notFound()
            return
        }

        try {
            hometownService.save(hometown)
        } catch (ValidationException e) {
            respond hometown.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'hometown.label', default: 'Hometown'), hometown.id])
                redirect hometown
            }
            '*' { respond hometown, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond hometownService.get(id)
    }

    def update(Hometown hometown) {
        if (hometown == null) {
            notFound()
            return
        }

        try {
            hometownService.save(hometown)
        } catch (ValidationException e) {
            respond hometown.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'hometown.label', default: 'Hometown'), hometown.id])
                redirect hometown
            }
            '*'{ respond hometown, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        hometownService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'hometown.label', default: 'Hometown'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'hometown.label', default: 'Hometown'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
