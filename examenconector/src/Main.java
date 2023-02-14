import java.sql.*;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class Main {
    public static Connection conexion;

    public static void main(String[] args) {
        connect();

        int cod = 5;
        String nombre = "las plamas", email = "aaa@email.com";
        if (!comprobarProf(cod)) {
            actualizaEstudio(cod, nombre, email);
        }
        System.out.println();

        infoArtista(16);
        System.out.println();

        System.out.println("Filas afectadas: " + eliminaArtista(99));
        System.out.println();

        datos("artistas");

        disconnect();
    }

    public static int printDBinfo(String tabla) {
        int n = 0;
        try {
            DatabaseMetaData m = (DatabaseMetaData) conexion.getMetaData();
            ResultSet foreignKeys = m.getExportedKeys(conexion.getCatalog(), null, tabla);

            while (foreignKeys.next()) {
                System.out.println("Claves ajenas que usan la clave primaria de esta tabla:");
                String fkTableName = "Tabla: " + foreignKeys.getString("FKTABLE_NAME");
                String fkName = "Nombre de la relacion: " + foreignKeys.getString("FK_NAME");
                String fkColumnName = "Nombre de la clave ajena: " + foreignKeys.getString("FKCOLUMN_NAME");
                System.out.println(fkTableName);
                System.out.println(fkName);
                System.out.println(fkColumnName);
                n = 1;
            }
        } catch (SQLException e) {
            System.err.println("Error al realizar la consulta: " + e);
        }
        return n;
    }

    public static void datos(String tabla) {
        try {
            System.out.println("Tabla: " + tabla);
            PreparedStatement datos = conexion.prepareStatement("select * from " + tabla);
            ResultSet resultSet = datos.executeQuery();
            ResultSetMetaData meta = resultSet.getMetaData();

            System.out.println("N columnas: " + meta.getColumnCount());
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                System.out.println("Nombre columna: " + meta.getColumnName(i));
                System.out.println("Tipo columna: " + meta.getColumnTypeName(i));
                System.out.println("Tamaño columnas: " + meta.getColumnDisplaySize(i));
            }
            if (printDBinfo(tabla) == 0) {
                System.out.println("Su clave primaria no es ajena en otra tabla");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión con la base de datos: " + e);
        }
    }


    public static int eliminaArtista(int id) {
        try {
            PreparedStatement del = conexion.prepareStatement("Delete from pel_art where artista_id like " + id);
            int i = del.executeUpdate();
            System.out.println("Eliminadas peliculas en las que partcipaba: " + i);
            PreparedStatement del2 = conexion.prepareStatement("DELETE  FROM peliculas WHERE director_id like " + id);
            int j = del2.executeUpdate();
            System.out.println("Eliminados peliculas dirigidas por ese artista: " + j);
            PreparedStatement del3 = conexion.prepareStatement("DELETE  FROM artistas WHERE artista_id like " + id);
            int k = del3.executeUpdate();
            System.out.println("Eliminados artistas con ese id: " + k);
            return i + j + k;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void infoArtista(int id) {
        try {
            String sql = "Select * from artistas where artista_id like ?";
            PreparedStatement check = conexion.prepareStatement(sql);
            check.setInt(1, id);
            ResultSet resultSet = check.executeQuery();

            if (resultSet.next()) {
                System.out.println("Artista id: " + resultSet.getInt(1));
                System.out.println("Artista nombre: " + resultSet.getString(2));
                System.out.println("Artista numero peliculas: " + contarPeliArt(id));
            } else {
                System.out.println("El artista con ese id no existe");
            }
        } catch (SQLException e) {
            System.out.println("Error en la conexión con la base de datos");
            e.printStackTrace();
        }
    }

    public static int contarPeliArt(int id) {
        int n = 0;
        try {
            String sql = "Select count(pelicula_id) from pel_art where artista_id like ?";
            PreparedStatement check = conexion.prepareStatement(sql);
            check.setInt(1, id);
            ResultSet resultSet = check.executeQuery();

            if (resultSet.next()) {
                n = resultSet.getInt(1);
            } else {
                System.out.println("El artista con ese id no existe");
            }
        } catch (SQLException e) {
            System.out.println("Error en la conexión con la base de datos");
            e.printStackTrace();
        }
        return n;
    }

    public static void actualizaEstudio(int cod, String nombre, String email) {
        try {
            String sql = "Insert into estudios values (?, ?, ? )";
            PreparedStatement insertar = conexion.prepareStatement(sql);
            insertar.setInt(1, cod);
            insertar.setString(2, nombre);
            insertar.setString(3, email);
            insertar.executeUpdate();
            System.out.println("Estudio introducido");
        } catch (SQLException e) {
            System.err.println("Error al introducir estudio: " + e);
        }
    }

    public static boolean comprobarProf(int cod) {
        boolean comprobar = false;
        try {
            String sql = "Select * from estudios where estudio_id like ?";
            PreparedStatement check = conexion.prepareStatement(sql);
            check.setInt(1, cod);
            ResultSet resultSet = check.executeQuery();

            if (resultSet.next()) {
                System.out.println("El código existe en la tabla");
                comprobar = true;
            } else {
                comprobar = false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la conexión con la base de datos");
            e.printStackTrace();
        }
        return comprobar;
    }

    public static void connect() {
        try {
            // Establecer la conexión con la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/peliculas", "examen", "examen");
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
}