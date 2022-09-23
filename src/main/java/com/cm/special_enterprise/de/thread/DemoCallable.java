package com.cm.special_enterprise.de.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class DemoCallable implements Callable<Boolean> {
    private String url;
    private String name;

    public DemoCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }
    @Override
    public Boolean call() throws Exception {
        DownLoadService downLoadService = new DownLoadService();
        downLoadService.down(url, name);
        System.out.println("已经下载了文件名为" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DemoCallable t1 = new DemoCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201708%2F17%2F20170817165222_uG8XZ.jpeg&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1619853513&t=b0beb9a2d2d044e227e0ed99002fc1c5", "01.jpg");
        DemoCallable t2 = new DemoCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201708%2F17%2F20170817165222_uG8XZ.jpeg&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1619853513&t=b0beb9a2d2d044e227e0ed99002fc1c5", "02.jpg");
        DemoCallable t3 = new DemoCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201708%2F17%2F20170817165222_uG8XZ.jpeg&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1619853513&t=b0beb9a2d2d044e227e0ed99002fc1c5", "03.jpg");

        //创建执行服务
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Boolean> s1 = es.submit(t1);
        Future<Boolean> s2 = es.submit(t2);
        Future<Boolean> s3 = es.submit(t3);
        Boolean aBoolean = s1.get();
        Boolean aBoolean1 = s2.get();
        Boolean aBoolean2 = s3.get();
        es.shutdown();

    }



}
class DownLoadService{
    public void down(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("down方法抛出异常");
        }
    }
}
