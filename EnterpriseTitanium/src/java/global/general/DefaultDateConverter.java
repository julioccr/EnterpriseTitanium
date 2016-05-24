/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package global.general;

import java.util.TimeZone;
import javax.faces.convert.DateTimeConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author JCortorreal
 */
@FacesConverter("defaultDateConverter")
public class DefaultDateConverter extends DateTimeConverter {

    public DefaultDateConverter() {
        setDateStyle("medium");
        setType("date");
        setTimeZone(TimeZone.getTimeZone("EST"));
    }

}