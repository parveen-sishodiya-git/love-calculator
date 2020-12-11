/**
 * 
 */
package tech.sishodiyology.lovecalculator.validator.editor.stringtonumber;

import java.beans.PropertyEditorSupport;

/**
 * @author Parveen Sishodiya
 *
 */
public class OnlyNumericsEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(removeCharsFromNumber(text));
	}

	private Object removeCharsFromNumber(String text) {
		// TODO Auto-generated method stub
		char[] textCharArray = text.toCharArray();
		text = "";
		for (int i = 0; i < textCharArray.length; i++) {
			if (textCharArray[i] > 47 && textCharArray[i] < 58) {
				text = text + textCharArray[i];
			}
		}
		try {
			return Integer.parseInt(text);
		} catch (Exception e) {
			return Integer.parseInt("0");
		}
	}

}
