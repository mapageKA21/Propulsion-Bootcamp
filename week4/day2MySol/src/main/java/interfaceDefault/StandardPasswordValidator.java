package interfaceDefault;

public class StandardPasswordValidator implements PasswordValidator {

	@Override
	public boolean isLongEnough(String password) {
		if (password.length() > 8) return true;
		return false;
	}

}
