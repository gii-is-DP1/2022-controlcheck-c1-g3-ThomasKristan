package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{

    @Autowired
    private RecoveryRoomService rrs;

    @Override
    public String print(RecoveryRoomType object, Locale locale) {
        return object.name;
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
        RecoveryRoomType recoveryRoomType = this.rrs.getRecoveryRoomType(text);
        if(recoveryRoomType != null) {
            return recoveryRoomType;
        } else {
            throw new ParseException("RecoveryRoomType not found: " + text, 0);
        }
    }

    
}
