package com.amo.copy;

import java.io.*;

//拷贝目录
public class CopyDir {

    public static void main(String[] args) {
        //源文件
        File srcFile=new File("D:\\实验四");
        //目标文件
        File destFile=new File("D:\\CopyTest\\");
        copyDir(srcFile,destFile);
    }
    public static void copyDir(File srcFile,File destFile){
        //首先获取拼接路径
        String path=destFile.getAbsolutePath().endsWith("\\")?destFile.getAbsolutePath()+"\\":destFile.getAbsolutePath();
        //如果srcFile是文件则递归结束
        if (srcFile.isFile()){
            FileInputStream fip=null;
            FileOutputStream fop=null;
            String filePath=path+srcFile.getAbsolutePath().substring(3);//去掉前缀
            byte []bytes=new byte[1024*1024];
            try {
                fip=new FileInputStream(srcFile);//读取源文件
                fop=new FileOutputStream(filePath);//目标文件，不存在则会自动创建
                int readCount;
                //边读边写
                while ((readCount= fip.read(bytes))!=-1){
                    fop.write(bytes, 0, readCount);
                }
                //刷新管道
                fop.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (fip!=null){
                    try {
                        fip.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fop!=null){
                    try {
                        fop.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


            return;
        }
        //是文件夹则递归
        File[] files = srcFile.listFiles();
        if (files==null) return;//空文件夹就不遍历
        for (File file : files) {
            if (file.isDirectory()){
                //如果是文件夹，则创建文件夹
                String dirPath=path+file.getAbsolutePath().substring(3);//去掉前缀
                File newFile=new File(dirPath);
                if (!newFile.exists()){
                    newFile.mkdirs();//不存在就创建
                }
            }
            copyDir(file, destFile);
        }

    }
}
