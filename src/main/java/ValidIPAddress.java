public class ValidIPAddress {
    public String validIPAddress(String IP) {
        if(IP.length() <7 || IP == null) {
            return "Neither";
        }
        if(IP.charAt(0) == '.' || IP.charAt(0) == ':' ||IP.charAt(IP.length()-1) == '.' || IP.charAt(IP.length()-1) == ':') {
            return "Neither";
        }
        if(IP.contains(".")) {
            if(IP.contains(":") || IP.length() > 15) {
                return "Neither";
            } else {
                String[] ipv4 = IP.split("\\.");
                if(ipv4.length != 4) {
                    return "Neither";
                }
                for(int i=0; i<ipv4.length; i++) {
                    String sub = ipv4[i];
                    if(sub.length() <= 0 || sub.length() >3 || sub.charAt(0) == '-') {
                        return "Neither";
                    }
                    if(sub.length() > 1 && sub.charAt(0) == '0') {
                        return "Neither";
                    }
                    try {
                        int subInt = Integer.parseInt(sub);
                        if(subInt < 0 || subInt > 255) {
                            return "Neither";
                        }
                    } catch(NumberFormatException nfe) {
                        return "Neither";
                    }


                }
                return "IPv4";
            }
        } else if(IP.contains(":")) {
            if(IP.contains(".") || IP.length() < 15 || IP.length() > 39) {
                return "Neither";
            } else {
                String[] ipv6 = IP.split("\\:");
                if(ipv6.length != 8) {
                    return "Neither";
                }
                for(int i=0; i<ipv6.length; i++) {
                    String sub = ipv6[i];
                    if(sub.length() <= 0 || sub.length() >4 || sub.charAt(0) == '-') {
                        return "Neither";
                    }
                    try {
                        int hex = Integer.parseInt(sub, 16);
                        if(hex <0 || hex > 65535) {
                            return "Neither";
                        }
                    }
                    catch(NumberFormatException nfe) {
                        return "Neither";
                    }

                }
                return "IPv6";
            }

        }
        return "Neither";
    }
}

