package com.suru.juintex1;

public class StringHelper {

	// truncate first two chars if they are 'A'
	// AACD -> CD
	// ACD -> CD
	// AAACS -> ACS
	public String tuncate2APositionsFirst(String string) {
		if (string == null || string.isEmpty()) {
			return null;
		}
		if (string.charAt(0) == 'A') {
			string = string.substring(1);
			if (string.charAt(0) == 'A') {
				string = string.substring(1);
			}
		}
		return string;
	}

	// ASSAZ -> false
	// AHJKSA -> true
	public boolean firstAndLastCharsAreSame(String string) {
		if (string == null || string.isEmpty()) {
			return false;
		}
		return (string.length() == 1 || (string.charAt(0) == string.charAt(string.length() - 1)));
	}

}
