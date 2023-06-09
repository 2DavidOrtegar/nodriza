package app.support.utils;

public class Paths {
    private String winso = "\\";
    private String otherso = "/";
    private String so;

    public Paths() {
        /**
         * Obtener sistema operativo
         */
        String sSistemaOperativo = System.getProperty("os.name");
        so = sSistemaOperativo;
    }

    /**
     * @param path
     * @return cleanPath
     */
    public String cleanPathSo(String path) {
        String cleanPath;

        if (so.contains("Windows")) {
            cleanPath = path.trim().replace("/", "\\");
        } else {
            cleanPath = path.trim().replace("\\", "/");
        }
        return cleanPath;
    }
}
