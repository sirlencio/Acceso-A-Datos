import java.sql.Date;

public class Profesor {
    double cod_prof, salario, cod_centro;
    String nombre_pro;
    String espe_pro;
    char sexo;
    Date fecha_nac;

    public Profesor() {
    }

    public Profesor(double cod_prof, String nombre_pro, String espe_pro, Date fecha_nac, char sexo, double salario, double cod_centro) {
        this.cod_prof = cod_prof;
        this.salario = salario;
        this.cod_centro = cod_centro;
        this.nombre_pro = nombre_pro;
        this.espe_pro = espe_pro;
        this.sexo = sexo;
        this.fecha_nac = fecha_nac;
    }

    public double getCod_prof() {
        return cod_prof;
    }

    public void setCod_prof(double cod_prof) {
        this.cod_prof = cod_prof;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getCod_centro() {
        return cod_centro;
    }

    public void setCod_centro(double cod_centro) {
        this.cod_centro = cod_centro;
    }

    public String getNombre_pro() {
        return nombre_pro;
    }

    public void setNombre_pro(String nombre_pro) {
        this.nombre_pro = nombre_pro;
    }

    public String getEspe_pro() {
        return espe_pro;
    }

    public void setEspe_pro(String espe_pro) {
        this.espe_pro = espe_pro;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "cod_prof=" + cod_prof +
                ", salario=" + salario +
                ", cod_centro=" + cod_centro +
                ", nombre_pro='" + nombre_pro + '\'' +
                ", espe_pro='" + espe_pro + '\'' +
                ", sexo=" + sexo +
                ", fecha_nac=" + fecha_nac +
                '}';
    }
}
