package util;



import java.io.File;

public class CommonFileUtil {
    public static final char separatorChar = '/';
    public static final String separator = "/";

    public static String getTempDirectory() {


        final String result = CommonFileUtil.getGenericPath(System.getProperty("java.io.tmpdir"));
        final int len = result.length();

        // remove last separator
        if ((len > 1) && (result.charAt(len - 1) == CommonFileUtil.separatorChar))
            return getGenericPath(result.substring(0, len - 1));

        return getGenericPath(result);
    }


    public static String getFileExtension(String path, boolean withDot) {
        final String finalPath = getGenericPath(path);

        if (StringUtil.isEmpty(finalPath))
            return "";

        final int indexSep = finalPath.lastIndexOf(separatorChar);
        final int indexDot = finalPath.lastIndexOf('.');

        if (indexDot < indexSep)
            return "";

        if (withDot)
            return finalPath.substring(indexDot);

        return finalPath.substring(indexDot + 1);
    }

    public static String getGenericPath(String path) {
        if (path != null) {
            return path.replace('\\', '/');
        } else
            return null;
    }


    public static String getDirectory(String path, boolean separator) {
        final String finalPath = getGenericPath(path);

        if (!StringUtil.isEmpty(finalPath)) {
            int index = finalPath.lastIndexOf(CommonFileUtil.separatorChar);
            if (index != -1)
                return finalPath.substring(0, index + (separator ? 1 : 0));

            index = finalPath.lastIndexOf(':');
            if (index != -1)
                return finalPath.substring(0, index + 1);
        }

        return "";
    }

    public static String getDirectory(String path) {
        return getDirectory(path, true);
    }

    public static String getFileName(String path, boolean withExtension) {
        String finalPath = getGenericPath(path);

        if (StringUtil.isEmpty(finalPath))
            return "";
        if (finalPath.lastIndexOf("/") == finalPath.length() - 1) {
            finalPath = finalPath.substring(0, finalPath.lastIndexOf("/"));
        }
        int index = finalPath.lastIndexOf(CommonFileUtil.separatorChar);
        final String fileName;

        if (index != -1) {

            fileName = finalPath.substring(index + 1);
        } else {
            index = finalPath.lastIndexOf(':');

            if (index != -1)
                fileName = finalPath.substring(index + 1);
            else
                fileName = finalPath;
        }

        if (withExtension)
            return fileName;

        index = fileName.lastIndexOf('.');

        if (index == 0)
            return "";
        else if (index != -1)
            return fileName.substring(0, index);
        else
            return fileName;
    }
    public static String getAppDataFolder(boolean withDirSeperator) {
        String workingDirectory;
        String OS = (System.getProperty("os.name")).toUpperCase();
        if (OS.contains("WIN") || OS.contains("WİN")) {
            workingDirectory = System.getenv("AppData");
        } else {
            workingDirectory = System.getProperty("user.home");
            //if we are on a Mac, we are not done, we look for "Application Support"
            workingDirectory += "/Library/Application Support";
        }
        String res = getGenericPath(workingDirectory);
        if (withDirSeperator)
            return res + "/";
        return res;
    }

    public static String getMusicAppConfigFolder(){
        String folder=CommonFileUtil.getAppDataFolder(false)+"/MusicListener/config/";
        if(!new File(folder).exists()) new File(folder).mkdirs();
        return folder;

    }
    public static String getOtomatAppConfigFolder(){
        String folder=CommonFileUtil.getAppDataFolder(false)+ "/main/java/Otomat/config/";
        if(!new File(folder).exists()) new File(folder).mkdirs();
        return folder;
    }
    public static String getLibraryAppConfigFolder(){
        String folder=CommonFileUtil.getAppDataFolder(false)+"/Library/config/";
        if(!new File(folder).exists()) new File(folder).mkdirs();
        return folder;
    } public static String getMavenAppConfigFolder(){
        String folder=CommonFileUtil.getAppDataFolder(false)+"/main/java/config/";
        if(!new File(folder).exists()) new File(folder).mkdirs();
        return folder;
    }

}