package algoritmo;

public class MapaSemNenhumaVisaoException extends RuntimeException {

	private static final long serialVersionUID = -4744426787005988267L;

	public MapaSemNenhumaVisaoException() {
		super("mapa sem nenhuma vis‹o");
	}

	public MapaSemNenhumaVisaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public MapaSemNenhumaVisaoException(String message) {
		super(message);
	}

	public MapaSemNenhumaVisaoException(Throwable cause) {
		super(cause);
	}

}
