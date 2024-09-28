package com.example.App1;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * fm.douban.app
 *
 * @author joe
 * @date 2019/12/13
 */
@Service
public class Checker implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    System.exit(0);
                } catch (Exception e) {

                }

            }
        });
        thread.start();
    }
}

