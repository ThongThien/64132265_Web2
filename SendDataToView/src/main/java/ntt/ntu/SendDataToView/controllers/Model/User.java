package ntt.ntu.SendDataToView.controllers.Model;

public class User {	
    private String mssv, ten, gioiTinh, namSinh;

    public User(String mssv, String ten, String gioiTinh, String namSinh) {
        this.mssv = mssv;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
    }

    public String getMssv() {
        return mssv;
    }

    public String getTen() {
        return ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getNamSinh() {
        return namSinh;
    }
}
