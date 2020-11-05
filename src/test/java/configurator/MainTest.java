package configurator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTest {

    private static final String REGISTRAR_PATTERN = ".*forwarded by george weissman.*";
    private static Pattern registrarPattern = Pattern.compile(REGISTRAR_PATTERN, Pattern.CASE_INSENSITIVE);
    private static Matcher matcher;

    public static void main(String[] args) {
        String str = "gary   production from the high island larger block a - 1 # 2 commenced on saturday at 2 : 00 p . m . at about 6   500 gross . carlos expects between 9   500 and 10   000 gross for tomorrow . vastar owns 68 % of the gross production . george x 3 - 6992 - - - - - - - - - - - - - - - - - - - - - - forwarded by george weissman / hou / ect on 12 / 13 / 99 10 : 16 am - - - - - - - - - - - - - - - - - - - - - - - - - - - daren j farmer 12 / 10 / 99 10 : 38 am to : carlos j rodriguez / hou / ect @ ect cc : george weissman / hou / ect @ ect   melissa graves / hou / ect @ ect subject : vastar resources   inc . carlos   please call linda and get everything set up . i  m going to estimate 4   500 coming up tomorrow   with a 2   000 increase each following day based on my conversations with bill fischer at bmar . d . - - - - - - - - - - - - - - - - - - - - - - forwarded by daren j farmer / hou / ect on 12 / 10 / 99 10 : 34 am - - - - - - - - - - - - - - - - - - - - - - - - - - - enron north america corp . from : george weissman 12 / 10 / 99 10 : 00 am to : daren j farmer / hou / ect @ ect cc : gary bryan / hou / ect @ ect   melissa graves / hou / ect @ ect subject : vastar resources   inc . darren   the attached appears to be a nomination from vastar resources   inc . for the high island larger block a - 1 # 2 ( previously   erroneously referred to as the # 1 well ) . vastar now expects the well to commence production sometime tomorrow . i told linda harris that we  d get her a telephone number in gas control so she can provide notification of the turn - on tomorrow . linda s numbers   for the record   are 281 . 584 . 3359 voice and 713 . 312 . 1689 fax . would you please see that someone contacts linda and advises her how to submit future nominations via e - mail   fax or voice ? thanks . george x 3 - 6992 - - - - - - - - - - - - - - - - - - - - - - forwarded by george weissman / hou / ect on 12 / 10 / 99 09 : 44 am - - - - - - - - - - - - - - - - - - - - - - - - - - -  linda harris  on 12 / 10 / 99 09 : 38 : 43 am to : george weissman / hou / ect @ ect cc : subject : hi a - 1 # 2 effective 12 - 11 - 99 | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - | | | | | | mscf / d | min ftp | time | | | | | | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - | | | | | | 4   500 | 9   925 | 24 hours | | | | | | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - | | | | | | 6   000 | 9   908 | 24 hours | | | | | | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - | | | | | | 8   000 | 9   878 | 24 hours | | | | | | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - | | | | | | 10   000 | 9   840 | 24 hours | | | | | | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - | | | | | | 12   000 | 9   793 | 24 hours | | | | | | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - | | | | | | 14   000 | 9   738 | 24 hours | | | | | | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - | | | | | | 16   000 | 9   674 | 24 hours | | | | | | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - | | | | | | 18   000 | 9   602 | 24 hours | | | | | | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - | | | | | | 20   000 | 9   521 | 24 hours | | | | | | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - | | | | | | 22   000 | 9   431 | 24 hours | | | | | | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - | | | | | | 24   000 | 9   332 | 24 hours | | | | | | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - | | | | | | 26   000 | 9   224 | 24 hours | | | | | | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - | | | | | | 28   000 | 9   108 | 24 hours | | | | | | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - | | | | | | 30   000 | 8   982 | 24 hours | | | | | | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - | | | | | | 32   000 | 8   847 | 24 hours | | | | | | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - | | | | | | 34   000 | 8   703 | 24 hours | | | | | | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - | | | | | | 36   000 | 8   549 | 24 hours | | | | | | - - - - - - - - + - - - - - - - - - - + - - - - - - - - - - - |";

        getRegistrar(str);

    }

    private static List<String> getRegistrar(String data){

        List<String> result = new ArrayList<String>();

        matcher = registrarPattern.matcher(data);

        System.out.println(matcher.find());
        return result;
    }
}
