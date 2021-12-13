package misc;

public class NumberToWordsII {

    public static void main(String[] args) {
        System.out.println(numberToWords(1));
        System.out.println(numberToWords(11));
        System.out.println(numberToWords(111));
        System.out.println(numberToWords(1111));
        System.out.println(numberToWords(11111));
        System.out.println(numberToWords(111111));
        System.out.println(numberToWords(1111111));
        System.out.println(numberToWords(11111111));
        System.out.println(numberToWords(111111111));

    }
    // Switch Case : 0-9, 10-19, 2-9x10(ty), 100, 1000, 1000000


    static String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        read(sb, num);
        return num + " => " + sb.toString();
    }

    static String read(StringBuilder sb, int num) {
        if (num < 20) {
            sb.append(getWord(num));
        } else if (num < 100) {
            sb.append(getWord(num)).append(" ").append(getWord(num % 10));
        } else if (num < 1000) {
            sb.append(getWord(num / 100)).append(" ").append(getWord(100)).append(" ").append(read(sb, num % 100));
        } else if (num < 1000000) {
            sb.append(read(sb, num / 1000)).append(" ").append(getWord(1000)).append(" ").append(read(sb, num % 1000));
        } else if (num < 1000000000) {
            sb.append(read(sb, num / 1000000)).append(" ").append(getWord(1000000)).append(" ").append(read(sb, num % 1000000));
        }
        return "";
    }

    static String getWord(int num) {
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
            case 20:
                return "Twenty";
            case 30:
                return "Thirty";
            case 40:
                return "Forty";
            case 50:
                return "Fifty";
            case 60:
                return "Sixty";
            case 70:
                return "Seventy";
            case 80:
                return "Eighty";
            case 90:
                return "Ninety";
            case 100:
                return "Hundred";
            case 1000:
                return "Thousand";
            case 1000000:
                return "Million";
            case 1000000000:
                return "Billion";
            default:
                return "";
        }
    }

}
