package cz.zcu.kiv.test;

import cz.zcu.kiv.signal.DataTransformer;
import cz.zcu.kiv.signal.EEGDataTransformer;
import cz.zcu.kiv.signal.EEGMarker;

import java.nio.ByteOrder;
import java.util.List;

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
            List<EEGMarker> list = transformer.readMarkerList("c:\\java\\guess_the_number\\data\\numbers\\Blatnice\\blatnice20141023_9.vmrk");
//            int channel = Integer.parseInt(args[args.length-1]);
            double[] dataInValues;
//            if (args.length == 3) {
//
//                dataInValues = transformer.readBinaryData(args[0], args[1], channel);
//            }
//            else {
                dataInValues = transformer.readBinaryData("c:\\java\\guess_the_number\\data\\train\\set2.vhdr", 1, ByteOrder.LITTLE_ENDIAN);
//            }
//
            for (double value: dataInValues)
                System.out.println(value);
//            for (EEGMarker marker: list) {
//                System.out.println(marker.getName() + " " + marker.getPosition());
//            }

       } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
