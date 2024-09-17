public class Solution {
    private boolean consistOfValidChar(String s) {
        String validChars = "0123456789eE-+.";
        for (char c : s.toCharArray()) {
            if (!validChars.contains(String.valueOf(c))) {
                return false;
            }
        }
        if (s.indexOf('e') != -1 && s.indexOf('E') != -1) return false;
        return true;
    }

    private boolean isDigits(String s) {
        if (s.length() == 0) return false;
        for (char c : s.toCharArray()) {
            if (c < '0' || c > '9') return false;
        }
        return true;
    }

    private boolean isIntegerNumber(String s) {
        if (s.length() == 0) return false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        return isDigits(s);
    }

    private boolean isDecimalNumber(String s) {
        if (s.length() == 0) return false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        if (s.length() == 0) return false;
        int pointIdx = s.indexOf('.');
        if (pointIdx == -1 || pointIdx != s.lastIndexOf('.')) {
            return false;
        }
        String beforePoint = s.substring(0, pointIdx);
        String afterPoint = pointIdx == s.length() ? "" : s.substring(pointIdx + 1);
        if (isDigits(beforePoint) && afterPoint == "") {
            return true;
        }
        if (isDigits(beforePoint) && isDigits(afterPoint)) {
            return true;
        }
        if (beforePoint == "" && isDigits(afterPoint)) {
            return true;
        }
        return false;
    }

    public boolean isNumber(String s) {
        if (!consistOfValidChar(s)) {
            return false;
        }
        int indexOfExp = Math.max(s.indexOf('e'), s.indexOf('E'));
        if (indexOfExp != Math.max(s.lastIndexOf('e'), s.lastIndexOf('E'))) {
            return false;
        }
        if (indexOfExp == -1) {
            return isIntegerNumber(s) || isDecimalNumber(s);
        } else {
            String beforeExp = s.substring(0, indexOfExp);
            String afterExp = indexOfExp == s.length() - 1 ? "" : s.substring(indexOfExp + 1);
            return (isIntegerNumber(beforeExp) && isIntegerNumber(afterExp)) ||
                (isDecimalNumber(beforeExp) && isIntegerNumber(afterExp));
        }
    }
} {
    
}
