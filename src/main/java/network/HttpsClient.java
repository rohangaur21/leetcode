package network;


import javafx.fxml.FXML;

import javax.net.ssl.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Properties;


public class HttpsClient {

    public static void main(String[] args) throws Exception {
//        new HttpsClient().testStratusIt();
        new HttpsClient().testFogIt();
    }

    private void testFogIt() throws Exception {

        String https_url = "https://fog-partners.intelispend.com/fis/xmlalerts";
        URL url;
        Properties systemProps = System.getProperties();
        //systemProps.put("javax.net.ssl.trustStore", "C:\\expo-resources\\FogFISClient-MarketPlace-API-Devopment.p12");
        //systemProps.put("javax.net.ssl.trustStorePassword", "5ZR5LLSJ4N5TQZMFLACP08PA1W");

        systemProps.put("javax.net.ssl.keyStore", "C:\\expo-resources\\FogFISClient-MarketPlace-API-Devopment.p12");
        systemProps.put("javax.net.ssl.keyStorePassword", "46XLMG59HYKK9J39SJQMG3VMPM");
        systemProps.put("javax.net.debug", "ssl");
        System.setProperties(systemProps);
        try {
            HostnameVerifier hostnameVerifier = new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    if (hostname.equals("fog-partners.intelispend.com")) {
                        return true;
                    } else {
                        return false;
                    }
                }
            };

            url = new URL(https_url);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/xml");
            con.setRequestProperty("Content-Language", "en-US");
            //con.setHostnameVerifier( hostnameVerifier );
            con.setDoOutput(true);
            con.setDoInput(true);
            String data ="<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><Event><Client><ClientId>5069</ClientId><ClientName>First Bank Personalized Web</ClientName><Acronym>FIRST BANKPWP</Acronym><ClientSpecificID>1593190028</ClientSpecificID></Client><Account><Card PAN=\"1\"><CardNumber>6011400058492011</CardNumber><Status Name=\"Active\">2</Status><PersonId>6168</PersonId><SubProgram><SubProgramId>1650</SubProgramId><SubProgramName>FIRST BANK Personalized Gift</SubProgramName></SubProgram></Card><Purse><PurseNumber>14</PurseNumber><AuthBalance CurrCode=\"840\" CurrAlpha=\"USD\">18.30</AuthBalance><SettleBalance CurrCode=\"840\" CurrAlpha=\"USD\">34.50</SettleBalance></Purse></Account><Transaction><TXNUID>BDA57184-A31B-47BD-9C7F-44F7DCF16326</TXNUID><RequestCode>50201</RequestCode><TxnTypeCode TxnTypeName=\"Purchase Approved Settled\">11</TxnTypeCode><CardNumber>6011400058492055</CardNumber><PurseNumber>14</PurseNumber><Amount>16.20</Amount><LocalAmt CurrCode=\"826\" CurrAlpha=\"GBP\">13.50</LocalAmt><TxnSign>-1</TxnSign><RetrievalRefNo>832305044814</RetrievalRefNo><SourceCode Description=\"VISA\">10</SourceCode><ReasonCode>0</ReasonCode><ResponseCode>0</ResponseCode><MCC>5541</MCC><MerchantName>SHELL SERVICE STATION TAMPA US</MerchantName><WCSUTCInserted>2010-08-04T19:25:14.90</WCSUTCInserted></Transaction><Notifications><Message MsgType=\"SMS\"><Msg MsgId=\"MT7\" UniqueMsgID=\"GCA57184-A31B-47BD-9C7F-44F7DCF16312\" LanguageId=\"1\" MsgAddress=\"7036562587\" MsgAddressPrefix=\"1\" MsgAddressCarrier=\"32000\" /><Msg MsgId=\"MT9\" UniqueMsgID=\"TRE57184-A31B-47BD-9C7F-44F7DCF12257\" LanguageId=\"1\" MsgAddress=\"7036562587\" MsgAddressPrefix=\"1\" MsgAddressCarrier=\"32000\" /></Message><Message MsgType=\"EMAIL\"><Msg MsgId=\"M89\" UniqueMsgID=\"EME57184-A31B-47BD-9C7F-44F7DCF12547\" MsgAddress=\"paul.doe@tmail.com\" PersonId=\"7423\" /></Message></Notifications><Persons><Person><PersonId>6168</PersonId><Name><First>Marie</First><Middle>C</Middle><Last>Doe</Last></Name><Relation Description=\"Spouse\">2</Relation></Person></Persons></Event>";
            byte[] compressedData = data.getBytes();
            DataOutputStream outputStream = new DataOutputStream(con.getOutputStream());
            outputStream.write(compressedData);
            outputStream.flush();
            outputStream.close();

            File pKeyFile = new File("C:\\expo-resources\\FogFISClient-MarketPlace-API-Devopment.p12");
            String pKeyPassword = "46XLMG59HYKK9J39SJQMG3VMPM";
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            InputStream keyInput = new FileInputStream(pKeyFile);
            keyStore.load(keyInput, pKeyPassword.toCharArray());
            keyInput.close();
            keyManagerFactory.init(keyStore, pKeyPassword.toCharArray());
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(keyManagerFactory.getKeyManagers(), null, new SecureRandom());

            SSLSocketFactory sockFact = context.getSocketFactory();

            con.setSSLSocketFactory(sockFact);
            System.out.println("sss");
            // dump all the content
            print_content(con);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void testStratusIt() throws Exception {

        String https_url = "https://qa-partners.intelispend.com/fis/xmlalerts";
        URL url;
        Properties systemProps = System.getProperties();
        //systemProps.put("javax.net.ssl.trustStore", "C:\\development\\MarketPlace\\FISAlerts\\fog\\Marketplace-API-Devopment-CA.p12");
        //systemProps.put("javax.net.ssl.trustStorePassword", "5ZR5LLSJ4N5TQZMFLACP08PA1W");

        systemProps.put("javax.net.ssl.keyStore", "C:\\expo-resources\\FIS-Preprod-MarketPlace-API-Preprod.p12");
        systemProps.put("javax.net.ssl.keyStorePassword", "V9QMCXXW11D9YHTV0T0CYA3DQR");
        systemProps.put("javax.net.debug", "ssl");
        System.setProperties(systemProps);

        try {
            HostnameVerifier hostnameVerifier = new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    if (hostname.equals("qa-partners.intelispend.com")) {
                        return true;
                    } else {
                        return false;
                    }
                }
            };

            url = new URL(https_url);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/xml");
            con.setRequestProperty("Content-Language", "en-US");
            //con.setHostnameVerifier( hostnameVerifier );
            con.setDoOutput(true);
            con.setDoInput(true);
            String data = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" + "<Event>\n" + "                <Client>\n" + "                                <ClientId>5069</ClientId>\n" + "                                <ClientName>First Bank Personalized Web</ClientName>\n" + "                                <Acronym>FIRST BANKPWP</Acronym>\n" + "                                <ClientSpecificID>1593190028</ClientSpecificID>\n" + "                </Client>\n" + "                <Account>\n" + "                                <Card PAN=\"1\">\n" + "                                                <CardNumber>1234561232165498</CardNumber>\n" + "                                                <Status Name=\"Active\">2</Status>\n" + "                                                <PersonId>6168</PersonId>\n" + "                                                <SubProgram>\n" + "                                                                <SubProgramId>1650</SubProgramId>\n" + "                                                                <SubProgramName>FIRST BANK Personalized Gift</SubProgramName>\n" + "                                                </SubProgram>\n" + "                                </Card>\n" + "                                <Card>\n" + "                                                <CardNumber>1234561232165476</CardNumber>\n" + "                                                <Status Name=\"Active\">2</Status>\n" + "                                                <PersonId>7423</PersonId>\n" + "                                                <SubProgram>\n" + "                                                                <SubProgramId>1650</SubProgramId>\n" + "                                                                <SubProgramName>FIRST BANK Personalized Gift</SubProgramName>\n" + "                                                </SubProgram>\n" + "                                </Card>\n" + "                                <Purse>\n" + "                                                <PurseNumber>14</PurseNumber>\n" + "                                                <AuthBalance CurrCode=\"840\" CurrAlpha=\"USD\">18.30</AuthBalance>\n" + "                                                <SettleBalance CurrCode=\"840\" CurrAlpha=\"USD\">34.50</SettleBalance>\n" + "                                </Purse>\n" + "                </Account>\n" + "                <Transaction>\n" + "                                <TXNUID>BDA57184-A31B-47BD-9C7F-44F7DCF16389</TXNUID>\n" + "                                <RequestCode>50201</RequestCode>\n" + "                                <TxnTypeCode TxnTypeName=\"Purchase Approved Settled\">11</TxnTypeCode>\n" + "                                <CardNumber>1234561232165476</CardNumber>\n" + "                                <PurseNumber>14</PurseNumber>\n" + "                                <Amount>16.20</Amount>\n" + "                                <LocalAmt CurrCode=\"826\" CurrAlpha=\"GBP\">13.50</LocalAmt>\n" + "                                <TxnSign>-1</TxnSign>\n" + "                                <RetrievalRefNo>832305044814</RetrievalRefNo>\n" + "                                <SourceCode Description=\"VISA\">10</SourceCode>\n" + "                                <ReasonCode>0</ReasonCode>\n" + "                                <ResponseCode>0</ResponseCode>\n" + "                                <MCC>5541</MCC>\n" + "                                <MerchantName>SHELL SERVICE STATION TAMPA US</MerchantName>\n" + "                                <WCSUTCInserted>2010-08-04T19:25:14.90</WCSUTCInserted>\n" + "                </Transaction>\n" + "                <Notifications>\n" + "                                <Message MsgType=\"SMS\">\n" + "                                                <Msg MsgId=\"MT7\" UniqueMsgID=\"GCA57184-A31B-47BD-9C7F-44F7DCF16312\"\n" + "                                                                LanguageId=\"1\" MsgAddress=\"7036562587\" MsgAddressPrefix=\"1\"\n" + "                                                                MsgAddressCarrier=\"32000\" />\n" + "                                                <Msg MsgId=\"MT9\" UniqueMsgID=\"TRE57184-A31B-47BD-9C7F-44F7DCF12257\"\n" + "                                                                LanguageId=\"1\" MsgAddress=\"7036562587\" MsgAddressPrefix=\"1\"\n" + "                                                                MsgAddressCarrier=\"32000\" />\n" + "                                </Message>\n" + "                                <Message MsgType=\"EMAIL\">\n" + "                                                <Msg MsgId=\"M89\" UniqueMsgID=\"EME57184-A31B-47BD-9C7F-44F7DCF12547\"\n" + "                                                                MsgAddress=\"paul.doe@tmail.com\" PersonId=\"7423\" />\n" + "                                </Message>\n" + "                </Notifications>\n" + "                <Persons>\n" + "                                <Person>\n" + "                                                <PersonId>7423</PersonId>\n" + "                                                <Name>\n" + "                                                                <First>Paul</First>\n" + "                                                                <Last>Doe</Last>\n" + "                                                </Name>\n" + "                                                <Relation Description=\"Self\">1</Relation>\n" + "                                                <Address>\n" + "                                                                <Line1>2568 NE 20th ST</Line1>\n" + "                                                                <City>Atlanta</City>\n" + "                                                                <State>GA</State>\n" + "                                                                <Zip>87523</Zip>\n" + "                                                                <Country>USA</Country>\n" + "                                                </Address>\n" + "                                </Person>\n" + "                                <Person>\n" + "                                                <PersonId>6168</PersonId>\n" + "                                                <Name>\n" + "                                                                <First>Marie</First>\n" + "                                                                <Middle>C</Middle>\n" + "                                                                <Last>Doe</Last>\n" + "                                                </Name>\n" + "                                                <Relation Description=\"Spouse\">2</Relation>\n" + "                                </Person>\n" + "                </Persons>\n" + "</Event>";
            byte[] compressedData = data.getBytes();
            DataOutputStream outputStream = new DataOutputStream(con.getOutputStream());
            outputStream.write(compressedData);
            outputStream.flush();
            outputStream.close();

            File pKeyFile = new File("C:\\expo-resources\\FIS-Preprod-MarketPlace-API-Preprod.p12");
            String pKeyPassword = "V9QMCXXW11D9YHTV0T0CYA3DQR";
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            InputStream keyInput = new FileInputStream(pKeyFile);
            keyStore.load(keyInput, pKeyPassword.toCharArray());
            keyInput.close();
            keyManagerFactory.init(keyStore, pKeyPassword.toCharArray());
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(keyManagerFactory.getKeyManagers(), null, new SecureRandom());

            SSLSocketFactory sockFact = context.getSocketFactory();

            con.setSSLSocketFactory(sockFact);

            // dump all the content
            print_content(con);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void print_content(HttpsURLConnection con) {
        if (con != null) {

            try {

                System.out.println("****** Content of the URL ********");
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

                String input;

                while ((input = br.readLine()) != null) {
                    System.out.println(input);
                }
                br.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}