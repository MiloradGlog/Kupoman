package grupa.rest.coupon;


public class CouponService {
    CouponRepository repository;

    public CouponService() {
        this.repository = new CouponRepository();
    }

    public Coupon getCoupon(int id){
        return repository.getByID(id);
    }

    public void addCoupon(Coupon coupon){
        repository.addCoupon(coupon);
    }

    public void deleteCoupon(int id) {
        repository.deleteCoupon(id);
    }
}
