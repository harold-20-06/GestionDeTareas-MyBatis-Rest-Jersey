package com.spectrum.GestionDeTareas;

import com.spectrum.GestionDeTareas.model.Usuario;
import com.spectrum.GestionDeTareas.repository.UsuarioRepositoryImpl;
import com.spectrum.GestionDeTareas.service.UsuarioService;
import com.spectrum.GestionDeTareas.service.UsuarioServiceImpl;

import java.util.List;
import java.util.Scanner;

   public class ConsoleApp {
        private static final Scanner scanner = new Scanner(System.in);
        private static final UsuarioService usuarioService = new UsuarioServiceImpl(new UsuarioRepositoryImpl());

      public static void main(String[] args) {
            while (true) {
                showMainMenu();
                int option = getOptionFromUser();
                switch (option) {
                    case 1:
                        showUserMenu();
                        break;
                    case 2:
                        showTareaMenu();
                        break;
                    case 3:
                        showEtiquetaMenu();
                        break;
                    case 4:
                        showTareasEtiquetasMenu();
                        break;
                    case 0:
                        // Salir del programa
                        System.exit(0);
                }
            }
        }

        private static void showMainMenu() {
            System.out.println("------- Menú Principal -------");
            System.out.println("1. Gestionar Usuarios");
            System.out.println("2. Gestionar Tareas");
            System.out.println("3. Gestionar Etiquetas");
            System.out.println("4. Gestionar Tareas-Etiquetas");
            System.out.println("0. Salir");
            System.out.println("-----------------------------");
        }

        private static int getOptionFromUser() {
            System.out.print("Ingrese el número de opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            return option;
        }

        private static void showUserMenu() {
            while (true) {
                System.out.println("------- Menú Usuarios -------");
                System.out.println("1. Crear Usuario");
                System.out.println("2. Actualizar Usuario");
                System.out.println("3. Eliminar Usuario");
                System.out.println("4. Listar Usuarios");
                System.out.println("5. Buscar Usuario");
                System.out.println("0. Volver al Menú Principal");
                System.out.println("-----------------------------");

                int option = getOptionFromUser();
                switch (option) {
                    case 1:
                        createUser();
                        break;
                    case 2:
                        updateUser();
                        break;
                    case 3:
                        deleteUser();
                        break;
                    case 4:
                        getAllUser();
                        break;
                    case 5:
                        showUserMenuByCriteria();
                        break;
                    case 0:
                        return; // Volver al Menú Principal
                }
            }
        }


        private static void createUser() {
            System.out.println("------- Crear Usuario -------");
            try {
                System.out.println("Ingrese el nombre: ");
                String nombre = scanner.nextLine();
                System.out.println("Ingrese el correo electrónico: ");
                String correo = scanner.nextLine();
                System.out.println("Ingrese la contraseña: ");
                String contrasena = scanner.nextLine();

                Usuario usuario = new Usuario(nombre, correo, contrasena);
                System.out.println(usuario);
                boolean esExitoso = usuarioService.insertUsuario(usuario);
                if (esExitoso) {
                    System.out.println("Usuario creado exitosamente");
                } else {
                    System.out.println("Error al crear el usuario");
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error durante la creación del usuario: " + e.getMessage());
                e.printStackTrace();
            }
        }

        private static void updateUser() {
            System.out.println("------- Actualizar Usuario -------");
            try {
                System.out.println("Ingrese el ID del usuario a actualizar: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                Usuario usuarioActualizar = usuarioService.getUsuarioById(id);
                System.out.println("Ingrese el nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                System.out.println("Ingrese el nuevo correo electrónico: ");
                String nuevoCorreo = scanner.next();
                System.out.println("Ingrese la nueva contraseña: ");
                String nuevaContrasena = scanner.next();

                Usuario usuarioActualizado = new Usuario(nuevoNombre, nuevoCorreo, nuevaContrasena);
                usuarioActualizado.setId(id);
                System.out.println("Anterior "+usuarioActualizar);
                System.out.println("Actual "+usuarioActualizado);
                boolean esExitoso = usuarioService.updateUsuario(usuarioActualizado);
                if (esExitoso) {
                    System.out.println("Usuario actualizado exitosamente");
                } else {
                    System.out.println("Error al actualizar el usuario");
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error durante la actualización del usuario: " + e.getMessage());
                e.printStackTrace();
            }
        }

        private static void deleteUser() {
            System.out.println("------- Eliminar Usuario -------");
            try {
                System.out.println("Ingrese el ID del usuario a eliminar: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.println(usuarioService.getUsuarioById(id));
                boolean esExitoso = usuarioService.deleteUsuario(id);
                if (esExitoso) {
                    System.out.println("Usuario eliminado exitosamente");
                } else {
                    System.out.println("Error al eliminar el usuario");
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error durante la eliminación del usuario: " + e.getMessage());
                e.printStackTrace();
            }
        }


       private static void getAllUser() {
           System.out.println("------- Lista de Usuarios -------");
           try {

               List<Usuario> usuarios = usuarioService.getAllUsuario();
               if (usuarios != null) {
                   mostrarUsuarios(usuarios);

               } else {
                   System.out.println("no se encontro usuarios");
               }
           } catch (Exception e) {
               System.out.println("Ocurrió un error durante consulta de usuarios: " + e.getMessage());
               e.printStackTrace();
           }
       }

       private static void showUserMenuByCriteria() {
           while (true) {
               System.out.println("------- Menú Buscar por Criterio -------");
               System.out.println("1. Buscar por id");
               System.out.println("2. Buscar por nombre");
               System.out.println("3. Buscar por correo");
               System.out.println("0. Salir");
               System.out.println("-----------------------------");
               int option = getOptionFromUser();
               switch (option) {
                   case 1:
                       System.out.println("1. Buscar por id");
                       System.out.println("----------------");
                       System.out.println("Introduzca id a buscar: ");
                       int id;
                       if (scanner.hasNextInt()) {
                           id = scanner.nextInt();
                           scanner.nextLine();

                           List<Usuario> usuarioId = usuarioService.getUsuarioByCriterio("id",id);
                           mostrarUsuarios(usuarioId);
                       } else {
                           String input = scanner.nextLine();
                           System.out.println("Entrada inválida. Se esperaba un número entero.");
                       }
                       break;
                   case 2:
                       System.out.println("Introduzca nombre a buscar");
                       String nombre = scanner.nextLine();
                       List<Usuario> usuarioNombre = usuarioService.getUsuarioByCriterio("nombre", nombre);
                       mostrarUsuarios(usuarioNombre);
                       break;
                   case 3:
                       System.out.println("Introduzca correo a buscar");
                       String correo = scanner.nextLine();
                       List<Usuario> usuarioCorreo = usuarioService.getUsuarioByCriterio("nombre", correo);
                       mostrarUsuarios(usuarioCorreo);
                       break;
                   case 0:
                       return; // Volver al Menú User
               }
           }
       }
       private static void getUsuarioById() {
           System.out.println("------- Usuario Encontrado -------");
           try {
               System.out.println("Introduzca id a buscar :");
               int id = scanner.nextInt();
               scanner.nextLine();
               Usuario usuario = usuarioService.getUsuarioById(id);
               if (usuario != null) {
                   System.out.println(usuario);
                   System.out.println("-----------------------------");
               } else {
                   System.out.println("no se encontro usuario con id "+ id);
               }
           } catch (Exception e) {
               System.out.println("Ocurrió un error durante consulta de usuario por id: " + e.getMessage());
               e.printStackTrace();
           }
       }
       private static void mostrarUsuarios(List<Usuario> usuarios) {
           if (usuarios.isEmpty()) {
               System.out.println("No se encontraron usuarios.");
           } else {
               int cantidadUsuarios = usuarios.size();
               for (Usuario usuario : usuarios) {
                   System.out.println(usuario);
                   System.out.println("-----------------------------");
               }
               System.out.println("Cantidad de usuarios mostrados: " + cantidadUsuarios);
           }
       }


       private static void showTareaMenu() {
            // Implementar menú de gestión de tareas
        }

        private static void showEtiquetaMenu() {
            // Implementar menú de gestión de etiquetas
        }

        private static void showTareasEtiquetasMenu() {
            // Implementar menú de gestión de tareas-etiquetas
        }
    }





