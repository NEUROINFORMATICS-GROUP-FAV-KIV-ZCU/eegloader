package cz.zcu.kiv.test;

import cz.zcu.kiv.signal.ChannelInfo;
import cz.zcu.kiv.signal.DataTransformer;
import cz.zcu.kiv.signal.EEGDataTransformer;
import org.apache.hadoop.conf.Configuration;

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

    private static final String HDFS_URI = "hdfs://localhost:8020";
    private static final Configuration HDFS_CONF = new Configuration();

    public static void main(String[] args)  {
        try {
            DataTransformer transformer = new EEGDataTransformer(HDFS_URI,HDFS_CONF);
            //List<EEGMarker> list = transformer.readMarkerList("c:\\java\\guess_the_number\\data\\numbers\\Blatnice\\blatnice20141023_9.vmrk");
            List<ChannelInfo> channels = transformer.getChannelInfo(args[0]);
            int channel = Integer.parseInt(args[args.length-1]);
            double[] dataInValues;
            if (args.length == 3) {

                 dataInValues = transformer.readBinaryData(args[0], args[1], channel, ByteOrder.LITTLE_ENDIAN);
            }
            else {
                 dataInValues = transformer.readBinaryData(args[0], channel, ByteOrder.LITTLE_ENDIAN);
            }
//68.4, 69.3, 73
            for (double value: dataInValues) {
                System.out.println(value);
            }


//            for (EEGMarker marker: list) {
//                System.out.println(marker.getName() + " " + marker.getPosition());
//            }

       } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
