package org.springframework.samples.petclinic.care;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CareFormatter implements Formatter<Care>{

    CareService careService;

    @Override
    public String print(Care object, Locale locale) {
        // TODO Auto-generated method stub
        return object.getName();
    }

    @Override
    public Care parse(String text, Locale locale) throws ParseException {
        // TODO Auto-generated method stub
        Care care = careService.getCare(text);
        if(care == null){
            throw new ParseException("Care not found: "+ text,0);
        }
        return care;
    }
    
}
