package Ejercicio_2;

public class departamento {
    private int dept_no;
    private String dnombre;
    private String loc;

    public departamento(int dept_no, String dnombre, String loc) {
        this.dept_no = dept_no;
        this.dnombre = dnombre;
        this.loc = loc;
    }

    public departamento(int dept_no) {
        this.dept_no = dept_no;
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Departamento{" + "dept_no=" + dept_no + ", dnombre='" + dnombre + '\'' + ", loc='" + loc + '\'' + '}';
    }
}
