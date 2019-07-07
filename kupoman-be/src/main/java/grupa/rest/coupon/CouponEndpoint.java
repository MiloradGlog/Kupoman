package grupa.rest.coupon;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/coupon")
public class CouponEndpoint {

    private CouponService couponService;

    public CouponEndpoint() {
        this.couponService = new CouponService();
    }

    @GET // This annotation indicates GET request
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/{id}")
    public Coupon getCoupon(@PathParam("id") Integer id) {
        Coupon response = couponService.getCoupon(id);
        System.out.println("Trazim za kupon "+ id);
        return response;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putCoupon(Coupon coupon) {
        String responseText = "error";

        try {
            couponService.addCoupon(coupon);
            responseText = "uspesno dodao kupon!";
        } catch (Exception e){
            e.printStackTrace();
        }

        return Response.
                status(200).entity(responseText).header("X-Content-Type-Options", "nosniff").build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCoupon(@PathParam("id") Integer id) {

        String responseText = "error";
        try {
            couponService.deleteCoupon(id);
            responseText = "uspesno obrisao kupon!";
        } catch (Exception e){
            e.printStackTrace();
        }


        return Response.
                status(200).entity(responseText).header("X-Content-Type-Options", "nosniff").build();

    }
}