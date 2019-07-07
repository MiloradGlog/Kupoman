package grupa.rest.coupon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Coupon {

    private int couponId;
    private int couponVersion;

    private String naziv;

    public Coupon(){
    }

    public Coupon(String naziv){
        this.naziv = naziv;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getCouponVersion() {
        return couponVersion;
    }

    public void setCouponVersion(int couponVersion) {
        this.couponVersion = couponVersion;
    }
}
