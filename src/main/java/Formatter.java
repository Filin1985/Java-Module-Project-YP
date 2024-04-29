public class Formatter {
    public static String formatMessage(double dividedPrice) {
        String message = String.format("Каждый участник должен заплатить: %.2f ", dividedPrice);
        return message + endString(dividedPrice);
    }

    public static String endString(double rubles) {
        int roundedRubles = (int)Math.floor(rubles);
        if(roundedRubles >= 10 && roundedRubles <=20) return "рублей";

        int reminderFromDivToTen = roundedRubles % 10;
        if (reminderFromDivToTen == 1) {
            return "рубль";
        } else if (reminderFromDivToTen >= 2 && reminderFromDivToTen <= 4) {
            return "рубля";
        }
        return "рублей";
    }
}
