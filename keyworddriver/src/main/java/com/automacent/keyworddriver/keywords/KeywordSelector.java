package com.automacent.keyworddriver.keywords;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.automacent.keyworddriver.anotations.Keyword;
import com.automacent.keyworddriver.enums.KeywordType;

public class KeywordSelector {

	List<Class<?>> keywordClasses = new ArrayList<>();
	{

		keywordClasses.add(UIKeywords.class);
		keywordClasses.add(InternalKeywords.class);
	}

	private Method method;

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	private KeywordType keywordtype;

	public KeywordType getKeywordtype() {
		return keywordtype;
	}

	public void setKeywordtype(KeywordType keywordtype) {
		this.keywordtype = keywordtype;
	}

	public KeywordSelector(String keyword) {
		super();
		generateMethod(keyword);
	}

	private void generateMethod(String keyword) {
		boolean isMethodFound = false;
		for (Class<?> keywordClass : keywordClasses) {
			for (Method method : keywordClass.getMethods()) {
				if (method.isAnnotationPresent(Keyword.class)) {
					Keyword annotation = method.getAnnotation(Keyword.class);
					this.method = method;
					this.keywordtype = annotation.type();
					isMethodFound = true;
					break;
				}
			}
			if (isMethodFound)
				break;
		}

		if (!isMethodFound) {
			/**
			 * 
			 * Throw exception
			 * 
			 */
		}

	}
}
