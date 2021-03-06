/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad.service;

import com.sun.xml.internal.ws.api.message.Packet;
import entidad.Categoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.jsp.PageContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author Usuario
 */
@Stateless
@Path("categoria")
public class CategoriaFacadeREST extends AbstractFacade<Categoria> {
    @PersistenceContext(unitName = "chamboPU")
    private EntityManager em;

    public CategoriaFacadeREST() {
        super(Categoria.class);
        
    }

    @POST
    @Override
    @Consumes( "application/json")
    public void create(Categoria entity) {
        super.create(entity);
    }
    
    /*
        @POST
    @Path("create")
    @Consumes("application/json")
    @Produces("application/json")
    public Response create1(Categoria entity) {
        super.create(entity);
        System.out.println(entity);
         Response.ResponseBuilder builder = Response.status(Response.Status.CREATED);
          return builder.build();
    }
    */

    @PUT
    @Path("{id}")
    @Consumes( "application/json")
    public void edit(@PathParam("id") Integer id, Categoria entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Categoria find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces("application/json")
    public List<Categoria> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces("application/json")
    public List<Categoria> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
