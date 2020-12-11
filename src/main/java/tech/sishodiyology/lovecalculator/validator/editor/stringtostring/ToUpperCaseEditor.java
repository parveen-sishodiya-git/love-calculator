package tech.sishodiyology.lovecalculator.validator.editor.stringtostring;

import java.beans.PropertyEditorSupport;

public class ToUpperCaseEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String str = text.toUpperCase();
		setValue(str);
	}

}
