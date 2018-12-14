package myjava.mybignumber;

/**
 * Tác gi?:  Tran Thanh Nam
 * DesCription.
 * Class MyBigNumber là l?p d? C?ng 2 s? l?n b?ng 2 chu?i.
 * Hàm sum trong Class MyBigNumber là hàm d? th?c hi?n phép c?ng 2 chu?i s?
 */

public class MyBigNumber {

    private IReceiver ireceiver;

    public MyBigNumber(final IReceiver ireceiver) {
        this.ireceiver = ireceiver;
    }

    /**
     * Ð? th?c hi?n phép c?ng, ta c?n 2 chu?i làm tham s? cho hàm sum trong dó:
     * 2 chu?i này d?u ch? ch?a các kí s? t? '0' d?n '9'.
     * <br/>
     *
     * @param s1 chu?i s? th? nh?t.
     * @param s2 chu?i s? th? hai.
     * @return chu?i có giá tr? là t?ng c?a hai s? s1 và s2.
     */
    public String sum(final String s1, final String s2) {
        // Buoc 1: lay do dai 2 chuoi
        // Phan khai bao

        String result = "";
        String msg = "";// Chuoi msg se lam tham so cho ham send cua interface IReceiver
        int length1 = s1.length();// do dai chuoi thu 1
        int length2 = s2.length();// do dai chuoi thu 2
        int max = (length1 > length2) ? length1 : length2;// lay do dau lon nhat giua a va b
        int nho = 0;// Kh?i t?o s? nh? = 0 d? khi c?ng s? có vài tru?ng h?p l?n hon 9
        int pos1 = 0;// V? trí chu?i s1
        int pos2 = 0;// V? trí chu?i s2
        char c1;// kí t? c1 dùng d? l?y kí t? cu?i cùng c?a chu?i s1
        char c2;// kí t? c2 dùng d? l?y kí t? cu?i cùng c?a chu?i s2
        int tong = 0;// Kh?i t?o bi?n t?ng = 0 d? c?ng 2 kí t? cu?i cùng l?i v?i nhau

        // L?p t? 0 d?n max l?n
        for (int i = 0; i < max; i++) {
            pos1 = length1 - i - 1;// c?p nh?t l?i v? trí chu?i s1
            pos2 = length2 - i - 1;// c?p nh?t l?i v? trí chu?i s2

            // Xét v? trí c?a 2 chu?i xem có >= 0 hay không
            if (pos1 >= 0) {
                c1 = s1.charAt(length1 - i - 1);// L?y kí t? ? v? trí cu?i cùng c?a chu?i

            } else {
                c1 = '0';
            }

            if (pos2 >= 0) {
                c2 = s2.charAt(length2 - i - 1);// L?y kí t? ? v? trí cu?i cùng c?a chu?i
            } else {
                c2 = '0';
            }

            tong = (c1 - '0') + (c2 - '0') + nho;// chuy?n kí t? thành s? xong c?ng cho s? nh?
            result = (tong % 10) + result;// L?y k?t qu? t?ng ? trên chia l?y du cho 10 và ghép vào chu?i k?t qu?
            nho = tong / 10;// C?p nh?t l?i s? nh?

            msg = "Step " + (i + 1) + ": " + c1 + " + " + c2 + " = "
                    + (tong - nho) + " + " + nho + " = " + tong + " . Write " + (tong % 10) + " remember " + nho;
            this.ireceiver.send(msg);
        }

        if (nho >= 1) {
            result = 1 + result;// N?u s? nh? còn du thì ghép vào chu?i k?t qu?
        }

        return result;// Tr? v? k?t qu? thu du?c
    }
}