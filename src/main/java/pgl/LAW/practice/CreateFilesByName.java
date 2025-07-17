package pgl.LAW.practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFilesByName {
    public static void main(String[] args) {
        // 定义类名列表
        String[] classNames = {
                "GW_M_g100grn", "GW_M_g1000grn", "PW_M_g", "PH_M_cm", "T_SpkN_Ct_SP", "S_SpkN_Ct_SP", "SpkN_Ct_1mA",
                "MSpkGW_M_g100grn", "MSpkGW_M_g1000grn", "MSpkW_M_g", "MSpkL_M_cm", "TAwnL_M_cmMSpk", "T_SplN_Ct_MSpk",
                "I_SplN_Ct_MSpk", "GN_Ct_MSpk", "GY_M_gMSpk", "SpkShp_E", "SpkUnf_E", "FLeafLLng_M_cm", "FLeafLWid_M_cm",
                "TN_Ct_1Plnt", "TN_Ct_10Plnt", "E_TN_Ct_1Plnt", "DN_Ct", "HGS_E"
        };

        // 定义生成文件的目标目录
        String targetDirectory = "D:\\Zheng\\Documents\\2_NBS\\Java\\LAW\\V4DB\\src\\test\\java\\pgl\\LAW\\V4DB\\domain\\model\\traits";

        // 创建目标目录（如果不存在）
        File directory = new File(targetDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // 遍历类名列表并生成文件
        for (String className : classNames) {
            generateClassFile(targetDirectory, className);
        }
    }

    private static void generateClassFile(String targetDirectory, String className) {
        // 定义文件路径
        String filePath = targetDirectory + "/" + className + ".java";

        // 定义类的内容
        String classContent = "package pgl.LAW.V4DB.domain.model.traits;\n\n" +
                "public class " + className + " {\n" +
                "}\n";

        // 写入文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(classContent);
            System.out.println("Generated: " + filePath);
        } catch (IOException e) {
            System.err.println("Failed to generate file for class: " + className);
            e.printStackTrace();
        }
    }
}
