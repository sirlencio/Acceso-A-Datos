import java.sql.*;

public class Main {
    /*
    Realizar una clase para acceso a la BD instituto con los siguientes métodos
    Se deberán controlar los errores y utilizar sentencias preparadas.

    a) Conectar a la BD (cargar del driver y establecimiento de conexión)
    b) Cerrar la conexión
    c) Método que reciba un objeto y actualice la tabla profesor
    d) Método que reciba un número de centros y obtenga los nombres de las
    asignaturas que se imparten en el mismo
    e) Método que reciba una especialidad y elimine a los profesores que la imparten.
    El método devolverá el número de filas afectadas.
    f) Método que reciba una consulta (por ejemplo SELECT FROM CENTRO) e imprima el número
    de columnas recuperadas, y por cada columns el nombre, tipo, tamaño y si admite
    o no nulos
    */
    private static Connection conexion = null;

    public static void main(String[] args) {
        connect();

        Profesor p = new Profesor(9999, "Pedro almodovar", "Canutos", new Date(System.currentTimeMillis()), 'H', 1200, 1000);
        if (!comprobarProf(p.getCod_prof())) {
            insertarProfesor(p);
        }

        if (comprobarCentr(1000)) {
            asignaturasCentro(1000);
        }

        eliminaEspecialidad("canutos");

        String sql = "Select * from centro";
        datos(sql);

        disconnect();
    }

    public static void connect() {
        try {
            // Establecer la conexión con la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "instituto", "");
        } catch (SQLException e) {
            System.err.println("Error al establecer la conexión con la base de datos: " + e);
        }
    }

    public static void disconnect() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión con la base de datos: " + e);
        }
    }

    public static void datos(String sql) {
        try {
            PreparedStatement datos = conexion.prepareStatement(sql);
            ResultSet resultSet = datos.executeQuery();

            ResultSetMetaData meta = resultSet.getMetaData();
            System.out.println("N columnas: " + meta.getColumnCount());
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                System.out.println("Nombre columna: " + meta.getColumnName(i));
                System.out.println("Tipo columna: " + meta.getColumnTypeName(i));
                System.out.println("Tamanio columnas: " + meta.getColumnDisplaySize(i));
                System.out.println("Puede nulo: " + (meta.isNullable(i) == ResultSetMetaData.columnNullable));
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión con la base de datos: " + e);
        }
    }

    public static void insertarProfesor(Profesor profesor) {
        try {
            String sql = "Insert into profesor values (?, ?, ?, ?, ?, ?, ? )";
            PreparedStatement insertar = conexion.prepareStatement(sql);
            insertar.setDouble(1, profesor.getCod_prof());
            insertar.setString(2, profesor.getNombre_pro());
            insertar.setString(3, profesor.getEspe_pro());
            insertar.setDate(4, profesor.getFecha_nac());
            insertar.setString(5, profesor.getSexo() + "");
            insertar.setDouble(6, profesor.getSalario());
            insertar.setDouble(7, profesor.getCod_centro());
            insertar.executeUpdate();
            System.out.println("Profesor insertado");
        } catch (SQLException e) {
            System.err.println("Error al insertar el empleado: " + e);
        }
    }

    public static boolean comprobarProf(double cod) {
        boolean comprobar = false;
        try {
            String sql = "Select * from profesor where cod_prof like ?";
            PreparedStatement checkprof = conexion.prepareStatement(sql);
            checkprof.setInt(1, (int) cod);
            ResultSet resultSet = checkprof.executeQuery();

            if (resultSet.next()) {
                System.out.println("El código existe en la tabla");
                comprobar = true;
            } else {
                System.out.println("El código no existe en la tabla");
                comprobar = false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la conexión con la base de datos");
            e.printStackTrace();
        }
        return comprobar;
    }

    public static void asignaturasCentro(int codcentro) {
        try {
            String sql = "Select nombre_asi from asignatura where COD_PROF in(SELECT COD_PROF from profesor where COD_CENTRO like ? )";
            PreparedStatement checkprof = conexion.prepareStatement(sql);
            checkprof.setInt(1, codcentro);
            ResultSet resultSet = checkprof.executeQuery();


            while (resultSet.next()) {
                System.out.println("Nombre asignatura: " + resultSet.getString(1));
            }

        } catch (SQLException e) {
            System.out.println("Error en la conexión con la base de datos");
            e.printStackTrace();
        }
    }

    public static boolean comprobarCentr(int cod) {
        boolean comprobar = false;
        try {
            String sql = "Select * from profesor where COD_CENTRO like ?";
            PreparedStatement checkprof = conexion.prepareStatement(sql);
            checkprof.setInt(1, cod);
            ResultSet resultSet = checkprof.executeQuery();

            if (resultSet.next()) {
                System.out.println("El código existe en la tabla");
                comprobar = true;
            } else {
                System.out.println("El código no existe en la tabla");
                comprobar = false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la conexión con la base de datos");
            e.printStackTrace();
        }
        return comprobar;
    }

    public static int eliminaEspecialidad(String especialidad) {
        try {
            PreparedStatement psPre = conexion.prepareStatement("Delete from asignatura where COD_PROF in (select COD_PROF FROM profesor where ESPE_PRO = '" + especialidad + "')");
            int i = psPre.executeUpdate();
            System.out.println("Eliminadas asignaturas: " + i);
            PreparedStatement ps = conexion.prepareStatement("DELETE  FROM profesor " +
                    "WHERE ESPE_PRO = '" + especialidad + "'");
            int e = ps.executeUpdate();
            System.out.println("Eliminados Profesores: " + e);
            return e + i;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
