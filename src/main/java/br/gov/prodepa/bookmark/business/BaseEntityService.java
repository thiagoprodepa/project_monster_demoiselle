package br.gov.prodepa.bookmark.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

/**
 * <p>
 *   A number of RESTful services implement GET operations on a particular type of entity. For
 *   observing the DRY principle, the generic operations are implemented in the <code>BaseEntityService</code>
 *   class, and the other services can inherit from here.
 * </p>
 *
 * <p>
 *    Subclasses will declare a base path using the JAX-RS {@link Path} annotation, for example:
 * </p>
 *
 * <pre>
 * <code>
 * &#064;Path("/widgets")
 * public class WidgetService extends BaseEntityService<Widget> {
 * ...
 * }
 * </code>
 * </pre>
 *
 * <p>
 *   will support the following methods:
 * </p>
 *
 * <pre>
 * <code>
 *   GET /widgets
 *   GET /widgets/:id
 *   GET /widgets/count
 * </code>
 * </pre>
 *
 *  <p>
 *     Subclasses may specify various criteria for filtering entities when retrieving a list of them, by supporting
 *     custom query parameters. Pagination is supported by default through the query parameters <code>first</code>
 *     and <code>maxResults</code>.
 * </p>
 *
 * <p>
 *     The class is abstract because it is not intended to be used directly, but subclassed by actual JAX-RS
 *     endpoints.
 * </p>
 *

 * @author Marius Bogoevici
 */
public abstract class BaseEntityService<T> {

    @Inject
    private EntityManager entityManager;

    private Class<T> entityClass;

    public BaseEntityService() {}
    
    public BaseEntityService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
