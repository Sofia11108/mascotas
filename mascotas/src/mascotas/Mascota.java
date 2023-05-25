package mascotas;

import javax.swing.JOptionPane;

public class Mascota {

    String identificacion;
    String nombre;
    String especie;
    int edad;

    public Mascota() {

    }

    public Mascota(String identificacion, String nombre, String especie, int edad) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public void registrarMascota(int i) {
    	
        nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota # " + (i+1)).toLowerCase();
    	identificacion = JOptionPane.showInputDialog("Ingrese la identificacion de la mascota " + nombre).toLowerCase();
        especie = JOptionPane.showInputDialog("Ingrese la especie de la mascota " + nombre).toLowerCase();
        edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota " + nombre));
    }

    
    public String hacerSonido() {

        String sonido = "";

        if (especie.equalsIgnoreCase("perro")) {
            sonido = "¡Guau guau!";
        } else if (especie.equalsIgnoreCase("gato")) {
            sonido = "¡Miau miau!";
        } else {
            sonido = "La mascota no hace sonidos conocidos.";
        }

        return sonido;
    }
    

    public void comer() {
        System.out.println(nombre + " está comiendo");
    }

    public String actividades() {
    	
    	String resultado;
    	
		if (especie.equalsIgnoreCase("perro")) {
			resultado = "estoy corriendo \n";
			
		} else if (especie.equalsIgnoreCase("gato")) {
			resultado = "estoy arañando";
	
		} else {
			resultado = "estoy durmiendo";
		}
		
		return resultado;
	}

}
