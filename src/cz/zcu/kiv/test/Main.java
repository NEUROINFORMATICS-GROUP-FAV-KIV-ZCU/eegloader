package cz.zcu.kiv.test;

import cz.zcu.kiv.signal.DataTransformer;
import cz.zcu.kiv.signal.EEGDataTransformer;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * This class shows an example how to use the EEGLoader.
 *
 * Tato t��da ukazuje p��klad, jak pou��t EEGLoader.
 *
 * @author Jan Stebetak
 */
public class Main {


    public static void main(String[] args)  {
        try {
            DataTransformer transformer = new EEGDataTransformer();
            int channel = Integer.parseInt(args[args.length-1]);
            double[] dataInValues;
            if (args.length == 3) {

                dataInValues = transformer.readBinaryData(args[0], args[1], channel);
            }
            else {
                dataInValues = transformer.readBinaryData(args[0], channel);
            }

            for (double value: dataInValues)
                System.out.println(value);

       } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
