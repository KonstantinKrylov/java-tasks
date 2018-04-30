import java.util.Objects;
import java.util.stream.Stream;

/*
 The following Java code is responsible for creating an HTML "SELECT"
 list of U.S. states, allowing a user to specify his or her state. This might
 be used, for instance, on a credit card transaction screen.

 Please rewrite this code to be "better". Submit your replacement code, and
 please also submit a few brief comments explaining why you think your code
 is better than the sample.

 (For brevity, this sample works for only 5 states. The real version would
 need to work for all 50 states. But it is fine if your rewrite shows only
 the 5 states here.)

 public class StateUtils {

  // Generates an HTML select list that can be used to select a specific
  // U.S. state.

  public static String createStateSelectList()
  {
    return
      "<select name=\"state\">\n"
    + "<option value=\"Alabama\">Alabama</option>\n"
    + "<option value=\"Alaska\">Alaska</option>\n"
    + "<option value=\"Arizona\">Arizona</option>\n"
    + "<option value=\"Arkansas\">Arkansas</option>\n"
    + "<option value=\"California\">California</option>\n"
    // more states here
    + "</select>\n"
    ;
  }

  // Parses the state from an HTML form submission, converting it to
  // the two-letter abbreviation.

  public static String parseSelectedState(String s)
  {
    if (s.equals("Alabama"))     { return "AL"; }
    if (s.equals("Alaska"))      { return "AK"; }
    if (s.equals("Arizona"))     { return "AZ"; }
    if (s.equals("Arkansas"))    { return "AR"; }
    if (s.equals("California"))  { return "CA"; }
    // more states here
  }

  // Displays the full name of the state specified by the two-letter code.

  public static String displayStateFullName(String abbr) {
  {
    if (abbr.equals("AL")) { return "Alabama";    }
    if (abbr.equals("AK")) { return "Alaska";     }
    if (abbr.equals("AZ")) { return "Arizona";    }
    if (abbr.equals("AR")) { return "Arkansas";   }
    if (abbr.equals("CA")) { return "California"; }
    // more states here
  }
}
*/

public class Question2 {

    //It's better to store this pieces as constants. It would be easy to change them if needed.
    private static final String BEGINNING = "<select name=\"state\">\n";
    private static final String LEFT_PART = "<option value=\"";
    private static final String CLOSED_TAG = "\">";
    private static final String RIGHT_PART = "</option>\n";
    private static final String END = "</select>\n";

    public String createStateSelectList() {

        //Main part of the result built in just in 3 lines, regardless the amount of states.

        StringBuilder result = new StringBuilder(BEGINNING);

        for (States state : States.values()) {
            String stateName = state.getStateName();
            result.append(LEFT_PART)
                  .append(stateName)
                  .append(CLOSED_TAG)
                  .append(stateName)
                  .append(RIGHT_PART);
        }

        result.append(END);
        return result.toString();
    }

    public String parseSelectedState(String stateName) {
        //Only one line to obtain state code.
        return States.byName(stateName).getStateCode();
    }

    public String displayStateFullName(String abbr) {
        //Only one line to obtain state name.
        return States.byCode(abbr).getStateName();
    }
}

enum States {
    /*
    As far as we have a lot of constants here, it is good practice to store them as enum.
    It is easy to read, easy to add more states manually. And it will cost just one line
    of code to obtain the state code or the state name.
    */

    ALABAMA("Alabama", "AL"),
    ALASKA("Alaska", "AK"),
    ARIZONA("Arizona", "AZ"),
    ARKANSAS("Arkansas", "AR"),
    CALIFORNIA("California", "CA");

    private String stateName;
    private String stateCode;

    States(String stateName, String stateCode) {
        this.stateName = stateName;
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public static States byName(String name) {
        return Stream.of(States.values())
                     .filter(states -> Objects.equals(name, states.stateName))
                     .findAny()
                     .orElse(null);
    }

    public static States byCode(String code) {
        return Stream.of(States.values())
                     .filter(states -> Objects.equals(code, states.stateCode))
                     .findAny()
                     .orElse(null);
    }

}