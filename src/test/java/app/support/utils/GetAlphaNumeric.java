package app.support.utils;

public class GetAlphaNumeric {

    private static final String alphaNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz";

    private static final int longiAlphaNumeric = 9;

    public static String getAlphaNumeric(){

        StringBuilder sb = new StringBuilder(longiAlphaNumeric);

        for (int i =0; i < longiAlphaNumeric; i++){
            int indice = (int) (alphaNum.length()*Math.random());

            sb.append(alphaNum.charAt(indice));
        }
        return  sb.toString();
    }

}
