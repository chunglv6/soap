package com.chung.ws.soap.mtom;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import java.io.*;

public class FilewsImpl implements Filews{
    @Override
    public void upload(DataHandler dataHandler) {
        InputStream inputStream = null;
        OutputStream os =null;
        try {
             inputStream = dataHandler.getInputStream();
             os = new FileOutputStream(new File("D:\\soap\\practice\\mtom\\src\\main\\resources\\picture\\test.jpg"));
            byte[] b = new byte[100000];
            int byteRead = 0;
            while ((byteRead = inputStream.read()) != -1){
                os.write(b,0,byteRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public DataHandler download() {
        return new DataHandler(new FileDataSource(new File("D:\\soap\\practice\\mtom\\src\\main\\resources\\picture\\test.jpg")));
    }
}
