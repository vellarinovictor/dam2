package repaso.ejercicio4;

public class UtilFecha {
	public static int ddhhmmTosegundos(int dias,int horas,int minutos) {
		return dias*86400+horas*3600+minutos*60;
	}
	public static int horasMes(int dias) {
		return dias*24;
	}

}
