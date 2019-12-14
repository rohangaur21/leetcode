package misc;

public class NumberToWords {
    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        read(sb, num);
        return sb.toString();
    }

    private void read(StringBuilder sb, int num) {
        if (num < 100) {
            readLessThanHundred(sb, num);
            return;
        }
        int unit = getNextUnit(num);
        readWithUnit(sb, num / unit, unit);
        if (num % unit > 0) {
            sb.append(" ");
            read(sb, num % unit);
        }
    }

    /**
     * Read the number and append an unit suffix.
     */
    private void readWithUnit(StringBuilder sb, int num, int unit) {
        read(sb, num);
        sb.append(" ");
        sb.append(readUnit(unit));
    }

    private void readLessThanHundred(StringBuilder sb, int num) {
        if (num < 10) {
            sb.append(getDigit(num));
            return;
        }
        if (num >= 10 && num < 20) {
            sb.append(getTenToNineteen(num));
            return;
        }
        sb.append(getTy(num / 10));
        if (num % 10 > 0) {
            sb.append(" ");
            sb.append(getDigit(num % 10));
        }
    }

    private int getNextUnit(int num) {
        if (num >= 1000000000) {
            return 1000000000;
        }
        if (num >= 1000000) {
            return 1000000;
        }
        if (num >= 1000) {
            return 1000;
        }
        return 100;
    }

    private String readUnit(int unit) {
        switch (unit) {
            case 1000000000:
                return "Billion";
            case 1000000:
                return "Million";
            case 1000:
                return "Thousand";
            case 100:
                return "Hundred";
            default:
                return "";
        }
    }

    private String getDigit(int num) {
        switch (num) {
            case 0:
                return "Zero";
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            default:
                return "";
        }
    }

    private String getTenToNineteen(int num) {
        switch (num) {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
            default:
                return "";
        }
    }

    private String getTy(int num) {
        switch (num) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(new NumberToWords().numberToWords(555));
    }
}
