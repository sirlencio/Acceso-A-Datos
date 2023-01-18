package Ejercicio_2;

import java.sql.*;
import java.util.ArrayList;

public class ejercicio2 {
    private static Connection conexion = null;

    public static void main(String[] args) {
        // a) Conectar a la base de datos (carga del driver y establecimiento de conexión).
        connect();

        // b)	Insertar un departamento. El método recibirá los argumentos: número, nombre y localidad.
        insertarDepartamento(1, "Comunicaciones", "Huelva");

        // c)	Lo mismo que b) pero recibiendo un solo argumento que será un objeto de la clase departamento.
        insertarDepartamento(new departamento(2, "Informacion", "Huelva"));

        // d)	Método que devuelve un ArrayList de objetos departamento ante la consulta de todas las columnas de todos los departamentos de la tabla departamento.
        System.out.println(listaDepartamentos().toString());

        // e)	Método que reciba un número de departamento y devuelva una lista de los empleados.
        System.out.println(listaEmpleadosDep(1).toString());

        // f)	Método que recibe el número de un departamento y un nuevo nombre y devuelve el número de filas afectadas.
        System.out.println("Se cambiaron " + cambioNombreDepartamento(1, "Maletas") + " departamentos de nombre");

        // g)	Método que reciba objeto departamento y actualice su localidad (segundo argumento delmétodo). Utilizar el siguiente procedemientoMySQL:
        //      delimiter $$
        //      CREATE PROCEDURE `actualizaDept`(cod INT(2), loc VARCHAR(13))
        //      BEGIN
        //      UPDATE Dept SET localidad = loc WHERE n_dep = cod;
        //      END$$
        actualizarLocalidad(new departamento(1), "Cadiz");

        // h)	Método que reciba una cantidad y un número de departamento e incremente el sueldo de todos los empleados de ese departamento en esa cantidad.
        incrementoSalario(150, 1);

        // i)	Método que imprima todas las tablas y vistas del esquema actual, indicando además, sitrata de una tabla o una vista.
        printDBinfo();

        disconnect();
    }

    public static void connect() {
        try {
            // Establecer la conexión con la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/unidad2", "unidad2", "");
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

    public static void insertarDepartamento(int numero, String nombre, String localidad) {
        try {
            String sql = "Insert into departamentos values (" + numero + ",'" + nombre + "',\'" + localidad + "')";
            PreparedStatement insertar = conexion.prepareStatement(sql);
            insertar.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar el departamento: " + e);
        }
    }

    public static void insertarDepartamento(departamento dep) {
        try {
            String sql = "Insert into departamentos values (" + dep.getN_dep() + ",'" + dep.getNombre_dep() + "',\'" + dep.getLocalidad() + "')";
            PreparedStatement insertar = conexion.prepareStatement(sql);
            insertar.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar el departamento: " + e);
        }
    }

    public static ArrayList<departamento> listaDepartamentos() {
        ArrayList<departamento> departamentos = new ArrayList<>();
        departamento dep;
        try {
            String sql = "Select * from departamentos";
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            ResultSet resul = sentencia.executeQuery();
            while (resul.next()) {
                dep = new departamento(resul.getInt(1), resul.getString(2), resul.getString(3));
                departamentos.add(dep);
            }
        } catch (SQLException e) {
            System.err.println("Error al realizar la consulta: " + e);
        }
        return departamentos;
    }

    public static ArrayList<empleado> listaEmpleadosDep(int n_dep) {
        ArrayList<empleado> empleados = new ArrayList<>();
        empleado emple;
        try {
            String sql = "Select * from empleados where n_dep = " + n_dep;
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            ResultSet resul = sentencia.executeQuery();
            while (resul.next()) {
                emple = new empleado(resul.getInt(1), resul.getString(2), resul.getString(3), resul.getInt(4), resul.getDate(5), resul.getFloat(6), resul.getFloat(7), resul.getInt(8));
                empleados.add(emple);
            }
        } catch (SQLException e) {
            System.err.println("Error al realizar la consulta: " + e);
        }
        return empleados;
    }

    public static int cambioNombreDepartamento(int n_dep, String nuevo) {
        int afectadas = 0;
        try {
            String sql = "update departamentos set nombre_dep = '" + nuevo + "' where n_dep = " + n_dep;
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            afectadas = sentencia.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al realizar el update: " + e);
        }
        return afectadas;
    }

    public static void actualizarLocalidad(departamento dep, String localidad) {
        try {
            String sql = "call actualizaDept(" + dep.getN_dep() + ",'" + localidad + "')";
            CallableStatement sentencia = conexion.prepareCall(sql);
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al realizar el procedimiento: " + e);
        }
    }

    public static void incrementoSalario(int cantidad, int n_dep) {
        try {
            String sql = "update empleados set salario = salario+" + cantidad + " where n_dep = " + n_dep;
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al realizar el update: " + e);
        }
    }

    public static void printDBinfo() {
        try {
            DatabaseMetaData m = conexion.getMetaData();
            ResultSet resultSet = m.getTables("unidad2", null, null, null);
            while (resultSet.next()) {
                System.out.printf("Tabla %s %n", resultSet.getString("TABLE_NAME").toUpperCase());
                System.out.printf("\tTipo: %s %n", resultSet.getString("TABLE_TYPE"));
            }
        } catch (SQLException e) {
            System.err.println("Error al realizar la consulta: " + e);
        }
    }
}