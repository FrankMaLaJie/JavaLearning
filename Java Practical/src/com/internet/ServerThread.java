package com.internet;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable
{
    private Socket s;

    public ServerThread(Socket s)
    {
        this.s = s;
    }

    @Override
    public void run()
    {
        //- 读数据，
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            //解决名称冲突问题
            int count = 0;
            File file = new File
                    ("G:\\Github Desktop\\JavaLearning\\Java Practical" +
                            "\\src\\com\\internet\\TCPtest6[" + count + "].txt");
            while (file.exists())
            {
                count++;
                file = new File
                        ("G:\\Github Desktop\\JavaLearning\\Java Practical" +
                                "\\src\\com\\internet\\TCPtest6[" + count + "].txt");
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            //把数据写入文本文件
            String line;
            while ((line = br.readLine()) != null)
            {
                //等待读取数据
                bw.write(line);
                bw.newLine();
                bw.flush();
            }

            //给出反馈
            BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bwServer.write("文件上传成功");
            bwServer.newLine();
            bwServer.flush();

            //释放资源
            s.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
