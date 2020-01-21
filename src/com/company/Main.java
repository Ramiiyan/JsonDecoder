package com.company;

public class Main {

    public static void main(String[] args) {

        String coldJsonFormat = "{\"deviceId\":\"qazwsxedcrfv\",\"payload\":\"444\",\"freq\":\"6\",\"datarate\":\"2\",\"snr\":\"2\",\"rssi\":\"3\",\"seqnum\":\"3\",\"timestamp\":\"1\",\"port\":\"1\",\"imei\":\"1\",\"lpwantype\":\"0\",\"gId\":\"1\",\"uId\":\"1\"}";

        String valueOf = jsonValueFinder(coldJsonFormat,"deviceId");

        System.out.println(valueOf);

    }
    public static String jsonValueFinder(String coldJson,String key){

        char [] textArr = coldJson.toCharArray();
        int keyIndexBegin = coldJson.indexOf(key);
        int valueIndexBegin;

        if(keyIndexBegin == - 1) {
            //  System.out.println("Name not found");
            return "not found";
        } else {
            valueIndexBegin = keyIndexBegin + key.length() + "\":\"".length() ;
            int valueIndexEnd = valueIndexBegin + coldJson.substring(valueIndexBegin).indexOf("\"");
            int j = 0;
            char [] valueArr = new char [valueIndexEnd-valueIndexBegin];

            for(int i = valueIndexBegin; i<valueIndexEnd;i++){
                //  System.out.println("textArr : " + textArr[i]);
                valueArr[j] = textArr[i];
                j++;
            }
            return new String(valueArr);
        }

    }
}
