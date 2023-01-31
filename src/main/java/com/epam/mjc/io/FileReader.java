package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) throws IOException {

        FileInputStream imputStream = null;
        //file = new File("Profile.txt");

        String profileString = "";

        try {
            imputStream = new FileInputStream(file);
            int c;
            while ((c = imputStream.read()) != -1) {
                profileString += (char)c;
            }
        } finally {

            if (imputStream != null) {
                imputStream.close();
            }
        }

        String[] pairs = profileString.split("\\n");
        for (int i = 0; i < pairs.length; i++) {

            pairs[i] = pairs[i].split(": ")[1];
        }

        String name = pairs[0];
        int age = Integer.parseInt(pairs[1]);
        String email = pairs[2];
        long phone = Long.parseLong(pairs[3]);

        return new Profile(name, age, email, phone);
    }
}
