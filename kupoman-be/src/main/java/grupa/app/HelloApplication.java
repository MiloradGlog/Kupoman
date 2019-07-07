package grupa.app;

import grupa.rest.HelloRestService;
import grupa.rest.coupon.CouponEndpoint;
import grupa.rest.filters.CorsFilter;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


public class HelloApplication extends Application {
    private Set<Object> singletons = new HashSet<Object>();
    public HelloApplication() {
        // Register our hello service
        singletons.add(new HelloRestService());
        singletons.add(new CouponEndpoint());
        singletons.add(new CorsFilter());
    }
    @Override    public Set<Object> getSingletons() {
        return singletons;
    }
}