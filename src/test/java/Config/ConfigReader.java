package Config;

import java.io.*;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;
    private final String propertyFilePath = "src//Config.properties";
    public static final String workingDirectory = System.getProperty("user.dir");

    public ConfigReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Config.properties not found at " + propertyFilePath);
        }
    }

    public String getApkPath(){
        return getPath("ApkPath");
    }

    public String getAndroidDeviceName(){
        return getPath("AndroidDeviceName");
    }

    public String getDeviceToBeRun(){
        return getPath("RunningDevice");
    }

    public String getIpaPath() {
        return getPath("IpaPath");
    }

    public final String getExtentConfig(){
       return workingDirectory+ "/"+getPath("ExtentConfig");

    }

    private  String getPath(String Path){
        String path = properties.getProperty(Path);
        if(path != null) return path;
        else throw new RuntimeException(Path + " not specified in Config.properties file");
    }

    public String getUdid() {
        return getPath("UDID");
    }
}

