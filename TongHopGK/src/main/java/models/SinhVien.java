package models;

public class SinhVien {
    private String mssv;
    private String hoTen;
    private double diemTb;

    public SinhVien(String mssv, String hoTen, double diemTb) {
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.diemTb = diemTb;
    }

	public SinhVien() {
		// TODO Auto-generated constructor stub
	}

	public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getDiemTb() {
        return diemTb;
    }

    public void setDiemTb(double diemTb) {
        this.diemTb = diemTb;
    }
}
