package team2.cs246.nationalparkapp.model;

import com.google.android.gms.common.util.Strings;

import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.text.WordUtils.capitalizeFully;

/**
 * Simple tool to convert state names to state codes and back.
 * Source: https://stackoverflow.com/a/39479536
 */
public class StateHelper {
    private static final Map<String, String> stateCodeToNameMap = new HashMap<>();
    private static final Map<String, String> stateNameToCodeMap = new HashMap<>();
    static {
        // Load US Codes.
        stateCodeToNameMap.put("AK", "Alaska");
        stateCodeToNameMap.put("AL", "Alabama");
        stateCodeToNameMap.put("AR", "Arkansas");
        stateCodeToNameMap.put("AZ", "Arizona");
        stateCodeToNameMap.put("CA", "California");
        stateCodeToNameMap.put("CO", "Colorado");
        stateCodeToNameMap.put("CT", "Connecticut");
        stateCodeToNameMap.put("DC", "District of Columbia");
        stateCodeToNameMap.put("DE", "Delaware");
        stateCodeToNameMap.put("FL", "Florida");
        stateCodeToNameMap.put("GA", "Georgia");
        stateCodeToNameMap.put("HI", "Hawaii");
        stateCodeToNameMap.put("IA", "Iowa");
        stateCodeToNameMap.put("ID", "Idaho");
        stateCodeToNameMap.put("IL", "Illinois");
        stateCodeToNameMap.put("IN", "Indiana");
        stateCodeToNameMap.put("KS", "Kansas");
        stateCodeToNameMap.put("KY", "Kentucky");
        stateCodeToNameMap.put("LA", "Louisiana");
        stateCodeToNameMap.put("MA", "Massachusetts");
        stateCodeToNameMap.put("MD", "Maryland");
        stateCodeToNameMap.put("ME", "Maine");
        stateCodeToNameMap.put("MI", "Michigan");
        stateCodeToNameMap.put("MN", "Minnesota");
        stateCodeToNameMap.put("MO", "Missouri");
        stateCodeToNameMap.put("MS", "Mississippi");
        stateCodeToNameMap.put("MT", "Montana");
        stateCodeToNameMap.put("NC", "North Carolina");
        stateCodeToNameMap.put("ND", "North Dakota");
        stateCodeToNameMap.put("NE", "Nebraska");
        stateCodeToNameMap.put("NH", "New Hampshire");
        stateCodeToNameMap.put("NJ", "New Jersey");
        stateCodeToNameMap.put("NM", "New Mexico");
        stateCodeToNameMap.put("NV", "Nevada");
        stateCodeToNameMap.put("NY", "New York");
        stateCodeToNameMap.put("OH", "Ohio");
        stateCodeToNameMap.put("OK", "Oklahoma");
        stateCodeToNameMap.put("OR", "Oregon");
        stateCodeToNameMap.put("PA", "Pennsylvania");
        stateCodeToNameMap.put("RI", "Rhode Island");
        stateCodeToNameMap.put("SC", "South Carolina");
        stateCodeToNameMap.put("SD", "South Dakota");
        stateCodeToNameMap.put("TN", "Tennessee");
        stateCodeToNameMap.put("TX", "Texas");
        stateCodeToNameMap.put("UT", "Utah");
        stateCodeToNameMap.put("VA", "Virginia");
        stateCodeToNameMap.put("VT", "Vermont");
        stateCodeToNameMap.put("WA", "Washington");
        stateCodeToNameMap.put("WI", "Wisconsin");
        stateCodeToNameMap.put("WV", "West Virginia");
        stateCodeToNameMap.put("WY", "Wyoming");
        stateCodeToNameMap.put("GU", "Guam");
        stateCodeToNameMap.put("VI", "Virgin Islands");
        stateCodeToNameMap.put("PR", "Puerto Rico");
        stateCodeToNameMap.put("AE", "Armed forces - Europe");
        stateCodeToNameMap.put("AA", "Armed forces - America");
        stateCodeToNameMap.put("AP", "Armed forces - Pacific");

        // Load US State Names.
        stateNameToCodeMap.put("Alabama","AL");
        stateNameToCodeMap.put("Alaska","AK");
        stateNameToCodeMap.put("Arizona","AZ");
        stateNameToCodeMap.put("Arkansas","AR");
        stateNameToCodeMap.put("California","CA");
        stateNameToCodeMap.put("Colorado","CO");
        stateNameToCodeMap.put("Connecticut","CT");
        stateNameToCodeMap.put("Delaware","DE");
        stateNameToCodeMap.put("District Of Columbia","DC");
        stateNameToCodeMap.put("Florida","FL");
        stateNameToCodeMap.put("Georgia","GA");
        stateNameToCodeMap.put("Hawaii","HI");
        stateNameToCodeMap.put("Idaho","ID");
        stateNameToCodeMap.put("Illinois","IL");
        stateNameToCodeMap.put("Indiana","IN");
        stateNameToCodeMap.put("Iowa","IA");
        stateNameToCodeMap.put("Kansas","KS");
        stateNameToCodeMap.put("Kentucky","KY");
        stateNameToCodeMap.put("Louisiana","LA");
        stateNameToCodeMap.put("Maine","ME");
        stateNameToCodeMap.put("Maryland","MD");
        stateNameToCodeMap.put("Massachusetts","MA");
        stateNameToCodeMap.put("Michigan","MI");
        stateNameToCodeMap.put("Minnesota","MN");
        stateNameToCodeMap.put("Mississippi","MS");
        stateNameToCodeMap.put("Missouri","MO");
        stateNameToCodeMap.put("Montana","MT");
        stateNameToCodeMap.put("Nebraska","NE");
        stateNameToCodeMap.put("Nevada","NV");
        stateNameToCodeMap.put("New Hampshire","NH");
        stateNameToCodeMap.put("New Jersey","NJ");
        stateNameToCodeMap.put("New Mexico","NM");
        stateNameToCodeMap.put("New York","NY");
        stateNameToCodeMap.put("North Carolina","NC");
        stateNameToCodeMap.put("North Dakota","ND");
        stateNameToCodeMap.put("Ohio","OH");
        stateNameToCodeMap.put("Oklahoma","OK");
        stateNameToCodeMap.put("Oregon","OR");
        stateNameToCodeMap.put("Pennsylvania","PA");
        stateNameToCodeMap.put("Rhode Island","RI");
        stateNameToCodeMap.put("South Carolina","SC");
        stateNameToCodeMap.put("South Dakota","SD");
        stateNameToCodeMap.put("Tennessee","TN");
        stateNameToCodeMap.put("Texas","TX");
        stateNameToCodeMap.put("Utah","UT");
        stateNameToCodeMap.put("Vermont","VT");
        stateNameToCodeMap.put("Virginia","VA");
        stateNameToCodeMap.put("Washington","WA");
        stateNameToCodeMap.put("West Virginia","WV");
        stateNameToCodeMap.put("Wisconsin","WI");
        stateNameToCodeMap.put("Wyoming","WY");
        stateNameToCodeMap.put("Guam", "GU");
        stateNameToCodeMap.put("Puerto Rico","PR");
        stateNameToCodeMap.put("Virgin Islands","VI");
        stateNameToCodeMap.put("Armed Forces (AE)","AE");
        stateNameToCodeMap.put("Armed Forces Americas","AA");
        stateNameToCodeMap.put("Armed Forces Pacific","AP");
    }

    /**
     * takes in a state name, turns it into a state code
     * @param state the name of a US state
     * @return      the official 2 letter state code for that state
     */
    public static String getStateCode(String state) {
        //If a state code is provided, return it
        //If a state is provided, return it's state code
        //If anything other than a state or state code is provided, return null.
        if (stateCodeToNameMap.containsKey(state.toUpperCase())) {
            return state.toUpperCase();
        } else if (stateNameToCodeMap.containsKey(capitalizeFully(state))) {
            return stateNameToCodeMap.get(capitalizeFully(state));
        } else {
            return null;
        }
    }

    /**
     * takes a state code, turns it into a state name
     * @param stateCode an official 2 letter state code
     * @return          the full name of the state
     */
    public static String getStateName(String stateCode) {
        //If a state name is provided, return it
        //If a state code is provided, return it's state name
        //If anything other than a state or state code is provided, return null.
        if (stateNameToCodeMap.containsKey(capitalizeFully(stateCode))) {
            return stateNameToCodeMap.get(capitalizeFully(stateCode));
        } else if (stateCodeToNameMap.containsKey(stateCode.toUpperCase())) {
            return stateCode.toUpperCase();
        } else {
            return null;
        }
    }

    /**
     * checks to see if a given string is a state name or state code
     * @param state the string that will be checked for statehood
     * @return      weather or not the state is a state
     */
    public static Boolean isState(String state){

        /*if (Strings.isEmptyOrWhitespace(state)) {
            return false;
        } */

        if (stateNameToCodeMap.containsKey(capitalizeFully(state))) {
            return true;
        } else if (stateCodeToNameMap.containsKey(state.toUpperCase())) {
            return true;
        } else {
            return false;
        }
    }
}
