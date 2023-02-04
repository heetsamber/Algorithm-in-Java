class Euclidean {
    static int gcd(int a, int b)
    {
        // GCD(0, b) == b; GCD(a, 0) == a,
        // GCD(0, 0) == 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        int k;
        for (k = 0; ((a | b) & 1) == 0; ++k) {
            a >>= 1;
            b >>= 1;
        }
        while ((a & 1) == 0)
            a >>= 1;

        do {
            while ((b & 1) == 0)
                b >>= 1;

            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            b = (b - a);
        } while (b != 0);

        return a << k;
    }

    // 테스트코드
    public static void main(String args[])
    {
        int a = 34, b = 17;

        System.out.println("최대 공약수는 " + gcd(a, b));
    }
}
