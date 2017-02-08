package interfaceDefault;

public interface PasswordValidator {
	
	boolean isLongEnough(String password);

	default boolean isValid(String password) {
		return isLongEnough(password);
	}
}
