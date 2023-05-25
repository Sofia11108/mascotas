package mascotas;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class Procesos {

		HashMap<String, Mascota> mapaMascotas = new HashMap<String, Mascota>();

		public Procesos() {
			
		}

		public void iniciar() {

			int opcion;

			do {
				opcion = Integer.parseInt(JOptionPane.showInputDialog(menu()));
				validarOpcion(opcion);
			} while (opcion != 5);
		}

		private String menu() {

			String menu = "";

			menu += "---- menu ----";
			menu += "\n\nIngrese la opcion:\n";
			menu += "\n1- Registrar mascotas.";
			menu += "\n2- Consultar lista de mascotas.";
			menu += "\n3- Consultar mascota.";
			menu += "\n4- Modificar datos de una mascota.";
			menu += "\n5- Salir.\n\n";

			return menu;
		}

		private void validarOpcion(int opcion) {

			switch (opcion) {

			case 1:
				registrarMascotas();
				break;

			case 2:
				listaMascotas();
				break;

			case 3:
				buscarMascota();
				break;

			case 4:
				actualizarMascota();
				break;

			case 5: JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opcion incorrecta");
			}
		}


		private void registrarMascotas() {

			int n;

			n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de mascotas"));

			for (int i = 0; i < n; i++) {

				Mascota mascota = new Mascota();

				mascota.registrarMascota(i);
				mapaMascotas.put(mascota.identificacion, mascota);
			}
		}

		
		public void listaMascotas() {

			String mensaje = "---- mascotas registradas ----\n";
			
			for (Mascota mascota : mapaMascotas.values()) {
				mensaje += "Identificacion: " + mascota.identificacion;
				mensaje += "\nNombre: " + mascota.nombre;
				mensaje += "\nEspecie: " + mascota.especie;
				mensaje += "\nEdad: " + mascota.edad;
				mensaje += "\nSonido: " + mascota.hacerSonido();
				mensaje += "\nActividades: " + mascota.actividades();
				mensaje += "\n \n";
			}

			JOptionPane.showMessageDialog(null, mensaje);
		}

		
		public void buscarMascota() {
			String mensaje = null;
			
			String identificacion = JOptionPane.showInputDialog("Ingrese la identificacion de la mascota a consultar");
			
			if (mapaMascotas.containsKey(identificacion)) {
				
				Mascota mascota = mapaMascotas.get(identificacion);
				mensaje = "---- Buscar máscota ----\n";

				mensaje += "\nIdentificacion: " + mascota.identificacion;
				mensaje += "\nNombre: " + mascota.nombre;
				mensaje += "\nEspecie: " + mascota.especie;
				mensaje += "\nEdad: " + mascota.edad;
				mensaje += "\nSonido: " + mascota.hacerSonido();
				mensaje += "\n";
				
			} else {
				JOptionPane.showMessageDialog(null, "La identificación de la mascota ingresada no se encuentra en el sistema");
			}
			
			JOptionPane.showMessageDialog(null, mensaje);
		}
		
		
		private void actualizarMascota() {

			String identificacion = JOptionPane.showInputDialog("Ingrese la identificacion de la mascota a consultar");
			
			String nombre = "";
			String especie = "";
			int edad = 0, opcion = 0; 
			
			Mascota mascota = mapaMascotas.get(identificacion);
			
			if (mapaMascotas.containsKey(identificacion)) {
				
				do {				
					opcion = Integer.parseInt(JOptionPane.showInputDialog("Elija que desea actualizar: 1.Nombre | 2.Especie | 3.Edad"));
				}while(opcion < 1 || opcion > 3);
				
				switch (opcion) {
					
				case 1: nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la mascota").toLowerCase();
						mascota.nombre = nombre;
						break;
						
				case 2: especie = JOptionPane.showInputDialog("Ingrese la nueva especie de la mascota").toLowerCase();		
						mascota.especie = especie;
						break;
						
				case 3: edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad de la mascota"));
						mascota.edad = edad;
						break;
				}	
				
				JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
				
			}else {
				JOptionPane.showMessageDialog(null, "La identificacion ingresada no se encuentra en el sistema");
			}
			
			
		}

}
