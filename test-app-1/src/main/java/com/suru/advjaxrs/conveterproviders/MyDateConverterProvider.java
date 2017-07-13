package com.suru.advjaxrs.conveterproviders;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Calendar;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import com.suru.advjaxrs.model.MyDate;

@Provider
// provider which provides param converter
public class MyDateConverterProvider implements ParamConverterProvider {

	// dealing with a generic type
	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, 
						Type genericType, Annotation[] annotations) {

		// checking the type id MyDate or not
		if (rawType.getName().equals(MyDate.class.getName())) {

			// ParamConverter is a converter
			return new ParamConverter<T>() {

				// string representation of the request
				@Override
				public T fromString(String value) {

					// checking the param data
					Calendar calendar = Calendar.getInstance();
					if (value.equals("tomorrow")) {
						calendar.add(Calendar.DATE, 1);
					} else if (value.equals("yesterday")) {
						calendar.add(Calendar.DATE, -1);
					}
					// my custom data type for date
					MyDate myDate = new MyDate();
					myDate.setMonth(calendar.get(Calendar.MONTH));
					myDate.setDay(calendar.get(Calendar.DATE));
					myDate.setYear(calendar.get(Calendar.YEAR));
					
					// returning my result data type as generic
					return rawType.cast(myDate);
				}

				@Override
				public String toString(T value) {
					return value.toString();
				}

			};
		}
		// return null with other data types
		return null;
	}

}
