This is a JAVA library ensuring reading EEG data from BrainVisionRecorder and transforming data to double values.
An interface (DataTransformer) that allows integration to an other application is created. User can simply create an
instance of EEGDataTransformer that implements this interface

DataTrasformer dt = new EEGDataTransformer();

This library also includes the Main class. Therefore, this library can be used as a console application. It expects arguments in
following formats:

java -jar EEGLoader_2.0.jar <name of header file (.vhdr)> <name of data file (.eeg or .avg)> <number of channel or electrode>

or

java -jar EEGLoader_2.0.jar <name of header file (.vhdr)> <number of channel or electrode>
In this case it is necessary that data file (.eeg or .avg) is in the same directory as the header file.

Note that numbers of channel starts at number 1.