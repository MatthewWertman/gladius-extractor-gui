package com.budaslounge.gui;

import java.util.Arrays;
import java.util.Objects;

public class util {
    protected static String[] buildCmdArr(String toolName, String l, String s, String o, boolean isModePack) {
        String modeStr = "-unpack";
        String fileListName = "";
        if (isModePack) {
            modeStr = "-pack";
        }
        String[] cmdArray = new String[6];
        cmdArray[0] = "python";
        cmdArray[1] = l + toolName;
        cmdArray[2] = modeStr;
        cmdArray[3] = s;
        cmdArray[4] = o;
        if (Objects.equals(toolName, "bec-tool.py")) {
            cmdArray = Arrays.copyOf(cmdArray, 7);
            fileListName = "gladius_bec_FileList.txt";
            cmdArray[6] = "--gc";
        } else if (Objects.equals(toolName, "ngciso-tool.py")) {
            fileListName = "BaseISO_FileList.txt";
        }
        cmdArray[5] = fileListName;
        return cmdArray;
    }
}
