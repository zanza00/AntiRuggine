package Currency;

import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by @Simone on 29/07/2015.
 */
public class Symbols {

    public static void main(String args[]) {

        // create a currency for uk locale
        String strLocale= "en_US";
        String[] strLocSplit = strLocale.split("_");
        Locale locale = new Locale(strLocSplit[0],strLocSplit[1]);
        Currency curr = Currency.getInstance(locale);

        // get and print the symbol of the currency
        String symbol = curr.getSymbol(locale);
        System.out.println("Currency symbol is = " + symbol);


        Float localizedCurrencyValue = 3.3F;
        String pattern = "0,000.0#";
        pattern = symbol+pattern;
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.applyPattern(pattern);
        String output = decimalFormat.format(localizedCurrencyValue);
        System.out.println("Final currency is = " + output);
    }
}

