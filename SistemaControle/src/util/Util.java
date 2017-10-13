package util;

import java.text.*;
import java.util.Date;

public class Util
{

    public static Date converterData(String rowData)
    {
        Date data = new Date();
        try
        {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            data = df.parse(rowData);
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }
        return data;
    }

    public static Object converterToString(Date data)
    {
        String dataString = null;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        dataString = df.format(data);
        return dataString;
    }
}
