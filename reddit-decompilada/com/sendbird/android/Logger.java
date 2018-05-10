package com.sendbird.android;

class Logger {
    public static int f22683a;

    public static void m24931a(Exception exception) {
        if (f22683a > 0) {
            String message = exception.getMessage();
            if (message == null) {
                message = "(null)";
            }
            System.err.println(message);
            exception.printStackTrace();
        }
    }

    public static void m24932a(String str) {
        if (f22683a > 0) {
            if (str == null) {
                str = "(null)";
            }
            System.err.println(str);
        }
    }

    public static void m24934b(String str) {
        if (f22683a >= 98765) {
            System.out.println(str);
        }
    }

    public static void m24933b(Exception exception) {
        if (f22683a >= 98765 && exception != null) {
            String message = exception.getMessage();
            if (message == null) {
                message = "(null)";
            }
            System.out.println(message);
            exception.printStackTrace();
        }
    }
}
