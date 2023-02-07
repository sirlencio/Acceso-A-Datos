package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Scanner;

public class Ejercicio36 {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        SessionFactory sesionF = HibernateUtil.getSessionFactory();
        Session s = sesionF.openSession();
        int opc = 0, id;
        do {
            menu();
            opc = input.nextInt();
            switch (opc) {
                case 1:
                    System.out.print("Inserte el id del cliente: ");
                    id = input.nextInt();
                    if (!comprobarIDCliente(s, id)) {
                        insertarCliente(s, id);
                    }
                    break;
                case 2:
                    System.out.print("Inserte el id del producto: ");
                    id = input.nextInt();
                    if (!comprobarIDProducto(s, id)) {
                        insertarProducto(s, id);
                    }
                    break;
                case 3:
                    System.out.print("Inserte el id de la venta: ");
                    id = input.nextInt();
                    if (!comprobarIDVenta(s, id)) {
                        insertarVenta(s, id);
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opc != 0);
    }

    public static void insertarVenta(Session s, int id) {
        s.beginTransaction();
        Ventas v = new Ventas();

        input.nextLine();
        System.out.print("Inserte la fecha de la venta (AAAA-mm-dd): ");
        String fecha = input.nextLine();

        System.out.print("Inserte el id del cliente de esa venta: ");
        int idcli = input.nextInt();
        Clientes c = s.get(Clientes.class, idcli);

        if (c == null) {
            System.out.println("El cliente con ese id no existe");
            s.getTransaction().commit();
        } else {
            System.out.print("Inserte el id del producto de esa venta: ");
            int idpro = input.nextInt();
            Productos p = s.get(Productos.class, idpro);

            if (p == null) {
                System.out.println("El producto con ese id no existe");
                s.getTransaction().commit();
            } else {
                System.out.print("Inserte la cantidad vendida:");
                int cantidad = input.nextInt();

                if (p.getStockactual() - cantidad < p.getStockminimo()) {
                    System.out.println("El producto debe tener stock");
                    s.getTransaction().commit();
                } else {
                    v.setIdventa(id);
                    v.setFechaventa(Date.valueOf(fecha));
                    v.setClientesByIdcliente(c);
                    v.setProductosByIdproducto(p);
                    v.setCantidad(cantidad);

                    s.persist(v);
                    s.getTransaction().commit();
                    s.close();
                    System.out.println("Venta insertada");
                }
            }
        }
    }

    public static void insertarProducto(Session s, int id) {
        s.beginTransaction();
        Productos p = new Productos();

        input.nextLine();
        System.out.print("Inserte la descripcion del producto: ");
        String desc = input.nextLine();
        System.out.print("Inserte el stock actual del producto: ");
        int stockact = input.nextInt();
        System.out.print("Inserte el stock minimo del producto: ");
        int stockmin = input.nextInt();
        System.out.print("Inserte el pvp del producto: ");
        double pvp = input.nextDouble();

        p.setId(id);
        p.setDescripcion(desc);
        p.setStockactual(stockact);
        p.setStockminimo(stockmin);
        p.setPvp(BigDecimal.valueOf(pvp));

        s.persist(p);
        s.getTransaction().commit();
        System.out.println("Producto insertado");
    }

    public static void insertarCliente(Session s, int id) {
        s.beginTransaction();
        Clientes c = new Clientes();

        input.nextLine();
        System.out.print("Inserte el nombre del cliente: ");
        String nombre = input.nextLine();
        System.out.print("Inserte la direccion del cliente: ");
        String direccion = input.nextLine();
        System.out.print("Inserte la poblacion del cliente: ");
        String pobl = input.nextLine();
        System.out.print("Inserte el telefono del cliente: ");
        String tfno = input.nextLine();
        System.out.print("Inserte el nif del cliente: ");
        String nif = input.nextLine();

        c.setId(id);
        c.setNombre(nombre);
        c.setDireccion(direccion);
        c.setPoblacion(pobl);
        c.setTelef(tfno);
        c.setNif(nif);

        s.persist(c);
        s.getTransaction().commit();
        System.out.println("Cliente insertado");
    }

    public static void menu() {
        System.out.println("1.- Insertar un cliente");
        System.out.println("2.- Insertar un producto");
        System.out.println("3.- Insertar una venta");
        System.out.println("0.- Salir");
        System.out.println("Eliga una opcion: ");
    }

    public static boolean comprobarIDCliente(Session s, int id) {
        Clientes c = s.get(Clientes.class, id);
        if (c == null) {
            return false;
        } else {
            System.out.println("Ya existe un cliente con ese id");
            return true;
        }
    }

    public static boolean comprobarIDProducto(Session s, int id) {
        Productos p = s.get(Productos.class, id);
        if (p == null) {
            return false;
        } else {
            System.out.println("Ya existe un producto con ese id");
            return true;
        }
    }

    public static boolean comprobarIDVenta(Session s, int id) {
        Ventas v = s.get(Ventas.class, id);
        if (v == null) {
            return false;
        } else {
            System.out.println("Ya existe una venta con ese id");
            return true;
        }
    }
}
