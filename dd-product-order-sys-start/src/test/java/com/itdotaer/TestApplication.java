package com.itdotaer;

import com.itdotaer.gatewayimpl.database.ProductInfoMapper;
import com.itdotaer.gatewayimpl.database.dataobject.ProductInfoDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplication {

    @Resource
    private ProductInfoMapper productInfoMapper;

    @Test
    public void insertDataTest() throws InterruptedException {
        CountDownLatch count = new CountDownLatch(2);

        new Thread(new Runnable() {
            private Integer counter = 100000;
            @Override
            public void run() {
                while (counter-- > 0) {
                    ProductInfoDO productInfoDO = new ProductInfoDO();
                    productInfoDO.setRegion("tw");
                    productInfoDO.setProductName("test insert product name:" + counter);
                    productInfoDO.setOnline(true);
                    productInfoDO.setStatus(0);
                    productInfoDO.setActive(true);
                    productInfoDO.setCreator("itdotaer:" + counter);
                    productInfoDO.setModifier("itdotaer:" + counter);

                    int affectedRows = productInfoMapper.create(productInfoDO);
                    System.out.println("affected rows: " + affectedRows);
                }

                count.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            private Integer counter = 100000;
            @Override
            public void run() {
                while (counter-- > 0) {
                    ProductInfoDO productInfoDO = new ProductInfoDO();
                    productInfoDO.setRegion("sg");
                    productInfoDO.setProductName("test insert product name:" + counter);
                    productInfoDO.setOnline(true);
                    productInfoDO.setStatus(0);
                    productInfoDO.setActive(true);
                    productInfoDO.setCreator("itdotaer:" + counter);
                    productInfoDO.setModifier("itdotaer:" + counter);

                    int affectedRows = productInfoMapper.create(productInfoDO);
                    System.out.println("affected rows: " + affectedRows);
                }

                count.countDown();
            }
        }).start();

        count.await();
    }
}
